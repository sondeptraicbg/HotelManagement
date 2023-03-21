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
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import model.Cart;
import model.Comment;
import model.Hotel;
import model.Room;
import model.Service;

/**
 *
 * @author laptop
 */
@WebServlet(name = "userhome", urlPatterns = {"/userhome"})
public class userhome extends HttpServlet {

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
            out.println("<title>Servlet userhome</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet userhome at " + request.getContextPath() + "</h1>");
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
        defaultDAO dd = new defaultDAO();
        List<Room> listRoom = ud.getAllRoom();
        List<Room> listRoomTop = ud.getAllRoomTOP();
        List<Hotel> listHotel = ud.getAllHotel();
        List<String> listType = ud.getTypes();
        
        Cookie[] cks = request.getCookies();
        String txt = "";
        if (cks != null) {
            for (Cookie c : cks) {
                if (c.getName().equals("cart")) {
                    txt += c.getValue();
                }
            }
        }

        Cart cart = new Cart(txt, listRoom);
        List<Booking> listBooking = cart.getBooking();
        int n;

        if (listBooking != null) {
            n = listBooking.size();
        } else {
            n = 0;
        }
        int page, numberpage = 3, size = listRoom.size();
        int num = size % 3 == 0 ? size / 3 : size / 3 + 1;
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }

        int start, end;
        start = (page - 1) * numberpage;
        end = Math.min(page * numberpage, size);

        List<Room> listRoomInPage = dd.getRoomPage(listRoom, start, end);
//        List 
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        
        boolean[] boolArray = new boolean[6];

        request.setAttribute("size", n);
        request.setAttribute("idType", boolArray);
        request.setAttribute("listType", listType);
        request.setAttribute("listRoom", listRoomInPage);
        request.setAttribute("listRoomTop", listRoomTop);
        request.setAttribute("listHotel", listHotel);
        request.setAttribute("in", "You are seeing all Hotels");
        List<Service> ser = dd.getAllServiceByHotel(30001);
        List<Service> serTop = ud.getAllServiceTop();
        List<Comment> listComment = ud.getAllCommentByHotel(30001);
        boolean isC = ud.isCommented(1010101, 30001);
        request.setAttribute("isC", isC);
        request.setAttribute("listComment", listComment);
        request.setAttribute("listServiceTop", serTop);
        request.setAttribute("listService", ser);
        request.getRequestDispatcher("userhome.jsp").forward(request, response);

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
        List<Service> ser = new ArrayList<>();
        for (int i = 0; i < listHotel.size(); i++) {
            ser.addAll(dd.getAllServiceByHotel(listHotel.get(i).getHotelCode()));
        }

        try {
            for (Hotel h : listHotel) {
                listRoom1.addAll(dd.getAllRoomByHotelCode(h.getHotelCode()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//        =======================================================================

        Cookie[] cks = request.getCookies();
        String txt = "";
        if (cks != null) {
            for (Cookie c : cks) {
                if (c.getName().equals("cart")) {
                    txt += c.getValue();
                }
            }
        }

        Cart cart = new Cart(txt, listRoom1);
        List<Booking> listBooking = cart.getBooking();
        int n;

        if (listBooking != null) {
            n = listBooking.size();
        } else {
            n = 0;
        }
        int page, numberpage = 3, size = listRoom1.size();
        int num = size % 3 == 0 ? size / 3 : size / 3 + 1;
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }

        int start, end;
        start = (page - 1) * numberpage;
        end = Math.min(page * numberpage, size);

        List<Room> listRoomInPage = dd.getRoomPage(listRoom1, start, end);
        
        request.setAttribute("page", page);
        request.setAttribute("num", num);

        request.setAttribute("size", n);

//        =======================================================================
        request.setAttribute("listRoom", listRoomInPage);
        request.setAttribute("listService", ser);
        request.setAttribute("listHotel", listHotel);
        request.setAttribute("in", "You are seeing Hotels in " + city);

        request.getRequestDispatcher("userhome.jsp").forward(request, response);
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
        List<Room> listRoom1 = new ArrayList<>();
        defaultDAO dd = new defaultDAO();
        List<Hotel> listHotel = dd.getAllHotelByCity("Ha Noi");
        for (Hotel h : listHotel) {
            listRoom1.addAll(dd.getAllRoomByHotelCode(h.getHotelCode()));
        }

        System.out.println(listRoom1.get(0));

    }

}
