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
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productCode = request.getParameter("productCode"); 
        
        // Call a method to delete the product by code
        ProductIO.deleteProductByCode(productCode); // Implement this method in ProductIO
        
        // Redirect to the product list page after deletion
        response.sendRedirect("products"); 
    }
}

