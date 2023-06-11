import axios from "axios";

const request = axios.create({
    baseURL: 'http://localhost:8080/petstore/api/v1/'
})

export default request