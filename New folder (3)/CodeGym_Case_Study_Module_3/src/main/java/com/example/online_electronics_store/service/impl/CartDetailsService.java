package com.example.online_electronics_store.service.impl;

import com.example.online_electronics_store.dao.impl.CartDAO;
import com.example.online_electronics_store.dao.impl.CartDetailsDAO;
import com.example.online_electronics_store.dao.impl.ProductDAO;
import com.example.online_electronics_store.model.Cart;
import com.example.online_electronics_store.model.CartDetails;
import com.example.online_electronics_store.model.Product;
import com.example.online_electronics_store.model.User;
import com.example.online_electronics_store.service.ICartDetailsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CartDetailsService implements ICartDetailsService {
    private static CartDetailsService instance;
    private CartDetailsService() {
    }

    public static CartDetailsService getInstance() {
        if (instance == null) {
            instance = new CartDetailsService();
        }
        return instance;
    }

    @Override
    public boolean create(HttpServletRequest request) throws ServletException, IOException, SQLException {
        return false;
    }

    public Long insertCart(HttpServletRequest request) throws SQLException {
        Long id = Long.parseLong(request.getParameter("product_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = ProductDAO.getInstance().findById(id);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null && product.isStockStatus()) {
            Cart cart = CartDAO.getInstance().findByUser(user);
            CartDetails cartDetails = new CartDetails(cart, product, quantity);
            CartDetailsDAO.getInstance().insert(cartDetails);
        } else {

        }
        return id;
    }

    @Override
    public void render(HttpServletRequest request, List<CartDetails> lists) throws SQLException, ClassNotFoundException {

    }

    public void renderCart(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Cart cart = CartDAO.getInstance().findByUser(user);
            List<CartDetails> carts = CartDetailsDAO.getInstance().findByItemId(cart);
            request.setAttribute("carts", carts);
        }
    }

    @Override
    public void update(HttpServletRequest request) throws SQLException {

    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public CartDetails getObject(HttpServletRequest request) {
        return null;
    }
}
