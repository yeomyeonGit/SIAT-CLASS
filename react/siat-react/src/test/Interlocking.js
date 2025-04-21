import React from "react";
import api from "../api/axios.js"
import User from "./User.jsx";

let users = [];
const btnHandler = async () => {
    console.log(">>>>>>>>>>>> btn click");
    const data = {
        title : "react",
        content : "react",
        priority : 10
    }

    // endpoint : http://localhost:8088/react/select
    const response = await api.get('/react/select', data);
    console.log("debug >>> ", response) ;
    console.log("debug >>> data ", response.data) ;
    users = response.data ;

}

function Interlocking(props) {
    return (
        <div>
            <button onClick = {btnHandler}>click </button>
            {/* 버튼에 이벤트가 발생하면 btnHandler가 실행된다 */}

        {
            users.map( (user) => {
                return (
                    <User name = {user.name} info={user.info}/>
                );
            } )
        }

        </div>

    );
}

export default Interlocking ;