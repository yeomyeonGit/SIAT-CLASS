import React from "react";

function LoginBtn(props) {
    const loginHandler = (setIsLoggedIn) => {
        setIsLoggedIn(true) ;
        console.log("debug >>>>> loginHandler")
    } 

    return (
        <div>
            <button onClick={() => loginHandler(props.isLogIn)}>로그인</button>

        </div>
    ) ;
}

export default LoginBtn ;