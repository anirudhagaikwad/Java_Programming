package com.example.controller;



import com.example.model.User;
import com.example.util.HibernateUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import java.io.IOException;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();
        HttpSession session = request.getSession();

        try (Session dbSession = HibernateUtil.getSessionFactory().openSession()) {
            if ("/register".equals(path)) {
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password"); // In production, hash this!
                User user = new User();
                user.setUsername(username);
                user.setEmail(email);
                user.setPasswordHash(password); // Placeholder; use bcrypt in production
                dbSession.beginTransaction();
                dbSession.persist(user);
                dbSession.getTransaction().commit();
                response.sendRedirect("/online-bookshop/login.html");
            } else if ("/login".equals(path)) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                User user = dbSession.createQuery("from User where username = :username", User.class)
                        .setParameter("username", username)
                        .uniqueResult();
                if (user != null && user.getPasswordHash().equals(password)) { // Compare hashed passwords in production
                    session.setAttribute("user", user);
                    response.sendRedirect("/online-bookshop/index.html");
                } else {
                    response.sendRedirect("/online-bookshop/login.html?error=invalid");
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo();
        if ("/logout".equals(path)) {
            request.getSession().invalidate();
            response.sendRedirect("/online-bookshop/index.html");
        }
    }
}
