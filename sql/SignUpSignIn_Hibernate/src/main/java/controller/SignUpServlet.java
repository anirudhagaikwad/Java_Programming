package controller;


import model.User;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate input
        if (username == null || username.trim().isEmpty()) {
            response.sendRedirect("signup.html?error=Username is required");
            return;
        }
        if (password == null || password.trim().isEmpty()) {
            response.sendRedirect("signup.html?error=Password is required");
            return;
        }

        User user = new User(username, password);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(user); // Use persist() instead of save()
            tx.commit();
            System.out.println("Requested URL: " + request.getRequestURI());
            response.sendRedirect("signin.html");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            response.sendRedirect("signup.html?error=Username already exists");
        } finally {
            session.close();
        }
    }
}