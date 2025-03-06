import siat.study.control.ControlApp;

public class ControlAppMain {
    public static void main(String[] args) {
        ControlApp demo = new ControlApp() ; 
        // String result = demo.woodMan2(2);
        // System.out.println(result); 

        // String result = demo.passOrNonpass(90, 35, 80);
        // System.out.println(result); 
        
        double result = demo.calc(10, '-', 10);
        System.out.println(result);
    }
}
