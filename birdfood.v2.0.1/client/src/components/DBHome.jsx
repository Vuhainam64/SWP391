import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getAllOrder, getAllProducts } from "../api";
import { setAllProducts } from "../context/actions/productActions";

import { CChart } from "@coreui/react-chartjs";
import { setOrders } from "../context/actions/ordersAction";

function DBHome() {
  const products = useSelector((state) => state.products);
  const orders = useSelector((state) => state.orders);

  const dispatch = useDispatch();

  const seed = products?.filter((item) => item.product_category === "seed");
  const suet = products?.filter((item) => item.product_category === "suet");
  const nectar = products?.filter((item) => item.product_category === "nectar");
  const fruit = products?.filter((item) => item.product_category === "fruit");
  const insect = products?.filter((item) => item.product_category === "insect");
  const wetfood = products?.filter(
    (item) => item.product_category === "wet food"
  );
  const livefood = products?.filter(
    (item) => item.product_category === "live food"
  );

  const preparing = orders?.filter((order) => order.sts === "preparing");
  const delivered = orders?.filter((order) => order.sts === "delivered");
  const cancelled = orders?.filter((order) => order.sts === "cancelled");

  useEffect(() => {
    if (!products) {
      getAllProducts().then((data) => {
        dispatch(setAllProducts(data));
      });
    }
  }, []);

  useEffect(() => {
    if (!orders) {
      getAllOrder().then((data) => {
        dispatch(setOrders(data));
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
                  "Nectar",
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
              options={{
                scales: {
                  y: {
                    ticks: {
                      stepSize: 1, // Chỉ số bước nhảy giữa các giá trị trên trục y
                      precision: 0, // Số chữ số sau dấu phẩy (không có số thập phân)
                    },
                  },
                },
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
                labels: ["Orders", "Delivered", "Preparing", "Cancelled"],
                datasets: [
                  {
                    backgroundColor: [
                      "#51FF00",
                      "#00B6FF",
                      "#008BFF",
                      "#FFD100",
                      "#FF00FB",
                    ],
                    data: [
                      delivered?.length + cancelled?.length + preparing?.length,
                      delivered?.length,
                      preparing?.length,
                      cancelled?.length,
                    ],
                  },
                ],
              }}
            />
          </div>
        </div>
      </div>
    </div>
  );
}

export default DBHome;
