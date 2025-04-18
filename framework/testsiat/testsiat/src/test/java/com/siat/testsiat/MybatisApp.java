package com.siat.testsiat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.siat.testsiat.test.dao.TestMapper;
import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;

@SpringBootTest
public class MybatisApp {
    
    @Autowired
    private TestMapper testMapper ;  

    @Test
    public void insertTest() {
        System.out.println("debug >>>>>>>>>>> insert test");
        // given 
        TodoRequestDTO request = TodoRequestDTO.builder()
                                    .title("겁나 어렵다")
                                    .content("뻥이야~~")
                                    .priority(10)
                                    .build();
        
        testMapper.insertRow(request);
        System.out.println("debug >>>> seq : "+request.getSeq()); 
        // when
        TodoResponseDTO response = testMapper.readRow(request.getSeq());
        System.out.println("debug >>>>"+response);
        // then 
        Assertions.assertEquals(request.getSeq(), 12, "정상처리");
    }

    @Test
    public void selectTest() {
        System.out.println("debug >>>>>>>>>>> select test");
        List<TodoResponseDTO> list = testMapper.selectRow() ;
        System.out.println("debug >>>>>>>>>>> list size = "+list.size());
        for(TodoResponseDTO response : list) {
            System.out.println(response); 
        }
    }

    @Test
    public void updateTest() {
        System.out.println("debug >>>>>>>>>>> update test");
        Map<String, Object> map = new HashMap<>();
        map.put("seq", 22);
        map.put("content", "수정");
        map.put("status", "Y");
        int flag = testMapper.updateRow(map);
        System.out.println("debug >>>>>>>>>>> flag : "+flag);
    }

    @Test
    public void deleteTest() {
        System.out.println("debug >>>>>>>>>>> delete test");
        int flag = testMapper.deleteRow(3);
        System.out.println("debug >>>>>>>>>>> flag : "+flag);
    }

    @Test
    public void readTest() {
        // JUnit - given when then
        System.out.println("debug >>>>>>>>>>> read test");
        // given
        Integer seq = 22 ;
        // when 
        TodoResponseDTO response = testMapper.readRow(seq);
        // then 
        System.out.println(response); 
    }
}
