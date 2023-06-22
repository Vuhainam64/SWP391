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
        console.log();
        try {
            // Perform necessary API requests to retrieve the product data
            const response = await request.get(`product/${productId}`);
            const productData = response.data;

            // Modify the product data as needed

            // Perform necessary API requests to update the product
            await request.put(`product/${productId}`, productData);

            // Fetch updated product list
            fetchProducts();
        } catch (error) {
            console.error('Error editing product:', error);
        }
    };

    const handleDelete = async (productId) => {
        try {
            // Perform necessary API requests to delete the product
            await request.delete(`product/${productId}`);
            console.log(productId);
            // Fetch updated product list
            fetchProducts();
        } catch (error) {
            console.error('Error deleting product:', error);
        }
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
                                <button onClick={() => handleDelete(product.productId)}>Disable</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Product;
