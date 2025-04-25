import React, {useState} from "react";
import ContextPage from "./ContextPage";
import ctx from "./contextMode";

function ContextApp(props) {
    const [ isMode, setIsMode ] = useState(false);  // 최상위에 상태 관리할 수 있는 값이 있음
    return (
        <div>
            {/* <ContextPage isMode={isMode} setIsMode={setIsMode} /> */}
            <ctx.Provider value={ { isMode, setIsMode } }>
                <ContextPage />
            </ctx.Provider>
        </div>
    ) ;
}

export default ContextApp ;