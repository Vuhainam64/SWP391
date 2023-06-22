import { getApp, getApps, initializeApp } from 'firebase/app';
import { getFirestore } from 'firebase/firestore';
import { getStorage } from 'firebase/storage';

const firebaseConfig = {
    apiKey: "AIzaSyAxf0TBVfGwlJH74M3FMn76GqPfwDjtJcQ",
    authDomain: "birdfoodapp.firebaseapp.com",
    databaseURL: "https://birdfoodapp-default-rtdb.firebaseio.com",
    projectId: "birdfoodapp",
    storageBucket: "birdfoodapp.appspot.com",
    messagingSenderId: "614137142674",
    appId: "1:614137142674:web:b7f8ad9015136102e7b54b"
};

const app = getApps.length > 0 ? getApp() : initializeApp(firebaseConfig);

const firestore = getFirestore(app);
const storage = getStorage(app);

export { app, firestore, storage }