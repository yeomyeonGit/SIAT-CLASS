import React from "react";

function LoginBtn(props) {
    return (
        <div>
            <button onClick={props.handler}>로그인</button>

        </div>
    ) ;
}

export default LoginBtn ;