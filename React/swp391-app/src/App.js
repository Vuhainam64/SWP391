import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Navbar } from "./components/navbar";
import { Register } from "./pages/register/register";
import { Home } from "./pages/home/home";
import { About } from "./pages/about/about";
import { Shop } from "./pages/shop/shop";
import { Contact } from "./pages/contact/contact";
import { Cart } from "./pages/cart/cart";
import { ShopContextProvider } from './context/shop-context';
import { ProductDetail } from './pages/product/product-detail';
import { Footer } from "./components/footer"


function App() {
  return (
    <div className = "App">
      <ShopContextProvider>
        <Router>
          <Navbar />
          <Routes>
            <Route path = "/register" element = {<Register />} />
            <Route path = "/home" element={<Home/>} />
            <Route path = "/about" element={<About/>} />
            <Route path = "/" element = {<Shop />} />
            <Route path = "/product" element = {<ProductDetail />} />
            <Route path = "/contact" element = {<Contact />} />
            <Route path = "/cart" element = {<Cart />} />
          </Routes>
          <Footer />
        </Router>
      </ShopContextProvider>
      
    </div>
  );
}

export default App;
