import React from "react" ;
const imgStyle = {
    image : {
        width : 50,
        height : 50,
        borderRadius : 25
    }
};


function Avatar(props) {
    return (
        <img src={props.src}
        style= {imgStyle.image}
        />
    );
}

export default Avatar ;