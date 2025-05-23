import react, { useState } from "react";
import api from "../api/axios";
import { useNavigate } from "react-router-dom" ;

function SignUp(props) {

    const [ id , setId ] = useState('') ;
    const [ pwd , setPwd ] = useState('') ;

    const moveUrl = useNavigate() ;

    const signUpHandler = async (id, pwd) => {
        console.log("login btn click" , id, pwd)
        const params = { id : id, pwd : pwd}

        try {
            // http://ip:port/forecast/getData?base_time=base_time ...  get방식일 때는 param으로 넘어감
            await api.post("/api/user/signUp", params)
            moveUrl("/")
        } 
        catch(e) {
        
        } ;
        
    }

    


    return (

        <form>
            <input type="text" value={id} onChange={ (e) => setId(e.target.value)}/>
            <input type="text" value={pwd} onChange={ (e) => setPwd(e.target.value)}/>
            <button type="button" onClick={() => signUpHandler(id, pwd)}>회원가입</button>
        </form>
    )
}

export default SignUp ;