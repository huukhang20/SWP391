<%-- 
    Document   : req_detail_admin
    Created on : Oct 25, 2022, 1:02:53 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product detail</title>
        <link rel="stylesheet" href="style_admin.css">
        <!-- Boxicons CDN Link -->
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- fonts -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
        <!-- owl stylesheets --> 
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="./product_list.css">
    </head>
    <body>
        <div class="sidebar">
            <div class="logo-details">
                <i class='bx bxl-c-plus-plus'></i>
                <span class="logo_name">E-butlter</span>
            </div>
            <ul class="nav-links">
                <li>
                    <a href="home_admin.jsp">
                        <i class='bx bx-grid-alt' ></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="ShowServiceAdminController">
                        <i class='bx bx-box' ></i>
                        <span class="links_name">Products And Services</span>
                    </a>
                </li>
                <li>
                    <a href="ShowRequestListController" class="active">
                        <i class='bx bx-list-ul' ></i>
                        <span class="links_name">Request List</span>
                    </a>
                </li>
                <li>
                    <a href="ShowUserListController">
                        <i class='bx bx-user' ></i>
                        <span class="links_name">User List</span>
                    </a>
                </li>
                <li>
                    <a href="ShowFeedbackListController">
                        <i class='bx bx-message' ></i>
                        <span class="links_name">Feed Back</span>
                    </a>
                </li>
                <li>
                    <a href="order_list_admin.html">
                      <i class='bx bx-coin-stack' ></i>
                      <span class="links_name">Oder List</span>
                    </a>
                  </li>
                <li class="log_out">
                    <a href="LogoutController">
                        <i class='bx bx-log-out'></i>
                        <span class="links_name">Log out</span>
                    </a>
                </li>
            </ul>
        </div>
        <!-- body -->
        <section class="home-section">
            <nav>
                <div class="sidebar-button">
                    <i class='bx bx-menu sidebarBtn'></i>
                    <span class="dashboard">Dashboard</span>
                </div>
                <div class="search-box">
                    <input type="text" placeholder="Search...">
                    <i class='bx bx-search' ></i>
                </div>
                <div class="profile-details">
                    <img src="images/profile.jpg" alt="">
                    <span class="admin_name">${sessionScope.USERROLE} ${sessionScope.USERLOGIN}</span>
                </div>
            </nav>

            <div class="home-content">
                <div class="container mt-5 mb-5">
                    <div class="d-flex justify-content-center row">
                        <div class="col-md-10">
                            <div class="row p-2 bg-white border rounded">
                                <div class="item">
                                    <div class="sq_box shadow">
                                        <div class="pdis_img"> 
                                            <c:if test="${requestScope.SERVICEDTO.serImage != null}">
                                                <c:if test="${not empty requestScope.SERVICEDTO.serImage}" var="check" scope="page">     
                                                    <img src="${requestScope.SERVICEDTO.serImage}">
                                                </c:if>
                                                <c:if test="${empty requestScope.SERVICEDTO.serImage}" var="check" scope="page">
                                                    <img src="images/img-4.png">
                                                </c:if>
                                            </c:if>
                                            <c:if test="${requestScope.SERVICEDTO.serImage == null}">
                                                <img src="images/img-4.png">
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="align-items-center align-content-center col-md-4 border-left mt-1">
                                    <div class="d-flex flex-row align-items-center">
                                        <h1 class="card-title">${requestScope.SERVICEDTO.serName}</h1>
                                    </div>
                                    <a>--------</a>
                                    <h3 class="p-1">Tag: ${requestScope.SERVICEDTO.cateId}</h3>

                                    <h3 class="p-1">Price: ${requestScope.SERVICEDTO.price}</h3> 
                                    <h3 class="p-1">Work Date: ${requestScope.SERVICEDTO.workDate}</h3>
                                    <a>--------</a>
                                    <h2 class="">Create by: ${requestScope.SERVICEDTO.supplierId}</h2>
                                    <div class="d-flex flex-column mt-4"><button class="btn btn-primary btn-sm" type="button">Accept</button>
                                        <button class="btn primary btn-sm mt-2 bg-danger text-white" type="button">Ignore</button></div>

                                </div>
                            </div>
                            <div class="row p-2 bg-white border rounded">
                                <div class="item">

                                </div>
                                <div class="card-body">
                                    <div class="card-body">
                                        <h3 class="card-title">Description</h3>  
                                        <p class="card-text">${requestScope.SERVICEDTO.serDescription}</p>
                                    </div>
                                </div>
                            </div>   
                        </div>
                    </div>
                </div>
                <script>
                    let sidebar = document.querySelector(".sidebar");
                    let sidebarBtn = document.querySelector(".sidebarBtn");
                    sidebarBtn.onclick = function () {
                        sidebar.classList.toggle("active");
                        if (sidebar.classList.contains("active")) {
                            sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
                        } else
                            sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
                    }
                </script>
            </div>
        </section>
    </body>
</html>
