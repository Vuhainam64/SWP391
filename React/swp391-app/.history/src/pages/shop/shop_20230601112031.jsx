import React from "react";
import { PRODUCTS } from "../../products";
import { Product } from "./product";
import "./shop.css";

export const Shop = () => {
    return (
        <div className = "shop">
            <div className = "shopTitle">
                <h3>Store</h3>
            </div>
            <div className="form">
            <form>
  <input class="chosen-value" type="text" value="" placeholder="Type to filter"></input>
  <ul class="value-list">
    <li>Alabama</li>
    <li>Alaska</li>
    <li>Arizona</li>
    <li>Arkansas</li>
    <li>California</li>
    <li>Colorado</li>
    <li>Connecticut</li>
    <li>Delaware</li>
    <li>Florida</li>
    <li>Georgia</li>
    <li>Hawaii</li>
    <li>Idaho</li>
    <li>Illinois</li>
    <li>Indiana</li>
    <li>Iowa</li>
    <li>Kansas</li>
    <li>Kentucky</li>
    <li>Louisiana</li>
    <li>Maine</li>
    <li>Maryland</li>
    <li>Massachusetts</li>
    <li>Michigan</li>
    <li>Minnesota</li>
    <li>Mississippi</li>
    <li>Missouri</li>
    
  </ul>
</form>
            </div>
            <div className = "products">
                {PRODUCTS.map((product) => (
                    <Product data = {product} />
                ))}
            </div>
        </div>
    );
};


