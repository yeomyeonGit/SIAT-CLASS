import siat.study.guess.GuessGameApp;

public class GuessGameAppMain {
    public static void main(String[] args) {
        int answer = GuessGameApp.generatorNan() ;     
        System.out.println("정답 : "+answer); 

        GuessGameApp app = GuessGameApp.builder().build();
        String result = app.gameFor(answer);
        System.out.println(result);
    }
}
