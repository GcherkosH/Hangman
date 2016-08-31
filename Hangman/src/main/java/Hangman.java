/**
 * Created by Gebrecherkos Alemayoh on 8/29/16.
 */
    import com.mashape.unirest.http.HttpResponse;
    import com.mashape.unirest.http.JsonNode;
    import com.mashape.unirest.http.Unirest;
    import com.mashape.unirest.http.exceptions.UnirestException;

    import org.apache.http.client.HttpClient;
    import org.apache.http.client.config.CookieSpecs;
    import org.apache.http.client.config.RequestConfig;
    import org.apache.http.impl.client.HttpClientBuilder;
    import org.apache.http.impl.client.HttpClients;
    import org.apache.http.impl.client.CloseableHttpClient;
    import  java.lang.SuppressWarnings;

    import org.json.*;
    import java.util.Scanner;
    import java.io.*;

public class Hangman
    {
        private  static String secret;
        private static double frequency;
        private Scanner sc;
        private static int level;
        private static String cont ="Yes";

        public Hangman (){
            sc = new Scanner(System.in);
            level = sc.nextInt();
            cont = "Yes";
                    // Getting  secret word from Words API
            getSecretword();
        }

        private  void getSecretword() {

            try{
                HttpResponse<JsonNode> response;

                /*RequestConfig customizedRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
                HttpClientBuilder customizedClientBuilder = HttpClients.custom().setDefaultRequestConfig(customizedRequestConfig);
                CloseableHttpClient client = customizedClientBuilder.build(); // customized client,*/

                switch(level) {
                    case 1: response = Unirest.get("https://wordsapiv1.p.mashape.com/words/?frequencyMin=7&random=true").header("X-Mashape-Key", "1uluTAFVyamshwzx4H2LKMOnoVpqp1fhphojsnYcnQ6il802it").header("Accept", "application/json").asJson();
                            break;
                    case 2: response = Unirest.get("https://wordsapiv1.p.mashape.com/words/?frequencyMin=3&frequencyMax=4&random=true").header("X-Mashape-Key", "1uluTAFVyamshwzx4H2LKMOnoVpqp1fhphojsnYcnQ6il802it").header("Accept", "application/json").asJson();
                            break;
                    case 3: response = Unirest.get("https://wordsapiv1.p.mashape.com/words/?frequencyMax=2&random=true").header("X-Mashape-Key", "1uluTAFVyamshwzx4H2LKMOnoVpqp1fhphojsnYcnQ6il802it").header("Accept", "application/json").asJson();
                        break;
                    default:response = Unirest.get("https://wordsapiv1.p.mashape.com/words/?hasDetails=typeOf&frequencyMax=1 &random=true").header("X-Mashape-Key", "1uluTAFVyamshwzx4H2LKMOnoVpqp1fhphojsnYcnQ6il802it").header("Accept", "application/json").asJson();
                            break;
                }
                JSONObject obj = response.getBody().getObject();
                secret = obj.getString("word");
                frequency = obj.getDouble("frequency");
            }
            catch(UnirestException e){
                System.out.println(e.getMessage());
            }
        }

        private static void Defeat() {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println(" You are hanged. Just kidding! ");
            System.out.println("The word you failed to guess is: " + secret);
            System.out.println(" Thank you for playing Hangman game. Do you want to play again? To continue enter \"Yes\" or \"No\" to quit");
            cont = sc.next();
        }

        private static void Won() {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println(" You WON and survived.");
            System.out.println();
            System.out.println(" Thank you for playing Hangman game. Do you want to play again? To continue enter \"Yes\" or \"No\" to quit ");
            cont = sc.next();
        }

        private static void pWordLine(String word, String lettersGot) {
            boolean pDash = true;
            for (int i = 0; i < word.length(); i++) {
                pDash = true;
                for (int j = 0; j < lettersGot.length(); j++) {
                    if (lettersGot.charAt(j) == word.charAt(i)) {
                        System.out.print(word.charAt(i) + " ");
                        pDash = false;
                    }
                }
                if (pDash) {
                    System.out.print("_ ");
                }
            }

            System.out.println();
            System.out.println();
        }

        private static void pHangMan(int hangC) {
            System.out.println();

            if (hangC == 0) {
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
            }
            if (hangC == 1) {
                System.out.println(" --------");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("         |");
            }
            if (hangC == 2) {
                System.out.println(" ---------");
                System.out.println("          |");
                System.out.println(" 0        |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
            }
            if (hangC == 3) {
                System.out.println(" ---------");
                System.out.println("          |");
                System.out.println(" 0        |");
                System.out.println(" |        |");
                System.out.println("          |");
                System.out.println("          |");
            }
            if (hangC == 4) {
                System.out.println(" ---------");
                System.out.println("          |");
                System.out.println(" 0        |");
                System.out.println("/|        |");
                System.out.println("          |");
                System.out.println("          |");
            }
            if (hangC == 5) {
                System.out.println(" ---------");
                System.out.println("          |");
                System.out.println(" 0        |");
                System.out.println("/|\\       |");
                System.out.println("          |");
                System.out.println("          |");
            }
            if (hangC == 6) {
                System.out.println(" ---------");
                System.out.println("          |");
                System.out.println(" 0        |");
                System.out.println("/|\\       |");
                System.out.println("/         |");
                System.out.println("          |");
            }
            if (hangC == 7) {
                System.out.println(" ---------");
                System.out.println("          |");
                System.out.println(" 0        |");
                System.out.println("/|\\       |");
                System.out.println("/ \\       |");
                System.out.println("          |");
            }
            if (hangC == 8) {
                System.out.println(" ---------");
                System.out.println(" |        |");
                System.out.println(" 0        |");
                System.out.println("/|\\       |");
                System.out.println("/ \\       |");
                System.out.println("          |");
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

        private static boolean existenceCheck(String word, char guess) {
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
            return guess;
        }
        private static void printInstructions() {

            System.out.println("");
            System.out.println("");
            System.out.println("                HANGMAN GAME ");
            System.out.println("");
            System.out.println("                Instructions    ");
            System.out.println(" The game is about guessing a secret word by entering a single letter at a time ");
            System.out.println(" You guess a single letter at a time. Numbers, spaces and punctuation are not allowed as input to the game.");
            System.out.println("");
            System.out.println(" The game has three levels. Choose the level you want to play. ");
        }
        private static void difficultyLevel() {
            System.out.println("");
            System.out.println(" Input: 1 to play easy level");
            System.out.println(" Input: 2 to play middle level");
            System.out.println(" Input: 3 to play difficult level");
            System.out.println("");
        }

        public static void main(String[] args) throws IOException
        {
            try {
                Boolean exitGame = false;
                printInstructions();

                while (!exitGame && !(cont.equalsIgnoreCase("No"))) {
                    difficultyLevel();
                    Hangman hangman = new Hangman();
                    if (secret.equals("")) {
                        exitGame = true;
                    }
                     else {
                        System.out.println();
                        System.out.println(" Here is a secret word that you have to guess to rescue yourself from hanging :) ");
                                     System.out.println("    Hint:  the secret word has frequency usage of  " + hangman.frequency + " in English language");
                        secret = secret.toLowerCase();
                        String alreadyGuessed = " ";
                        String lettersGot = "";
                        pWordLine(secret, lettersGot);

                        boolean won = false;
                        boolean dead = false;
                        boolean correct;
                        int hangC = 0;
                        int numLettersGot = 0;

                        while (!won && !dead) {
                            // Get a guess from a player
                            System.out.println(" Enter a letter you guess is in the word.");

                            char guess;
                            guess = hangman.getChar();
                            if(alreadyGuessed.indexOf(guess) >= 0 || !(guess >= 'a' && guess <= 'z') || (guess>= 'A' && guess <= 'Z') ) {
                                System.out.println(" Oops either you have repeated a letter or entered invaid input. Try other letters ");
                                System.out.println("");
                                          // prints progress of the game
                                hangC++;
                                pHangMan(hangC);
                                System.out.println("~~~~~~~~~~~~");
                                System.out.println();
                                pWordLine(secret, lettersGot);
                                if (hangC == 8) {
                                    dead = true;
                                    Defeat();
                                }
                                continue;
                            }
                            else
                                alreadyGuessed += " " + guess;

                            System.out.println();
                            System.out.println();

                            // checks correctness of guess
                            correct = existenceCheck(secret, guess);
                            if (correct) {
                                lettersGot += guess;
                                numLettersGot = getLetters(numLettersGot, secret, guess);
                                System.out.println(" Correct guess! ");
                                System.out.println( " You have guessed the following letters so far: " + alreadyGuessed);
                                if (numLettersGot == secret.length()) {
                                    won = true;
                                }
                            } else {
                                hangC++;
                                System.out.println(" Wrong guess! ");
                                System.out.println( " You have guessed the following letters so far: " + alreadyGuessed);
                                if (hangC == 8) {
                                    dead = true;
                                }
                            }
                            // Displays progress of the game
                            pHangMan(hangC);
                            System.out.println("~~~~~~~~~~~~");
                            System.out.println();
                            pWordLine(secret, lettersGot);
                            if (dead) {
                                Defeat();
                            } else if (won) {
                                Won();
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

