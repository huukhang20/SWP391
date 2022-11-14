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
        <title>E-Butler</title>
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
        <link rel="stylesheet" href="./product_list.css">
    </head>
    <body>
        <!-- header section start -->
        <div class="header_section haeder_main">
            <div class="container-fluid">
                <nav class="navbar navbar-light bg-light justify-content-between">
                    <div id="mySidenav" class="sidenav">
                        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                        <a href="ShowHomeGeneralController">Home</a>
                        <a href="contact.jsp">Contact</a>
                    </div>
                    <span style="font-size:30px;cursor:pointer; color: #fff;" onclick="openNav()"><img src="images/toggle-icon.png"></span>
                    <a class="navbar-brand" href="ShowHomeGeneralController">E-Butler</a></a>
                    <form class="form-inline ">
                        <div class="login_text">
                            <ul>
                                <li><a style="color: #000" href="SearchController?index=1">Normal</a></li>
                                <li><a style="color: #000" href="SortServiceBySupp?index=1">Supp</a></li>
                                <li><a style="color: #000" href="SortServiceAscByPrice?index=1">Price</a></li>
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
        <!-- computers section start -->
        <div class="container">
            <div class="row">
                <div class="col-12 col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${requestScope.listC}" var="o">
                                <a href="SortServiceAscByPriceAndCate?cateId=${o.cateId}&index=1"><li class="list-group-item ${mark == o.cateId ? "active":""}">${o.cateName}</li></a>
                                    </c:forEach>
                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-success text-white text-uppercase">Last Service</div>
                        <div class="card-body">
                            <c:if test="${not empty o.serImage}" var="check" scope="page">
                                <img class="img-fluid" src="${last.serImage}" width = "600" height = "400"/>
                            </c:if>
                            <c:if test="${empty o.serImage}" var="check" scope="page">
                                <a href="ShowServiceDetail?serId=${last.serID}"><img class="img-fluid" src="${last.serImage}" width = "600" height = "400"/></a>
                                </c:if>
                            <a href="ShowServiceDetail?serId=${last.serID}"><h5 class="card-title">${last.serName}</h5></a>
<!--                            <p class="card-text">${last.serDescription}</p>-->
                            <p class="bloc_left_price">${last.price} VND</p>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <c:if test="${requestScope.listP != null}">
                        <c:if test="${not empty requestScope.listP}" var="check" scope="page">
                            <div class="row">
                                <c:forEach items="${requestScope.listP}" var="o">
                                    <div class="col-12 col-md-6 col-lg-4 ">
                                        <div class="card">
                                            <c:if test="${not empty o.serImage}" var="check" scope="page">
                                                <a href="ShowServiceDetail?serId=${o.serID}"><img class="card-img-top" src="${o.serImage}" alt="Card image cap" width = "600" height = "400"></a>
                                                </c:if>
                                                <c:if test="${empty o.serImage}" var="check" scope="page">
                                                <img class="img-fluid" src="https://dummyimage.com/600x400/55595c/fff" width = "600" height = "400" />
                                            </c:if>
                                            <div class="card-body">
                                                <h4 class="card-title show_txt"><a href="ShowServiceDetail?serId=${o.serID}" title="View Product" >${o.serName}</a></h4>

<!--                                                <p class="card-text show_txt">${o.serDescription}</p>-->
                                                <div class="row">
                                                    <div class="col">
                                                        <p class="btn btn-danger ">${o.price} VND</p>
                                                    </div>
                                                    <div class="col">
                                                        <a href="CartController?op=add&serId=${o.serID}&quantity=1&url=product_list.jsp" class="btn btn-success btn-block">Add to cart</a>
                                                    </div>
                                                </div>
                                            </div> 
                                        </div>
                                    </div>
                                </c:forEach>
                                <div class="col-12">
                                    <nav aria-label="...">
                                        <ul class="pagination">
                                            <!--                                            <li class="page-item disabled">
                                                                                            <a class="page-link" href="#" tabindex="-1">Previous</a>
                                                                                        </li>-->
                                            <li class="page-item ${markPage == 1 ? "active":""}"><a class="page-link" href="SortServiceAscByPrice?index=1">1</a></li>

                                            <li class="page-item ${markPage == 2 ? "active":""}"><a class="page-link" href="SortServiceAscByPrice?index=2">2</a></li>
                                            <li class="page-item ${markPage == 3 ? "active":""}"><a class="page-link" href="SortServiceAscByPrice?index=3">3</a></li>
                                            <!--                                            <li class="page-item">
                                                                                            <a class="page-link" href="#">Next</a>
                                                                                        </li>-->
                                        </ul>
                                    </nav>
                                </div>
                            </div>   
                        </c:if>
                    </c:if>
                    <c:if test="${empty requestScope.listP}">
                        <h2 style="color: black">There is no service available</h2>
                    </c:if>
                </div>            
            </div>
        </div>
        <!-- computers section end -->
        <!-- footer section start -->
        <div class="footer_section layout_padding margin_top_90">
            <div class="container">
                <div class="footer_logo_main">
                    <div class="adderss_text" style="font-size: 70px"><a href="index.html">Ebutler</a></div>
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
                                    <!--                                    <li><a href="computers.html">Computers</a></li>
                                                                        <li><a href="Mans_clothes.html">Mans Clothes</a></li>
                                                                        <li><a href="womans_clothes.html">Womans Clothes</a></li>-->
                                    <li><a href="contact.jsp">Contact Us</a></li>
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
        </script> 
    </body>
</html>