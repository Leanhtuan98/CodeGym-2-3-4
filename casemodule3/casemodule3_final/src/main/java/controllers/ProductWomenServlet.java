package controllers;

import models.Product;
import services.ProductWomenService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/ProductWomenServlet")
public class ProductWomenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher = null;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "shirtwomen":
                req.setAttribute("products", ProductWomenService.getAllWomenShirt());
                requestDispatcher = req.getRequestDispatcher("view-product.jsp");
                break;
            case "coatwomen":
                req.setAttribute("products",ProductWomenService.getAllWomenCoat());
                requestDispatcher = req.getRequestDispatcher("view-product.jsp");
                break;
            case "jeanswomen":
                req.setAttribute("products",ProductWomenService.getAllWomenJeans());
                requestDispatcher = req.getRequestDispatcher("view-product.jsp");
                break;
            case "dresswomen":
                req.setAttribute("products",ProductWomenService.getAllWomenDress());
                requestDispatcher = req.getRequestDispatcher("view-product.jsp");
                break;
        }
        requestDispatcher.forward(req,resp);
    }
}
