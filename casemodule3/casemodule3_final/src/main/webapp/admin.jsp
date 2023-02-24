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
        <h1>Home</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/"></a>Home</li>
                <li class="breadcrumb-item">Admin login</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <jsp:include page="add-new-product-modal.jsp">
                <jsp:param name="addnew" value=""/>
            </jsp:include>
        </div>
        <div class="row collapsed" id="topselling">
            <div class="col-12">
                <div class="card top-selling overflow-auto">
                    <div class="card-body pb-0"><h5 class="card-title">Top Selling</h5>
                        <table class="table table-borderless">
                            <thead>
                            <tr>
                                <th scope="col">Preview</th>
                                <th scope="col">Product</th>
                                <th scope="col">Price</th>
                                <th scope="col">Sold</th>
                                <th scope="col">Comment</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row"><a href="#"><img src="/img/product-1.jpg" height="150" width="200"
                                                                 alt=""></a></th>
                                <td><a href="#" class="text-primary fw-bold">Ut inventore ipsa voluptas nulla</a></td>
                                <td>$64</td>
                                <td class="fw-bold">124</td>
                                <td>$5,828</td>
                            </tr>
                            <tr>
                                <th scope="row"><a href="#"><img src="/img/product-2.jpg" height="150" width="200"
                                                                 alt=""></a></th>
                                <td><a href="#" class="text-primary fw-bold">Exercitationem similique doloremque</a>
                                </td>
                                <td>$46</td>
                                <td class="fw-bold">98</td>
                                <td>$4,508</td>
                            </tr>
                            <tr>
                                <th scope="row"><a href="#"><img src="/img/product-3.jpg" height="150" width="200"
                                                                 alt=""></a></th>
                                <td><a href="#" class="text-primary fw-bold">Doloribus nisi exercitationem</a></td>
                                <td>$59</td>
                                <td class="fw-bold">74</td>
                                <td>$4,366</td>
                            </tr>
                            <tr>
                                <th scope="row"><a href="#"><img src="/img/product-4.jpg" height="150" width="200"
                                                                 alt=""></a></th>
                                <td><a href="#" class="text-primary fw-bold">Officiis quaerat sint rerum error</a></td>
                                <td>$32</td>
                                <td class="fw-bold">63</td>
                                <td>$2,016</td>
                            </tr>
                            <tr>
                                <th scope="row"><a href="#"><img src="/img/product-5.jpg" height="150" width="200"
                                                                 alt=""></a></th>
                                <td><a href="#" class="text-primary fw-bold">Sit unde debitis delectus repellendus</a>
                                </td>
                                <td>$79</td>
                                <td class="fw-bold">41</td>
                                <td>$3,239</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row collapsed" id="adminview">
            <table>
                <th>img</th>
                <th>Product's name</th>
                <th>Size</th>
                <th>Price</th>
                <th></th>
                <th></th>
            </table>
        </div>
    </section>
</main>
</body>
</html>
