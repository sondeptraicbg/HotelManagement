/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Room;

/**
 *
 * @author laptop
 */
@WebServlet(name="takebook", urlPatterns={"/takebook"})
public class takebook extends HttpServlet {
   
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
            out.println("<title>Servlet takebook</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet takebook at " + request.getContextPath () + "</h1>");
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
        userDAO ud = new userDAO();
        List<Room> listRoom = ud.getAllRoom();
        Cookie[] cks = request.getCookies();
        
        String txt = "";
        if(cks!=null){
            for(Cookie c: cks){
                if(c.getName().equals("cart")){
                    txt+=c.getValue();
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }
        String num = request.getParameter("num");
        String id = request.getParameter("id");
        
        if(txt.isEmpty()){
            txt=id+":"+num;
        }else{
            txt=txt + "/" + id + ":" + num;
        }
        
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(60*60*24*24);
        
        response.addCookie(c);
        response.sendRedirect("userhome");
//        request.getRequestDispatcher("showcart").forward(request, response);
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
        
        userDAO ud = new userDAO();
        List<Room> listRoom = ud.getAllRoom();
        Cookie[] cks = request.getCookies();
        
        String txt = "";
        if(cks!=null){
            for(Cookie c: cks){
                if(c.getName().equals("cart")){
                    txt+=c.getValue();
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }
        String num = request.getParameter("num");
        String id = request.getParameter("id");
        
        if(txt.isEmpty()){
            txt=id+":"+num;
        }else{
            txt=txt+","+num;
        }
        
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(60*60*24*24);
        
        response.addCookie(c);
        request.getRequestDispatcher("userhome").forward(request, response);
        
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
