import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getAllUsers } from "../api";
import { Avatar } from "../assets";
import {
  getAllUserDetails,
  setAllUserDetails,
} from "../context/actions/allUsersAction";
import DataTable from "./DataTable";
import MainLoader from "./MainLoader";

function DBUsers() {
  const allUsers = useSelector((state) => state.allUsers);
  const isLoading = useSelector((state) => state.isLoading);

  const dispatch = useDispatch();

  useEffect(() => {
    if (!allUsers) {
      dispatch(getAllUserDetails()); // Dispatch action to indicate loading state
      getAllUsers()
        .then((data) => {
          dispatch(setAllUserDetails(data));
        })
        .catch((error) => {
          console.log("Error fetching users:", error);
          dispatch(setAllUserDetails([])); // Set empty array to indicate no users
        });
    }
  }, []);

  if (isLoading) {
    return <MainLoader />;
  }

  return (
    <div className="flex items-center justify-self-center gap-4 pt-6 w-full">
      <DataTable
        columns={[
          {
            title: "Image",
            field: "photoURL",
            render: (rowData) => (
              <img
                src={rowData.photoURL ? rowData.photoURL : Avatar}
                className="w-32 h-16 object-contain rounded-md"
                alt=""
              />
            ),
          },
          {
            title: "Name",
            field: "displayName",
          },
          {
            title: "Email",
            field: "email",
          },
          {
            title: "Verified",
            field: "emailVerified",
            render: (rowData) => (
              <p
                className={`px-2 py-1 w-32 text-center text-primary rounded-md ${
                  rowData.emailVerified ? "bg-emerald-500" : "bg-red-500"
                }`}
              >
                {rowData.emailVerified ? "Verified" : "Not Verified"}
              </p>
            ),
          },
        ]}
        data={allUsers || []} // Provide an empty array as fallback if allUsers is null
        title="List of Users"
      />
    </div>
  );
}

export default DBUsers;
