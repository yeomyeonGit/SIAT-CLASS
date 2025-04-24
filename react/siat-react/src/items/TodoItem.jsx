import React, {useState} from "react";
import api from "../api/axios";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function TodoItem(props) {
    const moveUrl = useNavigate();

    const detailsHandler = async (seq) => {
        console.log("debug >>>>>> detailsHandler")
        const response = await api.get(`react/read/${seq}`)
        console.log(response.data)
        moveUrl("/todo/details", { state : response.data} )
    }



    return (
        <tr>
            <td>{props.data.title}</td>
            <td>{props.data.status}</td>
            <td>{props.data.priority}</td>
            <td>
                <button class = "btn btn-primary" onClick={() => props.handler(props.data.seq)}>삭제</button>
                <button class = "btn btn-danger" onClick={() => detailsHandler(props.data.seq)}>보기</button>
            </td>
        </tr>
    );
}

export default TodoItem ;