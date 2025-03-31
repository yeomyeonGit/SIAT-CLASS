import java.util.HashMap;

import todo.model.domain.TodoRequestDTO;

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
        
        HashMap map = new HashMap() ;
        map.put("content", "점심 메뉴는 규동") ;
        map.put("status", "Y") ;
        map.put("seq", 2) ;

        int updateFlag = dao.updateRow(map) ;
        if ( updateFlag != 0 ) {
            System.out.println("1 row update ok") ;
        } else {
            System.out.println("1 row update fail") ;
        }      
    }
    
}
