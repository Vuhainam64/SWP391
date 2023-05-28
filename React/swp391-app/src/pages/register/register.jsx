import React from "react";
import "./register.css";

export const Register = () => {
  return (
    <div className="container">
    <input type="checkbox" id="check"></input>
    <div className="login form">
      <header>LOGIN</header>
      <form action="#">
        <input type="text" placeholder="Enter your email"></input>
        <input type="password" placeholder="Enter your password"></input>
        <a href="#">Forgot password?</a>
        <input type="button" className="button" value="Login"></input>
      </form>
      <div className="signup">
        <span className="signup">Don't have an account?
         <label for="check">Signup</label>
        </span>
      </div>
    </div>
    <div className="registration form">
      <header>SIGNUP</header>
      <form action="#">
        <input type="text" placeholder="Enter your email"></input>
        <input type="password" placeholder="Create a password"></input>
        <input type="password" placeholder="Confirm your password"></input>
        <input type="button" className="button" value="Signup"></input>
      </form>
      <div className="signup">
        <span className="signup">Already have an account?
         <label for="check">Login</label>
        </span>
      </div>
    </div>
  </div>
  );
};
