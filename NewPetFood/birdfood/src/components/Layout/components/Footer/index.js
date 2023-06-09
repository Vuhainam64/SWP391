import React from 'react';
import classNames from 'classnames/bind';
import styles from './Footer.module.scss';
import images from '~/assets/images';
const cx = classNames.bind(styles);

function Footer() {
    return (
        <section className={cx('footer')}>
            <img src={images.topWave} alt="BirdFood" />
            <div className={cx('credit')}>
                created by <span>SWP391</span> | all rights reserved!
            </div>
        </section>
    );
}

export default Footer;
