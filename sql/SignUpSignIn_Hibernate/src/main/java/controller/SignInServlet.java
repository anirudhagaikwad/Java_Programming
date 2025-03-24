package controller;

import model.User;
import util.HibernateUtil;
import org.hibernate.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check for null or empty username
        if (username == null || username.trim().isEmpty()) {
            response.sendRedirect("signin.html?error=Username is required");
            return;
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            User user = session.get(User.class, username.trim()); // Use trimmed value
            if (user != null && user.getPassword().equals(password)) {
                response.sendRedirect("welcome");
            } else {
                response.sendRedirect("signin.html?error=Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("signin.html?error=Server error");
        } finally {
            session.close();
        }
    }
}