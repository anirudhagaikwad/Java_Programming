package com.example.controller;


import com.example.model.Book;
import com.example.util.HibernateUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cart/*")
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();
        if ("/view".equals(path)) {
            response.setContentType("application/json");
            HttpSession session = request.getSession();
            Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
            if (cart == null || cart.isEmpty()) {
                response.getWriter().write("[]");
                return;
            }
            try (Session dbSession = HibernateUtil.getSessionFactory().openSession()) {
                List<Book> books = dbSession.createQuery("from Book where book_id in :ids", Book.class)
                        .setParameterList("ids", cart.keySet())
                        .list();
                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < books.size(); i++) {
                    Book book = books.get(i);
                    int qty = cart.get(book.getBookId());
                    json.append(String.format("{\"id\":%d,\"title\":\"%s\",\"price\":%.2f,\"quantity\":%d}",
                            book.getBookId(), book.getTitle(), book.getPrice(), qty));
                    if (i < books.size() - 1) json.append(",");
                }
                json.append("]");
                response.getWriter().write(json.toString());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();
        HttpSession session = request.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
        if (cart == null) cart = new HashMap<>();

        if ("/add".equals(path)) {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            cart.put(bookId, cart.getOrDefault(bookId, 0) + 1);
            session.setAttribute("cart", cart);
            response.getWriter().write("Book added to cart");
        } else if ("/update".equals(path)) {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity <= 0) cart.remove(bookId);
            else cart.put(bookId, quantity);
            session.setAttribute("cart", cart);
            response.getWriter().write("Cart updated");
        }
    }
}
