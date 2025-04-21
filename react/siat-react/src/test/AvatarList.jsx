import React from "react";
import Avatar from "./Avatar";

const  avatars = [
    { src : "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png", msg : "섭섭이"},
    { src : "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png", msg : "씨앗"}
]
// 배열에 객체가 들어 있는 JSON 형식

function AvatarList(props) {
    return (
        <div>
            {avatars.map( (avatar) => {
                return (
                    <Avatar src = {avatar.src} msg = {avatar.msg}/>
                );
            })
        }
        </div>
    )
}

export default AvatarList ;