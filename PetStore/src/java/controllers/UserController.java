package controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import entity.User;
import db.UserFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author _viet.quangg
 */
@WebServlet(name = "UserController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {

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
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "login":
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                break;
            case "login_handler":
                login_handler(request, response);
                break;
            case "signup_handler":
                signup_handler(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            default:
            //Show error page
        }
    }

    protected void login_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "login":
                try {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    UserFacade uf = new UserFacade();
                    User user = uf.login(email, password);
                    if (user != null) {
                        //Neu login thanh cong:
                        //Luu account vao session
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        //quay ve home page
                        response.sendRedirect(request.getContextPath() + "/cakestore/index.do");
                    } else {
                        //Cho hien lai login form
                        request.setAttribute("message", "Incorrect email or password.");
                        request.getRequestDispatcher("/user/login.do").forward(request, response);
                    }
                } catch (Exception ex) {
                    //Cho hien lai login form
                    request.setAttribute("message", ex.toString());
                    request.getRequestDispatcher("/user/login.do").forward(request, response);
                }
                break;
            case "cancel":
                //quay ve home page
                response.sendRedirect(request.getContextPath() + "/cakestore/index.do");
                break;
        }
    }

    protected void signup_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "signup":
                try {
                    String name = request.getParameter("user");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    UserFacade uf = new UserFacade();
                    uf.create(name, email, password);
                    request.getRequestDispatcher("/user/login.do").forward(request, response);
                } catch (Exception ex) {
                    //Cho hien lai login form
                    request.setAttribute("message", ex.toString());
                    request.getRequestDispatcher("/user/login.do").forward(request, response);
                }
                break;
            case "cancel":
                //quay ve home page
                response.sendRedirect(request.getContextPath() + "/cakestore/index.do");
                break;
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Quay ve home page
        response.sendRedirect(request.getContextPath() + "/cakestore/index.do");
        //Xoa session
        HttpSession session = request.getSession();
        session.invalidate();
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
        processRequest(request, response);
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
