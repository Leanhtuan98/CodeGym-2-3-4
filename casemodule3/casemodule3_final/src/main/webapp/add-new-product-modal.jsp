<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 1/3/2023
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="addnew" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="addnewLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addnewLabel">Add new product</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="row g-3 needs-validation" novalidate>
                    <div class="row">
                        <label for="product'sName" class="form-label">Product's name</label>
                        <input type="text" class="form-control" id="product'sName"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Please enter product's name.
                        </div>
                    </div>
                    <div class="row">
                        <label for="category" class="form-label">Product's category</label>
                        <input type="text" class="form-control" id="category"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Please enter product's category.
                        </div>
                    </div>
                    <div class="row">
                        <label for="product'sType" class="form-label">Product's type</label>
                        <input type="text" class="form-control" id="product'sType"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Please enter product's type.
                        </div>
                    </div>
                    <div class="row">
                        <label for="product'sSize" class="form-label">Product's size</label>
                        <input type="text" class="form-control" id="product'sSize"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Please enter product's size.
                        </div>
                    </div>
                    <div class="row">
                        <label for="product'Price" class="form-label">Product's price</label>
                        <input type="text" class="form-control" id="product'Price"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Please enter product's price.
                        </div>
                    </div>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
