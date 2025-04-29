import React, { useState } from "react";
import api from "../api/axios";
import { useNavigate } from "react-router-dom";

function Login(props) {
    const [email, setEmail] = useState("");
    const [passwd, setPasswd] = useState("");
    const moveUrl = useNavigate();
    const loginHandler = async () => {
        const response = await api.post("auth/login", {
            "email" : email,
            "passwd" : passwd
        }) ;
        console.log("response >> ", response)
        console.log("authorization : ", response.headers.get("Authorization"))
        console.log("refreshToken : ", response.headers.get("Refresh-Token"))
        // 데이터를 담는 방법 - context, localStorage, 외부 라이브러리
        localStorage.setItem("accessToken", response.headers.get("Authorization"));
        localStorage.setItem("refreshToken", response.headers.get("Refresh-Token"));

        // 이 방식으로도 담을 수 있다. 오타 주의하기. 스프링의 컨트롤러의 헤더에 들어가는 데이터와 이름이 동일해야 한다
        // localStorage.setItem("accessToken", response.headers.authorization);
        // localStorage.setItem("refreshToken", response.headers.refreshToken);
        moveUrl("/success")
        
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