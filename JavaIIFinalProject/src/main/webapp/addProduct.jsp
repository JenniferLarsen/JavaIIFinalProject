<%-- 
    Document   : addProduct
    Created on : Oct 23, 2024, 10:08:11 PM
    Author     : djlar
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h1>Add New Product</h1>
    <form action="addProduct" method="post">
        <p>Code: <input type="text" name="productCode" required /></p>
        <p>Description: <input type="text" name="description" required /></p>
        <p>Price: <input type="text" name="price" required /></p>
        <p><input type="submit" value="Add Product" /></p>
    </form>
</body>
</html>
