package siat.study.control;

import lombok.val;

public class ControlApp {
    /*
     조건식 )
     A 또는 B 행위를 기대할 수 있는 것
     if (조건식) {
        조건에 대한 값이 true일 때 수행하는 블럭
     } else {
        조건에 대한 값이 false일 때 수행하는 블럭
      }
    switch (값) {
        case 값:   # 이 값과 정확하게 일치하면
            구현
            break ;
        default :   # 일치하지 않으면 이 블럭을 구현
            구현

           }
     */
    
     /*
      조건 ) 매개변수의 값이 1 ~ 3
      조건 ) 1: 금도끼, 2: 은도끼, 3: 쇠도끼
      조건 ) 나무꾼이 제 토끼는 1번입니다 라고 한다면? -> '거짓말을 하는구나' 메시지를 반환
      조건 ) 나무꾼이 제 토끼는 2번입니다 라고 한다면? -> '또 거짓말을 하는구나' 메시지를 반환
      조건 ) 나무꾼이 제 토끼는 3번입니다 라고 한다면? -> '정직하구나 너에게 모든 도끼를 주겠다' 메시지를 반환
      */
     public String woodMan(int n) {
        String msg = null;

        System.out.println("칠칠치 못한 것, 도끼를 찾으러 왔느냐?");
        
        if (n >= 1 && n <= 3) {
            
            if (n == 1) {
                msg = "거짓말을 하는구나";
                
            }
            else if (n == 2) {
                msg = "또 거짓말을 하는구나";
                
            }
            else {
                msg = "정직하구나 너에게 모든 도끼를 주겠다";
                
            }
        }else {
            msg = "죽을래? 똑바로 안 해?";
        }

        return msg;

     }

     public String woodMan2(int n) {
        String msg = null;
        System.out.println("칠칠치 못한 것, 도끼를 찾으러 왔느냐?");
        
        switch (n) {
            case 1:
                msg = "거짓말을 하는구나";
                break;
            case 2:
                msg = "거짓말을 하는구나";
                break;
            case 3:
                msg = "정직하구나 너에게 모든 도끼를 주겠다";
                break;
            default:
  
                break;
        }

        return msg;

     }

     /*
      Quiz 2)
      parameter: kor, eng, math (점수)
      return type: '합격' 또는 '불합격'
      method name: passOrNonpass
      합격의 조건 )
      - 세 과목의 점수가 각각 40점 이상이면서
      - 평균이 60점 이상이면 합격
      - 아니면 불합격

      */

      public String passOrNonpass(int kor, int eng, int math) {
        String result = null ;
        double avg = (kor + eng + math) / 3 ;   /* 메서드 안에서 선언 - 지역변수 */
        System.out.println("debug >>> " + avg) ;

        if (kor >= 40 && eng >= 40 && math >= 40 && avg >= 60) {
            result = "합격" ;   /* 메서드 안에서 선언 - 지역변수 */
        }
        else {
            result = "불합격" ;
            System.out.println("불합격 사유: ");
            if (avg < 60) {
                result += "평균 점수 미달 " ;
            }
            if (kor < 40) {
                result += "국어 점수 미달 " ;
            }
            if (eng < 40) {
                result += "영어 점수 미달 " ;
            }
            if (math < 40) {
                result += "수학 점수 미달 " ;
            }
        }
        
        return result;

      }

      // 사칙연산 메서드 정의
      public double calculator(int x, char oper, int y) {
        double result = 0.0;
        
        switch (oper) {   // 범위에 해당하는 값이 아니라 정확한 값에 해당해야 하기 때문에 switch문을 쓴다
            case '+':
                result = x + y ;
                break;
                // break가 없으면 해당하는 케이스부터 break가 있는 케이스까지 모두 실행된다
            
            case '-':
                result = x - y ;
                break;

            case '*':
                result = x * y ;
                break;

            case '/':
                result = x / y ;
                break;
        }
        
        return result ;

      }
    
}
