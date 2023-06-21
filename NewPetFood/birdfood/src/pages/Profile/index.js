import React, { useState, useEffect } from 'react';
import request from '~/utils/request';

function Profile() {
    const [accounts, setAccounts] = useState([]);

    useEffect(() => {
        fetchAccounts();
    }, []);

    const fetchAccounts = async () => {
        try {
            const response = await request.get('account');
            if (response.status === 200) {
                setAccounts(response.data);
            }
        } catch (error) {
            console.error('Error fetching accounts:', error);
        }
    };

    return (
        <div>
            <h2>Account Information</h2>
            {accounts.map((account) => (
                <div key={account.accountId}>
                    <h3>Account ID: {account.accountId}</h3>
                    <p>Username: {account.userName}</p>
                    <p>Email: {account.email}</p>
                    {/* Display other account information as needed */}
                </div>
            ))}
        </div>
    );
}

export default Profile;
