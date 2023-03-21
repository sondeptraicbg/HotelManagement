/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.manageDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Room;
import model.Service;

/**
 *
 * @author laptop
 */
@WebServlet(name="updateservice", urlPatterns={"/updateservice"})
public class updateservice extends HttpServlet {
   
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
            out.println("<title>Servlet updateservice</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateservice at " + request.getContextPath () + "</h1>");
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
        manageDAO md = new manageDAO();
        String id_raw = request.getParameter("id");
        
        try{
            
            int id = Integer.parseInt(id_raw);
            Service c = md.getServiceByCode(id);
            request.setAttribute("service", c);
            
            request.getRequestDispatcher("updateservice.jsp").forward(request, response);

        }catch(IOException | NumberFormatException e){
            System.out.println(e);
        }
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
        try{
        
            String ServiceCode = request.getParameter("ServiceCode");
            String ServiceName = request.getParameter("ServiceName");
            String ServiceDes = request.getParameter("ServiceDes");
            
            
            manageDAO cd = new manageDAO();
            cd.updateService(ServiceDes, ServiceName, ServiceDes);
            response.sendRedirect("managehome");
            
        }catch(IOException | NumberFormatException e){
            request.setAttribute("error", "Check information again");
            request.getRequestDispatcher("addservice.jsp").forward(request, response);
        }
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
