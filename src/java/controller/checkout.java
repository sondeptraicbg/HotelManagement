/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.defaultDAO;
import dal.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Cart;
import model.Room;
import model.User;

/**
 *
 * @author laptop
 */
@WebServlet(name="checkout", urlPatterns={"/checkout"})
public class checkout extends HttpServlet {
   
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
            out.println("<title>Servlet checkout</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkout at " + request.getContextPath () + "</h1>");
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
        processRequest(request, response);
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
        
        String bookingDate = request.getParameter("fromDate");
        String endDate = request.getParameter("toDate");
        String spcReq = request.getParameter("spcReq");
        if(spcReq.isEmpty()){
            spcReq = "no";
        }
        String paymentMode = request.getParameter("via");
        
        userDAO ud = new userDAO();
        List<Room> listRoom = ud.getAllRoom();
        Cookie[] cks = request.getCookies();
        String txt="";
        
        if(cks!=null){
            for(Cookie c:cks){
                if(c.getName().equals("cart")){
                    txt+=c.getValue();
                }
            }
        }
        
        Cart cart = new Cart(txt, listRoom);
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        if(u==null){
            response.sendRedirect("login.jsp");
        }else{
            defaultDAO dd = new defaultDAO();
            dd.addBooking(u, cart, bookingDate, endDate, spcReq, paymentMode);
            Cookie e = new Cookie("cart", "");
            e.setMaxAge(0);
            response.addCookie(e);
            response.sendRedirect("userhome");
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
    
    public static void main(String[] args) {
        

    }

}
