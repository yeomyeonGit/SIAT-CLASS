package com.siat.testspring.test.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter 
public class TodoResponseDTO {
    private int     seq ; 
    private String  title ;
    private String  content ;
    private Date    startDate ;
    private int     check ;   // 사라져야 하는데 기존 코드에 오류 생길 수 있으니까
    private String  status ;  // 이걸 대신해서 추가
    private Date    endDate ;
    private int     priority ;
}
