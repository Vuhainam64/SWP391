import React from "react";
import { PRODUCTS } from "../../products";
import { Product } from "./product";
import "./shop.css";

export const Shop = () => {
  return (
    <div className="shop">
      <div className="shopTitle">
        <h3>Store</h3>
        <div class="form">
        <label>
          <select>
            <option selected> Select Box </option>
            <option>Option 1</option>
            <option>Option 2</option>
            <option>Last long option</option>
          </select>
        </label>
      </div>
      </div>

      

      <div className="products">
        {PRODUCTS.map((product) => (
          <Product data={product} />
        ))}
      </div>
    </div>
  );
};
