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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author laptop
 */
@WebServlet(name="checkloginservice", urlPatterns={"/checkloginservice"})
public class checkloginservice extends HttpServlet {
   
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
            out.println("<title>Servlet checkloginservice</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkloginservice at " + request.getContextPath () + "</h1>");
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
        
        manageDAO cd = new manageDAO();

        if (session.getAttribute("account") == null) {
            request.setAttribute("error", "Login session has expired");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            String action = request.getParameter("action");
            switch (action) {
                case "add":
                    request.getRequestDispatcher("addservice.jsp").forward(request, response);
                    break;
                case "delete": {
                    String id_raw = request.getParameter("id");
                    int id;
                    try {
                        id = Integer.parseInt(id_raw);
                        cd.delete(cd.getRoomByCode(id));
                        response.sendRedirect("managehome");
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }
                    break;
                }
                default: {
                    String id_raw = request.getParameter("id");
                    try {
                        int id = Integer.parseInt(id_raw);
                        request.getRequestDispatcher("updateservice?id=" + id).forward(request, response);
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }
                    break;
                }
            }
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
