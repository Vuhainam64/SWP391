import React from "react";
import { Link } from "react-router-dom";
import { ShoppingCart, Bird, User } from "phosphor-react";
import "./navbar.css";

export const Navbar = () => {
  return (
    <div className="navbar">
      <div className="links">
        <div className="icon">
          <Link to="/home">
            <Bird size={40} />
          </Link>
        </div>
        <div className="middle">
          <Link to="/home"> Home </Link>
          <Link to="/about">About</Link>
          <Link to="/shop">Shop</Link>
          <Link to="/contact"> Contact</Link>
        </div>
        <div className="end">
          <Link to="/cart">
            <ShoppingCart size={40} />
          </Link>
            <Link to="/register"> 
                <User size={40}/>
            </Link>
        </div>
      </div>
    </div>
  );
};
