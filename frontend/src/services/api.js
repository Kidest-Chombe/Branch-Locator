import axios from "axios";

const API_BASE_URL = "http://localhost:8081/api/branches";

export const getAllBranches = () => axios.get(API_BASE_URL);

export const getNearestBranch = (district) =>
  axios.get(`${API_BASE_URL}/nearest?location=${encodeURIComponent(district)}`);

export const getBranchesByCity = (city) =>
  axios.get(`${API_BASE_URL}/city?city=${encodeURIComponent(city)}`);

export const getNearbyBranches = (lat, lng, radius = 10) =>
  axios.get(`${API_BASE_URL}/nearby?lat=${lat}&lon=${lng}&radius=${radius}`);