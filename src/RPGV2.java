import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class RPGV2 {
    public static void main(String[] args) {
        int option = 9;
        Scanner scanner = new Scanner(System.in);

        while (option != 0) {
            System.out.println();
            System.out.println("Welches Abenteuer möchtest du spielen?");
            System.out.println("--------------------------------------");
            System.out.println("1. The Drunken Viking");
            System.out.println("2. Rise of the Hydra");
            System.out.println("0. Aufgeben");
            option = scanner.nextInt();

            if (option == 1) {

            }
            if (option == 2) {
                Random rando =new Random();
                int lifeMax = 10; //  maximale Lebenspunkte des Spielers, startend bei 10
                int pLife = lifeMax; // Lebenspunkte des Spielers, startend bei lifeMax
                int mLife = rando.nextInt(21) + 3; // Lebenspunkte des Monsters, startend bei einem Zufallswert von 3-20
                int pAttack = rando.nextInt(pLife) + 1; // max. Angriffskraft des Spielers, zufällig von 1 bis pLife, festgelegt beim Kampfstart
                int mAttack = rando.nextInt(mLife) + 1; // max. Angriffskraft des Monsters, zufällig von 1 bis mLife, festgelegt beim Kampfstart
                int pGold = 0; // wie viele Goldmünzen der Spieler hat, startend bei 0
                int mGold = 0; // Zufallszahl zwischen 1 und mLife*100
                boolean gameOver = false;

//                System.out.println(pLife);
//                System.out.println(mLife);
//                System.out.println(pAttack);
//                System.out.println(mAttack);
//                System.out.println();

                String[][] choices = {

                        // {parentID, ID, choiceTxt, resultTxt, moveToID }

                        {"-1", "0", "", "Du stehst in einer Bar."},



                        {"0", "1", "Geh in die Wildnis auf der Suche nach Abenteuern", "Du bist in der Wildnis angekommen. Du triffst auf ein Monster."},

                        {"0", "2", "Trink ein Getränk und raste dich aus", "Du lässt dir ein Getränk schmecken", "0"},

                        {"0", "3", "Beeindrucke die Prinzessin mit deinen Schätzen", "Du gibst alles!", "0"},



                        {"1", "4", "Kämpf gegen das Monster", "", "6"},

                        {"1", "5", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"},



                        {"4", "6", "", ""},

                        {"6", "7", "Versuche das Monster mit deinem Schwert zu erwischen", "Du wirfst dich in die Schlacht!", "6"},

                        {"6", "8", "Es ist Zeit zu gehen", "Du versuchst zu flüchten, doch das Monster verfolgt dich.", "0"},



                        {"-1", "9", "", "Deine Zeit ist leider vorüber. Der Tod erwartet dich schon mit freundlichem Grinsen"}, // TOD

                        {"-1", "10", "", "Du bist der größte Held aller Zeiten! Hurra!"}, // SIEG

                };

                int currentChoice = 0;
                ArrayList<Integer> viableChoices = new ArrayList<>();
                ArrayList<String> viableChoicesText = new ArrayList<>();

                while (!gameOver) {

                    // show every Array- 2. var (if current Array 1. var Number) if its the same Number
                    for (int i = 0; i < choices.length; i++) {
                        for (int j = 0; j < choices[0].length; j++) {
                            if (Integer.parseInt(choices[i][0]) == currentChoice) {
                                viableChoices.add(Integer.parseInt(choices[i][1]));
                                viableChoicesText.add(choices[i][2]);
                                break;
                            }
                        }
                    }

                    // print current Array 3. var
                    System.out.println(choices[currentChoice][3]);
                    System.out.println("---------------------------");

                    for (int i = 0; i < viableChoices.size(); i++) {
                        System.out.println(viableChoices.get(i) + ".) " + viableChoicesText.get(i));
                    }

                    if (choices[currentChoice].length != 5) {
                        // Get the player's choice and validate it
                        do {
                            System.out.println("---------------------------");
                            System.out.print("Was willst du als nächstes tun? ");
                            currentChoice = scanner.nextInt();
                        } while (!viableChoices.contains(currentChoice));
                    } else {
                        currentChoice = Integer.parseInt(choices[currentChoice][4]);
                    }

                    // clear Choices
                    viableChoices.clear();
                    viableChoicesText.clear();
                }
            }
            if (option == 0) {
                System.out.println("Feigling!");
            }
        }
    }
}