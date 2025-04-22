import React from "react";
import Comment from "./Comment";

const comments = [
    { name : "복돌", comment : "데빌도그" },
    { name: "최여명", comment : "졸려" },
    { name: "쿵새", comment : "베네베네"}
]

function CommentList(props) {
    return (
        <div>
            {
                comments.map((comment =>
                    <Comment name = {comment.name} comment = {comment.comment} />
                 )
            )}
        </div>
    );
}

export default CommentList ;