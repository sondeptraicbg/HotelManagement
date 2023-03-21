/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.defaultDAO;
import dal.employeeDAO;
import dal.manageDAO;
import dal.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import model.Booking;
import model.ContactUs;
import model.Employee;
import model.MonthlyType;
import model.MonthlyVolume;
import model.Room;
import model.Service;

/**
 *
 * @author laptop
 */
@WebServlet(name="managehome", urlPatterns={"/managehome"})
public class managehome extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet managehome</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet managehome at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee e = (Employee) session.getAttribute("account");
        if(e==null){
            response.sendRedirect("login");
        }
        manageDAO md = new manageDAO();
        defaultDAO dd = new defaultDAO();
        List<Room> lr1 = md.getAllRoomByHotelCode(e.getHotelCode());
        List<Service> ser = dd.getAllServiceByHotel(e.getHotelCode());
        List<MonthlyVolume> hm = md.getBookingByMonth();
        List<MonthlyVolume> hWithPrice = md.getBookingByMonthWithPrice();
        employeeDAO yd = new employeeDAO();
        List<ContactUs> listCon = yd.getAllContact();
        List<Employee> listEm = md.getAllEmployeeByHotelWithStatus(e.getHotelCode());
        userDAO ud = new userDAO();
        List<String> listType = ud.getTypes();
        List<MonthlyType> monthlyType = md.getBookingByMonthWithType(listType);
        List<Booking> listBooking = md.getAllBooking();

        request.setAttribute("monthly", hm);
        request.setAttribute("listBooking", listBooking);
        request.setAttribute("monthNice", hWithPrice);
        request.setAttribute("monthType", monthlyType);
        request.setAttribute("listRoom1", lr1);
        request.setAttribute("listService", ser);
        request.setAttribute("listContact", listCon);
        request.setAttribute("listEm", listEm);
        request.getRequestDispatcher("managehome.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
