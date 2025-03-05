package siat.study.guess;

import java.util.Scanner;

import lombok.Builder;

@Builder
public class GuessGameApp {

    private int answer;

    public static int generatorNan() {
        int answer = (int) ( Math.random() * 100 ) + 1;
        return answer;
    }

    /*
    기회가 10회
    - 매개변수로 정답을 전달받고
    - 반환값으로
    - 성공) **번만에 정답을 맞췄습니다.
    - 실패) 10번의 기회를 모두 쓰셨습니다
     */

     public String gameFor(int answer) {
        // boolean isFlag = true;
        boolean isFlag = false;
        int cnt = 0;
        String msg = null ;
        Scanner scan = new Scanner(System.in) ;
        

        for (int i = 0; i < 10 ; i++ ) {
            
            cnt++ ;
            System.out.println("숫자를 맞춰 보세요!");
            
            int myAnswer = scan.nextInt();
            if (answer > myAnswer) {
                System.out.println(">> Up");
            }
            else if (answer < myAnswer){
                System.out.println(">> Down");

            // }else if (answer == myAnswer) {
            //     msg = i+"번 만에 정답을 맞추셨습니다" ;
            //     break ;
            }else {
                isFlag = true ;
                // msg = cnt+"번 만에 성공" ;
                break ;
                
            }
            
        }

        if (isFlag == true) {
            msg = cnt+"번 만에 성공" ;
        }else {
            msg = "10회의 기회를 모두 실패하셨습니다" ;
        }

        // if (msg == null){ 
        //     msg = "10번의 기회를 모두 쓰셨습니다" ;
        // }

        return msg ;
     }

     public String gameWhile(int answer) {
        String msg = null;
        int cnt = 0 ;
        System.out.println("숫자를 맞춰 보세요!");
        Scanner scan = new Scanner(System.in) ;
        
        while (cnt < 10) {
            int myAnswer = scan.nextInt();
            cnt++ ;
            if (answer > myAnswer) {
                System.out.println(">>> Up");
            } else if (answer < myAnswer) {
                System.out.println(">>> down");
            } else {
                msg = cnt+"회 만에 성공";
                break ;
            }

        if (msg == null) {
            msg = "10회의 기회를 모두 실패하셨습니다" ;
        }
        }
        return msg ;
     }

     public String gameDoWhile(int answer) {
        String msg = null;
        int cnt = 0 ;
        System.out.println("숫자를 맞춰 보세요!");
        Scanner scan = new Scanner(System.in) ;

        do {
            int myAnswer = scan.nextInt();
            cnt++ ;
            if (answer > myAnswer) {
                System.out.println(">>> Up");
            } else if (answer < myAnswer) {
                System.out.println(">>> down");
            } else {
                msg = cnt+"회 만에 성공";
                break ;
        }

        } while (cnt < 10) ;

        if (msg == null) {
            System.out.println("10회의 기회를 모두 실패하셨습니다");
        }
        return msg ;
     }
    
    
}
