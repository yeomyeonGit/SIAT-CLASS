// jsx의 문법을 쓰는 react의 컴포넌트
// 스크립트에 등록되어 있는 것을 html에서 바로바로 쓸 수 있게

import React from "react";
// const msg = "시간은 몰라요"

function Clock(props) {
    return (
        <div>
            <h1>현재 시간</h1>
            <h2> {new Date().toLocaleTimeString()} </h2>
        </div>
        
    ) 

    // 화면과 데이터 반환

}

export default Clock ;