import React from "react"
import Book from "./Book"
import Clock from "./Clock";

function Library() {
    return (
        <div>
            <Book name="섭서비와 함께하는 리액트" color="red"/> 
            {/* name은 props라는 속성 */}
            <Clock/>
        </div>
    );
}

export default Library ;  // 이게 없으면 html로 쓸 수 없다