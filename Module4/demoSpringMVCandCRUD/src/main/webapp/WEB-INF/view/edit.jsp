<%--
  Created by IntelliJ IDEA.
  User: Wind
  Date: 09/01/2023
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Product</h1>
<form action="/edit" method="post">
    <input name="id" placeholder="nhập id" value="${edit.id}" readonly><br>
    <input name="name" placeholder="nhập name" value="${edit.name}"><br>
    <input name="price" placeholder="nhập price" value="${edit.price}"><br>
    <button type="submit">Edit</button>
</form>
</body>
</html>
