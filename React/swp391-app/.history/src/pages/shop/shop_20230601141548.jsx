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
      
      <div>
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
        </div>
        <div className="search-bar">
          <input type="text" placeholder="Search.." />
        </div>
        <div className="icon-search">
          <button>Search</button>
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
