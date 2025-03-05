package siat.study.machine;

import java.util.Scanner;

import lombok.Builder;

@Builder
public class VendingMachineApp {

    /*  private VendingMachineApp() {
        빌더 패턴을 쓰면 외부에서 생성자 접근이 불가능
     } */
    
    public static final int COKE = 1800;
    public static int WATER = 800;
    public static final int VITAMIN = 2500;

    private int inputMoney ;
    private int choiceNum ;
    

    
    // type = if, switch
    public void init(String type) {  // init - 초기화
        switch(type) {
            case "if" :
                menuIf();
                break ;
            case "switch" :
                menuSwitch();
                break ;
            default :
                System.out.println("정확한 타입을 입력하세요. 프로그램을 종료합니다");
                System.out.println(0);


        }
    }

    
    public void menuIf() {

        menu();
        
        
        /* 조건 판단 및 잔액 반환을 고려
        - 선택한 메뉴와 금액을 판단하여 조건 처리
        - 잔액은 천원짜리, 오백원짜리, 백원짜리로 나누어서 생각
        - 반환 금액 출력
         * 
        */

        if (choiceNum == 1 && inputMoney >= COKE) {
            inputMoney -= COKE ;
        
        }
        else if (choiceNum == 2 && inputMoney >= WATER) {
            inputMoney -= WATER ;
                
        }


        else if (choiceNum == 3 && (inputMoney >= VITAMIN)) {
            inputMoney -= VITAMIN ;
                
        }
            
        else {
            System.out.println("잔돈이 부족합니다");
        }

        System.out.println("잔돈을 반환합니다 : " + inputMoney + "원");
        System.out.printf("천원: %d장, 오백원: %d개, 백원: %d개",
                        (inputMoney/1000), ((inputMoney%1000)/500), (((inputMoney%1000)%500)/100)
                        );

        
    }
        
        
    
    public void menuSwitch() {
        System.out.println("SWITCH Ver Vending Menu");
        int price =0 ;

        menu();
        
        switch (choiceNum) {
            case 1:
                price = COKE ;  
                break;
            
            case 2:
                price = WATER ;  
                break;
        
            case 3:
                price = VITAMIN ;  
                break;
        }
        if (inputMoney < price) {
            System.out.println("금액이 부족합니다");
        }
        else {
            inputMoney -= price ;
        }

        System.out.println("잔돈을 반환합니다 : " + inputMoney + "원");
        System.out.printf("천원: %d장, 오백원: %d개, 백원: %d개",
                        (inputMoney/1000), ((inputMoney%1000)/500), (((inputMoney%1000)%500)/100)
                        );


    }


    public void menu() {
        System.out.println("IF Ver Vending Menu");
        System.out.println("메뉴를 고르세요");
        System.out.println("1. 콜라(1800) 2. 생수(800) 3.비타민워터(2500) ");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("원하시는 음료 번호를 입력하세요");
        choiceNum = scan.nextInt();
        System.out.println("투입구에 돈을 넣어주세요");
        inputMoney = scan.nextInt();

    }

    
}
