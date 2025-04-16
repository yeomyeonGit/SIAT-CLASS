package com.siat.testspring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.siat.testspring.test.dao.TestMapper;
import com.siat.testspring.test.model.dto.TodoRequestDTO;
import com.siat.testspring.test.model.dto.TodoResponseDTO;

@SpringBootTest
public class MybatisApp {

    @Autowired
    private TestMapper testMapper ;

    @Test
    public void insertTest() {
        System.out.println("debug >>> insert test");
        TodoRequestDTO request = TodoRequestDTO.builder()
                                    .title("오늘은 힘든 날")
                                    .content("말같지 않은 말 하지 마라")
                                    .priority(10)
                                    .build();
        
        int flag = testMapper.insertRow(request) ;
        System.out.println("debug >>>>>>>>>> flag: " + flag);
    }

    @Test
    public void selectTest() {
        List<TodoResponseDTO> list = testMapper.selectRow() ;
        System.out.println("debg >>> list size: " + list.size());

        for (TodoResponseDTO response : list) {
            System.out.println(response);
        }
    
    }

    @Test
    public void updateTest() {
        System.out.println("debug >>>>>> update test");
        Map<String, Object> map = new HashMap<>() ;
        map.put("seq", 33) ;
        map.put("content", "우!아!아!우!가!구!고!갸!~") ;
        map.put("status", "Y") ;
        int flag = testMapper.updateRow(map) ;

        System.out.println("debug >>>>> flag: "+ flag);

    }

    @Test
    public void deleteTest() {
        System.out.println("debug >>>>>> update test");
        
        int flag = testMapper.deleteRow(32) ;

        System.out.println("debug >>>>> flag: "+ flag);

    }

    @Test
    public void readTest() {
        System.out.println("debug >>>>>> update test");
        
        TodoResponseDTO response = testMapper.readRow(15) ;
        System.out.println("debug >>>>> readRow: "+ response);

    }


}
