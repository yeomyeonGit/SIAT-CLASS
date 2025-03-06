package siat.study.control;

public class ControlApp {
    /*
    조건식)
    A 또는 B 를 행위를 기대할 수 있는 것
    if(조건식) {
        조건에 대한 값이 true일 때 수행하는 블럭
    } else {
        조건에 대한 값이 false일 때 수행하는 블럭
    }
    switch(값) {
        case 값 : 
            구현
            break ;
        default : 
            구현
    }
    */

    /*
    조건) 매개변수의 값이 1 ~ 3 
    조건) 1 : 금도끼 , 2 : 은도끼 , 3 : 쇠도끼
    조건) 나무꾼이 제 도끼는 1번입니다라고 한다면? -> '거짓말을 하는구나' 메시지를 반환
    조건) 나무꾼이 제 도끼는 2번입니다라고 한다면? -> '또 거짓말을 하는구나' 메시지를 반환
    조건) 나무꾼이 제 도끼는 3번입니다라고 한다면? -> '정직하구나 너에게 모든 도기를 주겠다' 메시지를 반환
    */
    public String woodMan(int number) {
        String msg = null ; 
        if( number >= 1 && number <=3 ) {
            System.out.println("산신령이 나타났습니다. ^*^") ;
            if( number == 1) {
                msg = "거짓말을 하는구나" ; 
            } else if( number == 2) {
                msg = "또 거짓말을 하는구나" ; 
            } else {
                msg = "정직하구나 너에게 모든 도끼를 주겠다" ; 
            }
            System.out.println("산신령이 연못으로 사라졌다. ^*^") ;
        } else {
            msg = "죽을래~~" ; 
        }
        return msg ;
    }

    public String woodMan2(int number) {
        String msg = null ; 
        if( number >= 1 && number <=3 ) {
            System.out.println("산신령이 나타났습니다. ^*^") ;
            
            switch(number) {
                case  1 :
                    msg = "거짓말을 하는구나" ; 
                    break;
                case  2 :
                    msg = "또 거짓말을 하는구나" ; 
                    break;
                case  3 :
                    msg = "정직하구나 너에게 모든 도끼를 주겠다" ; 
                    break;
                default :
                    break ; 
            }

            System.out.println("산신령이 연못으로 사라졌다. ^*^") ;
        } else {
            msg = "죽을래~~" ; 
        }
        return msg ;
    }

    /*
    Quiz)
    paramter    : kor, eng, math 
    return type : String
    method name : passOrNonpass 
    합격의 조건)
    - 세 과목의 점수가 각각 40점이상이면서
    - 평균 60점 이상이면 합격
    - 아니면 불합격
    */
    public String passOrNonpass(int kor, int eng, int math) {
        String result = null ; 
        double avg = (kor+eng+math) / 3 ;  
        System.out.println("debug >>>> avg , "+avg); 
        if( kor >= 40 && eng >= 40 && math >=40 && avg >= 60 ) {
            result = "합격" ;
        } else {
            if(avg < 60) {
                result = "평균 점수 미달로 불합격" ; 
            } 
            if(kor < 40) {
                result = "국어 점수 미달로 불합격" ; 
            }
            if(eng < 40) {
                result = "영어 점수 미달로 불합격" ; 
            }
            if(math < 40) {
                result = "수학 점수 미달로 불합격" ; 
            }
        }
        return result ;
    }

    // 사칙연산 메서드 정의 
    // +, -, *, /
    public double calc(int x , char oper, int y) {
        double result = 0.0 ; 
        switch(oper) {
            case '+' :
                result = x + y ; 
                break ;
            case '-' :
                result = x - y ; 
                break ;
            case '*' :
                result = x * y ; 
                break ;
            case '/' :
                result = x / y ; 
                break ;
        }
        return result ; 
    }
}
