<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- Designined by CodingLab | www.youtube.com/codinglabyt -->
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <title>Create New Request</title>
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
                <a href="ShowHomeGeneralController" class="logo_name">E-butlter</a>
            </div>
            <ul class="nav-links">
                <li>
                    <a href="home_supp.jsp" class="active">
                        <i class='bx bx-grid-alt' ></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="ShowServiceSuppController">
                        <i class='bx bx-box' ></i>
                        <span class="links_name">Service Management</span>
                    </a>
                </li>
                <li>
                    <a href="ShowRequestListForSuppController">
                        <i class='bx bx-list-ul' ></i>
                        <span class="links_name">Request Management</span>
                    </a>
                </li>
                <li>
                    <a href="create_req_supp.jsp">
                        <i class='bx bx-list-ul' ></i>
                        <span class="links_name">Create New Request</span>
                    </a>
                </li>
                <li>
                    <a href="ShowOrderListSuppController">
                        <i class='bx bx-coin-stack' ></i>
                        <span class="links_name">Order History</span>
                    </a>
                </li>
                <li>
                    <a href="ManageOrderSuppController">
                        <i class='bx bx-book-alt' ></i>
                        <span class="links_name">Manage Order</span>
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
                    <img src="${sessionScope.account.image}" alt="">
                    <span class="admin_name">Welcome Supplier ${sessionScope.account.name}</span>

                </div>
            </nav>

            <div class="home-content">
                <div class="container rounded bg-white mt-5 mb-5">
                    <div class="row">

                        <div class="col-md-8 border m-auto border-secondary rounded">
                            <div class="p-3 py-12 ">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                </div>
                                <form action="CreateReqController" id="form" methoad="post">
                                    <div class="row mt-3">

                                        <div class="col-md-12"><label class="labels">Service Name </label><input type="text" name="serName" class="form-control" placeholder="Service Name"></div>
                                        <div class="col-md-12"><label class="labels">Quantity</label><input type="number" name="quantity" class="form-control" placeholder="Quantity" ></div>
                                        <div class="col-md-12"><label class="labels">Price</label><input type="number" name ="price" class="form-control" placeholder="Price" ></div>
                                        <div class="col-md-12"><label class="labels">Release Date</label><input type="date" name="releaseDate" class="form-control" placeholder="Release Date" ></div>

                                        <label  for="myfile">Select a file:</label>
                                        <input type="file" id="myfile" name="myfile"><br><br>


                                        <label for="cars">Choose a category:</label>
                                        <select name="category" id="category">
                                            <option value="Gas">Gas</option>
                                            <option value="Electric">Electric</option>
                                            <option value="Rice">Rice</option>
                                            <option value="Water">Water</option>
                                            <option value="audi">Electric Device</option>
                                            <option value="audi">Market</option>
                                        </select>

                                    </div>
                                    <div class="form-group">
                                        <label for="exampleFormControlTextarea1">Description</label>
                                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description"></textarea>
                                    </div>
                                </form>
                                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit" form="form" onclick="AlertFunc()">Send Request</button></div>
                            </div>
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

        function AlertFunc() {
            alert("Request Added!.");
        }
    </script>

</body>
</html>
