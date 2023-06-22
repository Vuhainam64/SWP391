import React from "react";
import { Route, Routes } from "react-router-dom";
import { AnimatePresence } from "framer-motion";
import { CreateConainer, Header, MainContainer } from "./components";

function App() {
    return ( 
        <AnimatePresence>
            <div className="w-screen h-auto flex flex-col bg-primary">
                <Header />
                
                <main className="mt-14 md:mt-20 px-4 md:px-16 py-4 w-full">
                    <Routes>
                        <Route path="/*" element={<MainContainer />}/>
                        <Route path="/createItem" element={<CreateConainer />}/>
                    </Routes>
                </main>
            </div>
        </AnimatePresence>
     );
}

export default App;