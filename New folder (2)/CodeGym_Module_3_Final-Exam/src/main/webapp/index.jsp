<%--
  Created by IntelliJ IDEA.
  User: votra
  Date: 11/28/2022
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Manager</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="index.css">
    <style>
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
    </style>

<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Manage <b>Employees</b></h2>
                </div>
                <div class="col-sm-6">
                    <a href="#addModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Add New Employee</span></a>
                </div>

            </div>
        </div>
        <div class="row">
            <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/employee?action=search"
                  method="post">
                <input class="form-control mr-sm-2" type="search" id="nameSearch" name="nameSearch"
                       placeholder="Search by Name" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>Salary</th>
                <th>Department</th>
                <th style="width: 150px">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employees}" var="e">
                <tr>
                    <td><c:out value="${e.getId()}"/></td>
                    <td><c:out value="${e.getName()}"/></td>
                    <td><c:out value="${e.getEmail()}"/></td>
                    <td><c:out value="${e.getAddress()}"/></td>
                    <td><c:out value="${e.getPhoneNumber()}"/></td>
                    <td>$<c:out value="${e.getSalary()}"/></td>
                    <td><c:out value="${e.getDepartment().getName()}"/></td>
                    <td>
                        <a href="#e${e.getId()}" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Edit" style="color:cadetblue">&#xE254;</i></a>
                        <a href="#d${e.getId()}" class="delete"
                           data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                    </td>
                        <%--                    //editModal--%>
                    <div id="e${e.getId()}" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="${pageContext.request.contextPath}/employee?action=update" method="post">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Update Employee</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                            &times;
                                        </button>
                                    </div>
                                    <input type="hidden" name="id" value="${e.getId()}">
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label>Name</label>
                                            <input type="text" class="form-control" name="name"
                                                   value="${e.getName()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input type="email" class="form-control" name="email"
                                                   value="${e.getEmail()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Address</label>
                                            <input type="text" class="form-control" name="address"
                                                   value="${e.getAddress()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Phone Number</label>
                                            <input type="text" class="form-control" name="phoneNumber"
                                                   value="${e.getPhoneNumber()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Salary</label>
                                            <input ype="number" step="0.01" class="form-control" name="salary"
                                                   value="${e.getSalary()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Department</label>
                                            <select name="department" class="form-control">
                                                <c:forEach items="${departments}" var="d">
                                                    <c:if test="${d.getId() != e.getDepartment().getId()}">
                                                        <option value="${d.getId()}"><c:out
                                                                value="${d.getName()}"/></option>
                                                    </c:if>
                                                    <c:if test="${d.getId() == e.getDepartment().getId()}">
                                                        <option selected value="${d.getId()}"><c:out
                                                                value="${d.getName()}"/></option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal"
                                               value="Cancel">
                                        <input type="submit" class="btn btn-success" value="Save">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                        <%--                    //deleteModal--%>
                    <div id="d${e.getId()}" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="${pageContext.request.contextPath}/employee?action=delete" method="post">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Delete Employee #<c:out value="${e.getId()}"/></h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                            &times;
                                        </button>
                                    </div>
                                    <input type="hidden" name="id" value="${e.getId()}">
                                    <div class="modal-body">
                                        <p>Are you sure you want to delete this Employee?</p>
                                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                                    </div>
                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal"
                                               value="Cancel">
                                        <input type="submit" class="btn btn-danger" value="Delete">
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%--adModal--%>
<div id="addModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="${pageContext.request.contextPath}/employee?action=create" method="post" id="create">
                <div class="modal-header">
                    <h4 class="modal-title">Add Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" name="name" required id="name">
                        <div id="msg"></div>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" name="email" required>
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" name="address" required>
                    </div>
                    <div class="form-group">
                        <label>Phone Number</label>
                        <input type="text" class="form-control" name="phoneNumber" required>
                    </div>
                    <div class="form-group">
                        <label>Salary</label>
                        <input type="number" step="0.01" class="form-control" name="salary" required>
                    </div>
                    <div class="form-group">
                        <label>Department</label>
                        <select name="department" class="form-control" required>
                            <option value="">Select Department</option>
                            <c:forEach items="${departments}" var="d">
                                <option id="${d.getId()}" value="${d.getId()}">${d.getName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" onclick="success()" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.6.14/dist/sweetalert2.all.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.6/bootstrap-growl.js"
        integrity="sha512-+i6fcc1vA5OwH3UNZrFDPLZVLye7fifWOt7uUDHqGs9FbPJMeVXKIJzHYSQWbZowmCKDZUse4wGlVz96n9sJ0w=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#name").on("input", function (e) {
            $('#msg').hide();
            if ($('#name').val() == null
                || $('#name').val() == "") {
                $('#msg').show();
                $("#msg")
                    .html(
                        "name is required field.")
                    .css("color", "red");
            } else {
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/servlet-ajax-username-availability/AuthServlet",
                    data: $(
                        '#create')
                        .serialize(),
                    dataType: "html",
                    cache: false,
                    success: function (
                        msg) {
                        $('#msg')
                            .show();
                        $("#msg")
                            .html(
                                msg);
                    },
                    error: function (
                        jqXHR,
                        textStatus,
                        errorThrown) {
                        $('#msg')
                            .show();
                        $("#msg")
                            .html(
                                textStatus
                                + " "
                                + errorThrown);
                    }
                });
            }
        });
    });
</script>
</body>
</html>
