package com.review.testreview.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.testreview.test.dao.TestDao;

@Service
public class TestService {
    
    @Autowired
    private TestDao testDao ;

    public void testService() {
        System.out.println("debug >>> service TestService");
        testDao.testRow() ;
    }

    
}
