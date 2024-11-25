package servlets;

/**
 *
 * @author djlar
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import music.data.DBUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check user credentials
        if (isValidUser(username, password)) {
            // Successful login - redirect to welcome page
            response.sendRedirect("products.jsp");
        } else {
            // Invalid credentials - redirect back to login with error
            response.sendRedirect("login.jsp?error=true");
        }
    }

    private boolean isValidUser(String username, String password) {
        boolean isValid = false;

        try (Connection conn = DBUtil.getConnection()) {
            String query = "SELECT * FROM UserPass WHERE Username = ? AND Password = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, username);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        isValid = true;  // User found with matching credentials
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log error for debugging
        }

        return isValid;
    }
}
