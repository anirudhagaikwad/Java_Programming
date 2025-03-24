package com.example.controller;


import com.example.model.Book;
import com.example.util.HibernateUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import java.io.IOException;

@WebServlet("/admin/book")
public class AdminController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Simple admin check (in production, use proper role-based access)
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/online-bookshop/login.html");
            return;
        }

        String title = request.getParameter("title");
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String isbn = request.getParameter("isbn");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Book book = new Book();
            book.setTitle(title);
            book.setAuthorId(authorId);
            book.setCategoryId(categoryId);
            book.setPrice(price);
            book.setStock(stock);
            book.setIsbn(isbn);
            session.persist(book);
            session.getTransaction().commit();
            response.sendRedirect("/online-bookshop/index.html");
        }
    }
}
