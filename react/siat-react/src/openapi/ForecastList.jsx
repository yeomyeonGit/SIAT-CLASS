import React from "react";
import { useLocation } from "react-router-dom";
import ForecastItem from "./ForecastItem";

function ForecastList(props) {
    const location = useLocation();
    // location.state 배열이 들어 있음

    return (
        <div>목록 보기
        {   location.state == null ?
            <ForecastItem forecatst={"단기예보를 가져오지 못했습니다"}/>
            :
            location.state.map( (forecast, idx) => {
                return (
                    <ForecastItem key={idx} forecast={forecast.category}/>
                ) ;
            })
        
        }
        </div>
    )

}

export default ForecastList ;