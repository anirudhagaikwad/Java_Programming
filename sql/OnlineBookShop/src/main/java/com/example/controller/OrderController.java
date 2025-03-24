package com.example.controller;

import com.example.model.Book;
import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.model.User;
import com.example.util.HibernateUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/order/*")
public class OrderController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();
        if ("/checkout".equals(path)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("/online-bookshop/login.html");
                return;
            }
            Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
            if (cart == null || cart.isEmpty()) {
                response.sendRedirect("/online-bookshop/cart.html?error=empty");
                return;
            }

            try (Session dbSession = HibernateUtil.getSessionFactory().openSession()) {
                dbSession.beginTransaction();
                Order order = new Order();
                order.setUserId(user.getUserId());
                order.setOrderDate(new Date());
                order.setStatus("Pending");
                double total = 0;

                List<Book> books = dbSession.createQuery("from Book where book_id in :ids", Book.class)
                        .setParameterList("ids", cart.keySet())
                        .list();
                for (Book book : books) {
                    int qty = cart.get(book.getBookId());
                    total += book.getPrice() * qty;
                    book.setStock(book.getStock() - qty);
                    dbSession.update(book);

                    OrderItem item = new OrderItem();
                    item.setOrderId(order.getOrderId());
                    item.setBookId(book.getBookId());
                    item.setQuantity(qty);
                    item.setUnitPrice(book.getPrice());
                    dbSession.persist(item);
                }
                order.setTotalAmount(total);
                dbSession.persist(order);
                dbSession.getTransaction().commit();
                session.removeAttribute("cart");
                response.sendRedirect("/online-bookshop/order.html");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();
        if ("/history".equals(path)) {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("/online-bookshop/login.html");
                return;
            }
            response.setContentType("application/json");
            try (Session dbSession = HibernateUtil.getSessionFactory().openSession()) {
                List<Order> orders = dbSession.createQuery("from Order where user_id = :userId", Order.class)
                        .setParameter("userId", user.getUserId())
                        .list();
                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < orders.size(); i++) {
                    Order order = orders.get(i);
                    json.append(String.format("{\"id\":%d,\"date\":\"%s\",\"total\":%.2f,\"status\":\"%s\"}",
                            order.getOrderId(), order.getOrderDate(), order.getTotalAmount(), order.getStatus()));
                    if (i < orders.size() - 1) json.append(",");
                }
                json.append("]");
                response.getWriter().write(json.toString());
            }
        }
    }
}
