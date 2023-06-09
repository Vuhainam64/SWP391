// Layouts
import { HeaderOnly } from '~/components/Layout';

// Pages
import Home from '~/pages/Home';
import Shop from '~/pages/Shop';
import Detail from '~/pages/Detail';
import Profile from '~/pages/Profile';
import Admin from '~/pages/Admin';
import Search from '~/pages/Search';

// Public routes
const publicRoutes = [
    { path: '/', component: Home },
    { path: '/shop', component: Shop },
    { path: '/detail', component: Detail },
    { path: '/search', component: Search, layout: null },
    { path: '/profile', component: Profile },
    { path: '/admin', component: Admin, layout: HeaderOnly },
];

const privateRoutes = [];

export { publicRoutes, privateRoutes };
