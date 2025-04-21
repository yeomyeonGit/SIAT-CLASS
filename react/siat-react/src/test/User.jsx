import React from "react";

function User(props) {
    return (
        <div>
            <h1>{props.name}</h1>
            <h2>{props.info}</h2>
        </div>
        // html 형식으로 화면에 데이터를 구조화하여 뿌려준다.
    );

}

export default User;