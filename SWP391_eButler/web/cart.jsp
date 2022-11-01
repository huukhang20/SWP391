<%-- 
    Document   : cart
    Created on : Oct 27, 2022, 1:39:49 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>HTML5 Login Form with validation Example</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Frica</title>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
        <link rel="stylesheet" href="./cart.css">
        <link rel="stylesheet" href="./product_detail.css">

    </head>
    <body>
        <!-- header section start -->
        <div class="header_section haeder_main">
            <div class="container-fluid">
                <nav class="navbar navbar-light bg-light justify-content-between">
                    <div id="mySidenav" class="sidenav">
                        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                        <a href="ShowHomeGeneralController">Home</a>
                        <a href="ShowService">Product List</a>
                        <!--                        <a href="computers.html">Computers</a>-->
                        <a href="contact.jsp">Contact</a>
                    </div>
                    <span style="font-size:30px;cursor:pointer; color: #fff;" onclick="openNav()"><img src="images/toggle-icon.png"></span>

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
        <!-- partial:index.partial.html -->
        <header id="site-header">
            <div class="container">
                <h1>Shopping cart <span>
                        </header>

                        <div class="container">    
                            <c:set var="orderTotal" value="${0}" />
                            <form action="CartController">
                                <section id="cart"> 
                                    <c:forEach items="${cart.cart}" var="cartItem">
                                        <c:set var="serId" value="${cartItem.key}" />
                                        <c:set var="quantity" value="${cartItem.value}" />
                                        <jsp:useBean id="serviceDAO" scope="page" 
                                                     class="Service.ServiceDAO" 
                                                     type="Service.ServiceDAO" />
                                        <c:set var="ser" value="${serviceDAO.find(serId)}" />
                                        <article class="product">
                                            <header>
                                                <a class="remove" href="CartController?op=remove&isRemove=${ser.serID}">
                                                    <img src="${ser.serImage}" alt="Error Image">

                                                    <h3>Remove product</h3>
                                                </a>
                                            </header>

                                            <div class="content">

                                                <h1>${ser.serName}</h1>

                                                ${ser.serDescription}
                                            </div>

                                            <footer class="content">
                                                <span class="qt">Quantity:</span>
                                                <span class="qt">${quantity}</span>
                                                <h2 class="full-price">
                                                    <f:formatNumber var="itemTotal" 
                                                                    value="${ser.price * quantity}" 
                                                                    minIntegerDigits="0" />
                                                    <c:set var="orderTotal" 
                                                           value="${orderTotal + ser.price * quantity}" />
                                                    ${itemTotal} VND
                                                </h2>

                                                <h2 class="price">
                                                    <f:formatNumber var="price" 
                                                                    value="${ser.price}" 
                                                                    minIntegerDigits="0" />
                                                    ${price} VND
                                                </h2>




                                            </footer>
                                        </article>
                                    </c:forEach>

                                </section>
                            </form>
                        </div>

                        <footer id="site-footer">
                            <div class="container clearfix">

                                <div class="left">
                                    <h2 id="date"></h2>
                                </div>

                                <div class="right">
                                    <h1 class="total">Total: <span>
                                            <f:formatNumber var="strOrderTotal" 
                                                            value="${orderTotal}" 
                                                            minIntegerDigits="0" />
                                            ${strOrderTotal}

                                        </span>VND</h1>
                                    <a class="btn" href="check_out.jsp">Checkout</a>
                                </div>

                            </div>
                        </footer>
                        <!-- partial -->
                        <!-- footer section start -->
                        <div class="footer_section layout_padding margin_top_90">
                            <div class="container">
                                <div class="footer_logo_main">
                                    <!--                                    <div class="footer_logo"><a href="index.html"><img src="images/footer-logo.png"></a></div>-->
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
                        var check = false;

                        function changeVal(el) {
                            var qt = parseFloat(el.parent().children(".qt").html());
                            var price = parseFloat(el.parent().children(".price").html());
                            var eq = Math.round(price * qt * 100) / 100;

                            el.parent().children(".full-price").html(eq + "VND");

                            changeTotal();
                        }

                        function changeTotal() {

                            var price = 0;

                            $(".full-price").each(function (index) {
                                price += parseFloat($(".full-price").eq(index).html());
                            });

                            price = Math.round(price * 100) / 100;
                            var tax = Math.round(price * 0.05 * 100) / 100
                            var shipping = parseFloat($(".shipping span").html());
                            var fullPrice = Math.round((price + tax + shipping) * 100) / 100;

                            if (price == 0) {
                                fullPrice = 0;
                            }

                            $(".subtotal span").html(price);
                            $(".tax span").html(tax);
                            $(".total span").html(fullPrice);
                        }

                        var date = new Date();
                        var current_date = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
                        document.getElementById("date").innerHTML = current_date;
                        // $(document).ready(function(){

                        //   $(".remove").click(function(){
                        //     var el = $(this);
                        //     el.parent().parent().addClass("removed");
                        //     window.setTimeout(
                        //       function(){
                        //         el.parent().parent().slideUp('fast', function() { 
                        //           el.parent().parent().remove(); 
                        //           if($(".product").length == 0) {
                        //             if(check) {
                        //               $("#cart").html("<h1>The shop does not function, yet!</h1><p>If you liked my shopping cart, please take a second and heart this Pen on <a href='https://codepen.io/ziga-miklic/pen/xhpob'>CodePen</a>. Thank you!</p>");
                        //             } else {
                        //               $("#cart").html("<h1>No products!</h1>");
                        //             }
                        //           }
                        //           changeTotal(); 
                        //         });
                        //       }, 200);
                        //   });

                        //   $(".qt-plus").click(function(){
                        //     $(this).parent().children(".qt").html(parseInt($(this).parent().children(".qt").html()) + 1);

                        //     $(this).parent().children(".full-price").addClass("added");

                        //     var el = $(this);
                        //     window.setTimeout(function(){el.parent().children(".full-price").removeClass("added"); changeVal(el);}, 150);
                        //   });

                        //   $(".qt-minus").click(function(){

                        //     child = $(this).parent().children(".qt");

                        //     if(parseInt(child.html()) > 1) {
                        //       child.html(parseInt(child.html()) - 1);
                        //     }

                        //     $(this).parent().children(".full-price").addClass("minused");

                        //     var el = $(this);
                        //     window.setTimeout(function(){el.parent().children(".full-price").removeClass("minused"); changeVal(el);}, 150);
                        //   });

                        //   window.setTimeout(function(){$(".is-open").removeClass("is-open")}, 1200);

                        //   $(".btn").click(function(){
                        //     check = true;
                        //     $(".remove").click();
                        //   });
                        // });
                        </script> 
                        </body>
                        </html>
