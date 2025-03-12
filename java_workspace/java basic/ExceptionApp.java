import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionApp {

    public void printAry(String [] ary) {
        System.out.println(">>> ary print start");
        try {
            for(int idx=0 ; idx <= ary.length ; idx++) {
                System.out.println( ary[idx] ); 
            }
            System.out.println(">>> inner try");
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(); 
        }
        System.out.println(">>> ary print end");
    }

    public String inputStr() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ; 
        System.out.print("데이터를 입력하세요 : ");
        String data = null ; 
        // try{
            data = br.readLine() ; 
        // } catch(IOException e) {
        //    e.printStackTrace();
        // }
        return data ;
    }

    public void first(int x) throws Exception {
        System.out.println(">>> first start");
        second(x);
        System.out.println(">>> first end");
    }
    public void second(int x) {
        System.out.println(">>> second start");
        try {
            third(x);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(">>> second end");
    }
    public void third(int x) throws Exception{
        System.out.println(">>> third start");
        try {
            if( x < 0 ) {
                throw new Exception("양수를 입력하세요"); 
            }
        } finally {
            System.out.println(">>> third end");
        }
        
    }



}
