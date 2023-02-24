package com.example.online_electronics_store.service.impl;

import com.example.online_electronics_store.dao.impl.CategoryDAO;
import com.example.online_electronics_store.dao.impl.FeedbackDAO;
import com.example.online_electronics_store.dao.impl.ProductDAO;
import com.example.online_electronics_store.model.Category;
import com.example.online_electronics_store.model.Feedback;
import com.example.online_electronics_store.model.Product;
import com.example.online_electronics_store.service.IProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService {
    private static ProductService instance;

    private ProductService() {
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    @Override
    public boolean create(HttpServletRequest request) throws SQLException {
        return false;
    }


    @Override
    public void render(HttpServletRequest request, List<Product> lists) {

    }

    @Override
    public void update(HttpServletRequest request) throws SQLException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description").trim();
        String image = request.getParameter("image");
        boolean stock = false;
        if (request.getParameter("stock").equals("true")) {
            stock = true;
        }
        Category category = CategoryDAO.getInstance().findById(Long.parseLong(request.getParameter("category")));
        Product product = new Product(name,price,description,image,stock,category);
        ProductDAO.getInstance().update(id,product);
    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public Product getObject(HttpServletRequest request) {
        return null;
    }

    public String renderPage(HttpServletRequest request) throws SQLException {
        int index = Integer.parseInt(request.getParameter("page"));
        List<Product> productsPage = ProductDAO.getInstance().pagingProduct((index - 1) * 6);
        return render(request, index, productsPage);
    }

    public String renderDefault(HttpServletRequest request) throws SQLException {
        int index = 1;
        List<Product> productsPage = ProductDAO.getInstance().pagingProduct(0);
        return render(request, index, productsPage);
    }

    private String render(HttpServletRequest request, int index, List<Product> productsPage) throws SQLException {
        int count = ProductDAO.getInstance().getTotalCount();
        int pages = count / 6;
        if (count % 6 != 0) {
            pages++;
        }
        List<Category> categories = CategoryDAO.getInstance().findAll();
        request.setAttribute("index", index);
        request.setAttribute("products", productsPage);
        request.setAttribute("pages", pages);
        request.setAttribute("categories", categories);
        return "/shop/shop.jsp";
    }

    public void renderDetails(HttpServletRequest request) throws SQLException {
        Long id = Long.parseLong(request.getParameter("id"));
        Product product = ProductDAO.getInstance().findById(id);
        List<Feedback> feedbacks = FeedbackDAO.getInstance().findByProduct(product);
        request.setAttribute("product", product);
        request.setAttribute("feedbacks", feedbacks);
    }

    public void renderByCategory(HttpServletRequest request) throws SQLException {
        Long id = Long.parseLong(request.getParameter("category_id"));
        List<Product> productsFilterByCategory = ProductDAO.getInstance().findByCategory(id);
        List<Category> categories = CategoryDAO.getInstance().findAll();
        request.setAttribute("products", productsFilterByCategory);
        request.setAttribute("categories", categories);
    }

    public void renderByPrice(HttpServletRequest request) throws SQLException {
        Double start = Double.parseDouble(request.getParameter("min_price"));
        Double end = Double.parseDouble(request.getParameter("max_price"));
        List<Product> products = ProductDAO.getInstance().findByPrice(start, end);
        List<Category> categories = CategoryDAO.getInstance().findAll();
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
    }

    public void renderBySearchName(HttpServletRequest request) throws SQLException {
        String name = request.getParameter("search");
        List<Category> categories = CategoryDAO.getInstance().findAll();
        List<Product> productList = ProductDAO.getInstance().findBySearchName(name);
        request.setAttribute("categories", categories);
        request.setAttribute("products", productList);
    }
}
