import React from "react";
import FancyBoarder from "./FancyBoarder";

function WelcomeDialogue() {
    return (
        // 컴포넌트가 body를 가질 수 있음
        <FancyBoarder>
            <h1 className="title">
                합성
            </h1>
            <p className="message">
                맛점하세요
            </p>
        </FancyBoarder>
    ) ;

}

export default WelcomeDialogue ;