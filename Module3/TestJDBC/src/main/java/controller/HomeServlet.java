package controller;

import service.HocVienService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")

public class HomeServlet extends HttpServlet {
    HocVienService hocVienService = new HocVienService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listHv",hocVienService.getAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/showHocVien.jsp");
        requestDispatcher.forward(req,resp);
    }
}
