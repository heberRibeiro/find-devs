import axios from 'axios'

const api = axios.create({
    baseURL: 'http://192.168.99.100:8080'
})

export default api