import axios from "axios" ;

const api = axios.create( {
    baseURL : "http://localhost:8808",
    withCredentials : true
})

export default api ;