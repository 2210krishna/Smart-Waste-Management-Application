import axios from 'axios';
const API_BASE = 'http://localhost:8081/api/users';

export const getAllUsers = () => axios.get(API_BASE);
