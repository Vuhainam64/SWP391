import React from 'react';
import { PRODUCTS } from '../../products';
import { ShopContext } from "../../context/shop-context";

export const ProductDetail = (props) => {
    const productId = props.match.params.id;
    const product = PRODUCTS.find((p) => p.id === productId);

    return (
        <div className="product-detail">
            <img src={product.productImage} alt={product.productName} />
            <div className="description">
                <h2>{product.productName}</h2>
                <p>${product.price}</p>
                <button>Add to Cart</button>
            </div>
        </div>
    );
};