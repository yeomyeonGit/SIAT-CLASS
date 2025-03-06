public class VariableApp {
    public static void main(String[] args) {
        int     age = 20 ;
        double  height = 176.9 ; 
        char    gender = 'M' ; 
        String  name = "jslim" ; 
        boolean isMarriage = true ;   
        System.out.println(age);
        System.out.println(height);
        System.out.println(gender);
        System.out.println(name);
        System.out.println(isMarriage);
        //////////////////////////////////
        
        byte x = 10 , y = 10 , sum = 0 ; 
        sum = (byte)(x + y)  ;
        System.out.println("연산된 결과는 : "+sum); 

        // 자바의 캐스팅 연산자 : (타입)변수명 ; 
        char charValue = 'A' ;
        char charValue02 = 'B' ;
        System.out.println(charValue);
        System.out.println(charValue + charValue02); 
        System.out.println((char)(charValue + charValue02)); 
        System.out.println((char)97 );  
    }
}
