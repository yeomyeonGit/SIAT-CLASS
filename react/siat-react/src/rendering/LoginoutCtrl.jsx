import React, { useState } from "react";
import LoginBtn from "./LoginBtn";
import LogoutBtn from "./LogoutBtn";
import Greeting from "./Greeting";

function LoginoutCtrl(props) {
    const [isLoggedIn, setIsLoggedIn] = useState(false)

    const loginHandler = () => {
        setIsLoggedIn(true) ;
        console.log("debug >>>>> loginHandler")
    } 

    const logoutHandler = () => {
        setIsLoggedIn(false);
        console.log("debug >>>>> logoutHandler")
    }

    let button ;

    // 조건에 따라 렌더링
    // if (isLoggedIn) {
    //     button = <LogoutBtn handler={logoutHandler}/>   // 변수가 element가 된다, props로 handler를 전달한다.
    //     // 자식에서 핸들러가 실행됨. 자식에게 handler를 프롭스로 전달 중 
    // } else {
    //     button = <LoginBtn handler={loginHandler}/>
    // }

    return (
        <div>
            <Greeting isLoggedIn={isLoggedIn}/>
            {isLoggedIn
                ? <LogoutBtn handler={logoutHandler} />
                : <LoginBtn handler={loginHandler} />
            }

        </div>    
    ) ;
}

export default LoginoutCtrl ;