<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Breadcrumb Begin -->
<div class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="breadcrumb__text">
                    <h2>Shop</h2>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="breadcrumb__links">
                    <a href="<c:url value="/petstore/index.do"/>">Home</a>
                    <span>Shop</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Shop Section Begin -->
<section class="shop spad">
    <div class="container">
        <div class="shop__option">
            <div class="row">
                <div class="col-lg-7 col-md-7">
                    <div class="shop__option__search">
                        <form action="<c:url value="/shop/shop.do?"/>">
                            <select name="category">
                                <option value="">None</option>
                                <c:forEach var="category" items="${categories}">
                                    <option value="${category}" ${category==param.category?"selected":""}>${category}</option>
                                </c:forEach>
                            </select>
                            <input type="text" name="search" placeholder="Search" value="${param.search}">
                            <div style="display: none">
                                <select name="index"><option value="1">1</option></select>
                            </div>
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-5 col-md-5">
                    <div class="shop__option__right">
                        <select>
                            <option value="">Default sorting</option>
                            <option value="name" ${param.sort=="name"?"selected":""}>A to Z</option>
                            <option value="id"${param.sort=="id"?"selected":""}>1 - 8</option>
                            <option value="price"${param.sort=="price"?"selected":""}>Price</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach var="Products" items="${list}">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="${Products.image}">
                            <div class="product__label">
                                <span>${Products.category}</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="<c:url value="/detail/detail.do?pid=${Products.id}&currency=${param.currency}"/>">${Products.name}</a></h6>
                            <div class="product__item__price">${param.currency=="vnd"?Products.price*23580:Products.price} ${param.currency=="vnd"?"VND":"$"}</div>
                            <div class="cart_add">
                                <a href="<c:url value="/detail/detail.do?pid=${Products.id}&currency=${param.currency}"/>">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="shop__last__option">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="shop__pagination">
                        <c:forEach begin="1" end="${end}" var="i">
                            <a ${i==param.index?'style=" background: #000000; color: #ffffff;"':''} 
                            href="<c:url value="/shop/shop.do?category=${param.category}&search=${param.search}&index=${i}&sort=${param.sort}"/>">${i}</a>
                        </c:forEach>
                        <a href="<c:url value="/shop/shop.do?category=${param.category}&search=${param.search}&index=${param.index*pageSize<=count?param.index+1:param.index}&sort=${param.sort}"/>">></a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="shop__last__text">
                        <p>Showing 
                            ${param.index*pageSize-(pageSize-1)}
                            -
                            ${param.index*pageSize<=count?param.index*pageSize:count} 
                            of 
                            ${count} 
                            results
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Section End -->