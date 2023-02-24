package Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        ArrayList<Products> products = new ArrayList<>();
        products.add(new Products(1,"abc","https://bizweb.dktcdn.net/thumb/1024x1024/100/415/697/products/1-af0c84b6-d733-4bef-8dcf-d8a7d6bc30b8.jpg"));
        products.add(new Products(2,"aaa","https://bizweb.dktcdn.net/100/415/697/products/ahu2keci-1-iirh-hinh-mat-truoc-01.jpg?v=1657108771117"));
        products.add(new Products(3,"bbb","https://g2000vn.com/wp-content/uploads/2022/10/8-2-300x300.jpg"));


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin")&&password.equals("admin")){

            request.setAttribute("products",products);

            requestDispatcher = request.getRequestDispatcher("home.jsp");
            requestDispatcher.forward(request,response);
        }else {
            requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request,response);
        }

    }
}
