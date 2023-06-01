import React from "react";
import "./home.css";
import { PRODUCTS } from "../../products";
import { Product } from "./home-product";
import birdImage from "./../../assets/products/bird-home.jpg";
import contactImage from "./../../assets/products/contact_img.png" ;
import { Bathtub, Egg, SoccerBall, Heart } from "phosphor-react";
export const Home = () => {
    return(
        <div className="home">
        <div className="welcome">
            <h1><span className="hi-text">Hi</span> Welcome To Our Bird Food Store</h1>
            <button className="shop-now-btn">Shop Now</button>
            <img src={birdImage} alt=""/>
        </div>  
        <div className=" best-seller">
            <h1 className="best-seller-title">Best <span className="seller">Seller</span></h1>
            <div className="products">
            {PRODUCTS.slice(0, 4).map((product) => (
            <Product data={product} key={product.id} className="product-item" />
            ))}
        </div>
        </div>
        <div className="our-services">
        <h1 class="our-services-title"> Our <span className="services">services</span> </h1>

    <div class="box-container">

    <div class="box">
        <Bathtub className="services-icon" size={32} />
        <h3>Spa & Grooming</h3>
        <a href="#" class="read-more-btn">Read More</a>
    </div>

    <div class="box">
        <Egg className="services-icon" size={32} />
        <h3>Healthy Meal</h3>
        <a href="#" class="read-more-btn">Read More</a>
    </div>

    <div class="box">
    <SoccerBall className="services-icon" size={32} />
        <i class="fas fa-baseball-ball"></i>
        <h3>Activity Exercise</h3>
        <a href="#" class="read-more-btn">Read More</a>
    </div>

    <div class="box">
    <Heart className="services-icon" size={32} />
        <h3>Health Care</h3>
        <a href="#" class="read-more-btn">Read More</a>
    </div>

</div>
        </div>
        <div className="contact-us">
                
                <div className="home-contact">
                <div className="home-contact-image">
                <img src={contactImage}/>
                </div>
                <div className="home-contact-form">
                <form>
                    <h2 className="contact-us-title">Contact Us</h2>
                    <input className="name-home" type="text" id="name" placeholder="Your Name" required />
                    <input className="email-home" type="email" id="email" placeholder="Your Email" required />              
                    <input className="number-home" type="tel" id="number" placeholder="Your Number" required />     
                    <input className="message-home" type="message" id="message" placeholder="Your Message" required />

                    <input  type="submit" value="Send Message"/>
                </form>
                </div>
                </div>
        </div>
       
        <footer className="home-footer">
        Created By SWP391 | All Rights Reserved!
        </footer>
       
        </div>
    );
};