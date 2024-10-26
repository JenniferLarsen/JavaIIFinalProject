<%-- 
    Document   : confirmDelete
    Created on : Oct 25, 2024, 9:13:44 AM
    Author     : megan
--%>


<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Delete</title>
    </head>
    <body>
        <h1>Are you sure you want to delete this product?</h1>
        
            <form action="deleteProduct" method="post">
            <input type="hidden" name="productId" value="${product.id}"/>
            

			<p><b>Code: </b> ${product.code}</p>
			<p><b>Description: </b> ${product.description}</p>
			<p><b>Price: </b> ${product.price}</p>
            
            <button type="submit" name="action" value="confirmDelete">Yes</button>
            <button type="button" onclick="window.location.href='products.jsp'">No</button>
    </body>
</html>

