import React from "react";
import { useNavigate } from "react-router-dom" ;

function IndexPage(props) {

    // useNavigate() 이용해서 컴포넌트에서 컴포넌트 이동
    const moveUrl = useNavigate();
    
    return (
        <button class="btn btn-primary" onClick={() => {
            moveUrl("/user/loginForm")
        }}>로그인 페이지 이동</button>
    );
}

export default IndexPage ;