<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 1/3/2023
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<modal>
  <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="loginModalLabel">Login</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form class="row g-3 needs-validation" novalidate method="post">
            <div class="row">
              <label for="validationLoginEmail" class="form-label">Email/ID</label>
              <input type="text" class="form-control" id="validationLoginEmail"
                     aria-describedby="inputGroupPrepend" required>
              <div class="invalid-feedback">
                Please fill email or user ID.
              </div>
            </div>
            <div class="row">
              <label for="validationUserPassword" class="form-label">Password</label>
              <div class="input-group has-validation">
                <input type="password" class="form-control" id="validationUserPassword"
                       aria-describedby="inputGroupPrepend" required>
                <div class="invalid-feedback">
                  Please fill the correct password.
                </div>
              </div>
            </div>
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary">Login</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</modal>
</body>
</html>
