import siat.study.prime.PrimeApp;

public class PrimeAppMain {
    public static void main(String[] args) {
        PrimeApp app = PrimeApp.builder().build() ; 
        String result = app.primeNumber() ;
        System.out.println(result);
    }
}
