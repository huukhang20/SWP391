<%-- 
    Document   : check_out
    Created on : Oct 28, 2022, 7:36:12 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Checkout</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
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
    </head>
    <body>
        <!-- header section start -->
        <div class="header_section haeder_main">
            <div class="container-fluid">
                <nav class="navbar navbar-light bg-light justify-content-between">
                    <div id="mySidenav" class="sidenav">
                        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                        <a href="home_general.jsp">Home</a>
                        <a href="ShowService">Service List</a>
                        <a href="contact.jsp">Contact</a>
                    </div>
                    <span style="font-size:30px;cursor:pointer; color: #fff;" onclick="openNav()"><img src="images/toggle-icon.png"></span>
                    <a class="navbar-brand" href="index.html">E-Butler</a></a>
                    <form class="form-inline ">
                        <div class="login_text">
                            <ul>
                                <li><a href="login.jsp"><img src="images/user-icon.png"></a></li>
                                <li><a href="#"><img src="images/trolly-icon.png"></a></li>
                                <li><a href="#"><img src="images/search-icon.png"></a></li>
                                <li><a href="#"><img src="images/logout.png" width = "21" height = "20"></a></li>
                            </ul>
                        </div>
                    </form>
                </nav>
            </div>
        </div>
        <!-- header section end -->
        <!-- contact section start -->
        <div class="container">
            <div class="py-5 text-center">
                <h2>Checkout form</h2> </div>
            <div class="row">

                <div class="col-md-4 order-md-2 mb-4">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted">Your cart</span>
                    </h4>
                    <ul class="list-group mb-3 sticky-top">
                        <c:forEach items="${cart.cart}" var="cartItem">
                            <c:set var="serId" value="${cartItem.key}" />
                            <c:set var="quantity" value="${cartItem.value}" />
                            <jsp:useBean id="serviceDAO" scope="page" 
                                         class="Service.ServiceDAO" 
                                         type="Service.ServiceDAO" />
                            <c:set var="ser" value="${serviceDAO.find(serId)}" />
                            <li class="list-group-item d-flex justify-content-between lh-condensed">
                                <div>
                                    <h6 class="my-0">${ser.serName}</h6>
                                    <small class="text-muted">${ser.serDescription}</small>
                                </div>
                                <span class="text-muted">
                                    <f:formatNumber var="itemTotal" 
                                                    value="${ser.price * quantity}" 
                                                    minIntegerDigits="0" />
                                    <c:set var="orderTotal" 
                                           value="${orderTotal + ser.price * quantity}" />
                                    ${itemTotal} VND
                                </span>
                            </li>
                        </c:forEach>

                        <li class="list-group-item d-flex justify-content-between">
                            <span>Total (VND)</span>
                            <strong>
                                <f:formatNumber var="strOrderTotal" 
                                                value="${orderTotal}" 
                                                minIntegerDigits="0" />
                                ${strOrderTotal}
                            </strong>
                        </li>
                    </ul>

                </div>

                <div class="col-md-8 order-md-1">
                    <form class="needs-validation" novalidate="" action="CheckOutController" id="check_out" name="check_out" method="get" onsubmit="return validateform()">
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="fullName">Full name</label>
                                <input type="text" name="fullName" class="form-control" id="firstName" placeholder="" value="${account.name}" required="">

                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="phone">Phone Number</label>
                                <input type="text" name="phone" class="form-control"  placeholder="" value="${account.phone}" required="">

                            </div>  
                        </div>

                        <div class="mb-3">
                            <label for="email">Email <span class="text-muted"></span></label>
                            <input type="email" name="email" class="form-control" id="email" placeholder="you@example.com" value="${account.email}">
                            <div class="invalid-feedback"> Please enter a valid email address for shipping updates. </div>
                        </div>
                        <div class="mb-3">
                            <label for="address">Address</label>
                            <input type="text" name="address" class="form-control" id="address" placeholder="1234 Main St" required="" value="${account.address}">
                            <div class="invalid-feedback"> Please enter your shipping address. </div>
                        </div>

                        <hr class="mb-4">
                    </form>
                    <button class="btn btn-primary btn-lg btn-block" type="submit" form="check_out" value="submit" onclick="AlertFunc()">Done!?</button>
                </div>
            </div>

        </div>
        <!-- contact section end -->
        <!-- footer section start -->
        <div class="footer_section layout_padding margin_top_90">
            <div class="container">
                <div class="footer_logo_main">
                    <div class="footer_logo"><a href="index.html"><img src=""></a></div>
                    <div class="social_icon">
                        <ul>
                            <li><a href="#"><img src="images/fb-icon.png"></a></li>
                            <li><a href="#"><img src="images/twitter-icon.png"></a></li>
                            <li><a href="#"><img src="images/linkedin-icon.png"></a></li>
                            <li><a href="#"><img src="images/instagram-icon.png"></a></li>
                            <li><a href="#"><img src="images/youtub-icon.png"></a></li>
                        </ul>
                    </div>
                </div>
                <div class="footer_section_2">
                    <div class="row">
                        <div class="col-lg-3 col-sm-6">
                            <h4 class="adderss_text">About</h4>
                            <p class="ipsum_text">consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation u</p>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <h4 class="adderss_text">Menu</h4>
                            <div class="footer_menu">
                                <ul>
                                    <li><a href="index.html">Home</a></li>
                                    <li><a href="computers.html">Computers</a></li>
                                    <li><a href="Mans_clothes.html">Mans Clothes</a></li>
                                    <li><a href="womans_clothes.html">Womans Clothes</a></li>
                                    <li><a href="contact.jsp">Contact Us</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <h4 class="adderss_text">Useful Link</h4>
                            <div class="footer_menu">
                                <ul>
                                    <li><a href="#">Adipiscing</a></li>
                                    <li><a href="#">Elit, sed do</a></li>
                                    <li><a href="#">Eiusmod</a></li>
                                    <li><a href="#">Tempor</a></li>
                                    <li><a href="#">incididunt</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <h4 class="adderss_text">Contact</h4>
                            <div class="call_text"><img src="images/map-icon.png"><span class="paddlin_left_0"><a href="#">London 145 United Kingdom</a></span></div>
                            <div class="call_text"><img src="images/call-icon.png"><span class="paddlin_left_0"><a href="#">+7586656566</a></span></div>
                            <div class="call_text"><img src="images/mail-icon.png"><span class="paddlin_left_0"><a href="#">volim@gmail.com</a></span></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer section end -->
        <!-- copyright section start -->
        <div class="copyright_section">
            <div class="container">

            </div>
        </div>
        <!-- copyright section end -->
        <!-- Javascript files-->
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.0.0.min.js"></script>
        <script src="js/plugin.js"></script>
        <!-- sidebar -->
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/custom.js"></script>
        <!-- javascript --> 
        <script src="js/owl.carousel.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>  
        <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
        <script>
                        function openNav() {
                            document.getElementById("mySidenav").style.width = "100%";
                        }

                        function closeNav() {
                            document.getElementById("mySidenav").style.width = "0";
                        }
                        function validateform() {
                            var name = document.check_out.name.value;
                            var phone = document.check_out.phone.value;
                            var email = document.check_out.email.value;
                            var address = document.check_out.address.value;

                            if (name === null || name === "") {
                                alert("Name can't be blank");
                                return false;
                            } else if (phone ===  null || phone === "") {
                                alert("Phone Number can't be blank");
                                return false;
                            } else if (email ===  null || email === "") {
                                alert("Email can't be blank");
                                return false;
                            } else if (address ===  null || address === "") {
                                alert("Address can't be blank");
                                return false;
                            }
                        }
                        function AlertFunc() {
                            alert("Thanks for using our service.");
                        }
        </script> 
    </body>
</html>