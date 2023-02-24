<%--
  Created by IntelliJ IDEA.
  User: Wind
  Date: 27/12/2022
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <c:forEach items="${listHV}" var="hv">
        <tr>
            <td>${hv.id}</td>
            <td>${hv.name}</td>
            <td>${hv.adress}</td>
            <td>${hv.date}</td>
            <td>${hv.phone}</td>
            <td>${hv.email}</td>
            <td>${hv.classRoom}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
