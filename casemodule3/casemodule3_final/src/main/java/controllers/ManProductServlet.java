package controllers;
import services.ManProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ManProductServlet")
public class ManProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher = null;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "manshirt":
                request.setAttribute("products", ManProductService.getAllManShirt());
                requestDispatcher = request.getRequestDispatcher("view-product.jsp");
                break;
            case "mancoat":
                request.setAttribute("products", ManProductService.getAllManCoat());
                requestDispatcher = request.getRequestDispatcher("view-product.jsp");
                break;
            case "manjeans":
                request.setAttribute("products", ManProductService.getAllManJeans());
                requestDispatcher = request.getRequestDispatcher("view-product.jsp");
                break;
            case "manshort":
                request.setAttribute("products", ManProductService.getAllManShort());
                requestDispatcher = request.getRequestDispatcher("view-product.jsp");
                break;

            default:
                break;
        }
        requestDispatcher.forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        response.sendRedirect("/ManProductServlet");

    }
}