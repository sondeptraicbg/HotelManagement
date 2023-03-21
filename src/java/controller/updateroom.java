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

/**
 *
 * @author laptop
 */
@WebServlet(name="updateroom", urlPatterns={"/updateroom"})
public class updateroom extends HttpServlet {
   
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
            out.println("<title>Servlet updateroom</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateroom at " + request.getContextPath () + "</h1>");
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
            Room c = md.getRoomByCode(id);
            request.setAttribute("room", c);
            
            request.getRequestDispatcher("updateroom.jsp").forward(request, response);

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
        
            String id_raw = request.getParameter("RoomID");
            String RoomType = request.getParameter("RoomType");
            String price_raw = request.getParameter("RoomPrice");
            String RoomImg = request.getParameter("RoomImg");
            String RoomDesc = request.getParameter("RoomDesc");
            String area_raw = request.getParameter("Area");
            String Bed = request.getParameter("Bed");
            String Direct = request.getParameter("Direct");
            String available_raw = request.getParameter("Available");
            
            int id = Integer.parseInt(id_raw);
            int price = Integer.parseInt(price_raw);
            int area = Integer.parseInt(area_raw);
            int available = Integer.parseInt(available_raw);
            
            manageDAO cd = new manageDAO();
            Room r = new Room(id, RoomType, available, price, RoomImg, RoomDesc, null, area, Bed, Direct, available);
            cd.update(r);
            response.sendRedirect("managehome");
            
        }catch(IOException | NumberFormatException e){
            request.setAttribute("error", "Check information again");
            request.getRequestDispatcher("addroom.jsp").forward(request, response);
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
