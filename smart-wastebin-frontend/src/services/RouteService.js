import axios from 'axios';
const API_BASE = 'http://localhost:8081/api/routes';

export const getAllRoutes = () => axios.get(API_BASE);
