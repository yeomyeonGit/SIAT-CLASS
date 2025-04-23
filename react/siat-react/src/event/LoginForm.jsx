import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import api from "../api/axios";

function LoginForm(props) {
    const moveUrl = useNavigate();

    const [email, setEmail] = useState("");
    const [pwd, setPwd] = useState("");

    const loginHandler = async (event, email, pwd) => {
        event.preventDefault();
        console.log("debug >>> loginHandler ", email, pwd);

        try {
            const data = { "id" : email,
            "pwd" : pwd};
            console.log(data);
            const response = await api.post("react/login", data);
            console.log("debug >>> response: ", response) ;
            if (response.status == 204) {
                window.alert("로그인 성공 후 화면 이동 ^_^")
                moveUrl("/user/success")
            }
        }catch (err) {
            console.log(err)
        }
    }

    const emailHandler = (event) => {
        console.log("debug >>> emailHandler ");
        setEmail(event.target.value)
        console.log(`input email ${email}`)
    }

    const pwdHandler = (event) => {
        console.log("debug >>> pwdHandler ");
        setPwd(event.target.value)
        console.log(`input pwd ${pwd}`)
    }

    return (
        <div>
            <form onSubmit={(event) => loginHandler(event, email, pwd)}>
                <div class="mb-3 mt-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" class="form-control" placeholder="Enter email" value={email} onChange={emailHandler}/>
                </div>
                <div class="mb-3">
                    <label for="pwd" class="form-label">Password:</label>
                    <input type="password" class="form-control" placeholder="Enter password" value={pwd} onChange={pwdHandler}/>
                </div>
                <div class="form-check mb-3">
                    <label class="form-check-label">
                    <input class="form-check-input" type="checkbox"/> Remember me
                    </label>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="button" class="btn btn-danger" onClick={() => {
                    moveUrl("/")
                }}>Cancel</button>
            </form>
        </div>
    );
}

export default LoginForm ;

// 1. 키인 - 스크립트와 동기화
// 2. submit -> 핸들러 찾음. 파라미터로 전달
// 3. 파라미터를 JSON 형식으로 만들기
// 4. 서버로 넘김
// 서버로 파

// event: 이벤트가 발생된 근원지에 대한 정보를 넘겨줌.