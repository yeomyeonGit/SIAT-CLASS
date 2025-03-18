import java.util.List;

import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoInsertController;
import todo.ctrl.TodoReadController;
import todo.ctrl.TodoSelectController;
import todo.ctrl.TodoUpdateController;
import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class TodoAppMain {
    public static void main(String[] args) {
        TodoRequestDTO request = TodoRequestDTO.builder()
                                                .title("씨앗 키우기")
                                                .content("잘~~")
                                                .startDate("2025-03-17")
                                                .endDate("2025-03-21")
                                                .priority(3)
                                                .build() ;
        
        // Quiz
        // 사용자로부터 입력받은 데이터를 TodoInsertController에 전달하여
        // TodoService(insertService) -> TodoDAO(insertDao) 작업을 수행하고
        // 실행 결과를 반환 받는다.

        // Main -> Controller로 객체 생성해서 데이터 전달
        TodoInsertController insertCntrl = new TodoInsertController() ;
        int insertFlag = insertCntrl.insertCtrl(request) ;
        System.out.println(insertFlag);

        // Quiz (상세보기)
        // 사용자로부터 입력받은 키를 TodoReadController(selectTodo) 전달하여
        // TodoService(selectService) -> TodoDAO(selectDao) 작업을 수행하고
        // 실행 결과(TodoResponseDTO)를 반환받는다

        TodoReadController readCtrl = new TodoReadController() ;
        TodoResponseDTO response01 = readCtrl.selectTodo(1) ;
        System.out.println( response01 );

        // 삭제
        TodoDeleteController deleteCtrl = new TodoDeleteController() ;
        int deleteFlag = deleteCtrl.deleteCntrl(1) ; 
        System.out.println( deleteFlag );

        TodoUpdateController updateCntrl = new TodoUpdateController() ;
        int updateFlag = updateCntrl.updateCntrl(request) ;
        System.out.println( updateFlag );

        TodoSelectController selectCtrl = new TodoSelectController() ;
        List<TodoResponseDTO> selectLst = selectCtrl.selectCntrl() ;
        System.out.println( selectLst );
        for (TodoResponseDTO dto : selectLst) {
            System.out.println( dto );
        }
    }
}
