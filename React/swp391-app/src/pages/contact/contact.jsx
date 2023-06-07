import React from "react";
import "./contact.css"
export const Contact = () => {
    return (
        <div className="contact">
        <h1 className="title-contact">Contact</h1>
        <div className="contact-main">
        <div className="talk-to-us">
            <div className="chat">
                <h3>Chat to us</h3>
                <div>Our team is ready to answer </div>
                <div className="contact-mail">@gmail.com</div>
            </div>
            <div className="visit">
                <h3>Visit us</h3>
                <div>Come say hello at our store</div>
                <div className="contact-place">At street</div>
            </div>
            <div className="call">
                <h3>Call us</h3>
                <div>Give us a call from Mon - Fri</div>
                <div className="contact-phone">0912345678</div>
            </div>
        </div>
        <div className="form-contact">
        <h1>Contact us if there is a problem or if you have something in mind</h1>
        <form>
            <label>Name: </label>
            <input className="name-contact" type="text" id="name" required />

            <label>Email: </label>
            <input className="email-contact" type="email" id="email" required />

            <label>Message: </label>
            <input className="message-contact" type="message" id="message" required />

            <input type="submit" value="Submit"/>
        </form>
        </div>
        </div>
        </div>
        
        
    );
};