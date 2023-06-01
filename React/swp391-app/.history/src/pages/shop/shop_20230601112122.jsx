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


