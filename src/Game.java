import java.util.*;

public class Game {
    public static void main(String[] args) {
        int lives = 6;
        ArrayList<String> wordsList = new ArrayList<>(List.of("elephant", "programming", "advanced",
                "lawyer", "corupt", "masculine", "dictionary", "nightmare", "friendly", "ladder", "haircut",
                "relationship", "partner", "negotiation"));
        Random rnd = new Random();
        int index = rnd.nextInt(wordsList.size());
        System.out.println("Welcome to Hangman!");
        String hiddenWord = wordsList.get(index);
        char[] stars = new char[hiddenWord.length()];
//        for (int i = 0; i < stars.length; i++) {
//            stars[i] = '*';
//        }
        Arrays.fill(stars, '*');
        System.out.println("Today's word is " + String.valueOf(stars));
        Scanner sc = new Scanner(System.in);
        while (true) {
            boolean isLetterGuessed = false;
            System.out.println("Guess a letter!");
            char guessedLetter = sc.next().charAt(0);
            for (int i = 0; i < hiddenWord.length(); i++) {
                if (guessedLetter == hiddenWord.charAt(i)) {
                    stars[i] = guessedLetter;
                    isLetterGuessed = true;
                }
            }
            if (!isLetterGuessed) {
                System.out.println("Wrong letter!");
                lives--;
            }
            if (lives == 0){
                System.out.println("You're hanged, loser!");
                break;
            }
            System.out.println(stars);
            if (!String.valueOf(stars).contains("*")){
                System.out.println("Congrats, you guessed!");
                break;
            }
        }
    }
}
