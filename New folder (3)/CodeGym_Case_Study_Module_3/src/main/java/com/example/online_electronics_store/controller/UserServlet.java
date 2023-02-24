package com.example.online_electronics_store.controller;

import com.example.online_electronics_store.dao.impl.CategoryDAO;
import com.example.online_electronics_store.dao.impl.OrderDAO;
import com.example.online_electronics_store.dao.impl.ProductDAO;
import com.example.online_electronics_store.dao.impl.UserDAO;
import com.example.online_electronics_store.model.Category;
import com.example.online_electronics_store.model.Product;
import com.example.online_electronics_store.model.User;
import com.example.online_electronics_store.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller(request, response);
    }

    private void controller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "admin":
                    toAdmin(request, response);
                    break;
                case "account":
                    toAccount(request, response);
                    break;
                case "register":
                    register(request, response);
                    break;
                case "registerByAdmin":
                    registerByAdmin(request, response);
                    break;
                case "login":
                    login(request, response);
                    break;
                case "logout":
                    logout(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "view":
                    break;
                case "showAdminDashboard":
                    showAdminDashboard(request,response);
                    break;
                case "viewByAdmin":
                    viewByAdmin(request,response);
                    break;
                default:
                    toLoginPage(response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void registerByAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        String role = request.getParameter("role");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        UserDAO.getInstance().insert(new User(role,username,password,phoneNumber,email,address));
        viewByAdmin(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller(request, response);
    }

    private void toLoginPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8080/shop/login-register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        if (UserService.getInstance().create(request)) {
            request.setAttribute("regMess", "Register successfully");
            RequestDispatcher dispatcher = request.getRequestDispatcher("shop/login-register.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("regMess", "Username / Email / Phone number exist");
            RequestDispatcher dispatcher = request.getRequestDispatcher("shop/login-register.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        User user = UserService.getInstance().loginCheck(request);
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            if (user.getRole().equals("user")) {
                response.sendRedirect("/product");
            } else if (user.getRole().equals("admin")) {
                showAdminDashboard(request,response);
            }

        } else {
            request.setAttribute("logMess", "Wrong username / email or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("http://localhost:8080/shop/login-register.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void toAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("/product?action=display_admin");
    }

    private void toAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("shop/my-account.jsp");
    }

    private void showAdminDashboard(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/index.jsp");
        Integer totalProducts = ProductDAO.getInstance().getTotalCount();
        Integer totalCategories = CategoryDAO.getInstance().getTotalCount();
        Integer totalUsers = UserDAO.getInstance().getTotalCount();
        Integer totalOrders = OrderDAO.getInstance().getTotalCount();
        request.setAttribute("totalP",totalProducts);
        request.setAttribute("totalC",totalCategories);
        request.setAttribute("totalU",totalUsers);
        request.setAttribute("totalO",totalOrders);
        dispatcher.forward(request,response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        toLoginPage(response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        if (UserService.getInstance().updateAcc(request)) {
            request.setAttribute("mess", "success");
        } else {
            request.setAttribute("mess", "fail");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/my-account.jsp");
        dispatcher.forward(request, response);
    }

    private void viewByAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/user.jsp");
        List<User> users = UserDAO.getInstance().findAll();
        request.setAttribute("users", users);
        dispatcher.forward(request, response);
    }
}
