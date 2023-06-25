import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { deleteAProduct, getAllProducts } from "../api";
import { HiCurrencyRupee } from "../assets/icons";
import { DataTable } from "../components";
import { alertNULL, alertSuccess } from "../context/actions/alertAction";
import { setAllProducts } from "../context/actions/productActions";

const DBItems = () => {
  const products = useSelector((state) => state.products);
  const dispatch = useDispatch();
  return (
    <div className="flex items-center justify-self-center gap-4 pt-6 w-full">
      <DataTable />
    </div>
  );
};

export default DBItems;
