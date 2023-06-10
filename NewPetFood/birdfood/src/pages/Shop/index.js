import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import styles from './Shop.module.scss';

function Shop() {
    const [products, setProducts] = useState([]);
    const [category, setCategory] = useState('');
    const [sort, setSort] = useState('');
    const [search, setSearch] = useState('');
    const [filteredProducts, setFilteredProducts] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/petstore/api/v1/product')
            .then((res) => res.json())
            .then((data) => {
                setProducts(data);
                setFilteredProducts(data);
            })
            .catch((error) => console.log(error));
    }, []);

    useEffect(() => {
        filterProducts();
    }, [category, sort, search]);

    const filterProducts = () => {
        let filtered = products;

        if (category) {
            filtered = filtered.filter((product) => product.category === category);
        }

        if (search) {
            filtered = filtered.filter(
                (product) =>
                    product.productName.toLowerCase().includes(search.toLowerCase()) ||
                    product.tags.toLowerCase().includes(search.toLowerCase()),
            );
        }

        if (sort === 'priceLowToHigh') {
            filtered = filtered.sort((a, b) => a.productPrice - b.productPrice);
        } else if (sort === 'priceHighToLow') {
            filtered = filtered.sort((a, b) => b.productPrice - a.productPrice);
        }

        setFilteredProducts(filtered);
    };

    return (
        <div className={styles.shop}>
            <div className={styles.category}>
                <h2>Category</h2>
                <ul>
                    <li onClick={() => setCategory('')}>All</li>
                    <li onClick={() => setCategory('Seed')}>Seed</li>
                    <li onClick={() => setCategory('Wet Food')}>Wet Food</li>
                    <li onClick={() => setCategory('Dry Food')}>Dry Food</li>
                    <li onClick={() => setCategory('Live Food')}>Live Food</li>
                </ul>
            </div>
            <div className={styles.sort}>
                <h2>Sort</h2>
                <select value={sort} onChange={(e) => setSort(e.target.value)}>
                    <option value="">None</option>
                    <option value="priceLowToHigh">Price: Low to High</option>
                    <option value="priceHighToLow">Price: High to Low</option>
                </select>
            </div>
            <div className={styles.search}>
                <h2>Search</h2>
                <input type="text" value={search} onChange={(e) => setSearch(e.target.value)} />
            </div>
            <div className={styles.results}>
                {filteredProducts.map((product) => (
                    <div key={product.productId} className={styles.product}>
                        <img src={product.imageMain} alt={product.productName} />
                        <h3>{product.productName}</h3>
                        <p>{product.productDescription}</p>
                        <p>Price: ${product.productPrice}</p>
                        <p>Quantity: {product.quantity}</p>
                    </div>
                ))}
            </div>
            <div className={styles.pagination}>
                <ul>
                    <li>1</li>
                    <li>2</li>
                    <li>3</li>
                </ul>
            </div>
        </div>
    );
}

export default Shop;
