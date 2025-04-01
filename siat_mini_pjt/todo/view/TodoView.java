package todo.view;

import java.util.InputMismatchException;
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

    public void menu() {
        while(true) {
            try {
                System.out.println(">>> Todo Service <<<");
                System.out.println("1. 목록 보기 | 2. 작성 | 3. 수정 | 4. 삭제 | 5. 상세 보기 | 99. 종료");
                System.out.println("원하시는 번호를 선택하세요: ");
                Scanner scan = new Scanner(System.in) ;
                int number = scan.nextInt();
                scan.nextLine() ;

                switch (number) {
                    case 1:
                        subMenu(); break ;
                    case 2:
                        register() ; break ;
                    case 3:
                        update(); break ;
                    case 4:
                        delete(); break ;
                    case 5:
                        read(); break ;
                    
                    case 99:
                        System.out.println("시스템을 종료하시겠습니까?(y/n)");
                        String answer = scan.nextLine() ;
                        if (answer.equals("y")) {
                            System.exit(0);
                        } else if(answer.equals("n")) {
                            menu() ;
                        }
                        
                }
            } catch (Exception e) {
                e.printStackTrace();

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

        System.out.println("우선순위: ");
        int priority = scan.nextInt() ;
        scan.nextLine();

        int regiNum = front.register(title, content, priority) ;   // front를 back으로 넘겨주는 부분
        System.out.println(regiNum); ;
    }

    public void update() {
        System.out.println("수정할 게시글 번호: ");
        int seq = scan.nextInt() ;
        scan.nextLine();
        
        System.out.println("내용 수정: ");
        String content = scan.nextLine() ;
        

        System.out.println("완료 여부: ");
        String check = scan.nextLine() ;
        scan.nextLine();
        
        int upNum = front.update(seq, content, check) ;
        System.out.println(upNum);
        
    }

    public void delete() {

        System.out.println("삭제할 게시글 번호: ");
        int seq = scan.nextInt() ;
        scan.nextLine();

        int delNum = front.delete(seq) ;
        System.out.println(delNum); ;
    }

    public void read() {

        System.out.println();
        System.out.println(">>>Todo Read<<<");
        System.out.print("상세 보기할 일정 번호: ");
        int seq = scan.nextInt() ;
        scan.nextLine();
        TodoResponseDTO response = front.read(seq) ;
        System.out.println(response);

    }


    public void subMenu() {
        while(true) {

            try {
                System.out.println(">>> Todo Service SubMenu <<<");
                System.out.println("1. 상세 보기 | 2. 완료된 일정 | 3. 미완료된 일정 | 4. 상위메뉴 이동 | 5. 정렬");
                System.out.println("원하시는 번호를 선택하세요: ");
                Scanner scan = new Scanner(System.in) ;
                int number = scan.nextInt();
                switch (number) {
                    case 1:
                        list(); break;
                    case 2:
                        checkList() ; break ;
                    case 3:
                        uncheckList() ;
                        break ;
                    case 4:
                        return ;  // 상위로 돌아간다(return)
                    case 5:
                        priority() ;
                        break ;
                    
                    default:
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();

            }     

        }
    }

    public void checkList() {
        List<TodoResponseDTO> list = front.checkList() ;
        System.out.println(list);

    }

    public void uncheckList() {
        List<TodoResponseDTO> list = front.uncheckList() ;
        System.out.println(list);

    }

    public void priority() {
        List<TodoResponseDTO> list = front.priority() ;
        System.out.println(list);

    }

    
}
