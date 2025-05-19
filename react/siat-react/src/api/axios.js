import axios from "axios" ;

const api = axios.create({
    baseURL : 'http://localhost:8088/',
});

// const api = axios.create({
//     baseURL : 'http://localhost:8088/',
//     withCredentials : true
// });


// // 요청 인터셉트. 알아서 헤더에 붙여줌
// api.interceptors.request.use(
//     (config) => {
//         const accessToken = localStorage.getItem("accessToken");
//         if(accessToken) {
//             config.headers.Authorization = accessToken ; // 가정: 토큰이 만료됐다.
//             // 토큰이 만료됐어도 인터셉트가 동작하게 해야 한다.
//         }
//         return config ;
//     }
// );

// 응답 - access token 만료시 자동 재발급하여 재요청
// api.interceptors.response.use(
//     (response) => response, 
//     async (error) => {
        
//         console.log("debug >>>>>>>> response error : ", error);
//         console.log("debug >>>>>>>> response config : ", error.config);
//         console.log("debug >>>>>>>> response response : ", error.response);
//         const originalRequest = error.config;
//         if( error.response?.status === 403 && !originalRequest._retry) {
//             originalRequest._retry = true;
//             try {
//                 const refreshToken = localStorage.getItem("refreshToken");
//                 console.log("debug >>>>>>>> refreshToken : ", refreshToken);
//                 const res = await axios.post('auth/renew', {}, {
//                                 baseURL: "http://localhost:8088/",
//                                 headers : {
//                                     Authorization : `Bearer ${refreshToken}`
//                                 }
//                             });
//                 console.log("debug >>>>>>>> response header : ", res.headers);
//                 const newAccessToken = res.headers.get("Authorization")
//                 localStorage.setItem("accessToken", newAccessToken);

//                 // 재요청           
//                 originalRequest.headers.Authorization = `Bearer ${newAccessToken}` ;
//                 return api(originalRequest);
//             } catch(err) {
//                 console.log("debug >>>> response interceptor ", err);
//                 return Promise.reject(err);
//             }
            
//         } // if end
//         return Promise.reject(error);          
//     }
// );

export default api ;