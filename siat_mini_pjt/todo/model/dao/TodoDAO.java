/*
DAO가 있어야 DB에 접근 가능.
DB에 요청하는 것이기 때문에, 매개변수로 RequestDTO에서 받은 것을 전달받음
 */

 package todo.model.dao ;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    // 전체보기
    public List<TodoResponseDTO> selectRow() {
        System.out.println(">>>> dao selectRow");
        return list ;
    }

    // 삭제
    public int deleteRow(int seq) {
        System.out.println(">>> dao deleteRow");
        int flag = 0 ;
        for (int idx = 0 ; idx < list.size() ; idx++) {
            if (list.get(idx).getSeq() == seq) {
                list.remove(idx) ;
                flag = 1 ;
            }
        }
        return flag ;
    }

    // 수정
    public int updateRow(Map<String, Object> map) {
        System.out.println(">>> dao updateRow");
        int flag = 0 ;
        for (int idx = 0 ; idx < list.size() ; idx++) {
            if (list.get(idx).getSeq() == (Integer) (map.get("seq"))) {
                list.get(idx).setContent((String) map.get("content"));
                list.get(idx).setCheck((Integer) map.get("check"));
                flag = 1 ;
            }
        }
        return flag ;
    }

    // 상세보기: 결과를 배열에 담아야 함
    public Optional<TodoResponseDTO> readDetailRow(int seq) {
        System.out.println(">>> dao selectRow");
        Optional<TodoResponseDTO> response = Optional.empty() ;
        for (int idx = 0 ; idx < list.size() ; idx++) {
            if (list.get(idx).getSeq() == seq) {
                response = Optional.of(list.get(idx)) ;
            }
        }return response ;
        
    }

}
