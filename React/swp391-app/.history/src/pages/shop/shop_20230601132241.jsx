import React from "react";
import { PRODUCTS } from "../../products";
import { Product } from "./product";
import { MagnifyingGlass } from "phosphor-react";
import "./shop.css";

export const Shop = () => {
  return (
    <div className="shop">
      <div className="shopTitle">
        <h3>Store</h3>
      </div>

      <div class="form-shop">
        <label>
          <select>
            <option selected> None </option>
            <option>Seed</option>
            <option>Suet</option>
            <option>Nectar</option>
            <option>Fruit</option>
            <option>Insect</option>
          </select>
        </label>
        <input className="seach-bar" type="text" placeholder="Search.."/>
        <div className="icon-search">
            <MagnifyingGlass size={32} />
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