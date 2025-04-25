import React from "react";
import SubComponent from "./SubComponent";

function FancyBoarder(props) {
    return (
        <div className={props.color}>
            {props.children}
        </div>
        
    ) ;

}

export default FancyBoarder ;