<%-- 
    Document   : product_list_admin
    Created on : Oct 28, 2022, 10:01:49 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product And Service </title>
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
                    <a href="ShowServiceAdminController" class="active">
                        <i class='bx bx-box' ></i>
                        <span class="links_name">Products And Services</span>
                    </a>
                </li>
                <li>
                    <a href="ShowRequestListController">
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
                    <c:if test="${requestScope.SERVICELIST != null}">
                        <c:if test="${not empty requestScope.SERVICELIST}" var="check" scope="page">
                            <div class="d-flex justify-content-center row">
                                <c:forEach items="${requestScope.SERVICELIST}" var="dto" varStatus="counter">
                                    <div class="col-md-10">
                                        <div class="row p-2 bg-white border rounded">
                                            <c:if test="${dto.serImage != null}">
                                                <c:if test="${not empty dto.serImage}">
                                                    <div class="col-md-3 mt-1">
                                                        <img class="img-fluid img-responsive rounded product-image" src="${dto.serImage}" width = "450" height = "800"/>
                                                    </div>
                                                </c:if>
                                                <c:if test="${empty dto.serImage}">
                                                    <div class="col-md-3 mt-1">
                                                        <img class="img-fluid img-responsive rounded product-image" src="https://i.imgur.com/QpjAiHq.jpg" width = "450" height = "800"/>
                                                    </div>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${dto.serImage == null}">
                                                <div class="col-md-3 mt-1">
                                                    <img class="img-fluid img-responsive rounded product-image" src="https://i.imgur.com/QpjAiHq.jpg" width = "450" height = "800"/>
                                                </div>
                                            </c:if>
                                            <div class="col-md-6 mt-1">
                                                <h4 class="card-title" onclick="document.location.href = 'ShowServiceDetailController?txtID=${dto.serID}'">${dto.serName}</h4>
                                                <div class="d-flex flex-row">
                                                </div>
                                                <div class="mt-1 mb-1 spec-1"><span style="font-weight: bold">Category:</span><span class="dot"></span><span> ${dto.categoryName}</span><span class="dot"></span><span><br></span></div>
                                                <div class="mt-1 mb-1 spec-1"><span style="font-weight: bold">Supplier:</span><span class="dot"></span><span> ${dto.supplierName}</span><span class="dot"></span><span><br></span></div>
                                                <div class="mt-1 mb-1 spec-1"><span style="font-weight: bold">Work Time:</span><span class="dot"></span><span> ${dto.workDate}</span><span class="dot"></span><span><br></span></div>
                                                <div class="mt-1 mb-1 spec-1"><span style="font-weight: bold">Description: </span><span class="dot"></span><span> ${dto.serDescription}</span><span class="dot"></span></span></div>
                                            </div>
                                            <div class="align-items-center align-content-center col-md-3 border-left mt-1">
                                                <div class="d-flex flex-row align-items-center">
                                                    <h4 class="mr-1">$13.99</h4>
                                                    <button class="btn btn-success btn-sm mr-auto" type="button">activate</button>
                                                </div>
                                                <div class="d-flex flex-column mt-4"><button class="btn btn-primary btn-sm" type="button">change status</button>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                        <c:if test="${empty requestScope.SERVICELIST}">
                            <h2 style="color: black">No service is waiting for you to managed!</h2>
                        </c:if>
                    </c:if>
                    <c:if test="${requestScope.SERVICELIST == null}">
                        <h2 style="color: black">No service is waiting for you to managed!</h2>
                    </c:if>
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
        </section>
    </body>
</html>
