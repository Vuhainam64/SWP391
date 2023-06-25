import { useEffect } from "react";
import { useSelector } from "react-redux";
import { getAllProducts } from "../api";

function DBHome() {
  const products = useSelector((state) => state.products);

  useEffect(() => {
    if (!products) {
      getAllProducts().then((data) => {
        console.log(data);
      });
    }
  });

  return <div>DBHome</div>;
}

export default DBHome;
