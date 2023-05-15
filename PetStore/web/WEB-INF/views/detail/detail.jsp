<!-- Breadcrumb Begin -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="breadcrumb__text">
                    <h2>${detail.name} detail</h2>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="breadcrumb__links">
                    <a href="<c:url value="/cakestore/index.do"/>">Home</a>
                    <a href="<c:url value="/cakestore/shop.do"/>">Shop</a>
                    <span>Sweet autumn leaves</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Shop Details Section Begin -->
<section class="product-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="product__details__img">
                    <div class="product__details__big__img">
                        <img class="big_img" src="${detail.image}" alt="">
                    </div>
                    <div class="product__details__thumb">
                        <div class="pt__item active">
                            <img data-imgbigurl="${detail.image}"
                                 src="${detail.image}" alt="">
                        </div>
                        <div class="pt__item active">
                            <img data-imgbigurl="${detail.image1}"
                                 src="${detail.image1}" alt="">
                        </div>
                        <div class="pt__item">
                            <img data-imgbigurl="${detail.image2}"
                                 src="${detail.image2}" alt="">
                        </div>
                        <div class="pt__item">
                            <img data-imgbigurl="${detail.image3}"
                                 src="${detail.image3}" alt="">
                        </div>
                        <div class="pt__item">
                            <img data-imgbigurl="${detail.image4}"
                                 src="${detail.image4}" alt="">
                        </div>
                        <div class="pt__item">
                            <img data-imgbigurl="${detail.image5}"
                                 src="${detail.image5}" alt="">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="product__details__text">
                    <div class="product__label">${detail.category}</div>
                    <h4>${detail.name}</h4>
                    <h5>${param.currency=="vnd"?detail.price*23580:detail.price} ${param.currency=="vnd"?"VND":"$"}</h5>
                    <p>${detail.description}</p>
                    <ul>
                        <li>SKU: <span>${detail.id}</span></li>
                        <li>Category: <span>${detail.category}</span></li>
                        <li>Tags: <span>${detail.tags}</span></li>
                    </ul>
                    <div class="product__details__option">
                        <form action="<c:url value="/cart/add.do"/>" method="get">
                            <input type="hidden" value="${param.pid}" name="id">
                            <div class="quantity">
                                <div class="pro-qty">
                                    <span class="dec qtybtn"><a>-</a></span>
                                    <input type="text" value="1" name="quantity">
                                    <span class="inc qtybtn"><a>+</a></span>
                                </div>
                            </div>
                            <button style="border: none" type="submit" class="primary-btn">Add to cart</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="product__details__tab">
            <div class="col-lg-12">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Description</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Additional information</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">Previews(1)</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="tabs-1" role="tabpanel">
                        <div class="row d-flex justify-content-center">
                            <div class="col-lg-8">
                                <p>This delectable Strawberry Pie is an extraordinary treat filled with sweet and
                                    tasty chunks of delicious strawberries. Made with the freshest ingredients, one
                                    bite will send you to summertime. Each gift arrives in an elegant gift box and
                                    arrives with a greeting card of your choice that you can personalize online!</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tabs-2" role="tabpanel">
                        <div class="row d-flex justify-content-center">
                            <div class="col-lg-8">
                                <p>This delectable Strawberry Pie is an extraordinary treat filled with sweet and
                                    tasty chunks of delicious strawberries. Made with the freshest ingredients, one
                                    bite will send you to summertime. Each gift arrives in an elegant gift box and
                                    arrives with a greeting card of your choice that you can personalize online!2
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tabs-3" role="tabpanel">
                        <div class="row d-flex justify-content-center">
                            <div class="col-lg-8">
                                <p>This delectable Strawberry Pie is an extraordinary treat filled with sweet and
                                    tasty chunks of delicious strawberries. Made with the freshest ingredients, one
                                    bite will send you to summertime. Each gift arrives in an elegant gift box and
                                    arrives with a greeting card of your choice that you can personalize online!3
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Details Section End -->

<!-- Related Products Section Begin -->
<section class="related-products spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="section-title">
                    <h2>Related Products</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="related__products__slider owl-carousel">
                <div class="col-lg-3">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="<c:url value="/img/shop/product-1.jpg" />">
                            <div class="product__label">
                                <span>Cupcake</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Dozen Cupcakes</a></h6>
                            <div class="product__item__price">$32.00</div>
                            <div class="cart_add">
                                <a href="#">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="<c:url value="/img/shop/product-2.jpg" />">
                            <div class="product__label">
                                <span>Cupcake</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Cookies and Cream</a></h6>
                            <div class="product__item__price">$30.00</div>
                            <div class="cart_add">
                                <a href="#">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="<c:url value="/img/shop/product-3.jpg" />">
                            <div class="product__label">
                                <span>Cupcake</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Gluten Free Mini Dozen</a></h6>
                            <div class="product__item__price">$31.00</div>
                            <div class="cart_add">
                                <a href="#">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="<c:url value="/img/shop/product-4.jpg" />">
                            <div class="product__label">
                                <span>Cupcake</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Cookie Dough</a></h6>
                            <div class="product__item__price">$25.00</div>
                            <div class="cart_add">
                                <a href="#">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="<c:url value="/img/shop/product-5.jpg" />">
                            <div class="product__label">
                                <span>Cupcake</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">Vanilla Salted Caramel</a></h6>
                            <div class="product__item__price">$05.00</div>
                            <div class="cart_add">
                                <a href="#">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="<c:url value="/img/shop/product-6.jpg" />">
                            <div class="product__label">
                                <span>Cupcake</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">German Chocolate</a></h6>
                            <div class="product__item__price">$14.00</div>
                            <div class="cart_add">
                                <a href="#">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Related Products Section End -->
