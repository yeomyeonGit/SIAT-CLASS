import React from "react";
import {Link, useLocation} from "react-router-dom"

function TodoView(props) {
    const location = useLocation();
    const data = location.state ;

    return (
        <div>
            <Link to="/">랜딩 페이지</Link>
            <ul class="list-group">
                <li class="list-group-item">{data.seq}</li>
                <li class="list-group-item">{data.title}</li>
                <li class="list-group-item">{data.content}</li>
                <li class="list-group-item">{data.startDate}</li>
                <li class="list-group-item">{data.endDate}</li>
                <li class="list-group-item">{data.priority}</li>
                <li class="list-group-item">{data.status}</li>
            </ul>
        </div>
        
    )
}

export default TodoView