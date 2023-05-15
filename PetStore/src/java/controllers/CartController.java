/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.CouponFacade;
import db.DBContext;
import db.ProductsFacade;
import db.UserOrderFacade;
import entity.Cart;
import entity.Item;
import entity.Products;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PHT
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

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
        String op = request.getParameter("op");
        switch (action) {
            case "cart":
                list(request, response);
                break;
            case "add":
                add(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "empty":
                empty(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "coupon":
                coupon(request, response);
                break;
            case "checkout":
                checkout(request, response);
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
        ProductsFacade pf = new ProductsFacade();
        request.setAttribute("pf", pf);
        //Quay ve cart page
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductsFacade pf = new ProductsFacade();
        try {
            //Tạo connection để kết nối vào DBMS
            Connection con = DBContext.getConnection();
            Products product = pf.getProductById(id);
            Item item = new Item(product, 1);
            //Lay cart tu session
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                //Neu chua co cart thi tao cart moi
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            //Luu id vao session de bao ton trang thai combobox
            session.setAttribute("oldId", id);
            //Add item into cart
            cart.add(item);
        } catch (Exception e) {
            System.out.println(e);
        }
        //Quay ve home page
        request.getRequestDispatcher("/cart/cart.do").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //Lay cart tu session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        //Remove an item from cart
        cart.remove(id);
        //Quay ve home page
        request.getRequestDispatcher("/cart/cart.do").forward(request, response);
    }

    protected void empty(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Lay cart tu session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        //Remove an item from cart
        cart.empty();
        //Quay ve home page
        request.getRequestDispatcher("/cart/cart.do").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        //Lay cart tu session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        //Update quantity
        cart.update(id, quantity);
        //Quay ve home page
        request.getRequestDispatcher("/cart/cart.do").forward(request, response);
    }

    protected void coupon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the coupon code from the request parameter "coupon"
        String coupon = request.getParameter("coupon");
        // Retrieve the shopping cart from the session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        try {
            CouponFacade cf = new CouponFacade();
            double discount = Double.parseDouble(cf.getCoupon(coupon)) * cart.getTotal(); // convert to decimal percentage
            DecimalFormat df = new DecimalFormat("#.##");
            discount = Double.parseDouble(df.format(discount));
            request.setAttribute("discount", discount);
        } catch (Exception e) {
            System.out.println(e);
        }
        // Forward the request to the /cart/cart.do URL
        request.getRequestDispatcher("/cart/cart.do").forward(request, response);
    }

    protected void checkout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (session != null && user != null) {
            try {
                String email = user.getEmail();
                Cart cart = (Cart) session.getAttribute("cart");

                // Extract the product IDs and quantities from the cart
                List<Integer> productIds = new ArrayList<>();
                List<Integer> quantities = new ArrayList<>();

                for (Item item : cart.getItems()) {
                    productIds.add(item.getProducts().getId());
                    quantities.add(item.getQuantity());
                }

                // Create the order using UserOrderFacade
                UserOrderFacade uof = new UserOrderFacade();
                uof.create(email, productIds, quantities);

                // Clear the cart
                cart.empty();
            } catch (Exception e) {
                System.out.println(e);
            }

            // Redirect the user to a "thank you" page
            request.setAttribute("controller", "cart");
            request.setAttribute("action", "thanks");
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } else {
            // If the user is not logged in, redirect them to the login page
            request.getRequestDispatcher("/user/login.do").forward(request, response);
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
