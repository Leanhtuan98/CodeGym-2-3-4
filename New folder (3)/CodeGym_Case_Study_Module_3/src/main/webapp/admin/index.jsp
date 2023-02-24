<%@ page import="com.example.online_electronics_store.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>GRONE Admin Dashboard</title>
    <link rel="icon" type="image/x-icon" href="/admin/assets/img/favicon.ico"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
    <link href="/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/admin/assets/css/plugins.css" rel="stylesheet" type="text/css" />
    <!-- END GLOBAL MANDATORY STYLES -->

    <!-- BEGIN PAGE LEVEL PLUGINS/CUSTOM STYLES -->
    <link href="/admin/assets/css/support-chat.css" rel="stylesheet" type="text/css" />
    <link href="/admin/plugins/maps/vector/jvector/jquery-jvectormap-2.0.3.css" rel="stylesheet" type="text/css" />
    <link href="/admin/plugins/charts/chartist/chartist.css" rel="stylesheet" type="text/css">
    <link href="/admin/assets/css/default-dashboard/style.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL PLUGINS/CUSTOM STYLES -->   

</head>
<body class="default-sidebar">
    <!--  BEGIN NAVBAR  -->
    <header class="header navbar fixed-top navbar-expand-sm">
        <a href="javascript:void(0);" class="sidebarCollapse d-none d-lg-block" data-placement="bottom"><i class="flaticon-menu-line-2"></i></a>

        <ul class="navbar-nav flex-row ml-lg-auto">

            <li class="nav-item dropdown user-profile-dropdown ml-lg-0 mr-lg-2 ml-3 order-lg-0 order-1">
                <a href="javascript:void(0);" class="nav-link dropdown-toggle user" id="userProfileDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="flaticon-user-12"></span>
                </a>
                <div class="dropdown-menu  position-absolute" aria-labelledby="userProfileDropdown">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/user?action=logout">
                        <i class="mr-1 flaticon-power-button"></i> <span>Log Out</span>
                    </a>
                </div>
            </li>

        </ul>
    </header>
    <!--  END NAVBAR  -->

    <!--  BEGIN MAIN CONTAINER  -->
    <div class="main-container" id="container">

        <div class="overlay"></div>
        <div class="cs-overlay"></div>

        <!--  BEGIN SIDEBAR  -->

        <div class="sidebar-wrapper sidebar-theme">
            
            <div id="dismiss" class="d-lg-none"><i class="flaticon-cancel-12"></i></div>
            
            <nav id="sidebar">

                <ul class="navbar-nav theme-brand flex-row  d-none d-lg-flex">
                    <li class="nav-item theme-text">
                        <a href="${pageContext.request.contextPath}/user?action=showAdminDashboard" class="nav-link"> GRONE </a>
                    </li>
                </ul>


                <ul class="list-unstyled menu-categories" id="accordionExample">
                    <li class="menu">
                        <a href="${pageContext.request.contextPath}/user?action=showAdminDashboard"  aria-expanded="true" class="dropdown-toggle">
                            <div class="">
                                <i class="flaticon-computer-6 ml-3"></i>
                                <span>Dashboard</span>
                            </div>
                        </a>
                        <ul class="collapse submenu list-unstyled show" id="dashboard" data-parent="#accordionExample">
                            <li class="active">
                                <a href="${pageContext.request.contextPath}/product?action=viewByAdmin"> <i class="flaticon-package"></i> Product </a>
                            </li>
                            <li class="active">
                                <a href="${pageContext.request.contextPath}/user?action=viewByAdmin"> <i class="flaticon-user-1"></i> User </a>
                            </li>
                            <li class="active">
                                <a href="${pageContext.request.contextPath}/category?action=viewByAdmin"> <i class="flaticon-menu-dot-fill"></i> Category </a>
                            </li>
                        </ul>
                    </li>

                </ul>
            </nav>

        </div>

        <!--  END SIDEBAR  -->
        
        <!--  BEGIN CONTENT PART  -->
        <div id="content" class="main-content">
            <div class="container">
                <div class="page-header">
                    <div class="page-title">
                        <h3>GRONE Ecommerce admin dashboard</h3>
                    </div>
                </div>

                <div class="row layout-spacing ">

                    <div class="col-xl-3 mb-xl-0 col-lg-6 mb-4 col-md-6 col-sm-6">
                        <div class="widget-content-area  data-widgets br-4">
                            <div class="widget  t-sales-widget">
                                <div class="media">
                                    <div class="icon ml-2">
                                        <i class="flaticon-package"></i>
                                    </div>
                                    <div class="media-body text-right">
                                        <p class="widget-text mb-0">Products</p>
                                        <p class="widget-numeric-value"><c:out value="${totalP}"/></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-xl-3 mb-xl-0 col-lg-6 mb-4 col-md-6 col-sm-6">
                        <div class="widget-content-area  data-widgets br-4">
                            <div class="widget  t-order-widget">
                                <div class="media">
                                    <div class="icon ml-2">
                                        <i class="flaticon-cart-bag"></i>
                                    </div>
                                    <div class="media-body text-right">
                                        <p class="widget-text mb-0">Orders</p>
                                        <p class="widget-numeric-value"><c:out value="${totalO}"/></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-xl-3 col-lg-6 col-md-6 col-sm-6 mb-sm-0 mb-4">
                        <div class="widget-content-area  data-widgets br-4">
                            <div class="widget  t-customer-widget">
                                <div class="media">
                                    <div class="icon ml-2">
                                        <i class="flaticon-user-11"></i>
                                    </div>
                                    <div class="media-body text-right">
                                        <p class="widget-text mb-0">Customers</p>
                                        <p class="widget-numeric-value"><c:out value="${totalU}"/></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-xl-3 col-lg-6 col-md-6 col-sm-6">
                        
                        <div class="widget-content-area  data-widgets br-4">
                            <div class="widget  t-income-widget">
                                <div class="media">
                                    <div class="icon ml-2">
                                        <i class="flaticon-menu-dot-fill"></i>
                                    </div>
                                    <div class="media-body text-right">
                                        <p class="widget-text mb-0">Category</p>
                                        <p class="widget-numeric-value"><c:out value="${totalC}"/></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-xl-8 col-lg-12 col-md-12 col-12 layout-spacing">
                        <div class="widget-content-area event-calendar p-0 br-4">
                            <div class="calendar"><div class="pignose-calendar pignose-calendar-light br-4 pignose-calendar-default">												<div class="pignose-calendar-top br-4">													<a href="#" class="pignose-calendar-top-nav pignose-calendar-top-prev">														<span class="flaticon-left-arrow-fill pignose-calendar-top-icon"></span>													</a>													<div class="pignose-calendar-top-date">														<span class="pignose-calendar-top-month">December</span> &nbsp;<span class="pignose-calendar-top-year">2022</span>													</div>													<a href="#" class="pignose-calendar-top-nav pignose-calendar-top-next">														<span class="flaticon-right-arrow-fill pignose-calendar-top-icon"></span>													</a>												</div>												<div class="pignose-calendar-header"><div class="pignose-calendar-week pignose-calendar-week-su">SU</div><div class="pignose-calendar-week pignose-calendar-week-mo">MO</div><div class="pignose-calendar-week pignose-calendar-week-tu">TU</div><div class="pignose-calendar-week pignose-calendar-week-we">WE</div><div class="pignose-calendar-week pignose-calendar-week-th">TH</div><div class="pignose-calendar-week pignose-calendar-week-fr">FR</div><div class="pignose-calendar-week pignose-calendar-week-sa">SA</div></div>												<div class="pignose-calendar-body"><div class="pignose-calendar-row"><div class="pignose-calendar-unit pignose-calendar-unit-su"></div><div class="pignose-calendar-unit pignose-calendar-unit-mo"></div><div class="pignose-calendar-unit pignose-calendar-unit-tu"></div><div class="pignose-calendar-unit pignose-calendar-unit-we"></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-th" data-date="2022-12-01"><a href="#">1</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-fr" data-date="2022-12-02"><a href="#">2</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-sa" data-date="2022-12-03"><a href="#">3</a></div></div><div class="pignose-calendar-row"><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-su" data-date="2022-12-04"><a href="#">4</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-mo" data-date="2022-12-05"><a href="#">5</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-tu pignose-calendar-unit-active pignose-calendar-unit-first-active" data-date="2022-12-06"><a href="#">6</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-we" data-date="2022-12-07"><a href="#">7</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-th" data-date="2022-12-08"><a href="#">8</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-fr" data-date="2022-12-09"><a href="#">9</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-sa" data-date="2022-12-10"><a href="#">10</a></div></div><div class="pignose-calendar-row"><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-su" data-date="2022-12-11"><a href="#">11</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-mo" data-date="2022-12-12"><a href="#">12</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-tu" data-date="2022-12-13"><a href="#">13</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-we" data-date="2022-12-14"><a href="#">14</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-th" data-date="2022-12-15"><a href="#">15</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-fr" data-date="2022-12-16"><a href="#">16</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-sa" data-date="2022-12-17"><a href="#">17</a></div></div><div class="pignose-calendar-row"><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-su" data-date="2022-12-18"><a href="#">18</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-mo" data-date="2022-12-19"><a href="#">19</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-tu" data-date="2022-12-20"><a href="#">20</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-we" data-date="2022-12-21"><a href="#">21</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-th" data-date="2022-12-22"><a href="#">22</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-fr" data-date="2022-12-23"><a href="#">23</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-sa" data-date="2022-12-24"><a href="#">24</a></div></div><div class="pignose-calendar-row"><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-su" data-date="2022-12-25"><a href="#">25</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-mo" data-date="2022-12-26"><a href="#">26</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-tu" data-date="2022-12-27"><a href="#">27</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-we" data-date="2022-12-28"><a href="#">28</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-th" data-date="2022-12-29"><a href="#">29</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-fr" data-date="2022-12-30"><a href="#">30</a></div><div class="pignose-calendar-unit pignose-calendar-unit-date pignose-calendar-unit-sa" data-date="2022-12-31"><a href="#">31</a></div></div></div>											</div></div>
                        </div>
                    </div>

                    <div class="col-xl-4 col-lg-6 col-md-6 col-12 layout-spacing">
                        <div class="widget-content-area card-widget p-0  br-4">
                            <div class="card-1 br-4">
                                <div class="d-flex justify-content-between mb-5">
                                    <p class="card-title">Team Meeting</p>
                                    <p class="meta-time">12:30 - 2:30 PM</p>
                                </div>

                                <div class="row">
                                    <div class="col-md-12 mb-4">
                                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                        <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                    </div>

                                    <div class="col-md-12 text-center mt-sm-3">
                                        <button class="btn btn-outline-default btn-rounded">View Details</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>


            </div>
        </div>
        <!--  END CONTENT PART  -->

    </div>
    <!-- END MAIN CONTAINER -->

    <!--  BEGIN FOOTER  -->
    <footer class="footer-section theme-footer">

        <div class="footer-section-1  sidebar-theme">
            
        </div>

        <div class="footer-section-2 container-fluid">
            <div class="row">
                <div class="col-xl-12 col-md-12 col-sm-12 col-12">
                    <ul class="list-inline mb-0 d-flex justify-content-sm-end justify-content-center mr-sm-3 ml-sm-0 mx-3">
                        <li class="list-inline-item  mr-3">
                            <p class="bottom-footer">&#xA9; 2022 <a target="_blank" href="../shop/index.jsp">GRONE HOME </a></p>
                        </li>
                        <li class="list-inline-item align-self-center">
                            <div class="scrollTop"><i class="flaticon-up-arrow-fill-1"></i></div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    <!--  END FOOTER  -->


    <!-- BEGIN GLOBAL MANDATORY SCRIPTS -->
    <script src="/admin/assets/js/libs/jquery-3.1.1.min.js"></script>
    <script src="/admin/bootstrap/js/popper.min.js"></script>
    <script src="/admin/bootstrap/js/bootstrap.min.js"></script>
    <script src="/admin/plugins/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="/admin/assets/js/app.js"></script>
    <script>
        $(document).ready(function() {
            App.init();
        });
    </script>
    <script src="/admin/assets/js/custom.js"></script>
    <!-- END GLOBAL MANDATORY SCRIPTS -->

    <!-- BEGIN PAGE LEVEL PLUGINS/CUSTOM SCRIPTS -->
    <script src="/admin/plugins/charts/chartist/chartist.js"></script>
    <script src="/admin/plugins/maps/vector/jvector/jquery-jvectormap-2.0.3.min.js"></script>
    <script src="/admin/plugins/maps/vector/jvector/worldmap_script/jquery-jvectormap-world-mill-en.js"></script>
    <script src="/admin/plugins/calendar/pignose/moment.latest.min.js"></script>
    <script src="/admin/plugins/calendar/pignose/pignose.calendar.js"></script>
    <script src="/admin/plugins/progressbar/progressbar.min.js"></script>
    <script src="/admin/assets/js/default-dashboard/default-custom.js"></script>
    <script src="/admin/assets/js/support-chat.js"></script>
    <!-- BEGIN PAGE LEVEL PLUGINS/CUSTOM SCRIPTS -->
</body>
</html>