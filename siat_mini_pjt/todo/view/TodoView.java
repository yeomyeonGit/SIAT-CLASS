package todo.view;

import java.util.List;
import java.util.Scanner;

import todo.front.FrontController;
import todo.model.domain.TodoResponseDTO;

public class TodoView {
    private FrontController front ;
    Scanner scan = new Scanner(System.in) ;
    public TodoView() {
        front = new FrontController() ;
    }

    // cf. injection

    public void nemu() {
        while(true) {
            System.out.println(">>> Todo Service <<<");
            System.out.println("1. 목록 보기 | 2. 작성 | 3. 수정 | 4. 삭제 | 99. 종료");
            System.out.println("원하시는 번호를 선택하세요: ");
            Scanner scan = new Scanner(System.in) ;
            int number = scan.nextInt();
            switch (number) {
                case 1:
                    list(); break ;
                case 2:
                    register() ; break ;
                case 3:
                    update(); break ;
                case 4:
                    delete(); break ;
                
                case 99:
                    System.out.println("시스템을 종료하시겠습니까?(y/n)");
                    System.exit(0);
            }    
        }
        

    }
    public void list() {
        List<TodoResponseDTO> list = front.list() ;
        System.out.println(list);
    }

    public void register() {   // 입력을 하고 frontCtrl 객체를 생성해 여기에 매개변수로 전달
        System.out.println(">>> Todo Register <<<");
        
        System.out.println("제목: ");
        String title = scan.nextLine() ;

        System.out.println("내용: ");
        String content = scan.nextLine() ;

        System.out.println("시작일: ");
        String startDate = scan.nextLine() ;

        System.out.println("종료일: ");
        String endDate = scan.nextLine() ;

        System.out.println("우선순위: ");
        int priority = scan.nextInt() ;

        int regiNum = front.register(title, content, startDate, endDate, priority) ;   // front를 back으로 넘겨주는 부분
        System.out.println(regiNum); ;
    }

    public void update() {
        System.out.println("수정할 게시글 번호: ");
        int seq = scan.nextInt() ;
        scan.nextLine();

        System.out.println("제목 수정: ");
        String title = scan.next() ;
        

        System.out.println("내용 수정: ");
        String content = scan.next() ;
        

        System.out.println("시작일 수정: ");
        String startDate = scan.next() ;
        

        System.out.println("종료일 수정: ");
        String endDate = scan.next() ;
        

        System.out.println("우선순위 수정: ");
        int priority = scan.nextInt() ;
        

        int upNum = front.update(seq, title, content, startDate, endDate, priority) ;
        System.out.println(upNum);
        scan.nextLine();
    }

    public void delete() {

        System.out.println("삭제할 게시글 번호: ");
        int seq = scan.nextInt() ;

        int delNum = front.delete(seq) ;
        System.out.println(delNum); ;
    }
    
}
