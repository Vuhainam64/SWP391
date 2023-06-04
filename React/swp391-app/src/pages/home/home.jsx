import React from "react";
import "./home.css";
import { PRODUCTS } from "../../products";
import { Product } from "./home-product";
import birdImage from "./../../assets/products/bird-home.jpg";
import contactImage from "./../../assets/products/contact_img.png" ;
import aboutUs from "./../../assets/products/about_img.png"
import { Bathtub, Egg, SoccerBall, Heart } from "phosphor-react";
import { Link } from "react-router-dom";
export const Home = () => {
    return(
        
        <div className="home">
        <div className="welcome">
            <img src={birdImage} alt=""/>
            <h1><span className="hi-text">Hi</span> Welcome To Our Bird Food Store</h1>
            <Link to="/"><button className="shop-now-btn">Shop Now</button></Link>
        </div>  
        <div className="about-us">
            <div className="about-us-image">
            <img src={aboutUs}></img>
            </div>
            <div className="about-us-info">
            <div className="about-us-title"><h1>Premium <span className="bird-food-text">Bird Food</span> Manufacturer </h1></div>
            <div className="about-us-description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Est earum modi libero beatae aliquam cum, nihil itaque pariatur quae a, expedita amet. Aperiam perspiciatis numquam aut voluptatem. Sit, ea quaerat.</div>
            <Link to ="/about"><button className="read-more-btn-about">Read more</button></Link>
            </div>
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