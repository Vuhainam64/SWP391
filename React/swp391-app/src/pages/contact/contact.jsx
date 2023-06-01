import React from "react";
import "./contact.css"
export const Contact = () => {
    return (
        <div className="contact">
        <h1 className="title-contact">Contact</h1>
        <div className="form-contact">
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
        
        
    );
};