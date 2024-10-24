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

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a new product with the provided details
        Product newProduct = new Product();
        newProduct.setCode(productCode);
        newProduct.setDescription(description);
        newProduct.setPrice(price);

        // Use the method to add the new product
        ProductIO.addOrUpdateProduct(newProduct);

        // Redirect back to the products page
        response.sendRedirect("/JavaIIFinalProject/products");
    }
}

