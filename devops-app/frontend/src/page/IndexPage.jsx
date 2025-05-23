import react, { useState } from "react";
import api from "../api/axios";
import { useNavigate } from "react-router-dom" ;

function IndexPage(props) {
    const [ id , setId ] = useState('') ;
    const [ pwd , setPwd ] = useState('') ;

    const loginHandler = async (id, pwd) => {
        console.log("login btn click" , id, pwd)
        const data = { id : id, pwd : pwd}
        const response = await api.get("/api/user/signIn", {params : data})
        console.log("response: " , response.data) ;
    }

    const moveUrl = useNavigate() ;

    return (
        <div align="right">
            <form>
                <input type="text" value={id} onChange={ (e) => setId(e.target.value)}/>
                <input type="text" value={pwd} onChange={ (e) => setPwd(e.target.value)}/>
                <button type="button" onClick={() => loginHandler(id, pwd)}>로그인</button>
                <button type="button" onClick={() => moveUrl("/api/user/signUp")}>회원가입</button>
            </form>
        </div>

        // 할 일: 서버랑 통신해서 데이터 보내고 데이터 가져오기
    )
}

export default IndexPage ;