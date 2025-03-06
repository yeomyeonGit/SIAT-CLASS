package siat.study.loop;

import lombok.Builder;

/*
반복구문(for, while, do ~ while) 
- for : 반복횟수가 정의되어 있을 때
- while, do ~ while : 반복횟수가 정의되어있는 것이 아니라 어떤 상황이 올 때까지 반복
- while 반복되지 않을 수 있고
- do ~ while 무조건 한번은 반복을 수행
- break , continue 

for)
for(초기식 ; 조건식 ; 증감식) {
}
while)
초기식
while(조건식) {
    증감식 
}
do ~ while)
초기식
do {
    증감식
}while(조건식)
*/

@Builder
public class LoopApp {
    
    public int sumOneToTen() {
        int sum = 0 ; 
        for(int idx=1 ; idx <= 10 ; idx++) {
            sum = sum + idx; // sum += idx ;
        }
        return sum ; 
    }

    public String sumStartToEnd(int start , int end) {
        int sum = 0 ; 
        for(int idx=start ; idx <= end ; idx++) {
            sum = sum + idx; // sum += idx ;
        }
        return start + " ~ " + end + " 까지의 합은 = " + sum ;  
    }

    // Quiz) sumStartToEnd -> while, do ~ while 구문으로 변경
    public String sumStartToEndWhile(int start , int end) {
        int idx = start ; 
        int sum = 0 ; 
        while(idx <= end) {
            sum += idx ;
            idx++ ;
        }
        return start + " ~ " + end + " 까지의 합은 = " + sum ;  
    }
    public String sumStartToEndDoWhile(int start , int end) {
        int idx = start ; 
        int sum = 0 ;
        do {
            sum += idx ;
            idx++ ;
        }while(idx <= end) ;

        return start + " ~ " + end + " 까지의 합은 = " + sum ;  
    }

    // Quiz
    // 매개변수로 입력받은 값을 1 ~ 차례로 누적하여 합을 구하다가 
    // 입력받은 값을 넘으면 중단하고 
    // 마지막으로 더해진 값과 그 때까지의 합을 출력하고 싶다면?
    // 입력값) 100 
    // 출력예시) 14 105 
    public void loopBreak(int number) {
        int sum = 0 ; 
        int idx = 0 ;
        for(idx = 1 ; idx <= number ; idx++) {
            System.out.println("idx = "+idx);
            sum += idx ; 
            System.out.println("sum = "+sum); 
        }
        // for(idx = 1 ; idx <= number ; idx++) {
        //     if( sum > number) {
        //         break;
        //     }
        //     sum += idx ; 
        // }
        System.out.println((idx-1)+"\t"+sum);
    }

    // 1 ~ 100 사이의 난수를 발생시켜서 해당 난수까지의 합을 구한다면?
    public void sumRandom() {
        int nan = (int)( Math.random() * 100 ) + 1;
        System.out.println(nan);
        int sum = 0 ; 
        for(int idx = 1 ; idx <= nan ; idx++) {
            sum += idx ; 
        }
        System.out.println(sum); 
    }

    // 매개변수로 문자열을 입력받아서 문자 하나하나를 반복문을 이용해서 출력 
    public void popStr(String str) {
        System.out.println("debug >>>> params = "+ str);
        for(int idx=0 ; idx < str.length() ; idx++) {
            System.out.print(str.charAt(idx)+"\t");
        }
    }

    // 메서드가 클래스내에 정의된 다른 메서드를 호출 
    public void gugudanRow() {
        for(int dan = 2 ; dan <=9 ; dan++) {
            gugudanCol(dan);
        }
    }
    private void gugudanCol(int dan) {
        for(int col = 1 ; col <= 9 ; col++) {
            System.out.printf("%d * %d = %d\t", dan, col, (dan*col));
        }
        System.out.println();
    }
    public void gugudanTables() {
        for(int dan = 2 ; dan <=9 ; dan++) {
            for(int col = 1 ; col <= 9 ; col++) {
                System.out.printf("%d * %d = %d\t", dan, col, (dan*col));
            }
            System.out.println();
        }
    }

    // Quiz)
    // 이중 반복문을 이용해서 출력예시처럼 출력하시오
    /*
    출력예시)
    23456
    34567
    45678
    56789
    678910
    */
    public void printIJ() {
        for(int i=1 ; i <=5 ; i++) {
            for(int j=1 ; j <= 5 ; j++) {
                System.out.print(i+j);
            }
            System.out.println();
        }
    }


}
