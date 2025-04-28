import React, { useState } from "react";
import api from "../api/axios";
import { useNavigate } from "react-router-dom";

function Login(props) {
    const [email, setEmail] = useState("");
    const [passwd, setPasswd] = useState("");
    // const moveUrl = useNavigate();
    const loginHandler = async () => {
        const response = await api.post("api/v1/auth/login", {
            "email" : email,
            "passwd" : passwd
        }) ;
        console.log("response >> ", response)

        // localStorage.setItem("accessToken", response.headers.authorization);
        // localStorage.setItem("refreshToken", response.headers.refreshToken);
        // moveUrl("/")
        
    }
    return(
      <div>
        <h2>토큰 로그인</h2>
        <input  type="text"
                placeholder="이메일"
                value={email}
                onChange={ (e) => setEmail(e.target.value)} />
        <input  type="password"
                placeholder="패스워드"
                value={passwd}
                onChange={ (e) => setPasswd(e.target.value)} />
        <button onClick={loginHandler}>Login</button>
      </div>  
    );
}

export default Login;