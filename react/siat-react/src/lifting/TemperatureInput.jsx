import React from "react";

function TemperatureInput(props) {
    const changeHandler = (event) => {
        props.handler(event.target.value)
    } 
    return (
        <fieldset>
            <legend>
                온도를 입력하세요(단위: {props.scale}) 
                {/* props로 부모 컴포넌트에서 넘어온 것을 꺼냄. */}
            </legend>
            <input value={props.temperature} onChange={changeHandler}/>
        </fieldset>
    );
}

export default TemperatureInput ;