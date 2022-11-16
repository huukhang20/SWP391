<%-- 
    Document   : product
    Created on : Oct 26, 2022, 2:14:44 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>EButler</title>
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
                                <li><a href="LogOutController"><img src="images/logout.png" width = "21" height = "20"></a></li>
                            </ul>
                        </div>
                    </form>
                </nav>
            </div>
        </div>
        <!-- header section end -->
        <!-- computers section start -->
        <section id="services" class="services section-bg">
            <div class="container-fluid">
                <div class="row row-sm">
                    <div class="col-md-6 _boxzoom">                 
                        <div class="zoom-thumb">
                            <ul class="piclist">
                                <!--                                    <li><img src="https://s.fotorama.io/1.jpg" alt=""></li>
                                                                    <li><img src="https://s.fotorama.io/2.jpg" alt=""></li>
                                                                    <li><img src="https://s.fotorama.io/3.jpg" alt=""></li>
                                                                    <li><img src="https://ucarecdn.com/382a5139-6712-4418-b25e-cc8ba69ab07f/-/stretch/off/-/resize/760x/" alt=""></li>-->
                            </ul>
                        </div>
                        <div class="_product-images">
                            <div class="picZoomer">
                                <img class="my_img" src="${detailP.serImage}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="_product-detail-content">
                            <p class="_p-name"> ${detailP.serName} </p>
                            <div class="_p-price-box">
                                <div class="p-list">
                                    <span> Price :  </span>
                                    <span class="price"> ${detailP.price} VND </span>
                                </div>
                                <form action="CartController" method="get" accept-charset="utf-8" id="addtocart">
                                    <div class="_p-add-cart">
                                        <div class="_p-qty">
                                            <span>Add Quantity</span>
                                            <div class="value-button decrease_" id="" value="Decrease Value">-</div>
                                            <input type="number" name="quantity" id="number" value="1" />
                                            <div class="value-button increase_" id="" value="Increase Value">+</div>
                                        </div>
                                    </div>
                                    <div class="_p-features">
                                        <span> ${detailP.serDescription}</span>                       
                                    </div>

                                    <ul class="spe_ul"></ul>
                                    <div class="_p-qty-and-cart">
                                        <div class="_p-add-cart">
                                            <button class="btn-theme btn buy-btn" tabindex="0">
                                                <i class="fa fa-shopping-cart"></i> Buy Now
                                            </button>
                                            <button type="submit" id="addtocart" value="Submit" class="btn-theme btn btn-success" tabindex="0">
                                                <i class="fa fa-shopping-cart"></i> Add to Cart
                                            </button>
                                            <input type="hidden" name="op" value="add" />
                                            <input type="hidden" name="serId" value="${detailP.serID}" />
                                            <input type="hidden" name="url" value="" />    
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>              
                </div>
            </div>
        </section>
        <section class="sec bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 title_bx">
                        <h3 class="title">Other Services You May Like</h3>
                    </div>
                </div>
                <c:if test="${requestScope.RANDOMLIST != null}">
                    <c:if test="${not empty requestScope.RANDOMLIST}" var="check" scope="page">
                        <div class="computers_section_2">
                            <div class="container-fluid">
                                <div class="computer_main">
                                    <div class="row">
                                        <c:forEach items="${requestScope.RANDOMLIST}" var="dto" varStatus="counter">
                                            <div class="col-md-4">
                                                <c:if test="${dto.serImage != null}">
                                                    <c:if test="${not empty dto.serImage}">
                                                        <div class="computer_img">
                                                            <a href="ShowServiceDetail?serId=${dto.serID}"><img src="${dto.serImage}" style="height: 450px; width: 450px;"/></a>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${empty dto.serImage}">
                                                        <div class="computer_img">
                                                            <img src="https://dummyimage.com/600x400/55595c/fff" width = "450" height = "650"/>
                                                        </div>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${dto.serImage == null}">
                                                    <div class="computer_img">
                                                        <img src="https://dummyimage.com/600x400/55595c/fff" width = "450" height = "650"/>
                                                    </div>
                                                </c:if>
                                                <a href="ShowServiceDetail?serId=${dto.serID}"><h4 class="computer_text">${dto.serName}</h4></a>
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
                    </c:if>
                    <c:if test="${empty requestScope.RANDOMLIST}">
                        <p>There is no service is recommend for you!!</p>
                    </c:if>
                </c:if>
                <c:if test="${requestScope.RANDOMLIST == null}">
                    <p>There is no service is recommend for you!!</p>
                </c:if>
        </section>
        <!-- computers section end -->
        <!-- footer section start -->
        <div class="footer_section layout_padding margin_top_90">
            <div class="container">
                <div class="footer_logo_main">
                    <!--                    <div class="footer_logo"><a href="index.html"><img src="images/footer-logo.png"></a></div>-->
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
                                    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                                    <a href="ShowHomeGeneralController">Home</a>
                                    <a href="SearchController?index=1">Services List</a>
                                    <a href="contact.jsp">Contact</a>
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
                            <div class="call_text"><img src="images/call-icon.png"><span class="paddlin_left_0"><a href="#">+09887766</a></span></div>
                            <div class="call_text"><img src="images/mail-icon.png"><span class="paddlin_left_0"><a href="#">ebutler@gmail.com</a></span></div>
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
                                        /*!     
                                         jquery.picZoomer.js
                                         v 1.0
                                         David
                                         http://www.CodingSerf.com
                                         */

                                        //?????
                                        ;
                                        (function ($) {
                                            $.fn.picZoomer = function (options) {
                                                var opts = $.extend({}, $.fn.picZoomer.defaults, options),
                                                        $this = this,
                                                        $picBD = $('<div class="picZoomer-pic-wp"></div>').css({'width': opts.picWidth + 'px', 'height': opts.picHeight + 'px'}).appendTo($this),
                                                        $pic = $this.children('img').addClass('picZoomer-pic').appendTo($picBD),
                                                        $cursor = $('<div class="picZoomer-cursor"><i class="f-is picZoomCursor-ico"></i></div>').appendTo($picBD),
                                                        cursorSizeHalf = {w: $cursor.width() / 2, h: $cursor.height() / 2},
                                                        $zoomWP = $('<div class="picZoomer-zoom-wp"><img src="" alt="" class="picZoomer-zoom-pic"></div>').appendTo($this),
                                                        $zoomPic = $zoomWP.find('.picZoomer-zoom-pic'),
                                                        picBDOffset = {x: $picBD.offset().left, y: $picBD.offset().top};


                                                opts.zoomWidth = opts.zoomWidth || opts.picWidth;
                                                opts.zoomHeight = opts.zoomHeight || opts.picHeight;
                                                var zoomWPSizeHalf = {w: opts.zoomWidth / 2, h: opts.zoomHeight / 2};

                                                //???zoom????
                                                $zoomWP.css({'width': opts.zoomWidth + 'px', 'height': opts.zoomHeight + 'px'});
                                                $zoomWP.css(opts.zoomerPosition || {top: 0, left: opts.picWidth + 30 + 'px'});
                                                //???zoom????
                                                $zoomPic.css({'width': opts.picWidth * opts.scale + 'px', 'height': opts.picHeight * opts.scale + 'px'});

                                                //?????
                                                $picBD.on('mouseenter', function (event) {
                                                    $cursor.show();
                                                    $zoomWP.show();
                                                    $zoomPic.attr('src', $pic.attr('src'))
                                                }).on('mouseleave', function (event) {
                                                    $cursor.hide();
                                                    $zoomWP.hide();
                                                }).on('mousemove', function (event) {
                                                    var x = event.pageX - picBDOffset.x,
                                                            y = event.pageY - picBDOffset.y;

                                                    $cursor.css({'left': x - cursorSizeHalf.w + 'px', 'top': y - cursorSizeHalf.h + 'px'});
                                                    $zoomPic.css({'left': -(x * opts.scale - zoomWPSizeHalf.w) + 'px', 'top': -(y * opts.scale - zoomWPSizeHalf.h) + 'px'});

                                                });
                                                return $this;

                                            };
                                            $.fn.picZoomer.defaults = {
                                                picHeight: 460,
                                                scale: 2.5,
                                                zoomerPosition: {top: '0', left: '380px'},

                                                zoomWidth: 400,
                                                zoomHeight: 460
                                            };
                                        })(jQuery);



                                        $(document).ready(function () {
                                            $('.picZoomer').picZoomer();
                                            $('.piclist li').on('click', function (event) {
                                                var $pic = $(this).find('img');
                                                $('.picZoomer-pic').attr('src', $pic.attr('src'));
                                            });

                                            var owl = $('#recent_post');
                                            owl.owlCarousel({
                                                margin: 20,
                                                dots: false,
                                                nav: true,
                                                navText: [
                                                    "<i class='fa fa-chevron-left'></i>",
                                                    "<i class='fa fa-chevron-right'></i>"
                                                ],
                                                autoplay: true,
                                                autoplayHoverPause: true,
                                                responsive: {
                                                    0: {
                                                        items: 2
                                                    },
                                                    600: {
                                                        items: 3
                                                    },
                                                    1000: {
                                                        items: 5
                                                    },
                                                    1200: {
                                                        items: 4
                                                    }
                                                }
                                            });

                                            $('.decrease_').click(function () {
                                                decreaseValue(this);
                                            });
                                            $('.increase_').click(function () {
                                                increaseValue(this);
                                            });
                                            function increaseValue(_this) {
                                                var value = parseInt($(_this).siblings('input#number').val(), 10);
                                                value = isNaN(value) ? 0 : value;
                                                value++;
                                                $(_this).siblings('input#number').val(value);
                                            }

                                            function decreaseValue(_this) {
                                                var value = parseInt($(_this).siblings('input#number').val(), 10);
                                                value = isNaN(value) ? 0 : value;
                                                value < 1 ? value = 1 : '';
                                                value--;
                                                $(_this).siblings('input#number').val(value);
                                            }
                                        });

        </script> 
    </body>
</html>
