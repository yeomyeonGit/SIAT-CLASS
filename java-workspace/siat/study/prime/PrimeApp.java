package siat.study.prime;
import java.util.Scanner;
import lombok.Builder;


@Builder
public class PrimeApp {
    /*
    소수란 1과 자기 자신으로만 나누어지는 수
    0, 1은 소수가 아니다
    어떤 숫자가 소수인지를 판단하려면 2~ 입력된 숫자까지 차례대로 나누어보고
    나머지가 0인 경우가 한번도 없으면 그 수는 소수
    즉 N보다 작은 자연수들로 나누어지는 방식
    */

    public String primeNumber() {
        String result = null;
        boolean isFlag = false ;
        System.out.println("소수 판별을 위해서 숫자를 입력하세요");
        Scanner scan = new Scanner(System.in) ;
        int number = scan.nextInt() ;

        if (number < 2) {
            return number+"는 소수가 아닙니다" ;
        }
        if (number == 2) {
            return number+"는 소수입니다" ;
        }

        for (int i = 2 ; i < number; i++) {
            if(number % i == 0) {
                isFlag = true ;
                break ;

            }
        }

    result = (isFlag == true) ? number+"는 소수가 아닙니다" : number+"는 소수입니다" ;
    return result;
    }

    
}
