<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 12/27/2022
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<body>
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link " href="${pageContext.request.contextPath}/">
                <i class="bi bi-house"></i>
                <span>Trang chủ</span>
            </a>
        </li><!-- End Dashboard Nav -->
        <li class="nav-item">
            <a class="nav-link " href="${pageContext.request.contextPath}/view-product.jsp">
                <i class="bi bi-grid"></i>
                <span>Tất cả sản phẩm</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                <img src="https://cf.shopee.vn/file/687f3967b7c2fe6a134a2c11894eea4b_tn" height="32"
                     width="32"></img><span>Men's wear</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/ManProductServlet?action=manshirt">
                        <i class="bi bi-circle"></i><span>Shirt</span>
                    </a>
                </li>
                <li>
                    <a href="/ManProductServlet?action=mancoat">
                        <i class="bi bi-circle"></i><span>Coat</span>
                    </a>
                </li>
                <li>
                    <a href="/ManProductServlet?action=manjeans">
                        <i class="bi bi-circle"></i><span>Jeans</span>
                    </a>
                </li>
                <li>
                    <a href="/ManProductServlet?action=manshort">
                        <i class="bi bi-circle"></i><span>Short</span>
                    </a>
                </li>

            </ul>
        </li><!-- End Components Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#mobile-nav" data-bs-toggle="collapse" href="#">
                <img src="https://salt.tikicdn.com/ts/category/55/5b/80/48cbaafe144c25d5065786ecace86d38.png"
                     height="32" width="32"></img><span>Women's wear</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="mobile-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/ProductWomenServlet?action=shirtwomen ">
                        <i class="bi bi-circle"></i><span>Shirt</span>
                    </a>
                </li>
                <li>
                    <a href="/ProductWomenServlet?action=coatwomen ">
                        <i class="bi bi-circle"></i><span>Coat</span>
                    </a>
                </li>
                <li>
                    <a href="/ProductWomenServlet?action=jeanswomen">
                        <i class="bi bi-circle"></i><span>Jeans</span>
                    </a>
                </li>
                <li>
                    <a href="/ProductWomenServlet?action=dresswomen">
                        <i class="bi bi-circle"></i><span>Dress</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Forms Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#tablet-nav" data-bs-toggle="collapse" href="#">
                <img src="https://salt.tikicdn.com/cache/100x100/ts/category/13/64/43/226301adcc7660ffcf44a61bb6df99b7.png.webp"
                     height="32" width="32"></img><span>Kid's wear</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="tablet-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="#Kid-shirt.html">
                        <i class="bi bi-circle"></i><span>Shirt</span>
                    </a>
                </li>
                <li>
                    <a href="#Kid-Coat.html">
                        <i class="bi bi-circle"></i><span>Coat</span>
                    </a>
                </li>
                <li>
                    <a href="#Kid-jeans.html">
                        <i class="bi bi-circle"></i><span>Jeans</span>
                    </a>
                </li>
                <li>
                    <a href="#Kid-short.html">
                        <i class="bi bi-circle"></i><span>Short</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Forms Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed">
                <i class="bi bi-plus"></i>
                <span>
                <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#addnew">
                    Add new product
                </button></span>
            </a>
        </li><!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed">
                <span><button class="btn" type="button" data-bs-toggle="collapse"
                              data-bs-target="#topselling" aria-expanded="false" aria-controls="topselling">
                    Show TOP Selling
                </button></span>
            </a>
        </li><!-- Show top selling -->

        <li class="nav-item">
            <a class="nav-link collapsed">
                <span><button class="btn" type="button" data-bs-toggle="collapse"
                              data-bs-target="#adminview" aria-expanded="false" aria-controls="adminview">
                    Admin View Product
                </button></span>
            </a>
        </li><!-- End Contact Page Nav -->

    </ul>

</aside>

</body>
</html>
