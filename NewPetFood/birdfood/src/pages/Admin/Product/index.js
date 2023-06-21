import React, { useEffect, useState } from 'react';
import request from '~/utils/request';
import styles from './Product.module.scss';
import classNames from 'classnames/bind';
const cx = classNames.bind(styles);

function Product() {
    const [products, setProducts] = useState([]);
    const [categories, setCategories] = useState([]);
    const [searchCategory, setSearchCategory] = useState('');
    const [searchKeyword, setSearchKeyword] = useState('');
    const [sortByPrice, setSortByPrice] = useState(false);
    const [sortAscending, setSortAscending] = useState(true);

    useEffect(() => {
        fetchProducts();
        fetchCategories();
    }, []);

    const fetchProducts = async () => {
        try {
            const response = await request.get('product');
            setProducts(response.data);
        } catch (error) {
            console.error('Error fetching products:', error);
        }
    };

    const fetchCategories = async () => {
        try {
            const response = await request.get('product/category');
            setCategories(response.data);
        } catch (error) {
            console.error('Error fetching categories:', error);
        }
    };

    const handleSearch = async () => {
        try {
            const response = await request.get('product/search', {
                params: {
                    category: searchCategory,
                    keyword: searchKeyword,
                    sort_by_price: sortByPrice,
                    ascending: sortAscending,
                },
            });
            setProducts(response.data);
        } catch (error) {
            console.error('Error searching products:', error);
        }
    };

    const handleEdit = async (productId) => {
        // Implement edit logic here
        // Perform necessary API requests to update the product
    };

    const handleDelete = async (productId) => {
        // Implement delete logic here
        // Perform necessary API requests to remove the product
    };

    return (
        <div className={cx('product-container')}>
            <h2>Product page</h2>
            <div>
                <label>Category:</label>
                <select value={searchCategory} onChange={(e) => setSearchCategory(e.target.value)}>
                    <option value="">All</option>
                    {categories.map((category) => (
                        <option key={category} value={category}>
                            {category}
                        </option>
                    ))}
                </select>
            </div>
            <div>
                <label>Keyword:</label>
                <input type="text" value={searchKeyword} onChange={(e) => setSearchKeyword(e.target.value)} />
            </div>
            <div>
                <label>Sort by price:</label>
                <input type="checkbox" checked={sortByPrice} onChange={(e) => setSortByPrice(e.target.checked)} />
            </div>
            <div>
                <label>Sort ascending:</label>
                <input type="checkbox" checked={sortAscending} onChange={(e) => setSortAscending(e.target.checked)} />
            </div>
            <button onClick={handleSearch}>Search</button>
            <table className={cx('product-table')}>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {products.map((product) => (
                        <tr key={product.productId}>
                            <td>{product.productId}</td>
                            <td>{product.productName}</td>
                            <td>{product.category}</td>
                            <td>{product.productPrice}</td>
                            <td>
                                <button onClick={() => handleEdit(product.productId)}>Edit</button>
                                <button onClick={() => handleDelete(product.productId)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Product;
