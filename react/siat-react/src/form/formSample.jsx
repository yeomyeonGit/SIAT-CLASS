import React, { useState } from "react";

function FormSample(props) {
    const [name, setName] = useState("");
    const [pwd, setPwd] = useState("");
    const [gender, setGender] = useState("");

    const nameHandler = (event) => {
        console.log("debug name >>> : ", name)
        setName(event.target.value) ;
    }

    const pwdHandler = (event) => {
        console.log("debug pwd >>> : ", name)
        setPwd(event.target.value) ;
    }

    const genderHandler = (event) => {
        console.log("debug gender >>> : ", name)
        setGender(event.target.value) ;
    }

    const submitHandler = (name, pwd, gender) => {
        console.log("debug everything >>>>: ", name, pwd, gender)
        
        
    }

    return (
        <div>
            <form>
                <label>
                    아이디:
                    <input type = "text" placeholder="아이디" value={name} onChange={nameHandler}/>
                    패스워드:
                    <input type = "text" placeholder="아이디" value={pwd} onChange={pwdHandler}/>
                    성별:
                    <select value={gender} onChange={genderHandler}>
                        <option value="남자">남자</option>
                        <option value="여자">여자</option>
                    </select>
                </label>
                <button type = "button" onClick={() => submitHandler(name, pwd, gender)  }>제출</button>
            </form>
        </div>
    );
}

export default FormSample ;