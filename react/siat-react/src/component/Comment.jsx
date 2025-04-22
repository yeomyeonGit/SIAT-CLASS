import React from "react";

const styles = {
    containter : {
        margin : 8,
        padding : 8,
        display : "flex",
        flexDirection : "row",
        border : "1px solid gray",
        borderRadius : 16
    },

    commentContainer : {
        marginLeft : 8,
        display: "flex",
        flexDirection : "column",
        justifyContent : "center"
        
    },
    nameTxt : {
        color : "black",
        fontSize : 16,
        fontWeight : "bold"
    },
    commentTxt : {
        color : "red",
        fontSize : 16,
        fontWeight : "bold"

    }
}

function Comment(props) {
    return (
        <div style = {styles.containter}>
            <div style={styles.commentContainer}>
                <span style={styles.nameTxt}>{props.name}</span>
                <span style={styles.commentTxt}>{props.comment}</span>
            </div>
        </div>

    ) ;

}

export default Comment ;

// 컴포넌트는 화면을 렌더링하려고 만든다