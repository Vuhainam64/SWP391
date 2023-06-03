import React from "react";
import { PRODUCTS } from "../../products";
import { Product } from "./product";
import "./shop.css";
import ReactPaginate from "react-paginate";

export const Shop = () => {
  return (
    <div className="shop">
      <div className="shopTitle">
        <h3>Store</h3>
      </div>
    <div className="sort">
      <div className="form-shop">
        <div class="form-shop-select">
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
      <div className="sort-shop">
      <label>
            <select>
              <option selected> Default Sorting </option>
              <option>A To Z</option>
              <option>1 - 8</option>
              <option>Price</option>
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
