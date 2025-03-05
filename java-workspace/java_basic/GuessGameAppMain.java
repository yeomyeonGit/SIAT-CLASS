import siat.study.guess.GuessGameApp;

public class GuessGameAppMain {
    public static void main(String[] args) {
        int answer = GuessGameApp.generatorNan();
        System.out.println(answer);

        GuessGameApp game = GuessGameApp.builder()
                            .build() ;
        // System.out.println(game.gameFor(answer)) ;
        // System.out.println(game.gameWhile(answer)) ;
        System.out.println(game.gameDoWhile(answer));
    }
    
}
