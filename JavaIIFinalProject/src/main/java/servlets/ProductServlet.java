/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

/**
 *
 * @author djlar
 */

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
