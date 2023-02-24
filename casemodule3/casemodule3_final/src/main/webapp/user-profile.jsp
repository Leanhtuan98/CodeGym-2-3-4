<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="${pageContext.request.contextPath}/head.jsp">
    <jsp:param name="head" value=""/>
</jsp:include>


<body>
<jsp:include page='/header.jsp'>
    <jsp:param name="header" value=""/>
</jsp:include>
<jsp:include page='/sidebar.jsp'>
    <jsp:param name="asside" value=""/>
</jsp:include>
<%--<jsp:include page="WEB-INF/common/footer.jsp">--%>
<%--    <jsp:param name="footer" value=""/>--%>
<%--</jsp:include>--%>
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Profile</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li class="breadcrumb-item">User's profile</li>
                <%--                <li class="breadcrumb-item active">Profile</li>--%>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section profile">
        <div class="row">
            <div class="col-xl-3">

                <div class="card">
                    <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

                        <img src="${pageContext.servletContext.contextPath}/img/blank-user.png"
                             alt="Profile" class="rounded-circle">
                        <h2>User's name</h2>
                        <h3>Somethings</h3>
                    </div>
                </div>

            </div>

            <div class="col-xl-9">

                <div class="card">
                    <div class="card-body pt-3">
                        <!-- Bordered Tabs -->
                        <ul class="nav nav-tabs nav-tabs-bordered">

                            <li class="nav-item">
                                <button class="nav-link active" data-bs-toggle="tab"
                                        data-bs-target="#profile-transaction-history">
                                    Transaction History
                                </button>
                            </li>

                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Edit
                                    Profile
                                </button>
                            </li>

                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-settings">
                                    Settings
                                </button>
                            </li>

                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">
                                    Change Password
                                </button>
                            </li>

                        </ul>
                        <div class="tab-content pt-2">
                            <div class="tab-pane fade show active profile-transaction-history"
                                 id="profile-transaction-history">
                                <h5 class="card-title">Transaction history</h5>

                                <div class="row">
                                    <div id="content" class="p-4 p-md-5 pt-5">
                                        <c:forEach var="bill" items="${billinfos}">
                                            <!-- Modal edit-->
                                            <div class="modal fade" id="staticBackdrop${bill.billID}"
                                                 data-bs-backdrop="static"
                                                 data-bs-keyboard="false" tabindex="-1"
                                                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="staticBackdropLabe">Thông tin
                                                                hoá đơn:</h5>
                                                            <button type="button" class="btn-close"
                                                                    data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">

                                                                <%--<input name="productID" placeholder="nhập id"><br>--%>
                                                            <p>Khách hàng:${bill.name}</p>
                                                            <p>Thời gian mua:${bill.date}</p>
                                                            <table id="myTable" class="table table-striped">
                                                                <thead>
                                                                <tr>
                                                                    <th>Tên sản phẩm</th>
                                                                    <th>Số lượng</th>
                                                                    <th>Giá</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>

                                                                    <%--@elvariable id="products" type="java.util.List"--%>
                                                                <c:forEach var="detail" items="${billDetails}">
                                                                    <tr>
                                                                        <c:if test="${detail.billID == bill.billID}">
                                                                            <td>${detail.productID}</td>
                                                                            <td>${detail.amount}</td>
                                                                            <td>${detail.price}</td>
                                                                        </c:if>


                                                                    </tr>
                                                                </c:forEach>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal">Close
                                                            </button>
                                                            <button type="button" class="btn btn-primary">Understood
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>

                                        <table class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th>id Hoá đơn</th>
                                                <th>id người dùng</th>
                                                <th>Tên người dùng</th>
                                                <th>Tổng hoá đơn</th>
                                                <th>Ngày giao dịch</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%--@elvariable id="products" type="java.util.List"--%>
                                            <c:forEach var="bill" items="${billinfos}">
                                                <tr>
                                                    <td>${bill.billID}</td>
                                                    <td>${bill.userID}</td>
                                                    <td>${bill.name}</td>
                                                    <td>${bill.total}</td>
                                                    <td>${bill.date}</td>

                                                    <td>
                                                        <button id="${bill.billID}" type="button"
                                                                class="btn btn-primary" data-bs-toggle="modal"
                                                                data-bs-target="#staticBackdrop${bill.billID}">
                                                            Xem chi tiết
                                                        </button>
                                                    </td>
                                                    <td>
                                                        <a href="?id=${bill.billID}"
                                                           class="btn btn-danger">Xoá</a></td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>


                                </div>


                            </div>

                            <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                                <!-- Profile Edit Form -->
                                <form>
                                    <div class="row mb-3">
                                        <%--@declare id="profileimage"--%><label for="profileImage"
                                                                                 class="col-md-4 col-lg-3 col-form-label">Profile
                                        Image</label>
                                        <div class="col-md-8 col-lg-9">
                                            <img src="${pageContext.servletContext.contextPath}resource/assets/img/blank-user.png"
                                                 alt="Profile">
                                            <div class="pt-2">
                                                <a href="#" class="btn btn-primary btn-sm"
                                                   title="Upload new profile image"><i class="bi bi-upload"></i></a>
                                                <a href="#" class="btn btn-danger btn-sm"
                                                   title="Remove my profile image"><i class="bi bi-trash"></i></a>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Full Name</label>
                                        <div class="col-md-8 col-lg-9">
                                            <input name="fullName" type="text" class="form-control" id="fullName"
                                                   value="name">
                                        </div>
                                    </div>





                                    <div class="row mb-3">
                                        <label for="Address" class="col-md-4 col-lg-3 col-form-label">Address</label>
                                        <div class="col-md-8 col-lg-9">
                                            <input name="address" type="text" class="form-control" id="Address"
                                                   value="A108 Adam Street, New York, NY 535022">
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <label for="Phone" class="col-md-4 col-lg-3 col-form-label">Phone</label>
                                        <div class="col-md-8 col-lg-9">
                                            <input name="phone" type="text" class="form-control" id="Phone"
                                                   value="(436) 486-3538 x29071">
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <label for="Email" class="col-md-4 col-lg-3 col-form-label">Email</label>
                                        <div class="col-md-8 col-lg-9">
                                            <input name="email" type="email" class="form-control" id="Email"
                                                   value="k.anderson@example.com">
                                        </div>
                                    </div>





                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary">Save Changes</button>
                                    </div>
                                </form><!-- End Profile Edit Form -->

                            </div>


                            <div class="tab-pane fade pt-3" id="profile-change-password">
                                <!-- Change Password Form -->
                                <form>

                                    <div class="row mb-3">
                                        <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Current
                                            Password</label>
                                        <div class="col-md-8 col-lg-9">
                                            <input name="password" type="password" class="form-control"
                                                   id="currentPassword">
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">New
                                            Password</label>
                                        <div class="col-md-8 col-lg-9">
                                            <input name="newpassword" type="password" class="form-control"
                                                   id="newPassword">
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Re-enter New
                                            Password</label>
                                        <div class="col-md-8 col-lg-9">
                                            <input name="renewpassword" type="password" class="form-control"
                                                   id="renewPassword">
                                        </div>
                                    </div>

                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary">Change Password</button>
                                    </div>
                                </form><!-- End Change Password Form -->

                            </div>

                        </div><!-- End Bordered Tabs -->

                    </div>
                </div>

            </div>
        </div>
    </section>

</main><!-- End #main -->

<!-- ======= Footer ======= -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<%--<script src="${pageContext.servletContext.contextPath}/resource/assets/vendor/apexcharts/apexcharts.min.js"></script>--%>
<%--<script src="${pageContext.servletContext.contextPath}/resource/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>--%>
<%--<script src="${pageContext.servletContext.contextPath}/resource/assets/vendor/chart.js/chart.min.js"></script>--%>
<%--<script src="${pageContext.servletContext.contextPath}/resource/assets/vendor/echarts/echarts.min.js"></script>--%>
<%--<script src="${pageContext.servletContext.contextPath}/resource/assets/vendor/quill/quill.min.js"></script>--%>
<%--<script src="${pageContext.servletContext.contextPath}/resource/assets/vendor/simple-datatables/simple-datatables.js"></script>--%>
<%--<script src="${pageContext.servletContext.contextPath}/resource/assets/vendor/tinymce/tinymce.min.js"></script>--%>
<%--<script src="${pageContext.servletContext.contextPath}/resource/assets/vendor/php-email-form/validate.js"></script>--%>

<!-- Template Main JS File -->
<script src="${pageContext.servletContext.contextPath}resource/assets/js/main.js"></script>

</body>

</html>

