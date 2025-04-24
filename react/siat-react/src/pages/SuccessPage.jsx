import React, {useEffect, useState} from "react";
import { useNavigate } from "react-router-dom" ;
import api from "../api/axios"
import TodoItem from "../items/TodoItem";

function SuccessPage(props) {

    const [todoLists, setLists] =  useState([]) ;

    // mount가 있으면 effect이 있다는 것, side-effect 실행
    useEffect(() => {
        console.log("debug >>>> useEffect >>>>>>>>>>>>>>>>>> ") ;
        getList() ;
    }, []) ;

    // 🤔 왜 이렇게 쓰냐?
    // 주로 초기 데이터 로딩에 사용해.

    // 예를 들어:

    // API 호출해서 리스트 불러오기

    // 처음 한 번만 뭔가 등록하기 (이벤트 리스너 등)

    const getList = async () => {
        console.log("debug >>>>> getList endpoint: / react / list")
        const response = await api.get("/react/list")
        console.log("response:", response)
        console.log(`response status: ${response.status}` )
        console.log(`response data: ${response.data}`)
        setLists(response.data);
    }

    const deleteHandler = async (seq) => {
        console.log("debug >>>>>>>>>>>>> deleteHandler: ", seq)
        const response = await api.delete(`react/delete/${seq}`) ;
        if(response.status == 204) {
            // getList();
            setLists(...[todoLists.filter(list=>list.seq !== seq)])
        }
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
                    <th>Discard</th>
                </tr>
                </thead>
                <tbody>
                    { todoLists.map( todoList => {
                        return (
                            <TodoItem key={todoList.seq}
                                      data={todoList}
                                      handler={deleteHandler}
                                    />
                            // 객체를 통째로 넘기는 방법
                            // key는 유일한 값 - 기본키
                        );

                    })
                        
                    }
                    
                    
                </tbody>
            </table>
        </div>
    );
}

export default SuccessPage ;