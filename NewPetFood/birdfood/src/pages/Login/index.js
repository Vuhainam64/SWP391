import React, { useState } from 'react';
import classNames from 'classnames/bind';
import request from '~/utils/request';
import images from '~/assets/images';

import styles from './Login.module.scss';
const cx = classNames.bind(styles);

function Login({ onAuthSuccess }) {
    const [isLoginVisible, setLoginVisible] = useState(true);
    const [loginForm, setLoginForm] = useState({ email: '', accountPassword: '' });
    const [signupForm, setSignupForm] = useState({
        userName: '',
        accountaccountPassword: '',
        email: '',
        accountRole: '',
        userId: '',
    });

    const showLoginForm = () => {
        setLoginVisible(true);
    };

    const showSignUpForm = () => {
        setLoginVisible(false);
    };

    const handleLoginFormChange = (e) => {
        const { name, value } = e.target;
        setLoginForm((prevForm) => ({ ...prevForm, [name]: value }));
    };

    const handleSignupFormChange = (e) => {
        const { name, value } = e.target;
        setSignupForm((prevForm) => ({ ...prevForm, [name]: value }));
    };
    const handleLoginFormSubmit = (e) => {
        e.preventDefault();

        // Perform login API call using loginForm data
        request
            .post('/account', loginForm)
            .then((response) => {
                // Handle successful login
                console.log('Login successful');

                // Save a cookie to indicate that the user is logged in
                document.cookie = 'isLoggedIn=true; path=/'; // Set the cookie with a name "isLoggedIn" and value "true"

                onAuthSuccess(true); // Call the onAuthSuccess function with the value 'true'
            })
            .catch((error) => {
                // Handle login error
                console.error('Login failed', error);
            });

        // Reset login form
        setLoginForm({ email: '', accountPassword: '' });
    };

    const handleSignupFormSubmit = (e) => {
        e.preventDefault();

        // Convert signupForm data to an object
        const signupData = {
            userName: signupForm.userName,
            accountPassword: signupForm.accountPassword,
            email: signupForm.email,
            confirmaccountPassword: signupForm.confirmaccountPassword,
            accountRole: 'user',
            userId: 1,
        };

        // Perform signup API call using signupData
        request
            .post('account', signupData)
            .then((response) => {
                // Handle successful signup
                // Optionally, you can redirect the user to a success page or perform other actions
                console.log('Account created successfully');
                onAuthSuccess(true); // Call the onAuthSuccess function with the value 'true'
            })
            .catch((error) => {
                // Handle signup error
                // Optionally, you can display an error message to the user
                console.error('Error creating account:', error);
            });

        // Reset signup form
        setSignupForm({ userName: '', email: '', accountPassword: '', confirmaccountPassword: '' });
    };

    const sectionStyle = {
        backgroundImage: `url('${images.Login}')`,
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover',
        height: 'auto',
    };

    return (
        <section className={cx('section')} style={sectionStyle}>
            <div className={cx('container', 'd-flex', 'justify-content-center', 'align-items-center', 'vh-100')}>
                <div className={cx('row')}>
                    <div className={cx('col')}></div>
                    <div className={cx('col', 'cen')}>
                        <div className={cx('form')}>
                            <div className={cx('btn')}>
                                <button className={cx('loginBtn', { active: isLoginVisible })} onClick={showLoginForm}>
                                    LOG IN
                                </button>
                                <button
                                    className={cx('signUpBtn', { active: !isLoginVisible })}
                                    onClick={showSignUpForm}
                                >
                                    SIGN UP
                                </button>
                            </div>
                            <form
                                className={cx('signUp')}
                                style={{ display: isLoginVisible ? 'none' : 'block' }}
                                onSubmit={handleSignupFormSubmit}
                            >
                                <div className={cx('formGroup')}>
                                    <input
                                        type="text"
                                        id="userName"
                                        placeholder="User Name"
                                        autoComplete="off"
                                        name="userName"
                                        value={signupForm.userName}
                                        onChange={handleSignupFormChange}
                                    />
                                </div>
                                <div className={cx('formGroup')}>
                                    <input
                                        type="email"
                                        placeholder="Email ID"
                                        name="email"
                                        required
                                        autoComplete="off"
                                        value={signupForm.email}
                                        onChange={handleSignupFormChange}
                                    />
                                </div>
                                <div className={cx('formGroup')}>
                                    <input
                                        type="password"
                                        id="accountaccountPassword"
                                        placeholder="accountPassword"
                                        required
                                        autoComplete="off"
                                        name="accountPassword"
                                        value={signupForm.accountPassword}
                                        onChange={handleSignupFormChange}
                                    />
                                </div>
                                <div className={cx('formGroup')}>
                                    <input
                                        type="password"
                                        id="confirmaccountPassword"
                                        placeholder="Confirm accountPassword"
                                        required
                                        autoComplete="off"
                                        name="confirmaccountPassword"
                                    />
                                </div>
                                <div className={cx('checkBox')}>
                                    <input type="checkbox" name="checkbox" id="checkbox" />
                                    <span className={cx('text')}>I agree with terms & conditions</span>
                                </div>
                                <div className={cx('formGroup')}>
                                    <button type="submit" name="op" value="signup" className={cx('btn2')}>
                                        REGISTER
                                    </button>
                                </div>
                            </form>

                            <form
                                className={cx('login')}
                                style={{ display: isLoginVisible ? 'block' : 'none' }}
                                onSubmit={handleLoginFormSubmit}
                            >
                                <div className={cx('formGroup')}>
                                    <input
                                        type="email"
                                        placeholder="Email"
                                        name="email"
                                        required
                                        autoComplete="off"
                                        className={cx('form-control')}
                                        value={loginForm.email}
                                        onChange={handleLoginFormChange}
                                    />
                                </div>
                                <div className={cx('formGroup')}>
                                    <input
                                        type="password"
                                        name="accountPassword"
                                        id="accountPassword"
                                        placeholder="accountPassword"
                                        required
                                        autoComplete="off"
                                        className={cx('form-control')}
                                        value={loginForm.accountPassword}
                                        onChange={handleLoginFormChange}
                                    />
                                </div>
                                <i className={cx('text')} style={{ color: 'red' }}>
                                    {/* {message} */}
                                </i>
                                <div className={cx('checkBox')}>
                                    <input type="checkbox" name="checkbox" id="checkbox" />
                                    <span className={cx('text')}>Keep me signed in on this device</span>
                                </div>
                                <div className={cx('formGroup')}>
                                    <button type="submit" name="op" value="login" className={cx('btn2')}>
                                        LOGIN
                                    </button>
                                    <button type="submit" name="op" value="cancel" className={cx('btn2')}>
                                        CANCEL
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
}

export default Login;
