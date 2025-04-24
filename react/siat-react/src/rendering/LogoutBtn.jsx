import React from "react";

function LogoutBtn(props) {
    return (
        <div>
            <button onClick={props.handler}>로그아웃</button>

        </div>
    ) ;
}

export default LogoutBtn ;