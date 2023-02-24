package com.example.online_electronics_store.service.impl;

import com.example.online_electronics_store.dao.impl.CartDAO;
import com.example.online_electronics_store.dao.impl.CartDetailsDAO;
import com.example.online_electronics_store.dao.impl.ProductDAO;
import com.example.online_electronics_store.model.Cart;
import com.example.online_electronics_store.model.CartDetails;
import com.example.online_electronics_store.model.Product;
import com.example.online_electronics_store.model.User;
import com.example.online_electronics_store.service.ICartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartService implements ICartService {
    private static CartService instance;
    private CartService() {
    }

    public static CartService getInstance() {
        if (instance == null) {
            instance = new CartService();
        }
        return instance;
    }
    @Override
    public boolean create(HttpServletRequest request) throws ServletException, IOException, SQLException {
        return false;
    }

    @Override
    public void render(HttpServletRequest request, List<Cart> lists) throws SQLException {

    }

    @Override
    public void update(HttpServletRequest request) throws SQLException {

    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public Cart getObject(HttpServletRequest request) {
        return null;
    }

    public void updateCart(HttpServletRequest request) throws SQLException {
        List<CartDetails> carts = new ArrayList<>();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = CartDAO.getInstance().findByUser(user);
        int num = Integer.parseInt(request.getParameter("num"));
        for (int i = 1; i < num; i++) {
            String pName = "p-" + i;
            String qName = "q-" + i;
            Long id = Long.parseLong(request.getParameter(pName));
            Product product = ProductDAO.getInstance().findById(id);
            int quantity = Integer.parseInt(request.getParameter(qName));
            carts.add(new CartDetails(cart, product, quantity));
        }
        CartDetailsDAO.getInstance().updateCart(carts);
    }

    public void clearCart(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = CartDAO.getInstance().findByUser(user);
        CartDetailsDAO.getInstance().delete(cart);
    }

    public void removeProduct(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = CartDAO.getInstance().findByUser(user);
        Long id = Long.parseLong(request.getParameter("id"));
        Product product = ProductDAO.getInstance().findById(id);
        CartDetailsDAO.getInstance().remove(new CartDetails(cart, product));
    }
}
