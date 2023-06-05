import React from "react";
import birdHealth from "./../../assets/products/bird-health.png"
import birdSpa from "./../../assets/products/bird-spa.png"
import birdFood from "./../../assets/products/healthy-food.png"
import "./about.css"

export const About = () => {
    
    return (
    <div className="about">
    <h1 className="about-title">ABOUT US</h1>
    <div className="about-description">
    <h3>Bird Food Store</h3>
    <h1>Famous Local Bird Food Store</h1>
    <div>Lorem ipsum dolor sit amet consectetur adipisicing elit. Non rerum, est optio voluptates quod quo. Earum odit aspernatur, pariatur facilis reprehenderit magni veritatis quibusdam repudiandae ratione quidem modi debitis optio!</div>
    <button className="explore-more-about">Explore more </button>
    </div>

    
        <div className="about-spa">
            <img src={birdSpa}/>
            <div className="about-title-description">
            <h2>Lorem Ipsum</h2>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit, a quam atque laudantium repellat, voluptas tenetur necessitatibus perferendis quis asperiores vel at nam officia labore sed doloremque obcaecati laborum possimus.
            </div>
        </div>
        <div className="about-food">
        
            <div className="about-food-description">
            <h2>Lorem Ipsum</h2>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores, fuga eos? Vel blanditiis minus commodi nulla est. Ad cum neque, ducimus consequuntur fugiat optio recusandae consectetur, deleniti fugit excepturi hic!
            </div>
            <img src={birdFood}/>
        </div>
        <div className="about-health">
            <img src={birdHealth}/>
            <div className="about-health-description">
            <h2>Lorem Ipsum</h2>
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Suscipit animi, numquam corporis quia laboriosam obcaecati harum, voluptas praesentium consequuntur totam libero unde iure quod consequatur doloribus corrupti voluptatibus similique deleniti?\
            </div>
        </div>
    </div>
    );
};