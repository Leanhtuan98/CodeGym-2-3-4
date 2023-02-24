<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 1/3/2023
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="registerModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="registerModalLabel">Sign Up</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <%--                    <div class="col-lg-12 col-xl-11">--%>
                    <%--                        <div class="card text-black" style="border-radius: 25px;">--%>
                    <%--                            <div class="card-body p-md-5">--%>
                    <%--                                <div class="row justify-content-center">--%>
                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                    <form class="row g-3 needs-validation" novalidate method="post">
                        <div class="row">
                            <label for="yourName" class="form-label">Your name</label>
                            <input type="text" class="form-control" id="yourName"
                                   aria-describedby="inputGroupPrepend" required>
                            <div class="invalid-feedback">
                                Please fill your name.
                            </div>
                        </div>

                        <div class="row">
                            <label for="validationRegisterEmail" class="form-label">Email</label>
                            <input type="email" class="form-control" id="validationRegisterEmail"
                                   aria-describedby="inputGroupPrepend" required>
                            <div class="invalid-feedback">
                                Please fill email.
                            </div>
                        </div>

                        <div class="row">
                            <label for="validationRegisterPassword"
                                   class="form-label">Password</label>
                            <input type="password" class="form-control"
                                   id="validationRegisterPassword"
                                   aria-describedby="inputGroupPrepend" required>
                            <div class="invalid-feedback">
                                Please fill password.
                            </div>
                        </div>

                        <div class="row">
                            <label for="validationRegisterRepeatPassword" class="form-label">Repeat
                                Your Password</label>
                            <input type="password" class="form-control"
                                   id="validationRegisterRepeatPassword"
                                   aria-describedby="inputGroupPrepend" required>
                            <div class="invalid-feedback">
                                Please fill your password.
                            </div>
                        </div>

                        <div class="form-check d-flex justify-content-center mb-5">
                            <input class="form-check-input me-2" type="checkbox" value=""
                                   id="form2Example3" required/>
                            <label class="form-check-label" for="form2Example3">
                                I agree all statements in <a href="#!">Terms of service</a>
                            </label>
                            <div class="invalid-feedback">
                                Please fill your password.
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Register</button>
                        </div>

                    </form>

                    <%--                                    </div>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
