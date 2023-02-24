<%--
  Created by IntelliJ IDEA.
  User: Wind
  Date: 26/12/2022
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Edit Product</h1>
<form method="post">
  <input name="id" placeholder="nhập id" value="${toan.id}" readonly><br>
  <input name="name" placeholder="nhập name" value="${toan.name}"><br>
  <input name="img" placeholder="nhập img" value="${toan.img}"><br>
  <input name="price" placeholder="nhập price" value="${toan.price}"><br>
  <button type="submit">Edit</button>
</form>
</body>
</html>
