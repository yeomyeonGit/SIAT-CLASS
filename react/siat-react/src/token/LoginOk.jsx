import React from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";

function LoginOk(props) {
    const moveUrl = useNavigate();

    const btnHandler = async () => {
        console.log("debug >>>>>>>>> btnHandler") ; 
        const accessToken = localStorage.getItem("accessToken") ;
        console.log("debug >>> accessToken: ", accessToken)

        // # 인터셉트 사용하지 않을 때
        // const response = await api.get("api/v1/hello", 
        //     {
        //         headers: {Authorization: accessToken,},
        //     }
        //   ) ;    // 인터셉트가 대신할 수 있음

        // 인터셉트 사용
        const response = await api.get("api/v1/hello")
        console.log(">>>>>> response: " + response)

    }

    const logoutHandler = () => {
        // localStorage.setItem("accessToken", "") ;
        localStorage.removeItem("accessToken")
        localStorage.removeItem("refreshToken")
        moveUrl("/")
    }

    return (
        <div> 
            토큰 검증을 통한 사용자 요청 처리
            <button onClick={btnHandler}> 통신요청 </button>
            <button onClick={logoutHandler}> 로그아웃 </button>
        </div>
    ) ;
}

export default LoginOk ;