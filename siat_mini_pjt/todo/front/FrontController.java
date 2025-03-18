package todo.front;

import java.util.List;

import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoInsertController;
import todo.ctrl.TodoSelectController;
import todo.ctrl.TodoUpdateController;
import todo.factory.BeanFactory;
import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class FrontController {

    private BeanFactory factory ; 
    public FrontController() {
        factory = BeanFactory.getInstance() ;
    }

    // 1: 전체보기, 2: 입력, 3: 수정, 4: 삭제
    public List<TodoResponseDTO> list() {
        System.out.println(" >>> FrontController list");
        TodoSelectController selectCtrl = (TodoSelectController) factory.getCtrl("list") ;
        List<TodoResponseDTO> list = selectCtrl.selectCntrl() ;

        return list ;
    }

    public int register(String title, String content, String startDate, 
                                            String endDate, int priority) {
        System.out.println(" >>> FrontController register");
        TodoInsertController insertCtrl = (TodoInsertController) factory.getCtrl("register") ;
        TodoRequestDTO request = TodoRequestDTO.builder()
                                                .title(title)
                                                .content(content)
                                                .startDate(startDate)
                                                .endDate(endDate)
                                                .priority(priority)
                                                .build() ;
        int regiNum = insertCtrl.insertCtrl(request) ;
        return regiNum ;

    }

    public int update(int seq, String title, String content, String startDate,
                                                String endDate, int priority) {
        System.out.println(">>> FrontController update");
        TodoUpdateController updateCtrl = (TodoUpdateController) factory.getCtrl("update") ;
        TodoRequestDTO request = TodoRequestDTO.builder()
                                                .seq(seq)
                                                .title(title)
                                                .content(content)
                                                .startDate(startDate)
                                                .endDate(endDate)
                                                .priority(seq)
                                                .build() ;
        int upNum = updateCtrl.updateCntrl(request) ;
        return upNum ;

    }

    public int delete(int seq) {
        System.out.println(" >>> FrontController delete");
        TodoDeleteController deleteCntrl = (TodoDeleteController) factory.getCtrl("delete") ;
        int delNum = deleteCntrl.deleteCntrl(seq) ;
        return delNum ;
        

    }
}
