package com.example.online_electronics_store.controller;

import com.example.online_electronics_store.service.impl.FeedbackService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ReviewServlet", value = "/review")
public class ReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller(request, response);
    }

    private void controller(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "feedback":
                    feedback(request, response);
                    break;
                default:
            }
        } catch (SQLException | ServletException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void feedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException, ClassNotFoundException {
        Long id = FeedbackService.getInstance().feedback(request);
        response.sendRedirect("product?action=details&id=" + id);
    }
}
