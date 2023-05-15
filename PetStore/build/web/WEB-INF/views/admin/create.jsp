<%-- 
    Document   : edit
    Created on : Feb 16, 2023, 12:32:26 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>Product Creation</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/admin/create_handler.do" />">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">Id:</label>
                <input type="text" class="form-control" id="id" placeholder="Product id" name="id" value="${param.id}">
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" placeholder="Product name" name="name" value="${param.name}">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description:</label>
                <input type="text" class="form-control" id="description" placeholder="Product description" name="description" value="${param.description}">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price:</label>
                <input type="number" step="0.1" class="form-control" id="price" placeholder="Product price" name="price" value="${param.price}">
            </div>
            <div class="mb-3">
                <label for="category" class="form-label">Category:</label></br>
                <select name="category" class="form-control" >
                    <c:forEach var="category" items="${categories}">
                        <option value="${category}" ${category==param.category?"selected":""}>${category}</option>
                    </c:forEach>
                </select></br>
            </div></br>
            <div class="mb-3">
                <label for="image" class="form-label">Image:</label>
                <input type="text" class="form-control" id="image" placeholder="Product image" name="image" value="${param.image}">
            </div>
            <div class="mb-3">
                <label for="tags" class="form-label">Tags</label>
                <input type="text" class="form-control" id="tags" placeholder="Product tags" name="tags" value="${param.tags}">
            </div>
            <div class="mb-3">
                <label for="image1" class="form-label">Sub Image 1:</label>
                <input type="text" class="form-control" id="image1" placeholder="Product sub image 1" name="image1" value="${param.image1}">
            </div>
            <div class="mb-3">
                <label for="image2" class="form-label">Sub Image 2:</label>
                <input type="text" class="form-control" id="image2" placeholder="Product sub image 2" name="image2" value="${param.image2}">
            </div>
            <div class="mb-3">
                <label for="image3" class="form-label">Sub Image 3:</label>
                <input type="text" class="form-control" id="image3" placeholder="Product sub image 3" name="image3" value="${param.image3}">
            </div>
            <div class="mb-3">
                <label for="image4" class="form-label">Sub Image 4:</label>
                <input type="text" class="form-control" id="image1" placeholder="Product sub image 4" name="image4" value="${param.image4}">
            </div>
            <div class="mb-3">
                <label for="image5" class="form-label">Sub Image 5:</label>
                <input type="text" class="form-control" id="image1" placeholder="Product sub image 5" name="image5" value="${param.image5}">
            </div>
            <button type="submit" class="btn btn-outline-success" name="op" value="create"><i class="bi bi-check-lg"></i> Create</button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel"><i class="bi bi-x-lg"></i> Cancel</button>
        <i style="color:red;">${message}</i>
    </div>
    <div class="col">
        <img src="<c:url value="/img/instagram/cake-piece.png"/>" alt=""/>
    </div>
</div>

