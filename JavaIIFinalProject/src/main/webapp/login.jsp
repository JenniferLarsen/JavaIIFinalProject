<%-- 
    Document   : login
    Created on : Nov 20, 2024, 12:39:17 PM
    Author     : Ellis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Please Log In</h2>
    <form method="post" action="j_security_check">
        <label for="username">Username:</label>
        <input type="text" id="username" name="j_username" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="j_password" required><br><br>
        <button type="submit">Login</button>
    </form>
</body>
</html>

