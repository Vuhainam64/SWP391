<%-- 
    Document   : main
    Created on : Feb 2, 2023, 12:51:25 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Cake Template">
        <meta name="keywords" content="Cake, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Pet Store</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;600;700;800;900&display=swap"
              rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- Awesome Font -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              rel="stylesheet" />

        <!-- Css Styles -->

        <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/flaticon.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/barfiller.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/magnific-popup.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/elegant-icons.css" />.css" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/nice-select.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/owl.carousel.min.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/slicknav.min.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/style.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/404.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/index.css" />" type="text/css">



    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Header Section Begin -->
        <header class="header">

            <a href="#" class="logo"><i class="fa-solid fa-dove"></i> shop </a>

            <nav class="navbar">
                <a href="<c:url value="/petstore/index.do"/>">home</a>
                <a href="#about">about</a>
                <a href="<c:url value="/shop/shop.do"/>">shop</a>
                <a href="#contact">contact</a>
            </nav>

            <div class="icons">
                <div class="fa fa-bars" id="menu-btn"></div>
                <a href="<c:url value="/cart/cart.do"/>" class="fa fa-shopping-cart"></a>
                <div class="fa fa-user" id="login-btn"></div>
            </div>

            <form action="" class="login-form">
                <h3>sign in</h3>
                <input type="email" name="" placeholder="enter your email" id="" class="box">
                <input type="password" name="" placeholder="enter your password" id="" class="box">
                <div class="remember">
                    <input type="checkbox" name="" id="remember-me">
                    <label for="remember-me">remember me</label>
                </div>
                <input type="submit" value="sign in" class="btn">
                <div class="links">
                    <a href="#">forget password</a>
                    <a href="<c:url value="/user/login.do" />">sign up</a>
                </div>
            </form>

        </header>
        <!-- Header Section End -->

        <div class="row">
            <div class="col">
                <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
            </div>
        </div>

        <!-- Footer Section Begin -->
        <section class="footer">
            <img src="<c:url value="/image/main/top_wave.png"/>" alt="">
            <div class="credit"> created by <span> SWP391 </span> | all rights reserved! </div>
        </section>
        <!-- Footer Section End -->

        <!-- Js Plugins -->
        <script src="<c:url value="/js/jquery-3.3.1.min.js" />"></script>
        <script src="<c:url value="/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/js/jquery.nice-select.min.js" />"></script>
        <script src="<c:url value="/js/jquery.barfiller.js" />"></script>
        <script src="<c:url value="/js/jquery.magnific-popup.min.js" />"></script>
        <script src="<c:url value="/js/jquery.slicknav.js" />"></script>
        <script src="<c:url value="/js/owl.carousel.min.js" />"></script>
        <script src="<c:url value="/js/jquery.nicescroll.min.js" />"></script>
        <script src="<c:url value="/js/main.js" />"></script>
        <script src="<c:url value="/js/login.js" />"></script>
        <script src="<c:url value="/js/cart.js" />"></script>
        <script src="<c:url value="/js/index.js" />"></script>

    </body>
</html>
