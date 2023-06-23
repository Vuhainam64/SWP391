import React, { useEffect, useRef } from "react";
import { FaCartPlus } from 'react-icons/fa'
import { motion } from "framer-motion";

function RowContainer({flag, data, scrollValue}) {
    console.log(data)
    const rowContainer = useRef()
    useEffect(() => {
        rowContainer.current.scrollLeft += scrollValue
    }, [scrollValue])
    return ( 
        <div 
        ref={rowContainer}
        className={`w-full flex items-center gap-3 my-12 scroll-smooth ${
            flag 
            ? 'overflow-x-scroll scrollbar-none'
            : 'overflow-x-hidden flex-wrap'
        }`}>
            {
              data && data.map(item => (
                <div key={item.id} className="w-300 min-w-[300px] md:w-340 md:min-w-[340] h-auto bg-cardOverlay rounded-lg my-12
                backdrop-blur-lg p-2 hover:shadow-lg">
                    <div className="w-full flex items-center justify-between">
                        <motion.img 
                        whileHover={{scale : 1.2}}
                        src="http://localhost:3000/static/media/c3.55f83414f33f66456b35.png" 
                        alt="" 
                        className="w-40 -mt-8 drop-shadow-2xl"
                        />
                        <motion.div
                        whileTap={{scale : 0.7}} 
                        className="w-8 h-8 rounded-full bg-red-600 flex items-center 
                        justify-center cursor-pointer hover:shadow-md">
                            <FaCartPlus className="text-white"/>
                        </motion.div>
                    </div>
                    
                    <div className="w-full flex flex-col items-end justify-end">
                        <p className="text-textColor font-semibold text-base md:text-lg">
                            Chocolate & Vanilla
                        </p>
                        <p className="mt-1 text-sm text-gray-500">
                            45 Calories
                        </p>
                        <div className="flex items-center gap-8">
                            <p className="text-lg text-headingColor font-semibold">
                                <span className="text-sm text-red-500">
                                    $
                                </span>
                                5.25
                            </p>
                        </div>
                    </div>
                </div>
              ))  
            }
        </div>
     );
}

export default RowContainer ;