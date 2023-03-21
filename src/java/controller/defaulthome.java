/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.defaultDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import model.Cart;
import model.Hotel;
import model.Room;
import model.Service;

/**
 *
 * @author laptop
 */
@WebServlet(name = "defaulthome", urlPatterns = {"/defaulthome"})
public class defaulthome extends HttpServlet {

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
            out.println("<title>Servlet defaulthome</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet defaulthome at " + request.getContextPath() + "</h1>");
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

        defaultDAO dd = new defaultDAO();
        List<Room> lr1 = dd.getAllRoom();
        List<Hotel> listHotel = dd.getAllHotel();
        List<Service> ser = dd.getAllService();

//        Cookie
        Cookie[] cks = request.getCookies();
        String txt = "";
        if (cks != null) {
            for (Cookie c : cks) {
                if (c.getName().equals("cart")) {
                    txt += c.getValue();
                }
            }
        }

        int page, numberpage = 3, size = lr1.size();
        int num = size%3==0 ? size/3 : size/3+1;
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }

        int start, end;
        start = (page - 1) * numberpage;
        end = Math.min(page * numberpage, size);

        List<Room> listRoomInPage = dd.getRoomPage(lr1, start, end);
//        List 
        request.setAttribute("page", page);
        request.setAttribute("num", num);
//        request.setAttribute("listRoomInPage", listRoomInPage);
        request.setAttribute("listRoom1", listRoomInPage);
        request.setAttribute("listService", ser);
        request.setAttribute("listHotel", listHotel);
        request.setAttribute("in", "You are seeing all Hotels");
        Cart cart = new Cart(txt, lr1);
        List<Booking> listBooking = cart.getBooking();
        int n;

        if (listBooking != null) {
            n = listBooking.size();
        } else {
            n = 0;
        }
        request.setAttribute("size", n);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
        String city = request.getParameter("chooseCity");
        List<Room> listRoom1 = new ArrayList<>();
        defaultDAO dd = new defaultDAO();
        List<Hotel> listHotel = dd.getAllHotelByCity(city);
        List<Service> ser = dd.getAllService();

        try {
            for (Hotel h : listHotel) {
                listRoom1.addAll(dd.getAllRoomByHotelCode(h.getHotelCode()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        request.setAttribute("listRoom1", listRoom1);
        request.setAttribute("listService", ser);
        request.setAttribute("listHotel", listHotel);
        request.setAttribute("in", "You are seeing Hotels in " + city);

        request.getRequestDispatcher("home.jsp").forward(request, response);
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

    public static void main(String[] args) {
        defaultDAO d = new defaultDAO();
        List<Hotel> lh = d.getAllHotelByCity("Ha Noi");
        List<Room> listRoom1 = new ArrayList<>();
        for (Hotel h : lh) {
            listRoom1.addAll(d.getAllRoomByHotelCode(h.getHotelCode()));
        }
        System.out.println(listRoom1.get(0));
    }
}
