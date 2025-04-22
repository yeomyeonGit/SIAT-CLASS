import React, { useState, useEffect } from "react";

// 버튼의 이벤트를 감지해서 호출되는 함수
const countHandler = (setCnt, cnt) => {
    console.log("debug >>>> btn click");
    setCnt(cnt + 1);
    console.log("debug >>>> cnt value: ", cnt);
}

function Counter(props) {
    // life cycle
    // mount, unmount될 때
    // useEffect( 함수, 의존성배열 ["cnt"] )
    // 의존성 배열을 생략하면 컴포넌트가 업데이트될 때마다 호출된다
    // 컴포넌트가 마운트 된 이후,
    // 비어있는 의존성 배열([])을 넣어주게 되면 mount, unmount 됐을 때만 출력됨
    useEffect(() => {
        console.log("debug >>>> component mount ")
        console.log("debug >>>> component update cnt: ", cnt)
    });
    // 사이드이펙트? 의존성 배열이 없으면 업데이트가 됐을 때 영향을 받음. => 동기화
    // 있으면 mount, unmount 됐을 때만 출력됨

    // state
    const [cnt, setCnt] = useState(0);
    return (
        <div>
            <p>사용자 클릭횟수 : {cnt}</p>
            <button onClick={() => {
                setCnt(cnt + 1) ;
            } }>상태관리</button>
        </div>
    );
}

export default Counter ;