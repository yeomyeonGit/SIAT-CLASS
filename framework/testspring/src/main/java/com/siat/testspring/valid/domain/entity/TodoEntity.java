package com.siat.testspring.valid.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/*
트랜스퍼의 역할을 하면 안됨(DTO)
JPA에 의해 테이블과 매핑되는 역할
 */
 
 // DDL도 가능함
 // 기본키로 테이블을 가져옴

// @Table(todo_entity) 
@Entity(name = "jpa_todo_entity")  // 이름을 다르게 테이블 생성
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {
    
    @Id   // 기본키 지정
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // 숫자 자동생성, 서로 다른 값으로
    private int seq ;

    @Column(name = "title")
    private String title ;

    @Column(name = "content")
    private String content ;

    @Column(name = "phone")
    private String phone ;

    @Column(name = "start_date") // 테이블상 컬럼명
    private String startDate ;

    @Column(name = "end_date")
    private String endDate ;

    @Column(name = "status")
    private String status ;

    @Column(name = "priority")
    private int    priority ;
    
}
