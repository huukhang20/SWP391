<%-- 
    Document   : profile
    Created on : Sep 29, 2022, 6:27:13 PM
    Author     : Admin
--%>

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
      <title>Contact</title>
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
      <div class="header_section_haeder_main">
         <div class="container-fluid">
            <nav class="navbar navbar-light bg-light justify-content-between">
               <div id="mySidenav" class="sidenav">
                  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                  <a href="ShowHomeGeneralController">Home</a>
                  <a href="ShowService">Product List</a>
                  <a href="profile.jsp">Profile</a>
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
                        <li><a href="LogoutController"><img src="images/logout.png" width = "21" height = "20"></a></li>
                     </ul>
                  </div>
               </form>
            </nav>
         </div>
      </div>
      <!-- header section end -->
      <div class="container rounded bg-white mt-5 mb-5">
         <div class="row">
             <div class="col-md-3 border-right">
                 <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Edogaru</span><span class="text-black-50">edogaru@mail.com.my</span><span> </span></div>
                 <div class="mt-5 text-center">
                 <a href="OrderController" class="btn btn-info" role="button">YOUR ORDER LIST</a>
                 </div>
                 <div class="mt-5 text-center">
                  <a href="change_password.html" class="btn btn-info" role="button">Change Password</a>
                  </div>
             </div>
             <div class="col-md-5 border-right">
                 <div class="p-3 py-5">
                     <div class="d-flex justify-content-between align-items-center mb-3">
                         <h4 class="text-right">Profile Settings</h4>
                     </div>
                     <div class="row mt-2">
                         <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control" placeholder="first name" value="${account.getName()}"></div>
                         <div class="col-md-6"><label class="labels">Surname</label><input type="text" class="form-control" value="" placeholder="surname"></div>
                     </div>
                     <div class="row mt-3">
                         <div class="col-md-12"><label class="labels">username</label><input type="text" class="form-control" placeholder="username" value="${account.getUsername()}"></div>
                         <div class="col-md-12"><label class="labels">Mobile Number</label><input type="text" class="form-control" placeholder="enter phone number" value="${account.getPhone()}"></div>
                         <div class="col-md-12"><label class="labels">Address Line 1</label><input type="text" class="form-control" placeholder="enter address line 1" value="${account.getAddress()}"></div>
                  
      
                        
                         <div class="col-md-12"><label class="labels">Email ID</label><input type="text" class="form-control" placeholder="enter email id" value="${account.getEmail()}"></div>
                     </div>
                    
                     <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Save Profile</button></div>
                 </div>
             </div>
             <!-- <div class="col-md-4">
                 <div class="p-3 py-5">
                     <div class="d-flex justify-content-between align-items-center experience"><span>Edit Experience</span><span class="border px-3 p-1 add-experience"><i class="fa fa-plus"></i>&nbsp;Experience</span></div><br>
                     <div class="col-md-12"><label class="labels">Experience in Designing</label><input type="text" class="form-control" placeholder="experience" value=""></div> <br>
                     <div class="col-md-12"><label class="labels">Additional Details</label><input type="text" class="form-control" placeholder="additional details" value=""></div>
                 </div>
             </div> -->
         </div>
     </div>
     </div>
     </div>
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
                     <p class="ipsum_text"></p>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                     <h4 class="adderss_text">Menu</h4>
                     <div class="footer_menu">
                        <ul>
                           <li><a href="index.html">Home</a></li>
                           <li><a href="computers.html"></a></li>
                           <li><a href="Mans_clothes.html"></a></li>
                           <li><a href="womans_clothes.html"></a></li>
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
      </script> 
   </body>
</html>
