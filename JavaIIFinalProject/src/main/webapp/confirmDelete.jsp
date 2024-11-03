<%-- 
    Document   : confirmDelete
    Created on : Oct 25, 2024, 9:13:44 AM
    Author     : megan
--%>


<%
    String productCode = request.getParameter("productCode");
    String productDescription = request.getParameter("productDescription");
    String productPrice = request.getParameter("productPrice");
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirm Delete</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Are you sure you want to delete this product?</h1>
    
    <form action="deleteProduct" method="post">
        <input type="hidden" name="productCode" value="<%= productCode %>"/>
        
        <p><b>Code: </b> <%= productCode %></p>
        <p><b>Description: </b> <%= productDescription %></p>
        <p><b>Price: </b> <%= productPrice %></p>
        
        <button type="submit" name="action" value="confirmDelete">Yes</button>
        <button type="button" onclick="window.location.href='products'">No</button>
    </form>
</body>
</html>
