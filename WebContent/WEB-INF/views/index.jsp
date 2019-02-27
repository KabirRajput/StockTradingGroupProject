<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->

<!DOCTYPE html>
<html>
<head>

<title>Legend Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  body {
      font: 400 15px Lato, sans-serif;
      line-height: 1.8;
      color: #818181;
  }
  h2 {
      font-size: 24px;
      text-transform: uppercase;
      color: #303030;
      font-weight: 600;
      margin-bottom: 30px;
  }
  h4 {
      font-size: 19px;
      line-height: 1.375em;
      color: #303030;
      font-weight: 400;
      margin-bottom: 30px;
  }  
  .jumbotron {
      background-color: skyblue;
      color: #fff;
      padding: 100px 25px;
      font-family: Montserrat, sans-serif;
  }
  .container-fluid {
      padding: 60px 50px;
  }
  .bg-grey {
      background-color: #f6f6f6;
  }
  .logo-small {
      color: skyblue;
      font-size: 50px;
  }
  .logo {
      color: skyblue;
      font-size: 200px;
  }
  .thumbnail {
      padding: 0 0 15px 0;
      border: none;
      border-radius: 0;
  }
  .thumbnail img {
      width: 100%;
      height: 100%;
      margin-bottom: 10px;
  }
  .carousel-control.right, .carousel-control.left {
      background-image: none;
      color: skyblue;
  }
  .carousel-indicators li {
      border-color: skyblue;
  }
  .carousel-indicators li.active {
      background-color: skyblue;
  }
  .item h4 {
      font-size: 19px;
      line-height: 1.375em;
      font-weight: 400;
      font-style: italic;
      margin: 70px 0;
  }
  .item span {
      font-style: normal;
  }
  .panel {
      border: 1px solid skyblue; 
      border-radius:0 !important;
      transition: box-shadow 0.5s;
  }
  .panel:hover {
      box-shadow: 5px 0px 40px rgba(0,0,0, .2);
  }
  .panel-footer .btn:hover {
      border: 1px solid skyblue;
      background-color: #fff !important;
      color: skyblue;
  }
  .panel-heading {
      color: #fff !important;
      background-color: skyblue !important;
      padding: 25px;
      border-bottom: 1px solid transparent;
      border-top-left-radius: 0px;
      border-top-right-radius: 0px;
      border-bottom-left-radius: 0px;
      border-bottom-right-radius: 0px;
  }
  .panel-footer {
      background-color: white !important;
  }
  .panel-footer h3 {
      font-size: 32px;
  }
  .panel-footer h4 {
      color: #aaa;
      font-size: 14px;
  }
  .panel-footer .btn {
      margin: 15px 0;
      background-color: skyblue;
      color: #fff;
  }
  .navbar {
      margin-bottom: 0;
      background-color: skyblue;
      z-index: 9999;
      border: 0;
      font-size: 12px !important;
      line-height: 1.42857143 !important;
      letter-spacing: 4px;
      border-radius: 0;
      font-family: Montserrat, sans-serif;
  }
  .navbar li a, .navbar .navbar-brand {
      color: #fff !important;
  }
  .navbar-nav li a:hover, .navbar-nav li.active a {
      color: skyblue !important;
      background-color: #fff !important;
  }
  .navbar-default .navbar-toggle {
      border-color: transparent;
      color: #fff !important;
  }
  footer .glyphicon {
      font-size: 20px;
      margin-bottom: 20px;
      color: skyblue;
  }
  .slideanim {visibility:hidden;}
  .slide {
      animation-name: slide;
      -webkit-animation-name: slide;
      animation-duration: 1s;
      -webkit-animation-duration: 1s;
      visibility: visible;
  }
  @keyframes slide {
    0% {
      opacity: 0;
      transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      transform: translateY(0%);
    }
  }
  @-webkit-keyframes slide {
    0% {
      opacity: 0;
      -webkit-transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      -webkit-transform: translateY(0%);
    }
  }
  @media screen and (max-width: 768px) {
    .col-sm-4 {
      text-align: center;
      margin: 25px 0;
    }
    .btn-lg {
        width: 100%;
        margin-bottom: 35px;
    }
  }
  @media screen and (max-width: 480px) {
    .logo {
        font-size: 150px;
    }
  }
  </style>
</head>


<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="">LegendTrading</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
     <!--    <li><a href="#about">ABOUT</a></li>
        <li><a href="#services">SERVICES</a></li>
        <li><a href="#routes">ROUTES</a></li> -->
        <li><a href="trades">View Trades</a></li>
        <li><a href="positions">View Positions</a></li>
        <li><a href="addTrade">Add Trades</a></li>
         <li><a href="#contact">CONTACT</a></li>
        
      </ul>
       <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    </div>
    
  </div>
</nav>

<!-- <div class="jumbotron text-center"> -->
<!--   <h1>Fly LegendAirways. Come for the Journey, stay for the Service.</h1>  -->
<!--   <p>Legend Airways, where everyone's a Legend.</p>  -->
<!--   <form> -->
<!--     <div class="input-group"> -->
<!--       <input type="email" class="form-control" size="50" placeholder="Enter Your Email Address To Register For The Latest News Information" required> -->
<!--       <div class="input-group-btn"> -->
<!--         <button type="button" class="btn btn-primary">Subscribe</button> -->
<!--       </div> -->
<!--     </div> -->
<!--   </form> -->
<!-- </div> -->

<!-- Container (About Section) -->
<div id="about" class="container-fluid">
  <div class="row">
    <div class="col-sm-8">
      <h2>About Us</h2><br>
      <h4>Company History</h4><br>
      <p>Hi</p>
      <br><button class="btn btn-default btn-lg">Get in Touch</button>
    </div>
    <div class="col-sm-4">
<!--       <span class="glyphicon glyphicon-signal logo"></span> -->
      <img src="https://farm3.staticflickr.com/2455/3599499476_1c3000dd3a_b.jpg" alt="Zurich" width="400" height="300">
    </div>
  </div>
</div>

<div class="container-fluid bg-grey">
  <div class="row">
    <div class="col-sm-4">
     <img src="https://tybennett.com/wp-content/uploads/2018/08/8-15-a.jpg" alt="Zurich" width="400" height="300">
<!--       <span class="glyphicon glyphicon-globe logo slideanim"></span> -->
    </div>
    <div class="col-sm-8">
      <h2>Our Values</h2><br>
      <h4><strong>MISSION:</strong> We are deeply committed to Hong Kong, where the Company was founded in 2018. We continue to make substantial investments to develop Hong Kong's aviation industry and enhance Hong Kong's position as a regional transportation hub. In addition to our fleet of aircraft, these investments include catering, aircraft maintenance and ground handling companies, as well as our corporate headquarters at Hong Kong International Airport.</h4><br>
      <p><strong>VISION:</strong> Our vision is to be the world's best airline. Being the best means that we always strive to excel in everything we do. Our dynamic team provides the highest quality service so that our customers are happy they chose Legend Airways.</p>
    </div>
  </div>
</div>

<!-- Container (Services Section) -->
<div id="services" class="container-fluid text-center">
  <h2>SERVICES</h2>
  <h4>What we offer</h4>
  <br>
  <div class="row slideanim">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-plane logo-small"></span>
      <h4>NETWORK</h4>
      <p>Legend Airways is part of the One-World Alliance to bring you better global reach</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-usd logo-small"></span>
      <h4>PRICES</h4>
      <p>Cheap and affordable rates for frequent travel</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-lock logo-small"></span>
      <h4>SECURITY</h4>
      <p>Industry grade encryption to safeguard your personal data</p>
    </div>
  </div>
  <br><br>
  <div class="row slideanim">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-leaf logo-small"></span>
      <h4>GREEN</h4>
      <p>Sustainable flying is at the top of our agenda</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-globe logo-small"></span>
      <h4>LEGEND MILES</h4>
      <p>World class loyalty program to bring you the best deals and offers</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-cutlery logo-small"></span>
      <h4 style="color:#303030;">FOOD AND SERVICE</h4>
      <p>We strive to bring you the best cuisines from around the world</p>
    </div>
  </div>
</div>

<!-- Container (Portfolio Section) -->
<div id="routes" class="container-fluid text-center bg-grey">
  <h2>New Routes</h2><br>
  <h4>New long haul flights</h4>
  <div class="row text-center slideanim">
    <div class="col-sm-4">
      <div class="thumbnail">
<!--         <img src="https://www.telegraph.co.uk/content/dam/Travel/hotels/europe/france/paris/eiffel-tower-paris-p.jpg" alt="Paris" width="400" height="300"> -->
		<img src="images/paris.jpg" alt="Paris" width="400" height="300">
        <p><strong>Paris</strong></p>
        <p>Fly to the City of Love</p>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
<!--         <img src="https://media.timeout.com/images/104692494/image.jpg" alt="New York" width="400" height="300"> -->
        <img src="images/new-york-main-image.jpg" alt="New York" width="400" height="300">
        <p><strong>New York</strong></p>
        <p>Roam around in the City that never sleeps</p>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
<!--         <img src="https://www.thebubble.com/wp-content/uploads/GettyImages-480295417_super.jpg" alt="Zurich" width="400" height="300"> -->
        <img src="images/zurich.jpg" alt="Zurich" width="400" height="300">
        <p><strong>Zurich</strong></p>
        <p>Visit the heart of Europe</p>
      </div>
    </div>
  </div><br>
  
  <h2>What our customers say</h2>
  <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <h4>"Legend Airways is legendary. I am thrilled with the integrity and service!"<br><span>Kabir Rajput, Consultant, FDM Group</span></h4>
      </div>
      <div class="item">
        <h4>"One word... WOW! If that was the economy class, I can only imagine what first class is like..."<br><span>Wilson Chung, Consultant, FDM Group</span></h4>
      </div>
      <div class="item">
        <h4>"Sign me up for lifetime membership..."<br><span>Brian Leung, Consultant, FDM Group</span></h4>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<!-- Container (Pricing Section) -->
<div id="trades" class="container-fluid">
  <div class="text-center">
    <h2>Flights</h2>
    <h4>Choose a flight</h4>
  </div>
  <div class="row slideanim">
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>HKG -> MNL</h1>
        </div>
        <div class="panel-body">
          <p><strong>From</strong> HK Intl Airport</p>
          <p><strong>To</strong> Ninoy Acquino Intl Airport</p>
          <p><strong>Duration</strong> 02h35</p>
          <p><strong>Class</strong> Economy</p>
          
        </div>
        <div class="panel-footer">
          <h3>HK$3036</h3>
          <h4>Round-trip</h4>
          <a href="login" class="btn btn-lg">Book now</a>
        </div>
      </div>      
    </div>     
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>HKG -> ZRH</h1>
        </div>
        <div class="panel-body">
          <p><strong>From</strong> HK Intl Airport</p>
          <p><strong>To</strong> Zurich Intl Airport</p>
          <p><strong>Duration</strong> 11h05</p>
          <p><strong>Class</strong> Economy</p>
        </div>
        <div class="panel-footer">
          <h3>HK$7801</h3>
          <h4>Round-trip</h4>
          <a href="login" class="btn btn-lg">Book now</a>
        </div>
      </div>      
    </div>       
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>HKG -> PVG</h1>
        </div>
        <div class="panel-body">
          <p><strong>From</strong> HK Intl Airport</p>
          <p><strong>To</strong> Shanghai Pudong Intl Airport</p>
          <p><strong>Duration</strong> 02h50</p>
          <p><strong>Class</strong> Economy</p>
        </div>
        <div class="panel-footer">
          <h3>HK$4995</h3>
          <h4>Round-trip</h4>
          <a href="login" class="btn btn-lg">Book now</a>
        </div>
      </div>    
      
    </div>    
    <div class="panel-footer text-center">
      	<br><a href="login" class="btn btn-lg text-center">Search for more flights</a>  
    </div>
  </div>
</div>

	<!-- Container (Contact Section) -->
<div id="contact" class="container-fluid bg-grey">
  <h2 class="text-center">CONTACT</h2>
  <div class="row">
    <div class="col-sm-5">
      <p>Contact us and we'll get back to you within 24 hours.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span> Hong Kong</p>
      <p><span class="glyphicon glyphicon-phone"></span> +852 99463018</p>
      <p><span class="glyphicon glyphicon-envelope"></span> contactus@legendairways.com</p>
    </div>
    <div class="col-sm-7 slideanim">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Your Legendary Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Your Legendary Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
      <div class="row">
        <div class="col-sm-12 form-group">
          <button class="btn btn-default pull-right" type="submit">Send</button>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Image of location/map -->
<img src="/w3images/map.jpg" class="w3-image w3-greyscale-min" style="width:100%">

<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>Copyright © Legend Airways Limited</p>
</footer>

<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
})
</script>

<body>

<!-- <body> -->
<!-- 	<div class="container"> -->
<!-- 		<h1>Welcome to legend trading!</h1> -->
<%-- 		<p>${ greeting }</p> --%>
<!-- 		<a href="addTrade" -->
<!-- 			class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile">Click -->
<!-- 			to start trading</a>  -->
<!-- 		<a href="trades" -->
<!-- 			class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile">Click -->
<!-- 			to view trades</a> -->
<!-- 	</div> -->


<!-- <nav class="navbar navbar-expand-lg navbar-light bg-light"> -->
<!--   <a class="navbar-brand" href="#">Legend Trading</a> -->
<!--   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> -->
<%--     <span class="navbar-toggler-icon"></span> --%>
<!--   </button> -->

<!--   <div class="collapse navbar-collapse" id="navbarSupportedContent"> -->
<!--     <ul class="navbar-nav mr-auto"> -->
<%--      <c:if test="${ empty active_username }"> --%>
<!--                         <li class="nav-item"> -->
<!--                             <a class="nav-link" href="login">Login</a> -->
<!--                         </li> -->
<!--                         <li class="nav-item"> -->
<!--                             <a class="nav-link" href="register">Register</a> -->
<!--                         </li> -->
<%--                     </c:if> --%>
<%--        <c:if test="${ not empty active_username }"> --%>
<!--                         <li class="nav-item"> -->
<%--                             <span class="nav-link">Welcome, ${active_username }</span> --%>
<!--                         </li> -->
<!--                         <li class="nav-item"> -->
<!--                             <a class="nav-link" href="logout">Logout</a> -->
<!--                         </li> -->
<%--                     </c:if> --%>
<!--       <li class="nav-item dropdown"> -->
<!--         <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> -->
<!--           Trade -->
<!--         </a> -->
<!--         <div class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<!--           <a class="dropdown-item" href="#">Action</a> -->
<!--           <a class="dropdown-item" href="#">Another action</a> -->
<!--           <div class="dropdown-divider"></div> -->
<!--           <a class="dropdown-item" href="#">Something else here</a> -->
<!--         </div> -->
<!--       </li> -->
<!--       <li class="nav-item"> -->
<!--         <a class="nav-link disabled" href="#">Under Construction</a> -->
<!--       </li> -->
<!--     </ul> -->
<!--     <form class="form-inline my-2 my-lg-0"> -->
<!--       <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"> -->
<!--       <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
<!--     </form> -->
<!--   </div> -->
<!-- </nav> -->


<!-- 	<div class="container"> -->
<!-- 		<h1>Welcome to legend trading!</h1> -->
<%-- 		<p>${ greeting }</p> --%>
<!-- 		<a href="addTrade" -->
<!-- 			class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile">Click -->
<!-- 			to start trading</a>  -->
<!-- 		<a href="trades" -->
<!-- 			class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile">Click -->
<!-- 			to view trades</a> -->
<!-- 	</div> -->

<!-- </body> -->

<%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> --%>
<%--     <script src="js/bootstrap.min.js"></script> --%>
<%--     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> --%>

<%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script> --%>
<%-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> --%>

</html>