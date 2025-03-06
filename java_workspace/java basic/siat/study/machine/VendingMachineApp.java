package siat.study.machine;

import java.util.Scanner;

import lombok.Builder;

@Builder
public class VendingMachineApp {

    // 콜라, 물, 비타민음료 변수정의 
    public static final int COLA    = 800 ; 
    public static final int WATER   = 500 ; 
    public static final int VITAMIN = 1500 ; 

    // 지역변수의 문제점을 해결하기 위해서 전역으로 선언 
    private int choiceNum , inputMoney ; 

    // type = if, switch
    public void init(String type) {
        switch(type) {
            case "if" :
                menuIf();
                break ;
            case "switch" :
                menuSwitch();
                break ;
            default :
                System.out.println("정확한 타입을 입력하세요.. 프로그램을 종료합니다.");
                System.exit(0);
        }
    }

    public void menuIf() {
        System.out.println(">>>> IF Ver Vending Menu <<<<");
        menu() ;
        /*
        조건판단 및 잔액반환을 생각 
        - 선택한 메뉴와 금액을 판단하여 조건
        - 잔액은 천원짜리, 오백원짜리, 백원짜리로 나누어서 생각 
        - 반환금액 출력 
        */
        if( choiceNum == 1 && inputMoney >= COLA) {
            inputMoney -= COLA ; 
        } else if(choiceNum == 2 && inputMoney >= WATER) {
            inputMoney -= WATER ; 
        } else if(choiceNum == 3 && inputMoney >= VITAMIN) {
            inputMoney -= VITAMIN ; 
        } else {
            System.out.println("금액이 부족합니다 ^*^");
        }
        System.out.println("반환금액 : "+inputMoney);
        System.out.printf("천원 : %d장, 오백원 : %d개, 백원 : %d개" ,
                        (inputMoney/1000),
                        (inputMoney%1000)/500,
                        ((inputMoney%1000)%500)/100);
    }
    public void menuSwitch() {
        System.out.println(">>>> SWITCH Ver Vending Menu <<<<");
        menu() ;
        /*
        조건판단 및 잔액반환을 생각 
        - 선택한 메뉴와 금액을 판단하여 조건
        - 잔액은 천원짜리, 오백원짜리, 백원짜리로 나누어서 생각 
        - 반환금액 출력 
        */
        int price =  0 ;
        switch(choiceNum) {
            case 1 : 
                price = COLA ; 
                break;
            case 2 : 
                price = WATER ; 
                break;
            case 3 :
                price = VITAMIN ; 
                break;
        }
        if(inputMoney < price) {
            System.out.println("금액이 부족합니다 ^*^");
        } else {
            inputMoney -= price ;
        }
        
        System.out.println("반환금액 : "+inputMoney);
        System.out.printf("천원 : %d장, 오백원 : %d개, 백원 : %d개" ,
                        (inputMoney/1000),
                        (inputMoney%1000)/500,
                        ((inputMoney%1000)%500)/100);
    }

    private void menu() {
        System.out.println("메뉴를 고르세요");
        System.out.println("1. 콜라(800) 2. 생수(500) 3. 비타민워터(1500)"); 
        
        Scanner scan = new Scanner(System.in);
        System.out.print("원하시는 음료를 선택하세요 : ");
        choiceNum  = scan.nextInt() ; 
        System.out.print("투입구에 돈을 넣어주세요 : ");
        inputMoney = scan.nextInt() ; 
    }

}
