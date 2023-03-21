/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.defaultDAO;
import dal.searchDAO;
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
@WebServlet(name = "checkbox", urlPatterns = {"/checkbox"})
public class checkbox extends HttpServlet {

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
            out.println("<title>Servlet checkbox</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkbox at " + request.getContextPath() + "</h1>");
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
        String city = request.getParameter("city");
        if (city == null) {
            city = "all";
        }
        String[] type = request.getParameterValues("checktype");
        searchDAO sd = new searchDAO();

        userDAO ud = new userDAO();
        List<String> listType = ud.getTypes();

        defaultDAO dd = new defaultDAO();
        List<Hotel> listHotel = ud.getAllHotelByCity(city);
        Cookie[] cks = request.getCookies();
        String txt = "";
        if (cks != null) {
            for (Cookie c : cks) {
                if (c.getName().equals("cart")) {
                    txt += c.getValue();
                }
            }
        }

        List<Room> listRoom;
        if (type == null) {
            listRoom = sd.getAllRoom();
        } else {
            listRoom = sd.getAllRoomByHotelCodeCheckBox(type);
        }
//
//        for (Hotel h : listHotel) {
//            listRoom.addAll(sd.getAllRoomByType(type, h.getHotelCode()));
//        }

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
        boolean[] boolArray;
        if (type == null) {
            boolArray = new boolean[6];
        } else {
            boolArray = ischeck(listType, type);
        }

        List<Service> serTop = ud.getAllServiceTop();
        request.setAttribute("listServiceTop", serTop);
        List<Comment> listComment = ud.getAllCommentByHotel(30001);

        request.setAttribute("listComment", listComment);
        List<Room> listRoomTop = ud.getAllRoomTOP();
        request.setAttribute("listRoomTop", listRoomTop);
        request.setAttribute("size", n);
        request.setAttribute("listRoom", listRoomInPage);
        request.setAttribute("listHotel", listHotel);
        request.setAttribute("idType", boolArray);
        request.setAttribute("listType", listType);
        request.setAttribute("in", "You are seeing Hotels in " + city);
        List<Service> ser = ud.getAllService();
        request.setAttribute("listService", ser);
        request.getRequestDispatcher("userhome.jsp").forward(request, response);
    }

    private boolean[] ischeck(List<String> d, String[] id) {
        boolean[] boolArray = new boolean[6];
        for (int i = 0; i < id.length; i++) {
            for (int j = 0; j < d.size(); j++) {
                if (!d.get(j).equals(id[i])) {
                } else {
                    boolArray[j] = true;
                }
            }
        }
        return boolArray;
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
        processRequest(request, response);
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
