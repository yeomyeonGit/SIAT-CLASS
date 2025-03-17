/*
DAO가 있어야 DB에 접근 가능.
DB에 요청하는 것이기 때문에, 매개변수로 RequestDTO에서 받은 것을 전달받음
 */

import java.util.List;

public class TodoDAO {

    private TodoResponseDTO dto ;

    public TodoDAO() {
        dto = new TodoResponseDTO(0, null, null, null, 0, null, 0) ;
    }

    // 입력
    public int insertRow(TodoRequestDTO request) {
        System.out.println(">>>> dao insertRow");
        return 0 ;
    }

    // 상세보기
    public TodoResponseDTO selectRow(int number) {
        System.out.println(">>>> dao selectDao");
        return null ;
    }

    // 삭제
    public int deleteRow(int seq) {
        System.out.println(">>> dao deleteRow");
        return 0 ;
    }

    // 수정
    public int updateRow(TodoRequestDTO request) {
        System.out.println(">>> dao updateRow");
        return 0 ;
    }

    // 전체 보기: 결과를 배열에 담아야 함
    public List<TodoResponseDTO> selectRow() {
        System.out.println(">>> dao selectRow");
        return null ;
    }

}
