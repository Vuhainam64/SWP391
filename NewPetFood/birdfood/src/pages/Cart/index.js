import React from 'react';

function Cart({ cartItems }) {
    return (
        <div>
            <h2>Cart</h2>
            {cartItems.map((item) => (
                <div key={item.productId}>
                    <h3>{item.productName}</h3>
                    <p>Price: ${item.productPrice.toFixed(2)}</p>
                </div>
            ))}
        </div>
    );
}

export default Cart;
