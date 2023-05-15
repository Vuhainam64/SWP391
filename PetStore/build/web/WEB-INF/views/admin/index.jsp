<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="section-title">
    <h2>Product Manager</h2>
</div>
<hr/>
<a href="<c:url value="/admin/create.do" />"><i class="fa fa-pencil"></i> Create</a>
<table class="table table-striped">
    <tr>
        <th>No.</th>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Category</th>
        <th>Tags</th>
        <th>Operator</th>
    </tr>
    <c:forEach var="product" items="${list}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.category}</td>        
            <td>${product.tags}</td>
            <td>
                <a href="<c:url value="/admin/edit.do?id=${product.id}" />"><i class="fa fa-edit"></i> Edit</a> | 
                <a href="<c:url value="/admin/delete.do?id=${product.id}" />"><i class="bi bi-trash3"></i> Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>