import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getAllProducts } from "../api";
import { setAllProducts } from "../context/actions/productActions";

import { CChart } from "@coreui/react-chartjs";

const DBHome = () => {
  const products = useSelector((state) => state.products);
  const dispatch = useDispatch();

  const seed = products?.filter((item) => item.product_category === "seed");
  const suet = products?.filter((item) => item.product_category === "suet");
  const nectar = products?.filter((item) => item.product_category === "nectar");
  const fruit = products?.filter((item) => item.product_category === "fruit");
  const insect = products?.filter((item) => item.product_category === "insect");
  const wetfood = products?.filter(
    (item) => item.product_category === "wet  food"
  );
  const livefood = products?.filter(
    (item) => item.product_category === "live food"
  );

  useEffect(() => {
    if (!products) {
      getAllProducts().then((data) => {
        dispatch(setAllProducts(data));
      });
    }
  }, []);

  return (
    <div className="flex items-center justify-center flex-col pt-6 w-full h-full">
      <div className="grid w-full grid-cols-1 md:grid-cols-2 gap-4 h-full">
        <div className="flex items-center justify-center">
          <div className="w-340 md:w-508">
            <CChart
              type="bar"
              data={{
                labels: [
                  "Seed",
                  "Suet",
                  "Necar",
                  "Fruit",
                  "Insect",
                  "Wet Food",
                  "Live Food",
                ],
                datasets: [
                  {
                    label: "Category wise Count",
                    backgroundColor: "#f87979",
                    data: [
                      seed?.length,
                      suet?.length,
                      nectar?.length,
                      fruit?.length,
                      insect?.length,
                      wetfood?.length,
                      livefood?.length,
                    ],
                  },
                ],
              }}
              labels="months"
            />
          </div>
        </div>
        <div className="w-full h-full flex items-center justify-center">
          <div className="w-275 md:w-460">
            <CChart
              type="doughnut"
              data={{
                labels: [
                  "Orders",
                  "Delivered",
                  "Cancelled",
                  "Paid",
                  "Not Paid",
                ],
                datasets: [
                  {
                    backgroundColor: [
                      "#51FF00",
                      "#00B6FF",
                      "#008BFF",
                      "#FFD100",
                      "#FF00FB",
                    ],
                    data: [40, 20, 80, 34, 54],
                  },
                ],
              }}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default DBHome;
