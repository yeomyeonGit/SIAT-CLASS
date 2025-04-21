import React from "react";
import User from "./User";

// JSON 형식 데이터
const users = [
    {name : "섭서비", info : "강사"},
    {name : "박신형", info : "학생"}
] ;

function UserList(props) {
    return (
        <div>
            {
                // 배열 - users에서 하나씩 꺼낸다. 하나씩 꺼낸 것을 user라고 부르기로 한다. 
                users.map( (user) => {
                    return (
                        <User name = {user.name} info={user.info}/>
                        // User 컴포넌트의 props로 name과 info를 전달한다.
                    );
                } )
            }
            
        </div>

    );

}

export default UserList;