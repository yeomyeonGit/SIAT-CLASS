import React from "react";

function EventSample(props) {
    const handler = (id, pwd) => {
        console.log(">>> btn click", id, pwd)
        const data = { "id" : id, "pwd" : pwd }
        // axios.post("http://ip:port/user/login")
    } 

    return (
        <div>
            <div>
                <button onClick = {() => handler('jslim', 'jslim')}>Click</button>
            </div>

        </div>
    );
}

export default EventSample ;
