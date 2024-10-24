<%-- 
    Document   : product
    Created on : Oct 19, 2024, 6:36:22 PM
    Author     : casey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    
    </head>
    <body>
   <h1>Product</h1>
      <form id="form1" name="form1" method="post" action="">
  <p>Code: 
    <input type="text" name="code"  
           value="${product.code}"/>
  </p>
  <p>Description: 
    <input type="text" name="description" 
          value="${product.description}" />
  </p>
  <p>Price: 
    <input type="text" name="price" 
           value="${product.price}"/>
  </p>
 
  <p><input type="submit" value="Update Product" id="updateProduct"  />
  </p><br></br>
  
  <p><input type="submit" value="View Product" id="viewProduct" />
  </p>
</form>
    </body>
