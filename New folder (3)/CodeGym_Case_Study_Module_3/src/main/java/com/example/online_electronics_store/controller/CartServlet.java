package com.example.online_electronics_store.controller;

import com.example.online_electronics_store.model.CartDetails;
import com.example.online_electronics_store.model.User;
import com.example.online_electronics_store.service.impl.CartDetailsService;
import com.example.online_electronics_store.service.impl.CartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller(request, response);
    }

    private void controller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "user_add":
                    addAsUser(request, response);
                    break;
                case "update":
                    updateCart(request, response);
                    break;
                case "clear":
                    clearCart(request,response);
                    break;
                case "delete":
                    removeProduct(request, response);
                    break;
                default:
                    viewCart(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void addAsUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Long id = CartDetailsService.getInstance().insertCart(request);
        response.sendRedirect("/product?action=details&id=" + id);
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        CartDetailsService.getInstance().renderCart(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/cart.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        CartService.getInstance().updateCart(request);
        response.sendRedirect("/cart");
    }

    private void clearCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        CartService.getInstance().clearCart(request);
        response.sendRedirect("/cart");
    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        CartService.getInstance().removeProduct(request);
        response.sendRedirect("/cart");
    }
}
