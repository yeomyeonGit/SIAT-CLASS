import React from "react";

function LogoutBtn(props) {

    const logoutHandler = (setIsLoggedIn) => {
        setIsLoggedIn(false);
        console.log("debug >>>>> logoutHandler")
    }

    return (
        <div>
            <button onClick={() => logoutHandler(props.isLogIn)}>로그아웃</button>

        </div>
    ) ;
}

export default LogoutBtn ;