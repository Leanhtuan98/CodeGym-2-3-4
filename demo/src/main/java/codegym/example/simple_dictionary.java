package codegym.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "simple_dictionary", value = "/translate")
public class simple_dictionary extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("how", "nhu the nao");
        dictionary.put("book", "sach");
        dictionary.put("computer", "may tinh");

        String search = request.getParameter("txtSearch");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search);
        if (search !=null) {
            writer.println("Word:" + search);
            writer.println("Result:" + result);
        }else {
            writer.println("Not found!");
        }

    }
}
