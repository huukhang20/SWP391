<%-- 
    Document   : user_list_admin
    Created on : Oct 13, 2022, 8:44:44 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Manage Users</title>
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
                    <a href="ShowRequestListController">
                        <i class='bx bx-list-ul' ></i>
                        <span class="links_name">Request List</span>
                    </a>
                </li>
                <li>
                    <a href="ShowUserListController" class="active">
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
                    <a href="ShowOrderListAdminController">
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
                <div class="table-responsive">
                    <c:if test="${requestScope.ACCOUNTLIST != null}">
                        <c:if test="${not empty requestScope.ACCOUNTLIST}" var="check" scope="page">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Avatar</th>
                                        <th scope="col">Information</th>
                                        <th scope="col">Action</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.ACCOUNTLIST}" var="dto" varStatus="counter">
                                        <tr class="inner-box">
                                            <th scope="row">
                                                <span>${counter.count}</span>
                                            </th>
                                            <c:if test="${dto.image != null}">
                                                <c:if test="${not empty dto.image}" var="check" scope="page">
                                                    <td>
                                                        <div class="event-img">
                                                            <img src="${dto.image}" alt=""  height="250" width="200"/>
                                                        </div>
                                                    </td>
                                                </c:if>
                                                <c:if test="${empty dto.image}" var="check" scope="page">
                                                    <td>
                                                        <div class="event-img">
                                                            <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt=""  height="250" width="200"/>
                                                        </div>
                                                    </td>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${dto.image == null}">
                                                <td>
                                                    <div class="event-img">
                                                        <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt=""  height="250" width="200"/>
                                                    </div>
                                                </td>
                                            </c:if>
                                            <td>
                                                <div class="event-wrap">
                                                    <h3><a href="#">${dto.name}</a></h3>
                                                    <div class="meta">
                                                        <div class="organizers">
                                                            <a href="#">Phone: ${dto.phone}</a>
                                                        </div>
                                                        <div class="categories">
                                                            <a href="#">Email: ${dto.email}</a>
                                                        </div>
                                                        <div class="time">
                                                            <span>Status: ${dto.isStatus}</span>
                                                        </div>
                                                        <div class="time">
                                                            <span>Status: ${dto.username}</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <!-- Button trigger modal -->
                                                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#banAccountModal${counter.count}">
                                                    Ban Account
                                                </button>
                                                <!-- Modal -->
                                                <div class="modal fade" id="banAccountModal${counter.count}" tabindex="-1" aria-labelledby="banAccountModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="banAccountModalLabel">Ban a User?</h5>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body">
                                                                Do you want to ban user ${dto.username}?
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-danger" onclick="document.location.href = 'BanAccountController?txtID=${dto.accID}'">Ban</button>
                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty requestScope.ACCOUNTLIST}">
                            <h2 style="color: black">No account is waiting for you to managed!</h2>
                        </c:if>
                    </c:if>
                    <c:if test="${requestScope.ACCOUNTLIST == null}">
                        <h2 style="color: black">No account is waiting for you to managed!</h2>
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
