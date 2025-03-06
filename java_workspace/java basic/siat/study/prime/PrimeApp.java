package siat.study.prime;

import java.util.Scanner;

import lombok.Builder;

@Builder
public class PrimeApp {
    /*
    소수란? 1과 자기자신으로만 나누어지는 수 
    - 판단로직(for, if) 
    - 0, 1 은 소수가 아니다.
    - 어떤 숫자가 소수인지를 판단할려면 2 ~ 입력된숫자까지 차례대로 나누어보고
    - 나머지가 0인경우가 한번도 없으면 그 수는 소수 
    - 즉, N 보다 작은 자연수들로 나누어지는 방식 
    */
    public String primeNumber() {
        String result = null ; 
        boolean isFlag = false ;
        System.out.println("소수 판별을 위해서 숫자를 입력하세요 : ");
        Scanner scan = new Scanner(System.in) ;
        int number  = scan.nextInt() ;  
        if(number < 2) {
            return number+"는 소수가 아닙니다." ;
        } else if(number == 2) {
            return number+"는 소수입니다." ;
        }
        for(int idx=2 ; idx < number ; idx++) {
            if(idx%2 == 0) {
                isFlag = true ;
                break ;
            }
        }
        result = (isFlag == true) ? number+"는 소수가 아닙니다." : number+"는 소수입니다.";
        return result  ;
    }
}
