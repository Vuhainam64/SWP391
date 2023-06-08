import React from "react";
import birdHealth from "./../../assets/products/bird-health.png"
import birdSpa from "./../../assets/products/bird-spa.png"
import birdFood from "./../../assets/products/healthy-food.png"
import customer from "./../../assets/products/customer.png"
import { Link } from "react-router-dom";
import "./about.css"

export const About = () => {
    
    return (
    <div className="about">
    <h1 className="about-title">ABOUT US</h1>
    <div className="about-description">
    <h3 className="bird-food-store-title">Bird Food Store</h3>
    <h1>Famous Local <span className="bird-food-text">Bird Food</span> Store</h1>
    <div>Lorem ipsum dolor sit amet consectetur adipisicing elit. Non rerum, est optio voluptates quod quo. Earum odit aspernatur, pariatur facilis reprehenderit magni veritatis quibusdam repudiandae ratione quidem modi debitis optio!</div>
    <Link to ="/home"><button className="explore-more-about">Explore more </button></Link>
    </div>

    
        <div className="about-spa">
            <img src={birdSpa}/>
            <div className="about-title-description">
            <h2>Spa & Grooming</h2>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit, a quam atque laudantium repellat, voluptas tenetur necessitatibus perferendis quis asperiores vel at nam officia labore sed doloremque obcaecati laborum possimus.
            </div>
        </div>
        <div className="about-food">
        
            <div className="about-food-description">
            <h2>Healthy Meal</h2>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores, fuga eos? Vel blanditiis minus commodi nulla est. Ad cum neque, ducimus consequuntur fugiat optio recusandae consectetur, deleniti fugit excepturi hic!
            </div>
            <img src={birdFood}/>
        </div>
        <div className="about-health">
            <img src={birdHealth}/>
            <div className="about-health-description">
            <h2>Health Care</h2>
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Suscipit animi, numquam corporis quia laboriosam obcaecati harum, voluptas praesentium consequuntur totam libero unde iure quod consequatur doloribus corrupti voluptatibus similique deleniti?\
            </div>
        </div>
        <div className="review-about">
         <h2 className="customer-title">What Customers Say</h2>
         <div className="review-info">
         <div className="review-comment-about">
         <h2 className="review-comment-main-about">Amazing Products</h2>
         Lorem ipsum dolor sit amet consectetur adipisicing elit. Sequi libero, corrupti possimus maxime dolorum velit tempora odit cum perferendis tempore quaerat? Optio corrupti a repellat molestias mollitia placeat libero magnam.
         <div className="review-author-about">Author</div>
         </div>
         <img src={customer}/>
         </div>
        </div>
    </div>
    );
};