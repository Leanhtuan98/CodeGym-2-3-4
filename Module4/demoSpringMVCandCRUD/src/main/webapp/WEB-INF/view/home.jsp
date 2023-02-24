<%--
  Created by IntelliJ IDEA.
  User: Wind
  Date: 09/01/2023
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a type="button" class="btn btn-warning" href="/create">Create</a>

<h1>List Product</h1>
<div class="container mt-3">
  <table class="table table-striped">
    <thead>
    <tr>
      <th>id</th>
      <th>name</th>
      <th>price</th>
      <th>Edit</th>
      <th>Delete</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach var="p" items="${products}">
      <tr>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.price}</td>
        <td>
          <a href="/edit?id=${p.id}" type="button" class="btn btn-warning" >Edit</a>

        </td>
        <td>
          <a type="button" class="btn btn-danger" href="/delete?id=${p.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
