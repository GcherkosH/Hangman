/**
 * Created by Gebrecherkos Alemayoh on 8/29/16.
 */
    import com.mashape.unirest.http.HttpResponse;
    import com.mashape.unirest.http.JsonNode;
    import com.mashape.unirest.http.Unirest;
    import com.mashape.unirest.http.exceptions.UnirestException;

    import org.json.*;
    import java.util.Scanner;
    import java.io.*;

public class Hangman
    {
        private  String secret;
        private double frequency;
        private Scanner sc;
        private int difficulity;

        public Hangman (){
         //  Getting  secret word from Words API
            sc = new Scanner(System.in);
            this.difficulity = sc.nextInt();
            getSecretword();
        }

        private  void getSecretword() {

            try{
                HttpResponse<JsonNode> response;
                switch(this.difficulity) {
                    case 1: response = Unirest.get("https://wordsapiv1.p.mashape.com/words/the/frequency").header("X-Mashape-Key", "1uluTAFVyamshwzx4H2LKMOnoVpqp1fhphojsnYcnQ6il802it").header("Accept", "application/json").asJson();
                            break;
                    case 2: response = Unirest.get("https://wordsapiv1.p.mashape.com/words/yesterday/frequency").header("X-Mashape-Key", "1uluTAFVyamshwzx4H2LKMOnoVpqp1fhphojsnYcnQ6il802it").header("Accept", "application/json").asJson();
                            break;
                    case 3: response = Unirest.get("https://wordsapiv1.p.mashape.com/words/afore/frequency").header("X-Mashape-Key", "1uluTAFVyamshwzx4H2LKMOnoVpqp1fhphojsnYcnQ6il802it").header("Accept", "application/json").asJson();
                    default:response = Unirest.get("https://wordsapiv1.p.mashape.com/words/the/frequency").header("X-Mashape-Key", "1uluTAFVyamshwzx4H2LKMOnoVpqp1fhphojsnYcnQ6il802it").header("Accept", "application/json").asJson();
                            break;
                }
                JSONObject obj = new JSONObject();
                obj = response.getBody().getObject();

                this.secret = obj.getString("word");
                this.frequency = obj.getJSONObject("frequency").getDouble("diversity");
            }
            catch(UnirestException e){
                System.out.println(e.getMessage());
            }
        }

        private static void printDefeat() {
            System.out.println();
            System.out.println(" Sorry you will be hanged.  ");
            System.out.println(" Do you want to play again? ");
        }

        private static void printWon() {
            System.out.println();
            System.out.println(" You WON and survived.");
            System.out.println("Do you want to play again? Hangman votes no. Leave empty to exit.");
        }

        private static void printWordLine(String word, String lettersGot) {
            boolean printDash = true;

            for (int i = 0; i < word.length(); i++) {
                printDash = true;
                for (int j = 0; j < lettersGot.length(); j++) {
                    if (lettersGot.charAt(j) == word.charAt(i)) {
                        System.out.print(word.charAt(i) + " ");
                        printDash = false;
                    }
                }
                if (printDash) {
                    System.out.print("_ ");
                }
            }

            System.out.println();
            System.out.println();
        }

        private static void printHangMan(int hangP) {
            System.out.println();

            if (hangP == 0) {
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
            }
            if (hangP == 1) {
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("|");
            }
            if (hangP == 2) {
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("|");
                System.out.println("|");
            }
            if (hangP == 3) {
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            if (hangP == 4) {
                System.out.println("");
                System.out.println("       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 5) {
                System.out.println("");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 6) {
                System.out.println("__");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 7) {
                System.out.println("____");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 8) {
                System.out.println("________");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 9) {
                System.out.println("________");
                System.out.println("|       |");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 10) {
                System.out.println("________");
                System.out.println("|       |");
                System.out.println("|       0");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 11) {
                System.out.println("________");
                System.out.println("|       |");
                System.out.println("|      \\0");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 12) {
                System.out.println("________");
                System.out.println("|       |");
                System.out.println("|      _0/");
                System.out.println("|       ");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 13) {
                System.out.println("________");
                System.out.println("|       |");
                System.out.println("|      \\0_");
                System.out.println("|       |");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 14) {
                System.out.println("________");
                System.out.println("|       |");
                System.out.println("|      _0/");
                System.out.println("|       |_");
                System.out.println("|       ");
                System.out.println("|");
            }
            if (hangP == 15) {
                System.out.println("________");
                System.out.println("|       |");
                System.out.println("|      \\0_ ");
                System.out.println("|       |_");
                System.out.println("|       /");
                System.out.println("|");
            }
        }

        private static int getLetters(int letters, String word, char guess) {
            for (int i = 0; i < word.length(); i++) {
                if (guess == word.charAt(i)) {
                    letters++;
                }
            }
            return letters;
        }

        private static boolean getVerdict(String word, char guess) {
            for (int i = 0; i < word.length(); i++) {
                if (guess == word.charAt(i)) {
                    return true;
                }
            }
            return false;
        }

        private char getChar() {
            char guess;
            sc = new Scanner(System.in);
            guess = sc.next().charAt(0);
            if (!(guess >= 'a' && guess <= 'z') || (guess>= 'A' && guess <= 'Z'))
            {
                System.out.println(" Please enter letters as input for the game. Numbers and punctuation marks are not valid inputs. ");
                System.exit(0);
            }
            return guess;
        }
        private static void printInstructions() {

            System.out.println("");
            System.out.println("");
            System.out.println("                HANGMAN GAME ");
            System.out.println("");
            System.out.println("                  Instructions    ");
            System.out.println(" The game is about guessing a secret word by entering a single letter at a time ");
            System.out.println(" You guess a single letter at a time. Numbers, spaces and punctuation are not allowed as input to the game.");
            System.out.println("");
            System.out.println(" The game has three levels. Choose the level you want to play. ");



        }
        private static void DifficulityLevel() {
            System.out.println(" Input: 1 to play easy level");
            System.out.println(" Input: 2 to play middle level");
            System.out.println(" Input: 3 to play difficult level");

        }
        public static void main(String[] args) throws IOException
        {
            try {

                Boolean exitGame = false;
                printInstructions();

                while (!exitGame) {

                    DifficulityLevel();
                    Hangman hangman = new Hangman();
                    // Unirest.shutdown();
                    if (hangman.secret.equals("")) {
                        exitGame = true;
                    }
                     else {
                        System.out.println();
                        System.out.println(" I have a secret word that you have to guess to rescue yourself from hanging :) ");
                        System.out.println(" Hint:  the secret word has frequency usage of  " + hangman.frequency + " in English language");

                        hangman.secret = hangman.secret.toLowerCase();
                        String alreadyGuessed = " ";
                        String lettersGot = "";
                        boolean won = false;
                        boolean dead = false;
                        boolean correct;
                        int hangP = 0;
                        int numLettersGot = 0;

                        while (!won && !dead) {

                            // Get a guess
                            System.out.println(" Enter a letter you guess is in the word.");

                            char guess;
                            guess = hangman.getChar();
                            alreadyGuessed += " " + guess;

                            System.out.println();
                            System.out.println();

                            // correct guess?
                            correct = getVerdict(hangman.secret, guess);
                            if (correct) {
                                lettersGot += guess;
                                numLettersGot = getLetters(numLettersGot, hangman.secret, guess);
                                System.out.println(" Correct guess! ");
                                System.out.println( " You have guessed the following letters so far: " + alreadyGuessed);
                                if (numLettersGot == hangman.secret.length()) {
                                    won = true;
                                }
                            } else {
                                hangP++;
                                System.out.println(" Wrong guess! ");
                                System.out.println( " You have tried these letter " + alreadyGuessed);
                                if (hangP == 15) {
                                    dead = true;
                                }
                            }
                            // progress of the game

                            printHangMan(hangP);
                            System.out.println("~~~~~~~~~~~~");
                            System.out.println();
                            printWordLine(hangman.secret, lettersGot);
                            if (dead) {
                                printDefeat();
                            } else if (won) {
                                printWon();
                            }
                        }
                    }
                }
            }

            catch (Exception e){
                System.out.println(e.getMessage());

            }
        }
}

