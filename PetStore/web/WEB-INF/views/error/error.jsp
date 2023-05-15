<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="errorPage">
    <div class="errorPage__text">
        <h3>404</h3>
        <span class="errorPage__button"><a href="<c:url value="/cakestore/index.do"/>">Back to home</a></span>
    </div>
    <span class="errorPage__templeweed-container"><img src="<c:url value="/img/error/404.png"/>" class="errorPage__tembleweed"></span>
    <div class="errorPage__terrain"></div>
</section>