import React , {useState} from "react";
import api from "../api/axios";
import { useNavigate } from "react-router-dom";
import ForecastItem from "./ForecastItem";

function ForecastPage(props) {
    const [base_time, setBase_time] = useState('');
    const [base_date, setBase_date] = useState('');
    const [beach_num, setBeach_num] = useState('') ;

    const moveUrl = useNavigate();

    const forecatHandler = async (base_time, base_date, beach_num) => {
        console.log("debug >>>> forecastHandler")
        const data = { base_time : base_time, base_date: base_date, beach_num: beach_num} ;
        // 예외처리
        try {
            // http://ip:port/forecast/getData?base_time=base_time ...  get방식일 때는 param으로 넘어감
            const response = await api.get("forecast/getData",
                    {params : data}) ;  // requestParam으로 바인딩하거나 바로 DTO로 바인딩
            console.log("response >>>>>> " , response);
            moveUrl("/list", {state : response.data}) ;
        } 
        catch(e) {
            

        } ; 
    }

    
    return (
        <div>
            <input  type="text"
                placeholder="예보시간"
                value={base_time}
                onChange={ (e) => setBase_time(e.target.value) } /> <br/>
        <input  type="text"
                placeholder="예보날짜"
                value={base_date}
                onChange={ (e) => setBase_date(e.target.value)} /> <br/>
         <input  type="text"
                placeholder="해변번호"
                value={beach_num}
                onChange={ (e) => setBeach_num(e.target.value) } />
        <button onClick={(e) => forecatHandler(base_time, base_date, beach_num) }> Login </button>
        </div>
    )
}

export default ForecastPage ;