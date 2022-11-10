<%-- 
    Document   : home_cc
    Created on : Nov 10, 2022, 1:53:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title> Home Customer Care </title>
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
                    <a href="ShowHomeCCController" class="active">
                        <i class='bx bx-grid-alt' ></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="ShowFeedbackListCCController">
                        <i class='bx bx-list-ul' ></i>
                        <span class="links_name">Feedback</span>
                    </a>
                </li>
                <li>
                    <a href="ShowComplaintCCController" >
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
                    <span class="admin_name">Welcome CC ${sessionScope.account.name}</span>
                </div>
            </nav>

            <div class="home-content">
                <div class="overview-boxes">
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Feedback</div>
                            <div class="number">${requestScope.FB}</div>
                            <div class="indicator">
                                <i class='bx bx-up-arrow-alt'></i>
                                <!--<span class="text">Up from yesterday</span>-->
                            </div>
                        </div>
                        <i class='bx bx-cart-alt cart'></i>
                    </div>
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Waiting Feedback</div>
                            <div class="number">${requestScope.FBW}</div>
                            <div class="indicator">
                                <i class='bx bx-up-arrow-alt'></i>
                                <!--<span class="text">Up from yesterday</span>-->
                            </div>
                        </div>
                        <i class='bx bxs-cart-add cart two' ></i>
                    </div>
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Total Complaint</div>
                            <div class="number">${requestScope.Comp}</div>
                            <div class="indicator">
                                <i class='bx bx-up-arrow-alt'></i>
                                <!--<span class="text">Up from yesterday</span>-->
                            </div>
                        </div>
                        <i class='bx bx-cart cart three' ></i>
                    </div>
                    <div class="box">
                        <div class="right-side">
                            <div class="box-topic">Waiting Complaint</div>
                            <div class="number">${requestScope.CompW}</div>
                            <div class="indicator">
                                <i class='bx bx-down-arrow-alt down'></i>
                                <!--<span class="text">Down From Today</span>-->
                            </div>
                        </div>
                        <i class='bx bxs-cart-download cart four' ></i>
                    </div>
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
