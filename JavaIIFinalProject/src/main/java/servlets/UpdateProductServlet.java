/**
 *
 * @author djlar
 */
package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import music.business.Product;
import music.data.ProductIO;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a new product with updated details
        Product updatedProduct = new Product();
        updatedProduct.setCode(productCode);
        updatedProduct.setDescription(description);
        updatedProduct.setPrice(price);

        // Use the new method to add or update the product
        ProductIO.addOrUpdateProduct(updatedProduct);

        // Redirect back to the product list or show success message
        response.sendRedirect("/JavaIIFinalProject/products"); 
    }
}

