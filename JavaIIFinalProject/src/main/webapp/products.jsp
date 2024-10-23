<%-- 
    Document   : products
    Created on : Oct 23, 2024, 1:43:56?PM
    Author     : djlar
--%>

<%@ page import="music.business.Product" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Products</h1>
    
    <table border="1">
        <tr>
            <th>Code</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products != null) {
                for (Product product : products) {
        %>
        <tr>
            <td><%= product.getCode() %></td>
            <td><%= product.getDescription() %></td>
            <td><%= product.getPriceFormatted() %></td>
        </tr>
        <% 
                }
            } else { 
        %>
        <tr>
            <td colspan="3">No products available.</td>
        </tr>
        <% } %>
    </table>
</body>
</html>