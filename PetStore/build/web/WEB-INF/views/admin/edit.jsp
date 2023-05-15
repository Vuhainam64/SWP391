<%-- 
    Document   : edit
    Created on : Feb 16, 2023, 12:32:26 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Product Edit</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/admin/edit_handler.do" />">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">Id:</label>
                <input disabled type="text" class="form-control" id="id" placeholder="Product id" value="${param.id}">
                <input type="hidden" name="id" value="${param.id}" />
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" placeholder="Product name" name="name" value="${products.name}">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description:</label>
                <input type="text" class="form-control" id="description" placeholder="Product description" name="description" value="${products.description}">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price:</label>
                <input type="number" step="0.1" class="form-control" id="price" placeholder="Product price" name="price" value="${products.price}">
            </div>
            <div class="mb-3">
                <label for="category" class="form-label">Category:</label>
                <input type="text" class="form-control" id="category" placeholder="Product category" name="category" value="${products.category}">
            </div>
            <div class="mb-3">
                <label for="image" class="form-label">Image:</label>
                <input type="text" class="form-control" id="image" placeholder="Product image" name="image" value="${products.image}">
            </div>
            <div class="mb-3">
                <label for="tags" class="form-label">Tags</label>
                <input type="text" class="form-control" id="tags" placeholder="Product tags" name="tags" value="${products.tags}">
            </div>
            <div class="mb-3">
                <label for="image1" class="form-label">Sub Image 1:</label>
                <input type="text" class="form-control" id="image1" placeholder="Product sub image 1" name="image1" value="${products.image1}">
            </div>
            <div class="mb-3">
                <label for="image2" class="form-label">Sub Image 2:</label>
                <input type="text" class="form-control" id="image2" placeholder="Product sub image 2" name="image2" value="${products.image2}">
            </div>
            <div class="mb-3">
                <label for="image3" class="form-label">Sub Image 3:</label>
                <input type="text" class="form-control" id="image3" placeholder="Product sub image 3" name="image3" value="${products.image3}">
            </div>
            <div class="mb-3">
                <label for="image4" class="form-label">Sub Image 4:</label>
                <input type="text" class="form-control" id="image1" placeholder="Product sub image 4" name="image4" value="${products.image4}">
            </div>
            <div class="mb-3">
                <label for="image5" class="form-label">Sub Image 5:</label>
                <input type="text" class="form-control" id="image1" placeholder="Product sub image 5" name="image5" value="${products.image5}">
            </div>
            <button type="submit" class="btn btn-outline-success"value="update"><i class="bi bi-check-lg"></i> Update</button>
            <button type="submit" class="btn btn-outline-danger"value="cancel"><i class="bi bi-x-lg"></i> Cancel</button>
        </form>
    </div>
    <div class="col">
        <img src="<c:url value="/images/mickey.gif" />" alt=""/>
    </div>
</div>

