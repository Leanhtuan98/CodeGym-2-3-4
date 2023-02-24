<%@ page import="com.example.online_electronics_store.model.User" %>
<%@ page import="com.example.online_electronics_store.model.Cart" %>
<%@ page import="com.example.online_electronics_store.dao.impl.CartDAO" %>
<%@ page import="com.example.online_electronics_store.model.CartDetails" %>
<%@ page import="com.example.online_electronics_store.dao.impl.CartDetailsDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.online_electronics_store.model.Product" %>
<%@ page import="com.example.online_electronics_store.dao.impl.FeedbackDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Norda - Minimal eCommerce HTML Template</title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png">

    <!-- All CSS is here
	============================================ -->

    <link rel="stylesheet" href="/shop/assets/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/shop/assets/css/vendor/signericafat.css">
    <link rel="stylesheet" href="/shop/assets/css/vendor/cerebrisans.css">
    <link rel="stylesheet" href="/shop/assets/css/vendor/simple-line-icons.css">
    <link rel="stylesheet" href="/shop/assets/css/vendor/elegant.css">
    <link rel="stylesheet" href="/shop/assets/css/vendor/linear-icon.css">
    <link rel="stylesheet" href="/shop/assets/css/plugins/nice-select.css">
    <link rel="stylesheet" href="/shop/assets/css/plugins/easyzoom.css">
    <link rel="stylesheet" href="/shop/assets/css/plugins/slick.css">
    <link rel="stylesheet" href="/shop/assets/css/plugins/animate.css">
    <link rel="stylesheet" href="/shop/assets/css/plugins/magnific-popup.css">
    <link rel="stylesheet" href="/shop/assets/css/plugins/jquery-ui.css">
    <link rel="stylesheet" href="/shop/assets/css/style.css">
    <style>
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
        .add-to-cart-link, .add-to-cart-link:hover {
            color: white;
            text-decoration: none;
            padding: 8px 28px;
            display: block;
        }
    </style>

</head>

<body>

    <div class="main-wrapper">
        <header class="header-area">
            <div class="container">
                <div class="header-large-device">
                    <div class="header-top header-top-ptb-1 border-bottom-1">
                        <div class="row">
                            <div class="col-xl-4 col-lg-5">
                                <div class="header-offer-wrap">
                                    <p><i class="icon-paper-plane"></i> FREE SHIPPING world wide for all orders over <span>$199</span></p>
                                </div>
                            </div>
                            <div class="col-xl-8 col-lg-7 d-flex justify-content-end">
                                <%
                                    Object userObj = session.getAttribute("user");
                                    User user = (User) userObj;
                                    if (user != null) { %>
                                <p style="color: red; margin: auto; display: inline-block">
                                    <%= "Welcome " + user.getUsername() + "!" %>
                                </p>
                                <% } %>
                                <div class="header-top-right d-flex align-items-center">
                                    <div class="social-style-1 social-style-1-mrg ms-3 d-flex align-items-center">
                                        <a href="#"><i class="icon-social-twitter"></i></a>
                                        <a href="#"><i class="icon-social-facebook"></i></a>
                                        <a href="#"><i class="icon-social-instagram"></i></a>
                                        <a href="#"><i class="icon-social-youtube"></i></a>
                                        <a href="#"><i class="icon-social-pinterest"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="header-bottom">
                        <div class="row align-items-center">
                            <div class="col-xl-2 col-lg-2">
                                <div class="logo">
                                    <a href="${pageContext.request.contextPath}/product?action=home"><img src="${pageContext.request.contextPath}/shop/assets/images/group-one-logo/group-one-logo-ver-7-edited.png" alt="logo"></a>
                                </div>
                            </div>
                            <div class="col-xl-8 col-lg-7">
                                <div class="main-menu main-menu-padding-1 main-menu-lh-1">
                                    <nav>
                                        <ul>
                                            <li><a href="${pageContext.request.contextPath}/product?action=home">HOME </a>
                                            </li>
                                            <li><a href="${pageContext.request.contextPath}/product">SHOP </a>
                                            </li>
                                            </li>
                                            <li><a href="#aboutUs">ABOUT US </a>
                                            </li>
                                            <li><a href="#contacInfo">CONTACT </a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                            <div class="col-xl-2 col-lg-3">
                                <div class="header-action header-action-flex header-action-mrg-right">
                                    <div class="same-style-2 header-search-1">
                                        <a class="search-toggle" href="#">
                                            <i class="icon-magnifier s-open"></i>
                                            <i class="icon_close s-close"></i>
                                        </a>
                                        <div class="search-wrap-1">
                                            <form action="${pageContext.request.contextPath}/product?action=search" method="post">
                                                <input placeholder="Search product" type="text" name="search">
                                                <button class="button-search"><i class="icon-magnifier"></i></button>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="same-style-2">
                                        <% if (user == null) { %>
                                        <a href="${pageContext.request.contextPath}/user"><i class="icon-user"></i></a>
                                        <% } else if (user.getRole().equals("user")) { %>
                                        <a href="${pageContext.request.contextPath}/user?action=account"><i class="icon-user"></i></a>
                                        <% } else if (user.getRole().equals("admin")) { %>
                                        <a href="${pageContext.request.contextPath}/user?action=admin"><i class="icon-user"></i></a>
                                        <% } %>
                                    </div>
                                    <div class="same-style-2 header-cart">
                                        <% if (user != null) { %>
                                            <a href="/cart">
                                            <i class="icon-basket-loaded"></i>
                                            <%
                                                Cart cart = CartDAO.getInstance().findByUser(user);
                                                List<CartDetails> cartDetailsList = CartDetailsDAO.getInstance().findByItemId(cart);
                                                int count = CartDetailsDAO.getInstance().getProductQuantity(cartDetailsList);
                                                if (count > 0) {
                                            %>
                                            <span class="pro-count red"><%= count%></span>
                                            <% } %>
                                        </a>
                                        <% } %>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div class="breadcrumb-area bg-gray">
            <div class="container">
                <div class="breadcrumb-content text-center">
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/product?action=home">Home</a>
                        </li>
                        <li class="active">Shop </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="shop-area pt-120 pb-120">
            <div class="container">
                <div class="row flex-row-reverse">
                    <div class="col-lg-9">
                        <div class="shop-topbar-wrapper">
                            <div class="shop-topbar-left">
                                <div class="view-mode nav">
                                    <a class="active" href="#shop-1" data-bs-toggle="tab"><i class="icon-grid"></i></a>
<%--                                    <a href="#shop-2" data-bs-toggle="tab"><i class="icon-menu"></i></a>--%>
                                </div>
<%--                                <p>Showing 1 - 20 of 30 results </p>--%>
                            </div>
                            <div class="product-sorting-wrapper">
                                <div class="product-show shorting-style">
                                    <label>Sort by :</label>
                                    <select onchange="sort(this)">
                                        <option value="">Default</option>
                                        <option value="/product?action=sort&condition=name">Name</option>
                                        <option value="/product?action=sort&condition=price">Price</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="shop-bottom-area">
                            <div class="tab-content jump">
                                <div id="shop-1" class="tab-pane active">
                                    <div class="row">
                                        <%
                                            List<Product> products = (List<Product>) request.getAttribute("products");
                                            for (Product p : products) {
                                        %>
                                        <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6 col-12">
                                            <div class="single-product-wrap mb-35">
                                                <div class="product-img product-img-zoom mb-15">
                                                    <a href="${pageContext.request.contextPath}/product?action=details&id=<%= p.getId()%>">
                                                        <img src="${pageContext.request.contextPath}/<%= p.getImage()%>" alt="img">
                                                    </a>
                                                    <% if (!p.isStockStatus()) { %>
                                                        <span class="pro-badge left bg-red">Out of stock</span>
                                                    <% } %>
                                                </div>
                                                <div class="product-content-wrap-2 text-center">
                                                    <div class="product-rating-wrap">
                                                        <%
                                                            Double avg = FeedbackDAO.getInstance().findAvgRate(p);
                                                            int count = avg.intValue();
                                                        %>
                                                        <div class="product-rating">
                                                            <% for (int i = 0; i < count; i++) { %>
                                                                <i class="icon_star"></i>
                                                            <% } %>
                                                        </div>
                                                        <span>(<%= (double) Math.round(avg * 100) / 100 %>)</span>
                                                    </div>
                                                    <h3><a href="${pageContext.request.contextPath}/product?action=details&id=<%= p.getId()%>"><%= p.getName()%></a></h3>
                                                    <div class="product-price-2">
                                                        <span class="new-price">$<%= p.getPrice()%></span>
                                                    </div>
                                                </div>
                                                <div class="product-content-wrap-2 product-content-position text-center">
                                                    <div class="product-rating-wrap">
                                                        <div class="product-rating">
                                                            <% for (int i = 0; i < count; i++) { %>
                                                            <i class="icon_star"></i>
                                                            <% } %>
                                                        </div>
                                                        <span>(<%= (double) Math.round(avg * 100) / 100 %>)</span>
                                                    </div>
                                                    <h3><a href="${pageContext.request.contextPath}/product?action=details&id=<%= p.getId()%>"><%= p.getName()%></a></h3>
                                                    <div class="product-price-2">
                                                        <span class="new-price">$<%= p.getPrice()%></span>
                                                    </div>
                                                    <div class="pro-add-to-cart">
                                                        <button style="border-radius: 50px" class="p-0" title="Add to Cart">
                                                            <a class="add-to-cart-link" href="${pageContext.request.contextPath}/product?action=details&id=<%= p.getId()%>">Add To Cart</a>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <% } %>
                                    </div>
                                </div>
                            </div>
                            <div class="pro-pagination-style text-center mt-10">
                                <ul>
<%--                                    <li><a class="prev" href="#"><i class="icon-arrow-left"></i></a></li>--%>
                                    <c:forEach begin="1" end="${pages}" var="i">
                                        <c:if test="${i == index}">
                                            <li><a class="active" href="${pageContext.request.contextPath}/product?action=view&page=${i}">${i}</a></li>
                                        </c:if>
                                        <c:if test="${i != index}">
                                            <li><a href="${pageContext.request.contextPath}/product?action=view&page=${i}">${i}</a></li>
                                        </c:if>
                                    </c:forEach>

                                <%--                                    <li><a class="next" href="#"><i class="icon-arrow-right"></i></a></li>--%>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="sidebar-wrapper sidebar-wrapper-mrg-right">
                        <div class="sidebar-widget mb-40">
                            <h4 class="sidebar-widget-title">Search </h4>
                            <div class="sidebar-search">
                                <form class="sidebar-search-form" action="${pageContext.request.contextPath}/product?action=search" method="post">
                                    <input type="text" name="search" placeholder="Search here...">
                                    <button>
                                        <i class="icon-magnifier"></i>
                                    </button>
                                </form>
                            </div>
                        </div>
                        <div class="sidebar-widget shop-sidebar-border mb-35 pt-40">
                            <h4 class="sidebar-widget-title">Categories </h4>
                            <div class="shop-catigory">
                                <ul>
                                    <c:forEach items="${categories}" var="c">
                                        <li><a href="/product?action=filter&category_id=${c.getId()}">
                                            <c:out value="${c.getName()}"/>
                                        </a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="sidebar-widget shop-sidebar-border mb-40 pt-40">
                            <form action="${pageContext.request.contextPath}/product?action=price" method="post">
                                <h4 class="sidebar-widget-title">Price Filter </h4>
                                <div class="price-filter">
                                    <span>Range:  $0.00 - 100.00 </span>
                                    <div class="price-slider-amount">
                                        <label for="minPrice"></label><input type="number" id="minPrice" name="min_price"
                                                                             placeholder="Min value:"/>
                                        <label for="maxPrice"></label><input type="number" id="maxPrice" name="max_price"
                                                                             placeholder="Max value:"/>
                                    </div>
                                    <div class="price-slider-amount">
                                        <button type="submit">Filter</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="about-us-area pt-85">
        <div class="container">
            <div class="border-bottom-1 about-content-pb">
                <div class="row">
                    <div class="col-lg-3 col-md-3">
                        <div class="about-us-logo">
                            <img src="${pageContext.request.contextPath}/shop/assets/images/group-one-logo/group-one-logo-ver-7.png"
                                 alt="logo">
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-9">
                        <div class="about-us-content" id="aboutUs">
                            <h3>Introduce</h3>
                            <p>GrOne store is a business concept is to offer fashion and quality at the best price.
                                It has since it was founded in 2022 grown into one of the best WooCommerce Fashion
                                Theme. The shop was built and developed by Dien, Hung, Truong from C0822I1.</p>
                            <div class="signature">
                                <h2>Dien Hung Truong</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="subscribe-area bg-gray pt-115 pb-115">
        <div class="container">
            <div class="row">
                <div class="col-lg-5 col-md-5">
                    <div class="section-title">
                        <h2>keep connected</h2>
                        <p>Get updates by subscribe our weekly newsletter</p>
                    </div>
                </div>
                <div class="col-lg-7 col-md-7">
                    <div id="mc_embed_signup" class="subscribe-form">
                        <form id="mc-embedded-subscribe-form" class="validate subscribe-form-style" novalidate=""
                              target="_blank" name="mc-embedded-subscribe-form" method="post"
                              action="https://devitems.us11.list-manage.com/subscribe/post?u=6bbb9b6f5827bd842d9640c82&amp;id=05d85f18ef">
                            <div id="mc_embed_signup_scroll" class="mc-form">
                                <input class="email" type="email" required="" placeholder="Enter your email address"
                                       name="EMAIL" value="">
                                <div class="mc-news" aria-hidden="true">
                                    <input type="text" value="" tabindex="-1"
                                           name="b_6bbb9b6f5827bd842d9640c82_05d85f18ef">
                                </div>
                                <div class="clear">
                                    <input id="mc-embedded-subscribe" class="button" type="submit" name="subscribe"
                                           value="Subscribe">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="footer-area bg-gray pb-30">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="contact-info-wrap" id="contacInfo">
                        <div class="footer-logo">
                            <a href="#"><img src="assets/images/group-one-logo/group-one-logo-ver-7-edited.png"
                                             alt="logo"></a>
                        </div>
                        <div class="single-contact-info">
                            <span>Our Location</span>
                            <p>Kent Class, Code Gym My Dinh, HD Mon City</p>
                        </div>
                        <div class="single-contact-info">
                            <span>24/7 hotline:</span>
                            <p>(+84) 966778899</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="footer-right-wrap">
                        <div class="footer-menu">
                            <nav>
                                <ul>
                                    <li><a href="#">home</a></li>
                                    <li><a href="#">Shop</a></li>
                                    <li><a href="#">Contact</a></li>
                                    <li><a href="#">Blog</a></li>
                                </ul>
                            </nav>
                        </div>
                        <div class="social-style-2 social-style-2-mrg">
                            <a href="#"><i class="social_twitter"></i></a>
                            <a href="#"><i class="social_facebook"></i></a>
                            <a href="#"><i class="social_googleplus"></i></a>
                            <a href="#"><i class="social_instagram"></i></a>
                            <a href="#"><i class="social_youtube"></i></a>
                        </div>
                        <div class="copyright">
                            <p>Copyright © 2022 HasThemes | <a href="https://hasthemes.com/">Built with
                                <span>Norda</span> by HasThemes</a>.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</div>

<!-- All JS is here
============================================ -->

<script src="/shop/assets/js/vendor/modernizr-3.11.7.min.js"></script>
<script src="/shop/assets/js/vendor/jquery-v3.6.0.min.js"></script>
<script src="/shop/assets/js/vendor/jquery-migrate-v3.3.2.min.js"></script>
<script src="/shop/assets/js/vendor/popper.min.js"></script>
<script src="/shop/assets/js/vendor/bootstrap.min.js"></script>
<script src="/shop/assets/js/plugins/slick.js"></script>
<script src="/shop/assets/js/plugins/jquery.syotimer.min.js"></script>
<script src="/shop/assets/js/plugins/jquery.nice-select.min.js"></script>
<script src="/shop/assets/js/plugins/wow.js"></script>
<script src="/shop/assets/js/plugins/jquery-ui.js"></script>
<script src="/shop/assets/js/plugins/magnific-popup.js"></script>
<script src="/shop/assets/js/plugins/sticky-sidebar.js"></script>
<script src="/shop/assets/js/plugins/easyzoom.js"></script>
<script src="/shop/assets/js/plugins/scrollup.js"></script>
<script src="/shop/assets/js/plugins/ajax-mail.js"></script>
<!-- Main JS -->
<script src="/shop/assets/js/main.js"></script>
<script>
    function sort(obj) {
        let path = obj.value;
        window.location.href = path;
    }
</script>

</body>

</html>