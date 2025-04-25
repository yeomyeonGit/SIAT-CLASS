import React, { useContext } from "react";
import ctx from "./contextMode";

function ContextFooterPage(props) {
    const {isMode, setIsMode} = useContext(ctx);
    const changeHandler = () => {
        console.log("debug >>>> changeHandler");
        setIsMode(!isMode) ;
    }
    return (
        <div>
            <footer style={{
                backgroundColor : isMode ? "black" : "white"
            }}>
            <button onClick={changeHandler}>
                모드 변경
            </button>
            </footer>
        </div>
    ) ;
}

export default ContextFooterPage ;