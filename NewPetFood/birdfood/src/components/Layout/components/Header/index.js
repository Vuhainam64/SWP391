import { useState, useEffect } from 'react';
import { useCookies } from 'react-cookie';
import { Link } from 'react-router-dom';
import classNames from 'classnames/bind';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
    faCircleQuestion,
    faEarthAsia,
    faEllipsisVertical,
    faGear,
    faKeyboard,
    faSignOut,
    faUser,
} from '@fortawesome/free-solid-svg-icons';
import Tippy from '@tippyjs/react';
import 'tippy.js/dist/tippy.css';

import Button from '~/components/Button';
import styles from './Header.module.scss';
import images from '~/assets/images';
import Menu from '~/components/Popper/Menu';
import { CartIcon } from '~/components/Icons';
import Image from '~/components/Image';

const cx = classNames.bind(styles);

const MENU_ITEMS = [
    {
        icon: <FontAwesomeIcon icon={faEarthAsia} />,
        title: 'English',
        children: {
            title: 'Language',
            data: [
                {
                    type: 'language',
                    code: 'en',
                    title: 'English',
                },
                {
                    type: 'language',
                    code: 'vi',
                    title: 'Tiếng Việt',
                },
            ],
        },
    },
    {
        icon: <FontAwesomeIcon icon={faCircleQuestion} />,
        title: 'Feedback and help',
        to: '/feedback',
    },
    {
        icon: <FontAwesomeIcon icon={faKeyboard} />,
        title: 'Keyboard shortcuts',
    },
];

function Header() {
    const [cookies] = useCookies(['isLoggedIn']);
    const [currentUser, setCurrentUser] = useState(false);

    useEffect(() => {
        // Check if the user cookie exists and set currentUser accordingly
        setCurrentUser(cookies.isLoggedIn === 'true');
    }, [cookies]);

    // Handle logic
    const handleMenuChange = (menuItem) => {
        switch (menuItem.type) {
            case 'language':
                // Handle change language
                break;
            default:
        }
    };

    const userMenu = [
        {
            icon: <FontAwesomeIcon icon={faUser} />,
            title: 'View profile',
            to: '/profile',
        },
        {
            icon: <FontAwesomeIcon icon={faGear} />,
            title: 'Settings',
            to: '/settings',
        },
        ...MENU_ITEMS,
        {
            icon: <FontAwesomeIcon icon={faSignOut} />,
            title: 'Log out',
            to: '/logout',
            separate: true,
        },
    ];

    return (
        <header className={cx('wrapper')}>
            <div className={cx('inner')}>
                <Link to="/" className={cx('logo')}>
                    <img src={images.logo} alt="BirdFood" />
                    <h2> Bird Food</h2>
                </Link>

                <nav className={cx('navbar')}>
                    <Link to="/" className="nav-link">
                        Home
                    </Link>
                    <Link to="/about" className="nav-link">
                        About
                    </Link>
                    <Link to="/shop" className="nav-link">
                        Shop
                    </Link>
                    <Link to="/contact" className="nav-link">
                        Contact
                    </Link>
                </nav>

                <div className={cx('actions')}>
                    {currentUser ? (
                        <>
                            <Tippy delay={[0, 50]} content="Cart" placement="bottom">
                                <Link to="/cart">
                                    <button className={cx('action-btn')}>
                                        <CartIcon />
                                        <span className={cx('badge')}>12</span>
                                    </button>
                                </Link>
                            </Tippy>
                            <Menu items={userMenu} onChange={handleMenuChange}>
                                <Image
                                    className={cx('user-avatar')}
                                    src="https://files.fullstack.edu.vn/f8-prod/public-images/6486634cba202.png"
                                    alt="Nguyen Van A"
                                />
                            </Menu>
                        </>
                    ) : (
                        <>
                            <Tippy delay={[0, 50]} content="Cart" placement="bottom">
                                <button className={cx('action-btn')}>
                                    <CartIcon />
                                    <span className={cx('badge')}>12</span>
                                </button>
                            </Tippy>
                            <Link to="/login" className="nav-link">
                                <Button primary>Log in</Button>
                            </Link>
                            <Menu items={MENU_ITEMS} onChange={handleMenuChange}>
                                <button className={cx('more-btn')}>
                                    <FontAwesomeIcon icon={faEllipsisVertical} />
                                </button>
                            </Menu>
                        </>
                    )}
                </div>
            </div>
        </header>
    );
}

export default Header;
