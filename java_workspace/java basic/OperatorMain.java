public class OperatorMain {
    public static void main(String[] args) {
        OperatorApp obj = new OperatorApp(); 
        obj.example01();
        ////////////
        String returnMsg = obj.example02("red", "green") ; 
        System.out.println("result = "+returnMsg); 
        String oddEvenMsg = obj.example03(10) ; 
        System.out.println("result = "+oddEvenMsg); 
        boolean returnFlag = obj.example04(90);
        String msg = (returnFlag == true) ? "사이값확인" : "벗어남" ; 
        System.out.println(msg); 
    }    
}
