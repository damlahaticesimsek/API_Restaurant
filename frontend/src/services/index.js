import axios from 'axios'

const api = axios.create({
    baseURL: 'http://13.41.73.177:8080/api',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
    }
})

export const postApi = axios.create({
    baseURL: 'http://13.41.73.177:8080/api',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
    },
    method: 'POST'
})

export const S3Api = axios.create({
    baseURL: 'https://restaurant-api-image.s3.eu-west-2.amazonaws.com/images/',
    headers: {
        'Content-Type': 'image/*'
    },
    responseType: 'arraybuffer'
})

export default api