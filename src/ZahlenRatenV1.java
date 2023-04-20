import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV1 {
    public static void main(String[] args) {
        int option = 1;
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);

        while (option != 0){
            System.out.println("Welches Level möchtest du spielen?");
            System.out.println("1. Level 1");
            System.out.println("2. Level 2");
            System.out.println("3. Level 3");
            System.out.println("4. Level 4");
            System.out.println("0. Spiel beenden");
            option = scanner.nextInt();

            if (option == 1){
                int randomNum = r.nextInt(101);
                int guess = 0;
                int trys = 9;

                //System.out.println(randomNum);
                while (trys >  0 && guess != randomNum){
                    System.out.println("Welche Zahl schätzt du?");
                    guess = scanner.nextInt();
                    if (guess == randomNum){
                        System.out.println("Erraten");
                    } else if (guess < randomNum) {
                        System.out.println("Größer");
                    } else if (guess > randomNum) {
                        System.out.println("Kleiner");
                    }
                    trys--;
                    System.out.println("Du hast noch " + trys + " Versuche");
                }
                if (trys == 0){
                    System.out.println("Verloren");
                } else{
                    System.out.println("Gewonnen");
                }

            } else if (option == 2) {
                int randomNum = r.nextInt(101);
                int guess = 0;
                int trys = 9;

                System.out.println(randomNum);
                while (trys > 0 && guess != randomNum) {
                    System.out.println("Welche Zahl schätzt du?");
                    guess = scanner.nextInt();

                    int difference = Math.abs(guess - randomNum);

                    if (difference >= 4 && difference <= 10) {
                        System.out.println("relativ nahe / 4 - 10 daneben");
                    }  else if (difference >= 1 && difference <= 3) {
                        System.out.println("Fast da / 1 - 3 daneben");
                    }else if (difference >= 11 && difference <= 20) {
                        System.out.println("Nicht ganz so weit weg / max 20 daneben");
                    } else {
                        System.out.println("Weit weg / mehr als 20");
                    }
                    trys--;
                    System.out.println("Du hast noch " + trys + " Versuche");
                }

                if (trys == 0) {
                    System.out.println("Verloren");
                } else {
                    System.out.println("Gewonnen");
                }
            }else if (option == 3) {
                ArrayList<Integer> humanGuesses = new ArrayList<>();    // Safes all the Input Numbers from human
                ArrayList<Integer> computerGuesses = new ArrayList<>(); // Safes all the Input Numbers from Computer
                int humanGuess = 3;
                int computerGuess = -1;
                int targetNum = r.nextInt(101);
                boolean humanTurn = false; //r.nextBoolean();
                boolean rightNum = false;
                boolean humanBigger = false;
                boolean computerBigger = false;
                ArrayList<Integer> computerArea = new ArrayList<>();

                for (int i = 0; i < 101; i++) {
                    computerArea.add(i);
                }
                //System.out.println(targetNum);

                // Code here
                while (!rightNum) {
                    if (humanTurn) {
                        System.out.println("Dein Versuch: ");
                        humanGuess = scanner.nextInt();
                        System.out.println("humanGuess: " + humanGuess);
                    } else {
                        int areaSizeDivided = (computerArea.size() / 2); // Hälfte von computerArea.size
                        computerGuess = computerArea.get(areaSizeDivided);
                        System.out.println("Computerguess: " + computerGuess);
                    }
                    // Area from 1 to 100
                    if (humanTurn && (humanGuess < targetNum)) {
                        for (int i = 0; i < humanGuess; i++) {
                            computerArea.remove(Integer.valueOf(i));
                        }
                        System.out.println("Größer");
                    }
                    if (humanTurn && (humanGuess > targetNum)) {
                        for (int i = 100; i > humanGuess; i--) {
                            computerArea.remove(Integer.valueOf(i));
                        }
                        System.out.println("Kleiner");
                    }
                    if (!humanTurn && (computerGuess < targetNum)) {
                        for (int i = 0; i < computerGuess; i++) {
                            computerArea.remove(Integer.valueOf(i));
                        }
                        System.out.println("Größer");
                    }
                    if (!humanTurn && (computerGuess > targetNum)) {
                        for (int i = 100; i > computerGuess; i--) {
                            computerArea.remove(Integer.valueOf(i));
                        }
                        System.out.println("Kleiner");
                    }
                    if (computerGuess == targetNum){
                        System.out.println("Computer Gewinnt!");
                        rightNum = true;
                    } if (humanGuess == targetNum){
                        System.out.println("Spieler Gewinnt!");
                        rightNum = true;
                    }
                    humanTurn = !humanTurn;
                    humanGuesses.add(humanGuess);
                    computerGuesses.add(computerGuess);
                    System.out.println("humanGuesses: " + humanGuesses + "   computerGuesses: " + computerGuesses );
                }
            }else if (option == 4) {

            }else if (option == 0) {
                System.out.println("Auf Wiedersehen!");
            }
        }
    }
}