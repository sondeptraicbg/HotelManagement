/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.employeeDAO;
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
import model.Employee;
import model.User;

/**
 *
 * @author laptop
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String un = request.getParameter("username");
        String pw = request.getParameter("password");
        String role = request.getParameter("role");
        String rem = request.getParameter("remember");

        Cookie cookieUser = new Cookie("cuser", un);
        Cookie cookiePass = new Cookie("cpass", pw);
        Cookie cookieRole = new Cookie("role", role);
        Cookie cookieRem = new Cookie("crem", rem);

        if (rem != null) {
            //luu
            cookieUser.setMaxAge(60 * 60 * 24 * 7);
            cookiePass.setMaxAge(60 * 60 * 24 * 7);
            cookieRole.setMaxAge(60 * 60 * 24 * 7);
            cookieRem.setMaxAge(60 * 60 * 24 * 7);
        } else {
            //khong muon luu
            cookieUser.setMaxAge(60 * 60 * 24);
            cookiePass.setMaxAge(60 * 60 * 24);
            cookieRole.setMaxAge(60 * 60 * 24);
            cookieRem.setMaxAge(60 * 60 * 24);
        }

        response.addCookie(cookieUser);
        response.addCookie(cookiePass);
        response.addCookie(cookieRole);
        response.addCookie(cookieRem);

        switch (role) {
            case "manager":
                try {
                    int id = Integer.parseInt(un);
                    employeeDAO ed = new employeeDAO();
                    Employee e = ed.getEmployeeByID(id, pw, "President");
                    if (e == null) {
                        request.setAttribute("error", "Wrong username or password");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        HttpSession session = request.getSession();
                        session.setAttribute("account", e);
                        response.sendRedirect("managehome");
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "For staffs, username is your ID");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            break;

            case "employee":
                try {
                    int id = Integer.parseInt(un);
                    employeeDAO ed = new employeeDAO();
                    Employee e = ed.getEmployeeByID(id, pw, "Staff");
                    if (e == null) {
                        request.setAttribute("error", "Wrong username or password");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        HttpSession session = request.getSession();
                        session.setAttribute("account", e);
                        response.sendRedirect("employeehome");
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "For staffs, username is your ID");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            break;

            default:
                try {
                    long id = Long.parseLong(un);
                    userDAO ud = new userDAO();
                    User u = ud.getUserByID(id, pw);
                    if (u == null) {
                        request.setAttribute("error", "Wrong username or password");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        HttpSession session = request.getSession();
                        session.setAttribute("account", u);
                        response.sendRedirect("userhome");
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "Username is your phone number");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            break;
        }

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
