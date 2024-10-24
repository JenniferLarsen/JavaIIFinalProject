package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // get parameters from the request
        String productString = request.getParameter("product");
        String descriptionString = request.getParameter("description");
        String priceString = request.getParameter("price");

        // validate the parameters
        String url;
        String message;
        String product ;
        String description;
        double price = 0;            
        try {
            product = productString;
            description = descriptionString;
            price = Double.parseDouble(priceString);            
            message = "";
            url = "/product.jsp";
            if(descriptionString!=null){
                message = "Please enter a valid price.";
            }
        }
        catch (NumberFormatException e) {
            message = "Please enter a valid price.";
            url = "/product.jsp";
            
         
        }

      
            
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
  

}
