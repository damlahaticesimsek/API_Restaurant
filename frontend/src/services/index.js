import axios from 'axios'

const api = axios.create({
    baseURL: 'http://13.41.73.177:8080/api',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
    }
})

export default api