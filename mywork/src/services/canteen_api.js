import axios from "axios";

const canteen_apiClient = axios.create({
    baseURL: 'http://localhost:3000/canteen',
    headers: {
        'Content-Type': 'application/json;charset=UTF-8'
    }
});

export default canteen_apiClient;