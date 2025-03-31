import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class JdbcAppMain {
    public static void main(String[] args) {
        JdbcDao dao = new JdbcDao() ;
        System.out.println(">>> 입력") ;
        // TodoRequestDTO request = TodoRequestDTO.builder()
        //                         .title("jdbc")
        //                         .content("jdbc")
        //                         .priority(5)
        //                         .build();
        
        // int insertFlag = dao.insertRow(request) ;
        // if ( insertFlag != 0 ) {
        //     System.out.println("1 row insert ok") ;
        // } else {
        //     System.out.println("1 row insert fail") ;
        // }
        
        // int deleteFlag = dao.deleteRow(2) ;
        // if ( deleteFlag != 0 ) {
        //     System.out.println("1 row delete ok") ;
        // } else {
        //     System.out.println("1 row delete fail") ;
        // }
        
        // HashMap map = new HashMap() ;
        // map.put("content", "점심 메뉴는 규동") ;
        // map.put("status", "Y") ;
        // map.put("seq", 2) ;

        // int updateFlag = dao.updateRow(map) ;
        // if ( updateFlag != 0 ) {
        //     System.out.println("1 row update ok") ;
        // } else {
        //     System.out.println("1 row update fail") ;
        // } 

        System.out.println("출력") ;
        List<TodoResponseDTO> list = dao.selectRow() ;
        for(TodoResponseDTO response : list) {
            System.out.println(response) ;
        }

        // System.out.println("출력") ;
        // Optional<TodoResponseDTO> op = dao.selectRow(3) ;
        // System.out.println(op) ;
    }
    
}
