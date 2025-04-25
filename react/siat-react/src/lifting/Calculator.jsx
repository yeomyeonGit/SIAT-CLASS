import React, { useState } from "react";
import TemperatureInput from "./TemperatureInput";

function Calculator(props) {
    const [temperature, setTemperature] = useState(0); // 최상위 컴포넌트의 상태

    const temCelHandler = (temp) => {
        console.log("debug >>>>> temCelHandler: ", temp)
        setTemperature(temp);

    }

    const temFarHandler = (temp) => {
        console.log("debug >>>>> temFarHandler: ", temp)
        setTemperature(temp);
    }

    return (
        <div>
            <TemperatureInput
                scale = "c" temperature={temperature}  // 상태를 자식 컴포넌트로 넘겨줄 수 있다
                handler = {temCelHandler}  // 이벤트가 있을 때 실행되는 함수인 핸들러를 자식 컴포넌트로 넘겨줄 수 있다
                />
            <TemperatureInput
                scale = "f" temperature={temperature}
                handler = {temFarHandler} />
        </div>
    );

}

export default Calculator ;