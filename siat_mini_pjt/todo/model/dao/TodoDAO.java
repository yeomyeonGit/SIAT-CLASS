/*
DAO가 있어야 DB에 접근 가능.
DB에 요청하는 것이기 때문에, 매개변수로 RequestDTO에서 받은 것을 전달받음
 */

 package todo.model.dao ;

import java.util.ArrayList;
import java.util.List;

import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class TodoDAO {
    private int idx ;
    private List<TodoResponseDTO> list ;

    public TodoDAO() {
        list = new ArrayList<TodoResponseDTO>() ;
        
    }

    // 입력
    public int insertRow(TodoRequestDTO request) {
        System.out.println(">>>> dao insertRow");
        TodoResponseDTO response = TodoResponseDTO.builder()
                                                 .seq(idx++)
                                                 .title(request.getTitle())
                                                 .content(request.getContent())
                                                 .check(0)
                                                 .startDate(request.getStartDate())
                                                 .endDate(request.getEndDate())
                                                 .priority(request.getPriority())
                                                 .build() ;
        list.add(response) ;
        return 1 ;
    }

    // 상세보기
    public TodoResponseDTO selectRow(int number) {
        System.out.println(">>>> dao selectRow");
        return null ;
    }

    // 삭제
    public int deleteRow(int seq) {
        System.out.println(">>> dao deleteRow");
        list.remove(seq) ;
        return 1 ;
    }

    // 수정
    public int updateRow(TodoRequestDTO request) {
        System.out.println(">>> dao updateRow");
        TodoResponseDTO response = TodoResponseDTO.builder()
                                                 .title(request.getTitle())
                                                 .content(request.getContent())
                                                 .check(0)
                                                 .startDate(request.getStartDate())
                                                 .endDate(request.getEndDate())
                                                 .priority(request.getPriority())
                                                 .build() ;
        list.set(request.getSeq(), response) ;
        return 0 ;
    }

    // 전체 보기: 결과를 배열에 담아야 함
    public List<TodoResponseDTO> selectRow() {
        System.out.println(">>> dao selectRow");
        return list ;
    }

}
