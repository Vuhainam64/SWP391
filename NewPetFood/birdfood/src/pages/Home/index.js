import { Link } from 'react-router-dom';
import React, { useEffect, useState } from 'react';
import classNames from 'classnames/bind';
import styles from './Home.module.scss';
import images from '~/assets/images';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
    faBath,
    faDrumstickBite,
    faBaseballBall,
    faHeartbeat,
    faEye,
    faCartShopping,
    faHeart,
} from '@fortawesome/free-solid-svg-icons';

const cx = classNames.bind(styles);

function Home() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetch('https://vuhainam64.github.io/SWP391/Rest_API/products.json')
            .then((res) => res.json())
            .then((data) => {
                setProducts(data);
            })
            .catch((error) => console.log(error));
    }, []);
    return (
        <>
            {/* home section starts */}
            <section className={cx('home')} id="home">
                <div className={cx('content')}>
                    <h3>
                        <span>hi</span> welcome to our bird food
                    </h3>
                    <Link to="/" className={cx('btn')}>
                        shop now
                    </Link>
                </div>
                <img src={images.bottomWave} className={cx('wave')} alt="" />
            </section>
            {/* home section ends */}

            {/* about section starts */}
            <section className={cx('about')} id="about">
                <div className={cx('image')}>
                    <img src={images.aboutImage} alt="" />
                </div>
                <div className={cx('content')}>
                    <h3>
                        premium <span>bird food</span> manufacturer
                    </h3>
                    <p>
                        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Voluptatum sint, dolore perspiciatis
                        iure consequuntur eligendi quaerat vitae shaikh anas.
                    </p>
                    <Link to="/" className={cx('btn')}>
                        Read more
                    </Link>
                </div>
            </section>
            {/* about section end */}

            {/* shop section starts */}
            <section className={cx('shop')} id="shop">
                <h1 className={cx('heading')}>
                    best <span>seller</span>
                </h1>
                <div className={cx('box-container')}>
                    {products.map((product) => (
                        <div className={cx('box')} key={product.productId}>
                            <div className={cx('icons')}>
                                <Link to="/d">
                                    <FontAwesomeIcon icon={faCartShopping} />
                                </Link>
                                <Link to="/d">
                                    <FontAwesomeIcon icon={faHeart} />
                                </Link>
                                <Link to="/d">
                                    <FontAwesomeIcon icon={faEye} />
                                </Link>
                            </div>
                            <div className={cx('image')}>
                                <img src={product.imageMain} alt={product.productName} />
                            </div>
                            <div className={cx('content')}>
                                <h3>{product.productName}</h3>
                                <div className={cx('amount')}>
                                    ${product.productPrice.toFixed(2)} - ${(product.productPrice * 2).toFixed(2)}
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            </section>
            {/* shop section end */}

            {/* services section starts */}
            <section className={cx('services')} id="services">
                <h1 className={cx('heading')}>
                    our <span>services</span>
                </h1>

                <div className={cx('box-container')}>
                    <div className={cx('box')}>
                        <FontAwesomeIcon icon={faBath} />
                        <h3>spa & grooming</h3>
                        <Link to="/" className={cx('btn')}>
                            read more
                        </Link>
                    </div>

                    <div className={cx('box')}>
                        <FontAwesomeIcon icon={faDrumstickBite} />
                        <h3>healthy meal</h3>
                        <Link to="/" className={cx('btn')}>
                            read more
                        </Link>
                    </div>

                    <div className={cx('box')}>
                        <FontAwesomeIcon icon={faBaseballBall} />
                        <h3>activity exercise</h3>
                        <Link to="/" className={cx('btn')}>
                            read more
                        </Link>
                    </div>

                    <div className={cx('box')}>
                        <FontAwesomeIcon icon={faHeartbeat} />
                        <h3>health care</h3>
                        <Link to="/" className={cx('btn')}>
                            read more
                        </Link>
                    </div>
                </div>
            </section>
            {/* services section end */}

            {/* contact starts */}
            <section className={cx('contact')} id="contact">
                <div className={cx('image')}>
                    <img src={images.contact} alt="contact" />
                </div>

                <form action="">
                    <h3>contact us</h3>
                    <input type="text" placeholder="your name" className={cx('box')} />
                    <input type="email" placeholder="your email" className={cx('box')} />
                    <input type="number" placeholder="your number" className={cx('box')} />
                    <textarea placeholder="your message" cols="30" rows="10"></textarea>
                    <input type="submit" value="send message" className={cx('btn')} />
                </form>
            </section>
            {/* contact end */}
        </>
    );
}

export default Home;
