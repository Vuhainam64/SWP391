// Layouts
import { AdminOnly, HeaderOnly } from '~/components/Layout';

// Pages
import Home from '~/pages/Home';
import Login from '~/pages/Login';
import Shop from '~/pages/Shop';
import Cart from '~/pages/Cart';
import Detail from '~/pages/Detail';
import Profile from '~/pages/Profile';
import Admin from '~/pages/Admin';
import Product from '~/pages/Admin/Product';

// Public routes
const publicRoutes = [
    { path: '/', component: Home },
    { path: '/login', component: Login, layout: HeaderOnly },
    { path: '/shop', component: Shop },
    { path: '/cart', component: Cart },
    { path: '/detail', component: Detail },
    { path: '/profile', component: Profile },
    { path: '/admin', component: Admin, layout: AdminOnly },
    { path: '/admin/products', component: Product, layout: AdminOnly },
];

const privateRoutes = [];

export { publicRoutes, privateRoutes };
