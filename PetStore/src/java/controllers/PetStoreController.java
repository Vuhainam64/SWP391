/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.DBContext;
import db.ProductsFacade;
import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PHT
 */
@WebServlet(name = "PetStoreController", urlPatterns = {"/petstore"})
public class PetStoreController extends HttpServlet {

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
            case "index":
                list(request, response);
                break;
            case "about":
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                break;
            case "blog-details":
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                break;
            case "blog":
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                break;
            case "class":
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                break;
            case "contact":
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                break;
            case "login":
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                break;
            default:
                //Show error page
                request.setAttribute("controller", "error");
                request.setAttribute("action", "error");
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                break;

        }
    }

    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductsFacade pf = new ProductsFacade();
        try {
            List<Products> listcupcake = pf.getProductWithCategory("cupcake");
            request.setAttribute("listcupcake", listcupcake);
            List<Products> listbutter = pf.getProductWithCategory("butter");
            request.setAttribute("listbutter", listbutter);
            List<Products> listred_velvet = pf.getProductWithCategory("red_velvet");
            request.setAttribute("listred_velvet", listred_velvet);
            List<Products> listbiscuit = pf.getProductWithCategory("biscuit");
            request.setAttribute("listbiscuit", listbiscuit);
            List<Products> listdonut = pf.getProductWithCategory("donut");
            request.setAttribute("listdonut", listdonut);
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            //Hien trang thong bao loi
            ex.printStackTrace();//in thong bao loi chi tiet cho developer
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
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
