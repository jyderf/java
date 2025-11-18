import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/users", // URL de tu backend Spring Boot
});

export default API;
