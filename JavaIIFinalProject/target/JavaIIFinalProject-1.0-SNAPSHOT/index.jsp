<%-- 
    Document   : index
    Author     : 1ellis
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Maintenance - Index Page</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Product Maintenance Application</h1>
    </header>

    <!-- Navigation Bar -->
    <nav class="nav">
        <ul class="nav-links">
            <li><a href="#">Home</a></li>
            <li>
                <a href="#">Products</a>
                <ul class="dropdown">
                    <li><a href="products">View Products</a></li>
                    <li><a href="addProduct.jsp">Add Product</a></li>
                </ul>
            </li>
        </ul>
    </nav>

    <main class="main">
        <section>
            <h2>Welcome to the Product Maintenance Application</h2>
            <p>This application allows you to manage your product inventory efficiently. You can add, update, or delete products as needed.</p>
        </section>

        <section>
            <h3>Important Notes</h3>
            <p>As you navigate through the application, please remember:</p>
            <ul>
                <li>Each project builds upon the previous projects.</li>
                <li>Ensure all product data is validated before submission.</li>
            </ul>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 Product Maintenance Application. All Rights Reserved.</p>
    </footer>
</body>
</html>
