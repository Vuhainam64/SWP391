import { useState } from "react";
import { motion } from "framer-motion";
import { fadeInOut } from "../animations";

function LoginInput({
  placeHolder,
  icon,
  inputState,
  inputStateFunc,
  type,
  isSignUp,
}) {
  const [isFocus, setIsFocus] = useState(false);
  return (
    <motion.div
      {...fadeInOut}
      className={`flex items-center justify-center gap-4 bg-lightOverlay 
      backdrop-blur-md w-full py-2 px-4 
      ${isFocus ? "shadow-md shadow-orange-400" : "shadow-none"}`}
    >
      {icon}
      <input
        type={type}
        placeholder={placeHolder}
        onChange={(e) => inputStateFunc(e.target.value)}
        onFocus={() => setIsFocus(true)}
        onBlur={() => setIsFocus(false)}
        className="w-full h-full bg-transparent text-headingColor text-lg 
        font-semibold border-none outline-none"
      />
    </motion.div>
  );
}

export default LoginInput;
