import React, { useState, useEffect } from "react";

// var      변수
// let      변수(중복되는 변수를 선언할 수 없음)
// const    상수

const CAPACITY = 10 ;
const cntUpHandler = () => {
    console.log("debug >>> cntUpHandler ")

}

const cntDownHandler = () => {
    console.log("debug >>> cntDownHandler ")

}

// function a() {

// } 이렇게도 쓸 수 있다

// 사람이 입장하고 퇴장하는데 수용인원에 따른 카운트를 관리하고 싶다면?


function StateSample(props) {
    // 초기상태 설정
    const [cnt, setCnt] = useState(0) ;
    const [isFull, setIsFull] = useState(false) ;
    const [isAbscent, setIsAbscent] = useState(false) ;

    // cnt의 상태가 바뀔 때마다 다음을 실행한다.
    useEffect(() => {
        console.log("debug >>>> component update cnt: ", cnt)
        setIsFull(cnt >= CAPACITY) // cnt가 CAPACITY보다 같거나 크면 isFull의 상태를 변경한다.
        setIsAbscent( cnt <= 0 ) // cnt가 0보다 같거나 작으면 isAbscent의 상태를 변경한다.
    }, [cnt]);

    useEffect( () => {
        console.log(`debug >>>> component update isFull: ${isFull}`)
    }, [isFull])
    
    useEffect(() => {
        console.log("debug >>>> component update isAbscent: ", isAbscent)
    }, [isAbscent]);

    return (
        <div>
            <p>{`입장 인원 : ${cnt}`}</p>
            <button onClick={() => {
                setCnt( (cnt) => cnt + 1);

            }} disabled={isFull}>입장</button>
            <button onClick={ () => {
                setCnt((cnt) => cnt - 1)

            }} disabled={isAbscent}>
            퇴장</button>
            { isFull && <p style={{color : "red"}}>정원이 가득가득</p>}
        </div>
    );
}

export default StateSample ;