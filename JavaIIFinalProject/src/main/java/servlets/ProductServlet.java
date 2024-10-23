/**
 *
 * @author djlar
 */

package servlets;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;  // Update from javax to jakarta
import jakarta.servlet.annotation.WebServlet; // Update from javax to jakarta
import jakarta.servlet.http.*; // Update from javax to jakarta
import music.business.Product;
import music.data.ProductIO;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        ProductIO.init(getServletContext().getRealPath("/WEB-INF/products.txt"));
        List<Product> products = ProductIO.selectProducts();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
    }
}
