package com.example.online_electronics_store.controller;

import com.example.online_electronics_store.dao.impl.CategoryDAO;
import com.example.online_electronics_store.dao.impl.ProductDAO;
import com.example.online_electronics_store.model.Category;
import com.example.online_electronics_store.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
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
                case "viewByAdmin":
                    displayForAdmin(request, response);
                    break;
                case "create":
                    createCategory(request, response);
                    break;
                case "update":
                    updateCategory(request, response);
                    break;
                case "delete":
                    deleteCategory(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayForAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/category.jsp");
        List<Category> categories = CategoryDAO.getInstance().findAll();
        request.setAttribute("categories", categories);
        dispatcher.forward(request, response);
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        CategoryDAO.getInstance().insert(new Category(name));
        displayForAdmin(request, response);
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        CategoryDAO.getInstance().update(id, new Category(name));
        displayForAdmin(request, response);
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        CategoryDAO.getInstance().delete(id);
        displayForAdmin(request, response);
    }

}
