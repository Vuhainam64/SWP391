import { useState, useEffect } from 'react';
import { useCookies } from 'react-cookie';
import { Link } from 'react-router-dom';
import classNames from 'classnames/bind';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCircleQuestion, faEarthAsia, faGear, faKeyboard, faSignOut } from '@fortawesome/free-solid-svg-icons';
import 'tippy.js/dist/tippy.css';

import styles from './AdminHeader.module.scss';
import images from '~/assets/images';
import Menu from '~/components/Popper/Menu';
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

function AdminHeader() {
    const [cookies, removeCookie] = useCookies(['isLoggedIn']);
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

    const handleLogout = () => {
        console.log('Logout clicked');
        removeCookie('isLoggedIn', { path: '/' });
        setCurrentUser(false);
    };

    const userMenu = [
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
            onClick: handleLogout,
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
                    <Link to="/admin/products" className="nav-link">
                        Products
                    </Link>
                    <Link to="/admin/accounts" className="nav-link">
                        Accounts
                    </Link>
                    <Link to="/admin/coupons" className="nav-link">
                        Coupons
                    </Link>
                    <Link to="/admin/orders" className="nav-link">
                        Orders
                    </Link>
                </nav>

                <div className={cx('actions')}>
                    <Menu items={userMenu} onChange={handleMenuChange}>
                        <Image
                            className={cx('user-avatar')}
                            src="https://files.fullstack.edu.vn/f8-prod/public-images/6486634cba202.png"
                            alt="Nguyen Van A"
                        />
                    </Menu>
                </div>
            </div>
        </header>
    );
}

export default AdminHeader;
