import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import classNames from 'classnames/bind';
import request from '~/utils/request';

import styles from './Detail.module.scss';

const cx = classNames.bind(styles);

function Detail() {
    const location = useLocation();
    const params = new URLSearchParams(location.search);
    const productId = params.get('product');
    const [detail, setDetail] = useState({});
    const [selectedImage, setSelectedImage] = useState('');

    useEffect(() => {
        if (productId) {
            request
                .get(`product/${productId}`)
                .then((res) => {
                    setDetail(res.data);
                    setSelectedImage(res.data.imageMain);
                })
                .catch((error) => console.log(error));
        }
    }, [productId]);

    const handleImageClick = (image) => {
        setSelectedImage(image);
    };

    const thumbnailImages = [
        {
            image: detail.imageSub1,
            alt: 'Sub1-Preview',
        },
        {
            image: detail.imageSub2,
            alt: 'Sub2-Preview',
        },
        {
            image: detail.imageSub3,
            alt: 'Sub3-Preview',
        },
        {
            image: detail.imageSub4,
            alt: 'Sub4-Preview',
        },
    ];

    return (
        <div className={cx('productDetail')}>
            <div className={cx('leftSection')}>
                <img className={cx('imagePreview')} src={selectedImage} alt={detail.imageMain} />
            </div>
            <div className={cx('rightSection')}>
                <h1 className={cx('name')}>{detail.productName}</h1>
                <h3 className={cx('brand')}>{detail.brand}</h3>
                <h3>
                    Price: Rs <span className={cx('price')}>{detail.productPrice}</span>
                </h3>
                <h3>Description</h3>
                <p className={cx('description')}>{detail.productDescription}</p>
                <h3>Product Preview</h3>
                <div className={cx('thumbnail')}>
                    <img
                        className={cx('thumbnailImage', { selected: selectedImage === detail.imageMain })}
                        src={detail.imageMain}
                        alt="Main-Preview"
                        onClick={() => handleImageClick(detail.imageMain)}
                    />
                    {thumbnailImages.map(
                        (thumbnail, index) =>
                            thumbnail.image && (
                                <img
                                    key={index}
                                    className={cx('thumbnailImage', { selected: selectedImage === thumbnail.image })}
                                    src={thumbnail.image}
                                    alt={thumbnail.alt}
                                    onClick={() => handleImageClick(thumbnail.image)}
                                />
                            ),
                    )}
                </div>
                <button className={cx('addButton')}>Add to Cart</button>
            </div>
        </div>
    );
}

export default Detail;
