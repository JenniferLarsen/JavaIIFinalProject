package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author casey
 */


@WebServlet("/product")
public class NewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters from the request
        String productString = request.getParameter("product");
        String descriptionString = request.getParameter("description");
        String priceString = request.getParameter("price");

        // Validate the parameters
        String url;
        String message;
        String product = "";
        String description = "";
        double price = 0;

        try {
            product = productString;
            description = descriptionString;
            price = Double.parseDouble(priceString);
            message = "";
            url = "/product.jsp";  // Forward to JSP
        } catch (NumberFormatException e) {
            message = "Please enter a valid price.";
            url = "/product.jsp";  // Forward to JSP even on error
        }

        // Set attributes to be accessed in the JSP
        request.setAttribute("product", product);
        request.setAttribute("description", description);
        request.setAttribute("price", price);
        request.setAttribute("message", message); // Optional: Send message to JSP if needed

        // Forward the request to the JSP page
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    // Optional: Implement doGet if needed to handle GET requests for product display
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // This could be used to display the product page without needing a POST
        request.getRequestDispatcher("/product.jsp").forward(request, response);
    }
}
