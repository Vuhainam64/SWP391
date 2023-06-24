import { combineReducers } from "redux";
import alertReducer from "./aleartReducer";
import userReducer from "./userReducer";

const myReducer = combineReducers({
  user: userReducer,
  alert: alertReducer,
});

export default myReducer;
