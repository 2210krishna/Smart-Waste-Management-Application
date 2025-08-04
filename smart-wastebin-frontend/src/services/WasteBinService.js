import axios from 'axios';
const API_BASE = 'http://localhost:8081/api/wastebins';

export const getAllWasteBins = () => axios.get(API_BASE);
