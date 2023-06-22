import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

import { BrowserRouter as Router} from 'react-router-dom';

import App from './App'
import { StateProvider } from './context/StateProvider';
import { initalState } from './context/initalState';
import reducer from './context/reducer';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <Router>
        <StateProvider initalState={initalState} reducer={reducer}>
            <App/>
        </StateProvider>
    </Router>,
);