package com.siat.testspring.test.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
    public void testRow() {
        System.out.println("debug >>> dao testRow");
    }
    
}
