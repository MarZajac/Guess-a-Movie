import java.io.File;
import java.util.Scanner;


public class GuessAMovie {
    private static char[] password;
    private static String passwordMovie;

    public static void main(String [] args) throws Exception {
        //Lista filmów
        String [] lista = {"the shawshank redemption", "the godfather", "the dark knight", "schindler's list", "pulp fiction", "the lord of the rings", "the good the bad and the ugly", "fight club", "the lord of the rings", "forrest gump", "star wars", "inception", "the lord of the rings", "the matrix", "samurai", "star wars", "city of god", "the silence of the lambs", "batman begins", "die hard", "chinatown", "room", "dunkirk", "fargo","no country for old men"};

        //File file = new File("movie.txt");
        //Scanner scanner = new Scanner(file);

            double x = Math.random()*lista.length;
            int y = (int) x;
            System.out.println("Try to guess the movie title by entering single letters. You have 10 chances");

        password = new char[lista[y].length()];
        passwordMovie = new String(lista[y]);

        int win = 0;
        for (int j=0; j<lista[y].length(); j++) {

            if(passwordMovie.charAt(j) != ' '){
            password[j] = '_';
            } else {
                win++;
            }

        }
        int lives = 10;

        while (lives>0) {
            System.out.println(password);
            if (win == passwordMovie.length()){
                System.out.println("You Won!!!");
                break;
            }

            Scanner scanner = new Scanner(System.in);

            char guess = scanner.next().charAt(0);

           // System.out.println(guess);

            int miss = 0;
            for (int j = 0; j < lista[y].length(); j++) {

                if (guess == passwordMovie.charAt(j) && password[j] == '_') {
                    password[j] = guess;
                    win++;
                } else if (guess == passwordMovie.charAt(j)) {
                    System.out.println("The letter you have already entered. Try another one.");
                } else {
                        miss++;
                }

            }
            if (miss == passwordMovie.length()) {
                lives--;
                System.out.println("Try again. You still have " + lives+ " changes.");
                miss = 0;
            } else {
                miss = 0;
            }
        }
        if (lives == 0) {
            System.out.println("You lose. Game Over!");
            System.out.println("The password is: " +passwordMovie);
        }
    }
}
