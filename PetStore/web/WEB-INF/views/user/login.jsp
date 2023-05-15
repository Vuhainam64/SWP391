<%-- 
    Document   : login
    Created on : Feb 25, 2023, 10:30:40 AM
    Author     : vuhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value="/css/login.css" />" type="text/css">
<section class="vh-100" 
         style="
         background-image: url('<c:url value="/img/login/383127.jpg" />');
         background-repeat: no-repeat;
         background-size: cover;
         ">
    <div class="container" style="  display: flex;
         justify-content: center;
         align-items:center !important;
         height: 100vh;">
        <div class="row">
            <div class="col">

            </div>
            <div class="col cen">
                <div class="form">
                    <div class="btn">
                        <button class="loginBtn">LOG IN</button>
                        <button class="signUpBtn">SIGN UP</button>
                    </div>
                    <form class="signUp" action="<c:url value="/user/signup_handler.do"/>" method="get">
                        <div class="formGroup">
                            <input type="text" id="userName" placeholder="User Name" autocomplete="off" name="user">
                        </div>
                        <div class="formGroup">
                            <input type="email" placeholder="Email ID" name="email" required autocomplete="off">
                        </div>
                        <div class="formGroup">
                            <input type="password" id="password" placeholder="Password" required autocomplete="off" name="password">
                        </div>
                        <div class="formGroup">
                            <input type="password" id="confirmPassword" placeholder="Confirm Password" required autocomplete="off">
                        </div>
                        <div class="checkBox">
                            <input type="checkbox" name="checkbox" id="checkbox">
                            <span class="text">I agree with term & conditions</span>
                        </div>
                        <div class="formGroup">
                            <button type="submit" name="op" value="signup"  class="btn2"> REGISTER </button>
                        </div>

                    </form>

                    <!------ Login Form -------- -->
                    <form class="login" action="<c:url value="/user/login_handler.do"/>" method="get">

                        <div class="formGroup">
                            <input type="email" placeholder="Email " name="email" required autocomplete="off" class="form-control">
                        </div>
                        <div class="formGroup">
                            <input type="password" name="password" id="password" placeholder="Password" required autocomplete="off" class="form-control">

                        </div>
                        <i class="text" style="color:red;">${message}</i>
                        <div class="checkBox">
                            <input type="checkbox" name="checkbox" id="checkbox">
                            <span class="text">Keep me signed in on this device</span>
                        </div>

                        <div class="formGroup">
                            <button type="submit" name="op" value="login"  class="btn2"> LOGIN </button>
                            <button type="submit" name="op" value="cancel"  class="btn2"> CANCEL </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
