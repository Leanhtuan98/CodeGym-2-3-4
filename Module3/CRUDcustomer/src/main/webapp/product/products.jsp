<%--
  Created by IntelliJ IDEA.
  User: Wind
  Date: 26/12/2022
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
    <h2>SĐây là file Product.jsp</h2>
    <p>The .table-striped class adds zebra-stripes to a table:</p>
    <a href="/product/createProduct.jsp" class="btn btn-success">Create</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>status</th>
            <th>img</th>
            <th>price</th>
            <th>edit</th>
            <th>delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td><img src="${p.img}" width="250" height="200"></td>
                <c:if test="${p.status}"><td style="color: green">Sẵn sàng</td></c:if>
                <c:if test="${!p.status}"><td style="color: red">Hết hàng</td> </c:if>
                <td>${p.price}</td>
                <td><a href="/editProduct?action=edit&id=${p.id}" class="btn btn-warning" >Edit</a></td>
                <td><a href="delete?id=${p.id}" type="button" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
