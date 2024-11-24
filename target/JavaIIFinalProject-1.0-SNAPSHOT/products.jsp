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
        <link rel="stylesheet" href="styles.css">
        <a href="index.jsp">Home</a>
    </head>
    <body>
        <h1>Products</h1>

        <table border="1">
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
                <th>Actions</th> <!-- New column for actions -->
            </tr>
            <%
                List<Product> products = (List<Product>) request.getAttribute("products");
                if (products != null) {
                    for (Product product : products) {
            %>
            <tr>
                <td><%= product.getCode()%></td>
                <td><%= product.getDescription()%></td>
                <td><%= product.getPriceFormatted()%></td>
                <td>
                    <form action="editProduct" method="get" style="display:inline;">
                        <input type="hidden" name="productCode" value="<%= product.getCode()%>"/>
                        <input type="submit" value="Edit"/>
                    </form>
                    <form action="confirmDelete.jsp" method="get" style="display:inline;">
                        <input type="hidden" name="productCode" value="<%= product.getCode()%>"/>
                        <input type="hidden" name="productDescription" value="<%= product.getDescription()%>"/>
                        <input type="hidden" name="productPrice" value="<%= product.getPriceFormatted()%>"/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="4">No products available.</td>
            </tr>
            <% }%>
        </table>
        <a href="addProduct.jsp"><button>Add Product</button></a>
    </body>
</html>
