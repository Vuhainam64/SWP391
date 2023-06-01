import React from "react";
import { PRODUCTS } from "../../products";
import { Product } from "./product";
import "./shop.css";

export const Shop = () => {
  return (
    <div className="shop">
      <div className="shopTitle">
        <h3>Store</h3>
      </div>

      <div class="form">
        <label>
          <select>
            <option selected> None </option>
            <option>Seed</option>
            <option>Suet</option>
            <option>Nectar</option>
            <option>Fruit</option>
            <option>Insect</option>
            <option>Last long option</option>
          </select>
        </label>
      </div>

      <div className="products">
        {PRODUCTS.map((product) => (
          <Product data={product} />
        ))}
      </div>
    </div>
  );
};
