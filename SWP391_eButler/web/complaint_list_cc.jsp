<%-- 
    Document   : complain_list_cc
    Created on : Nov 10, 2022, 2:17:29 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title> Complain Order </title>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="sidebar">
            <div class="logo-details">
                <i class='bx bxl-c-plus-plus'></i>
                <span class="logo_name">E-butlter</span>
            </div>
            <ul class="nav-links">
                <li>
                    <a href="home_cc.jsp" >
                        <i class='bx bx-grid-alt' ></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="ShowFeedbackListCCController" >
                        <i class='bx bx-list-ul' ></i>
                        <span class="links_name">Feedback</span>
                    </a>
                </li>
                <li>
                    <a href="ShowComplaintCCController" class="active">
                        <i class='bx bx-book-alt' ></i>
                        <span class="links_name">Complain</span>
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
                    <span class="admin_name">Welcome CC ${sessionScope.USERLOGIN}</span>

                </div>
            </nav>
            <!-- body -->
            <div class="home-content">
                <div class="table-responsive">
                    <c:if test="${requestScope.COMPLAINTLISTCC != null}">
                        <c:if test="${not empty requestScope.COMPLAINTLISTCC}" var="check" scope="page">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">User</th>
                                        <th scope="col">Order ID</th>
                                        <th scope="col">Message</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.COMPLAINTLISTCC}" var="dto" varStatus="counter">
                                        <tr class="inner-box">
                                            <td scope="row">
                                                <div class="event-date">
                                                    <span>${dto.ID}</span>
                                                </div>
                                            </td>
                                            <td>
                                                <span>${dto.accName}</span>
                                            </td>
                                            <td>
                                                <div class="event-wrap">
                                                    <div class="categories">
                                                        ${dto.orderId}
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <span>${dto.description}</span>
                                            </td>
                                            <td>
                                                <c:if test="${dto.status == 0}">
                                                    <div class="d-flex">
                                                        <button class="btn btn-danger btn-sm" type="button" data-bs-toggle="modal" data-bs-target="#confirmDoneModal${counter.count}">Solve</button>
                                                    </div>
                                                    <!-- Modal -->
                                                    <div class="modal fade" id="confirmDoneModal${counter.count}" tabindex="-1" aria-labelledby="confirmDoneModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="confirmDoneModalLabel">Complete this feedback?</h5>
                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    Do you want to complete this feedback?
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-primary" onclick="document.location.href = 'ConfirmComplaintCCController?txtID=${dto.ID}'">Complete</button>
                                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:if> 
                                                <c:if test="${dto.status == 1}">
                                                    <p>Complaint Solved</p>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.COMPLAINTLISTCC}">
                            <p>There is no complaint waiting to solve!!</p>
                        </c:if>
                    </c:if>
                    <c:if test="${requestScope.COMPLAINTLISTCC == null}">
                        <p>There is no complaint waiting to solve!!</p>
                    </c:if>
                </div>
            </div>
        </section>

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
    </body>
</html>
