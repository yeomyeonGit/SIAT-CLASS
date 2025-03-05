package siat.study.loop;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/*
반복구문 (for, while, do ~ while)
- for: 반복횟수가 정의되어 있을 때
- while, do ~ while: 반복횟수가 정의되어 있는 것이 아니라 어떤 상황이 올 때까지 반복
- while 반복되지 않을 수 있고
- do while 무조건 한번은 반복을 수행
- break, continue\

for)
for (초기식 ; 조건식 ; 증감식) {
}

while)
초기식
while (조건식) {
    증감식
}

do ~ while) do 부분을 무조건 한번은 수행한다
초기식
do {  
    증감식
} while (조건식)

 */

@Builder

public class LoopApp {
    String status ;
    public int sumOneToTen() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum ;
    }

    public int sumStarToEnd(int x, int y) {
        int sum = 0;
        for (int i = x; i <= y; i++) {
            sum += i;
        }
        return sum ;
        
    }

    public int sumStarToEndWhile(int x, int y) {
        int sum = 0;
        int i = x ;
        while (i <= y) {
            sum += i ;
            i++ ;
        }
        return sum ; 
    }

    public int sumStarToEndDo(int x, int y) {
        int i = 1 ;
        int sum = 0 ;
        do {
            sum += i ;
            i++ ;
        } while (i <= y) ;
        return sum ; 
    }

    // Quiz
    // 매개변수로 입력 받은 값을 1부터 차례로 누적하여 합을 구하다가
    // 입력 받은 값을 넘으면 중단하고
    // 마지막으로 더해진 값과 그때까지의 합을 출력하고 싶다면 ?
    // 입력값) 100
    // 출력예시) 20 104

    public void loopBreak(int number) {
        int idx = 1;
        int sum = 0;

        while (idx <= number) {
            System.out.println("debug idx >>" + idx);
            sum += idx ;

            System.out.println("debug sum >>" + sum);

            if (sum > number) {
                System.out.println(idx);
                System.out.println(sum);
                break ;
            }

            idx++ ;

        }   

    }

    // 1 ~ 100까지의 난수를 발생시켜서 해당 난수까지의 합을 구해 본다면?

    public void sumRandom() {
        int nan = (int) (Math.random() * 100) + 1;
        // Math.random(): 0.0부터 1.0 미만의 수를 발생시킴
        System.out.println(nan);
        int sum = 0 ;

        for(int idx = 1; idx <= nan; idx++) {
            sum += idx ;
        }
        System.out.println(sum);
    }

    // 매개변수로 문자열을 입력 받아서 문자 하나하나를 반복문을 이용해서 출력
    public void popStr(String str) {
        System.out.println(("debug >>> params = "+ str));
        for(int idx = 0; idx < str.length() ; idx++) {
            System.out.print(str.charAt(idx) + "\t");
        }
    }

    // 메서드가 클래스 내 정의된 다른 메서드를 호출
    public void gugudanRow() {  // 내부에 gugudanCol을 호출할 계획
        for (int dan = 2; dan <= 9; dan++) {
            gugudanCol(dan);

        }
    }

    private void gugudanCol(int dan) {
        // 외부에서 이 메서드를 호출해봤자 의미가 없어서 접근지정자를 private로 설정해 내부에서만 사용
        for (int col = 1 ; col <= 9 ; col++) {
            System.out.printf("%d * %d = %d\t", dan, col, (dan*col));
        }
        System.out.println();
    }

    public void gugudanTable() {  // 내부에 gugudanCol을 호출할 계획
        for (int dan = 2; dan <= 9; dan++) {
            for (int col = 1 ; col <= 9 ; col++) {
                System.out.printf("%d * %d = %d\t", dan, col, (dan*col));
            }
            System.out.println();
        }
    }
    
    // Quiz) 이중 반복문을 이용해서 출력예시처럼 출력하시오

    /*\
     출력예시)
     23456
     34567
     45678
     56789
     678910
     */
    public void printIJ() {
        for (int i = 1; i <= 5; i++) {
            for(int j = 1; j <= 5; j++) {
                System.out.print((i+j));
            }
            System.out.println();
        }

    }
}


// Quiz ) sumStartToEnd -> while, do ~ while 구문으로 변경

