<%-- 
    Document   : home_general
    Created on : Oct 14, 2022, 1:43:22 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Ebutler</title>
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
                        <a href="ShowHomeGeneralController">Home</a>
                        <a href="ShowService">Services List</a>
                        <a href="contact.jsp">Contact</a>
                    </div>
                    <span style="font-size:30px;cursor:pointer; color: #fff;" onclick="openNav()"><img src="images/toggle-icon.png"></span>
                    <a class="navbar-brand" href="ShowHomeGeneralController">E-Butler</a></a>
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
        <!-- banner section start -->
        <div class="banner_section layout_padding">
            <div id="my_slider" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <div class="container">
                            <div class="row border_1">
                                <div class="col-md-4">
                                    <div class="image_1"><img src="" style="width:100%"></div>
                                </div>
                                <div class="col-md-4">
                                    <h1 class="banner_taital">Big Sale Offer</h1>
                                    <div class="buynow_bt active"><a href="#">Buy Now</a></div>
                                    <div class="contact_bt"><a href="contact.html">Contact Us</a></div>
                                </div>
                                <div class="col-md-4">
                                    <div class="image_2"><img src="images/gao.png" style="width:100%"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="container">
                            <div class="row border_1">
                                <div class="col-md-4">
                                    <div class="image_1"><img src="" style="width:100%"></div>
                                </div>
                                <div class="col-md-4">
                                    <h1 class="banner_taital">Electricity Problem?</h1>
                                    <div class="buynow_bt active"><a href="#">Check Now</a></div>
                                    <div class="contact_bt"><a href="contact.html">Contact Us</a></div>
                                </div>
                                <div class="col-md-4">
                                    <div class="image_2"><img src="images/repair.png" style="width:80%"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="container">
                            <div class="row border_1">
                                <div class="col-md-4">
                                    <div class="image_1"><img src="" style="width:100%"></div>
                                </div>
                                <div class="col-md-4">
                                    <h1 class="banner_taital">Tired of Work?</h1>
                                    <div class="buynow_bt active"><a href="#">Check Now</a></div>
                                    <div class="contact_bt"><a href="contact.html">Contact Us</a></div>
                                </div>
                                <div class="col-md-4">
                                    <div class="image_2"><img src="" style="width:100%"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#my_slider" role="button" data-slide="prev">
                    <i class="fa fa-angle-left"></i>
                </a>
                <a class="carousel-control-next" href="#my_slider" role="button" data-slide="next">
                    <i class="fa fa-angle-right"></i>
                </a>
            </div>
        </div>
        <!-- banner section end -->
        <!-- catagary section start -->
        <div class="catagary_section layout_padding">
            <div class="container">
                <div class="catagary_main">
                    <div class="catagary_left">
                        <!--                  <h2 class="categary_text">Category</h2>-->
                    </div>
                    <div class="catagary_right">
                        <div class="catagary_menu">
                            <ul>
                                <li><a href="ShowServiceByCategory?cateId=1">Gas</a></li>
                                <li><a href="ShowServiceByCategory?cateId=2">Electric</a></li>
                                <li><a href="ShowServiceByCategory?cateId=3">Rice</a></li>
                                <li><a href="ShowServiceByCategory?cateId=4">Water</a></li>
                                <li><a href="ShowServiceByCategory?cateId=5">Electronic Device</a></li>
                                <li><a href="ShowServiceByCategory?cateId=6">Market</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="catagary_section_2">
            <div class="container-fluid">
                <div class="row">
                    <c:forEach items="${requestScope.RANDOMLIST}" var="dto" varStatus="counter">
                        <div class="col-md-4">
                            <div class="box_man">
                                <h3 class="mobile_text"></h3>
                                <c:if test="${dto.serImage != null}">
                                    <c:if test="${not empty dto.serImage}">
                                        <div class="mobile_img">
                                            <img src="${dto.serImage}">
                                        </div>
                                    </c:if>
                                    <c:if test="${empty dto.serImage}">
                                        <div class="computer_img">
                                            <img src="https://i.imgur.com/QpjAiHq.jpg"/>
                                        </div>
                                    </c:if>
                                </c:if>
                                <c:if test="${dto.serImage == null}">
                                    <div class="computer_img">
                                        <img src="https://i.imgur.com/QpjAiHq.jpg"/>
                                    </div>
                                </c:if>
                                <div class="cart_main">
                                    
                                    <h4 class="samsung_text">${dto.serName}</h4>
                                    <h6 class="rate_text">${dto.price} $</h6>
                                    <h6 class="rate_text_1"></h6>
                                </div>
                                    <div class="row">
                                    <div class="cart_bt_1 "><a href="#">Add To Cart</a></div>
                                    </div>
                             
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- catagary section end -->

        <!-- computers section start -->
        <div class="computers_section layout_padding">
            <div class="container">
                <h1 class="computers_taital"></h1>
            </div>
        </div>
        <div class="computers_section_2">
            <div class="container-fluid">
                <div class="computer_main">
                    <div class="row">
                        <c:forEach items="${requestScope.RANDOMLIST2}" var="dto" varStatus="counter">
                            <div class="col-md-4">
                                <c:if test="${dto.serImage != null}">
                                    <c:if test="${not empty dto.serImage}">
                                        <div class="computer_img">
                                            <img src="${dto.serImage}"/>
                                        </div>
                                    </c:if>
                                    <c:if test="${empty dto.serImage}">
                                        <div class="computer_img">
                                            <img src="https://i.imgur.com/QpjAiHq.jpg"/>
                                        </div>
                                    </c:if>
                                </c:if>
                                <c:if test="${dto.serImage == null}">
                                    <div class="computer_img">
                                        <img src="https://i.imgur.com/QpjAiHq.jpg"/>
                                    </div>
                                </c:if>
                                <h4 class="computer_text">${dto.serName}</h4>
                                <div class="computer_text_main">
                                    <h4 class="dell_text"></h4>
                                    <h6 class="price_text mt-auto">${dto.price} $</h6>
                                    <h6 class="price_text_1"><a href="#"></a></h6>
                                </div>
                                <div class="cart_bt_1"><a href="#">Add To Cart</a></div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <!-- computers section end -->

        <!-- footer section start -->
        <div class="footer_section layout_padding margin_top_90">
            <div class="container">
                <div class="footer_logo_main">
                    <div class="footer_logo"><a href="index.html"></a></div>
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
                            <p class="ipsum_text">EButler is a website that helps you with butler services such as: electrical repair, rice, gas supply, ...</p>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <h4 class="adderss_text">Menu</h4>
                            <div class="footer_menu">
                                <ul>
                                    <li><a href="index.html">Home</a></li>
                                    <li><a href="computers.html"></a></li>
                                    <li><a href="Mans_clothes.html"></a></li>
                                    <li><a href="womans_clothes.html"></a></li>
                                    <li><a href="contact.html">Contact Us</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <h4 class="adderss_text">Useful Link</h4>
                            <div class="footer_menu">
                                <ul>
                                    <li><a href="#">Facebook</a></li>
                                    <li><a href="#">Instagram</a></li>
                                    <li><a href="#">Youtube</a></li>
                                    <li><a href="#">Twitter</a></li>
                                    <li><a href="#">License</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <h4 class="adderss_text">Contact</h4>
                            <div class="call_text"><img src="images/map-icon.png"><span class="paddlin_left_0"><a href="#">FPT University, TP.HCM</a></span></div>
                            <div class="call_text"><img src="images/call-icon.png"><span class="paddlin_left_0"><a href="#">+099887766</a></span></div>
                            <div class="call_text"><img src="images/mail-icon.png"><span class="paddlin_left_0"><a href="#">ebutler@gmail.com</a></span></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer section end -->
        <!-- copyright section start -->
        <div class="copyright_section">

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
        </script> 
    </body>
</html>
