public class OperatorMain {
    public static void main(String[] args) {
        OperatorApp opr = new OperatorApp() ;

        opr.example01();
        
        String returnMsg = opr.example02("red", "green") ;
        System.out.println("result = " + returnMsg);
    
        String oddEven = opr.example03(25) ;
        System.out.println(oddEven);

        boolean isHundred = opr.example04(-10) ;
        System.out.println(isHundred);
        String msgHundred = (isHundred == true) ? "사이값" : "사이값 아님" ;
        System.out.println(msgHundred);
    }
    
}
