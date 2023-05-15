<%-- 
    Document   : subscribe
    Created on : Feb 24, 2023, 10:53:28 PM
    Author     : vuhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String email = request.getParameter("email");
    // Do something with the email (e.g. add it to a database, send a confirmation email)
    // ...
%>
<div class="container">
</div>
<section class="hero">
    <style>
        .hero__text:after{
            content: "" !important;
            display: none !important;
        }
    </style>
    <div class="hero__slider owl-carousel">
        <div class="hero__item set-bg" data-setbg="<c:url value="/img/hero/hero-1.jpg"/>">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-8">
                        <div class="hero__text">
                            <h2>Thanks for subscribing</h2>
                            <p>Your email address: <%=email%></p>
                            <a href="<c:url value="/cakestore/index.do" />" class="primary-btn">Return Home</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

