package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;  // Update from javax to jakarta
import jakarta.servlet.annotation.WebServlet; // Update from javax to jakarta
import jakarta.servlet.http.*; // Update from javax to jakarta
import music.business.Product;
import music.data.ProductIO;

/**
 *
 * @author djlar
 */


@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productCode = request.getParameter("productCode"); // Retrieve the product code

        // Fetch the product by code
        Product product = ProductIO.selectProductByCode(productCode); // This should return the product if found

        // Set the product in the request for editing
        if (product != null) {
            request.setAttribute("product", product);
            getServletContext().getRequestDispatcher("/editProduct.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Product not found.");
            getServletContext().getRequestDispatcher("/products").forward(request, response);
        }
    }
}




