import { Link } from 'react-router-dom';
import React, { useEffect, useState } from 'react';
import classNames from 'classnames/bind';
import request from '~/utils/request';
import Cart from '../Cart';

import styles from './Shop.module.scss';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEye, faCartShopping, faHeart } from '@fortawesome/free-solid-svg-icons';

const cx = classNames.bind(styles);

function Shop() {
    const [products, setProducts] = useState([]);
    const [categories, setCategories] = useState([]);
    const [selectedCategory, setSelectedCategory] = useState('');
    const [searchTerm, setSearchTerm] = useState('');
    const [sortBy, setSortBy] = useState('');
    const [currentPage, setCurrentPage] = useState(1);
    const productsPerPage = 8;
    const [cartItems, setCartItems] = useState([]);

    useEffect(() => {
        request
            .get('product')
            .then((res) => {
                setProducts(res.data);
            })
            .catch((error) => console.log(error));

        request
            .get('product/category')
            .then((res) => {
                setCategories(res.data);
            })
            .catch((error) => console.log(error));
    }, []);

    // Cart
    const addToCart = (product) => {
        setCartItems([...cartItems, product]);
    };

    // Handle category change
    const handleCategoryChange = (event) => {
        setSelectedCategory(event.target.value);
    };

    // Handle search term change
    const handleSearchTermChange = (event) => {
        setSearchTerm(event.target.value);
    };

    // Handle sort by change
    const handleSortByChange = (event) => {
        setSortBy(event.target.value);
    };

    // Filter and sort products based on category, search term, and sort by option
    const filteredAndSortedProducts = products
        .filter((product) => {
            const matchesCategory = selectedCategory === '' || product.category === selectedCategory;
            const matchesSearchTerm = product.productName.toLowerCase().includes(searchTerm.toLowerCase());
            return matchesCategory && matchesSearchTerm;
        })
        .sort((a, b) => {
            if (sortBy === 'price-low-high') {
                return a.productPrice - b.productPrice;
            } else if (sortBy === 'price-high-low') {
                return b.productPrice - a.productPrice;
            } else if (sortBy === 'name-az') {
                return a.productName.localeCompare(b.productName);
            } else if (sortBy === 'name-za') {
                return b.productName.localeCompare(a.productName);
            } else {
                return 0;
            }
        });

    const totalPages = Math.ceil(filteredAndSortedProducts.length / productsPerPage);

    const indexOfLastProduct = currentPage * productsPerPage;
    const indexOfFirstProduct = indexOfLastProduct - productsPerPage;
    const currentProducts = filteredAndSortedProducts.slice(indexOfFirstProduct, indexOfLastProduct);

    const goToPreviousPage = () => {
        setCurrentPage(currentPage - 1);
    };

    const goToNextPage = () => {
        setCurrentPage(currentPage + 1);
    };

    return (
        <>
            <section className={cx('shop')} id="shop">
                <h1 className={cx('heading')}>
                    <span>Shop</span>
                </h1>
                <div className={cx('search-bar')}>
                    <select value={selectedCategory} onChange={handleCategoryChange}>
                        <option value="">All Categories</option>
                        {categories.map((category) => (
                            <option key={category} value={category}>
                                {category}
                            </option>
                        ))}
                    </select>
                    <input
                        type="text"
                        placeholder="Search products"
                        value={searchTerm}
                        onChange={handleSearchTermChange}
                    />
                    <select value={sortBy} onChange={handleSortByChange}>
                        <option value="">Sort By</option>
                        <option value="price-low-high">Price (Low to High)</option>
                        <option value="price-high-low">Price (High to Low)</option>
                        <option value="name-az">Name (A-Z)</option>
                        <option value="name-za">Name (Z-A)</option>
                    </select>
                </div>
                <div className={cx('box-container')}>
                    {currentProducts.map((product) => (
                        <div className={cx('box')} key={product.productId}>
                            <div className={cx('icons')}>
                                <Link to="#" onClick={() => addToCart(product)}>
                                    <FontAwesomeIcon icon={faCartShopping} />
                                </Link>

                                <Link to="/d">
                                    <FontAwesomeIcon icon={faHeart} />
                                </Link>
                                <Link to={`/product/${product.productId}`}>
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
                <div className={cx('pagination')}>
                    <button onClick={goToPreviousPage} disabled={currentPage === 1}>
                        Previous
                    </button>
                    <span>{currentPage}</span>
                    <button onClick={goToNextPage} disabled={currentPage === totalPages}>
                        Next
                    </button>
                </div>
            </section>
            <Cart cartItems={cartItems} />
        </>
    );
}

export default Shop;
