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
import model.Booking;
import model.Cart;
import model.Room;

/**
 *
 * @author laptop
 */
@WebServlet(name = "process", urlPatterns = {"/process"})
public class process extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet process</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet process at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
        if (cks != null) {
            for (Cookie c : cks) {
                if (c.getName().equals("cart")) {
                    txt += c.getValue();
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }

        Cart cart = new Cart(txt, listRoom);
        String num_raw = request.getParameter("num");
        String id_raw = request.getParameter("id");
        int id, num;

        try {
            id = Integer.parseInt(id_raw);
            Room r = ud.getRoomByCode(id);

            int numStore = r.getAvailable();
            num = Integer.parseInt(num_raw);
            if (num == -1 && (cart.getQuantityById(id) <= 1)) {
                cart.removeBooking(id);
            } else {
                if ((num == 1) && cart.getQuantityById(id) >= numStore) {
                    num = 0;
                }

                Booking b = new Booking();
                b.setRoom(r);
                b.setQuantity(num);
                cart.addBooking(b);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        List<Booking> booking = cart.getBooking();

        txt = "";
        if (booking.size() > 0) {
            txt = booking.get(0).getRoom().getRoomID() + ":" + booking.get(0).getQuantity();
            for (int i = 1; i < booking.size(); i++) {
                txt += "/" + booking.get(i).getRoom().getRoomID() + ":" + booking.get(i).getQuantity();
            }
        }
        
        if(txt.isEmpty()){
            request.setAttribute("size", 0);
        }else{
            request.setAttribute("size", 1);
        }
        
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(60 * 60 * 24 * 2);
        response.addCookie(c);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("mycart.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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
        if (cks != null) {
            for (Cookie c : cks) {
                if (c.getName().equals("cart")) {
                    txt += c.getValue();
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }

        String id = request.getParameter("id");
        String[] ids = txt.split("/");
        String out = "";
        for (int i = 0; i < ids.length; i++) {
            String[] s = ids[i].split(":");
            if (!s[0].equals(id)) {
                if (out.isEmpty()) {
                    out = ids[i];
                } else {
                    out += "/" + ids[i];
                }

            }
        }

        if (!out.isEmpty()) {
            Cookie c = new Cookie("cart", out);
            c.setMaxAge(60 * 60 * 24 * 2);
            response.addCookie(c);
        }
        
        if(out.isEmpty()){
            request.setAttribute("size", 0);
        }else{
            request.setAttribute("size", 1);
        }
        
        Cart cart = new Cart(out, listRoom);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("mycart.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
