import React from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";

function LoginOk(props) {
    const btnHandler = async () => {
        console.log("debug >>>>>>>>> btnHandler") ; 
        const accessToken = localStorage.getItem("accessToken") ;
        console.log(accessToken)

        const response = await api.get("api/v1/hello", 
            {
                headers: {Authorization: accessToken,},
            }
          ) ;
        console.log(">>>>>> response: " + response)

    }
    return (
        <div> 
            토큰 검증을 통한 사용자 요청 처리
            <button onClick={btnHandler}> 통신요청 </button>
        </div>
    ) ;
}

export default LoginOk ;