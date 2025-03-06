package siat.study.guess;

import java.util.Scanner;

import lombok.Builder;

@Builder
public class GuessGameApp {

    public static int generatorNan() {
        int answer = (int)(Math.random() * 100) + 1 ; 
        return answer ; 
    }

    /*
    기회가 10회 
    - 매개변수로 정답을 전달받고
    - 반환값으로 
    -- 성공) xx번째 정답을 맞췄습니다.
    -- 실패) 10번의 기회를 모두 사용하였습니다.
    */
    public String gameFor(int answer) {
        String msg = null ; 
        boolean isFalg = false ;
        int     cnt = 0 ; 
        System.out.println("****************************");
        System.out.println("1 ~ 100 사이의 숫자를 맞춰보세요");
        System.out.println("10번의 기회가 있습니다.");
        System.out.println("게임 스타트~~~");
        System.out.println("****************************");
        for(int idx=1 ; idx <= 10 ; idx++) {
            cnt++ ; 
            System.out.print("숫자를 입력하세요 : ");
            Scanner scan = new Scanner(System.in);
            int guess = scan.nextInt() ;
            if( answer > guess ) {
                System.out.println(">> Up");
            } else if( answer < guess ) {
                System.out.println(">> Down");
            } else {
                isFalg = true ;
                break ;
            }
        }
        if(isFalg) {
            msg = cnt+"번에 맞췄습니다." ; 
        } else {
            msg = "10번의 기회를 모두 사용하였습니다.";
        }
        return msg ; 
    } 
    public String gameWhile(int answer) {
        return null ;
    }
    public String gameDoWhile(int answer) {
        return null ;
    }


}
