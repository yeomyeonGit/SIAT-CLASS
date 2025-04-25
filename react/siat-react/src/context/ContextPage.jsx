import React from "react";
import ContextHeaderPage from "./ContextHeaderPage";
import ContextBodyPage from "./ContextBodyPage";
import ContextFooterPage from "./ContextFooterPage";

function ContextPage(props) {
    return (
        <div>
            {/* 
            <ContextHeaderPage isMode={props.isMode}/>
            <ContextBodyPage isMode={props.isMode}/>
            <ContextFooterPage isMode={props.isMode} setIsMode={props.setIsMode}/>
             */}
            
            <ContextHeaderPage />
            <ContextBodyPage />
            <ContextFooterPage />

        </div>
    ) ;
}

export default ContextPage ;