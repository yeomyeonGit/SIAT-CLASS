import React from "react" // react 라이브러리에서 가져온 것을 React라는 이름으로 쓰겠다

function Book(props) {
    return (
        <div>
            <h1>{`책 이름: ${props.name}, ${props.color}` }</h1>
        </div>
    )

}

export default Book ;