package com.example.controller;

import com.example.model.Book;
import com.example.util.HibernateUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String search = request.getParameter("search");
            List<Book> books;
            if (search != null && !search.isEmpty()) {
                books = session.createQuery("from Book where title like :search", Book.class)
                        .setParameter("search", "%" + search + "%")
                        .list();
            } else {
                books = session.createQuery("from Book", Book.class).list();
            }
            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                json.append(String.format("{\"id\":%d,\"title\":\"%s\",\"price\":%.2f,\"stock\":%d}",
                        book.getBookId(), book.getTitle(), book.getPrice(), book.getStock()));
                if (i < books.size() - 1) json.append(",");
            }
            json.append("]");
            response.getWriter().write(json.toString());
        }
    }
}