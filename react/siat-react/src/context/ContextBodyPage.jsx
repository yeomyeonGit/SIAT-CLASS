import React, { useContext } from "react";
import ctx from "./contextMode";

function ContextBodyPage(props) {
    const {isMode} = useContext(ctx);
    return (
        <div>
            <div style={{
                backgroundColor : isMode ? "black" : "white",
                color : isMode ? "white" : "black",
            }}>
                <p>씨앗 수강생님, 화이팅</p>
            </div>
        </div>
    ) ;
}

export default ContextBodyPage ;