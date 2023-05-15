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
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vuhai
 */
@WebServlet(name = "ShopController", urlPatterns = {"/shop"})
public class ShopController extends HttpServlet {

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
            case "shop":
                list(request, response);
                break;
            default:
                request.setAttribute("controller", "error");
                request.setAttribute("action", "error");
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                break;
        }
    }

    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        String category = request.getParameter("category");
        String sort = request.getParameter("sort");
        if (sort == null || sort == "") {sort = "name";}
        ProductsFacade pf = new ProductsFacade();
        String index = request.getParameter("index");
        if (search == null) {search = category = "";index = "1";}
        try {
            //Category
            List<String> categories = pf.getCategory();
            request.setAttribute("categories", categories);

            //Page
            int pageSize = 8;
            int endPage = 0;
            int count = pf.getCount(search, category);
            endPage = count / pageSize;
            if (count % pageSize != 0) {
                endPage++;
            }

            //Get Products
            List<Products> list = pf.getProduct(search, category, sort, Integer.parseInt(index), pageSize);
            request.setAttribute("list", list);
            request.setAttribute("count", count);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("end", endPage);
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
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
