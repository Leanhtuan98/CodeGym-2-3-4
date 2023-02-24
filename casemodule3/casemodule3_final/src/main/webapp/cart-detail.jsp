<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
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
    <section class="section">
        <!-- Topbar End -->
        <!-- Cart Start -->
        <div class="container-fluid pt-5">
            <div class="row px-xl-5">
                <div class="col-lg-8 table-responsive mb-5">
                    <table class="table table-bordered text-center mb-0">
                        <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Size</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Remove</th>
                        </tr>
                        </thead>
                        <tbody class="align-middle">
                        <tr>
                            <td class="align-middle"><img
                                    src="${pageContext.servletContext.contextPath}img/product-1.jpg" alt=""
                                    style="width: 50px;"> Colorful
                                Stylish Shirt
                            </td>
                            <td class="align-middle">$150</td>
                            <td><select>
                                <option>S</option>
                                <option>M</option>
                                <option>L</option>
                                <option>XL</option>
                            </select></td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-minus">
                                            <i class="bi-dash"></i>
                                        </button>
                                    </div>
                                    <input type="text" class="form-control form-control-sm bg-secondary text-center"
                                           value="1">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-plus">
                                            <i class="bi-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle">$150</td>

                            <td class="align-middle">
                                <button class="btn btn-sm btn-primary"><i class="bi-x"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <td class="align-middle"><img
                                    src="${pageContext.servletContext.contextPath}img/product-2.jpg" alt=""
                                    style="width: 50px;"> Colorful
                                Stylish Shirt
                            </td>
                            <td class="align-middle">$150</td>
                            <td><select>
                                <option>S</option>
                                <option>M</option>
                                <option>L</option>
                                <option>XL</option>
                            </select></td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-minus">
                                            <i class="bi-dash"></i>
                                        </button>
                                    </div>
                                    <input type="text" class="form-control form-control-sm bg-secondary text-center"
                                           value="1">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-plus">
                                            <i class="bi-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle">$150</td>
                            <td class="align-middle">
                                <button class="btn btn-sm btn-primary"><i class="bi-x"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <td class="align-middle"><img
                                    src="${pageContext.servletContext.contextPath}img/product-3.jpg" alt=""
                                    style="width: 50px;"> Colorful
                                Stylish Shirt
                            </td>
                            <td class="align-middle">$150</td>
                            <td><select>
                                <option>S</option>
                                <option>M</option>
                                <option>L</option>
                                <option>XL</option>
                            </select></td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-minus">
                                            <i class="bi-dash"></i>
                                        </button>
                                    </div>
                                    <input type="text" class="form-control form-control-sm bg-secondary text-center"
                                           value="1">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-plus">
                                            <i class="bi-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle">$150</td>
                            <td class="align-middle">
                                <button class="btn btn-sm btn-primary"><i class="bi-x"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <td class="align-middle"><img
                                    src="${pageContext.servletContext.contextPath}img/product-4.jpg" alt=""
                                    style="width: 50px;"> Colorful
                                Stylish Shirt
                            </td>
                            <td class="align-middle">$150</td>
                            <td><select>
                                <option>S</option>
                                <option>M</option>
                                <option>L</option>
                                <option>XL</option>
                            </select></td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-minus">
                                            <i class="bi-dash"></i>
                                        </button>
                                    </div>
                                    <input type="text" class="form-control form-control-sm bg-secondary text-center"
                                           value="1">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-plus">
                                            <i class="bi-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle">$150</td>

                            <td class="align-middle">
                                <button class="btn btn-sm btn-primary"><i class="bi-x"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <td class="align-middle"><img
                                    src="${pageContext.servletContext.contextPath}img/product-5.jpg" alt=""
                                    style="width: 50px;"> Colorful
                                Stylish Shirt
                            </td>
                            <td class="align-middle">$150</td>
                            <td><select>
                                <option>S</option>
                                <option>M</option>
                                <option>L</option>
                                <option>XL</option>
                            </select></td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-minus">
                                            <i class="bi-dash"></i>
                                        </button>
                                    </div>
                                    <input type="text" class="form-control form-control-sm bg-secondary text-center"
                                           value="1">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-plus">
                                            <i class="bi-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle">$150</td>
                            <td class="align-middle">
                                <button class="btn btn-sm btn-primary"><i class="bi-x"></i></button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-4">
                    <form class="mb-5" action="">
                        <div class="input-group">
                            <input type="text" class="form-control p-4" placeholder="Coupon Code">
                            <div class="input-group-append">
                                <button class="btn btn-primary">Apply Coupon</button>
                            </div>
                        </div>
                    </form>
                    <div class="card border-secondary mb-5">
                        <div class="card-header bg-secondary border-0">
                            <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                        </div>
                        <div class="card-body">
                            <div class="d-flex justify-content-between mb-3 pt-1">
                                <h6 class="font-weight-medium">Subtotal</h6>
                                <h6 class="font-weight-medium">$150</h6>
                            </div>
                            <div class="d-flex justify-content-between">
                                <h6 class="font-weight-medium">Shipping</h6>
                                <h6 class="font-weight-medium">$10</h6>
                            </div>
                        </div>
                        <div class="card-footer border-secondary bg-transparent">
                            <div class="d-flex justify-content-between mt-2">
                                <h5 class="font-weight-bold">Total</h5>
                                <h5 class="font-weight-bold">$160</h5>
                            </div>
                            <button class="btn btn-block btn-primary my-3 py-3">Proceed To Checkout</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cart End -->

    </section>
    <!-- Vendor End -->
</main>
<!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>Tran Huy Media Mart</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
        <%--        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>--%>
    </div>
</footer><!-- End Footer -->
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<!-- Vendor JS Files -->
<%--<script src="resource/assets/vendor/apexcharts/apexcharts.min.js"></script>--%>
<%--<script src="resource/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>--%>
<%--<script src="resource/assets/vendor/chart.js/chart.min.js"></script>--%>
<%--<script src="resource/assets/vendor/echarts/echarts.min.js"></script>--%>
<%--<script src="resource/assets/vendor/quill/quill.min.js"></script>--%>
<%--<script src="resource/assets/vendor/simple-datatables/simple-datatables.js"></script>--%>
<%--<script src="resource/assets/vendor/tinymce/tinymce.min.js"></script>--%>
<%--<script src="resource/assets/vendor/php-email-form/validate.js"></script>--%>

<!-- Template Main JS File -->
<script src="${pageContext.servletContext.contextPath}resource/assets/js/main.js"></script>

</body>

</html>
