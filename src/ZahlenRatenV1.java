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

            }else if (option == 4) {

            }else if (option == 0) {
                System.out.println("Auf Wiedersehen!");
            }
        }
    }
}