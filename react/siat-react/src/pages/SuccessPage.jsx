import React, {useEffect, useState} from "react";
import { useNavigate } from "react-router-dom" ;
import api from "../api/axios"

function SuccessPage(props) {

    const [todoLists, setLists] =  useState([]) ;

    useEffect(() => {
        console.log("debug >>>> useEffect >>>>>>>>>>>>>>>>>> ")
        getList() ;
    }, []) ;

    const getList = async () => {
        console.log("debug >>>>> getList endpoint: / react / list")
        const response = await api.get("/react/list")
        console.log("response:", response)
        console.log(`response status: ${response.status}` )
        console.log(`response data: ${response.data}`)
        setLists(response.data);

    }

    // useNavigate() 이용해서 컴포넌트에서 컴포넌트 이동
    return (
        <div align = "center">
            OOO님, 로그인 성공!
            <table class="table">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Status</th>
                    <th>Priority</th>
                </tr>
                </thead>
                <tbody>
                    { todoLists.map( todoList => {
                        return (
                        <tr>
                            <td>{todoList.title}</td>
                            <td>{todoList.status}</td>
                            <td>{todoList.priority}</td>
                        </tr>
                        );

                    })
                        
                    }
                    
                    
                </tbody>
            </table>
        </div>
    );
}

export default SuccessPage ;