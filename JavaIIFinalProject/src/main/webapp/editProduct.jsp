<%-- 
    Document   : editProduct.jsp
    Created on : Oct 23, 2024, 9:31:58 PM
    Author     : djlar
--%>

<%@ page import="music.business.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Edit Product</h1>
    <%
        Product product = (Product) request.getAttribute("product");
        if (product != null) {
    %>
    <form action="updateProduct" method="post">
        <input type="hidden" name="productCode" value="<%= product.getCode() %>"/>
        <p>
            Code: <%= product.getCode() %> (read-only)
        </p>
        <p>
            Description: <input type="text" name="description" value="<%= product.getDescription() %>" required/>
        </p>
        <p>
            Price: <input type="text" name="price" value="<%= product.getPrice() %>" required/>
        </p>
        <p>
            <input type="submit" value="Update Product"/>
        </p>
    </form>
    <%
        } else {
    %>
        <p>Error: Product not found.</p>
    <%
        }
    %>
    <a href="products">Back to Product List</a>
</body>
</html>
