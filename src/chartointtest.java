import java.util.Random;
import java.util.Scanner;

public class chartointtest {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int mineCount = 0;
        boolean gameOn = true;


        int[][] map = new int[][]{  // Safes Random Numbers -3 to 0
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        String[][] mapString = new String[][]{
                {"  ", "A  ", "B  ", "C  ", "D  ", "E  ", "F  ", "G  ", "H  ", "I  ", "J  "},
                {"0", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"1", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"2", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"3", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"4", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"5", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"6", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"7", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"8", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"9", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}
        };
        char firstInput = 0;
        char secondInput = 0;
        double rightChoices = 0;

        // make Random Map
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int rndCount = r.nextInt(-3, 1);
                map[i][j] = rndCount;
                if (rndCount == 0) {
                    mineCount++;
                }
            }
        }
        while (gameOn) {

            // Show Map(String)
            for (int g = 0; g < mapString.length; g++) {
                for (int k = 0; k < mapString[g].length; k++) {
                    System.out.print(mapString[g][k]);
                }
                System.out.println();
            }
            int i;
            int j;

            String userInput = null;
            do {
                char firstInputTry;
                char secondInputTry;

                boolean again = true;

                do {
                    System.out.println("Your Try: ");
                    userInput = scanner.nextLine();
                    firstInputTry = userInput.charAt(0);   // first
                    if (userInput.length() < 2)
                        userInput = "AB";
                    secondInputTry = userInput.charAt(1);  // second
                } while (firstInputTry < 'A' || firstInputTry > 'J' || secondInputTry < 48 || secondInputTry > 57 || userInput.length() != 2);

                i = firstInputTry - 65;
                j = secondInputTry - 48;

                System.out.println(i + "/" + j);

                if (map[i][j] == 9)
                    System.out.println("Ist schon aufgedeckt");
                //userInput = scanner.nextLine();
            } while (map[i][j] == 9);

            // check if mine or not
            if (map[i][j] == 0) {                                                             // this is the bomb
                mapString[j + 1][i + 1] = "[*]";
                System.out.println("Du bist auf eine Mine getreten");
                System.out.println("Game Over");
                gameOn = false;
            } else if (map[i][j] == -1) {                                                   // this is -1
                // Show pre-Map description
                mapString[j + 1][i + 1] = "[-]";
                //map[i][j] = 9;
                rightChoices++;
                System.out.println("Du hast " + rightChoices + "/" + (100 - mineCount) + " (" + (rightChoices / (100 - mineCount) * 100) + "%) " + "des nicht verminten Gebiets auf Minen gecheckt");
                System.out.println("Es bleiben noch " + mineCount + " Minen versteckt.");
                System.out.println("Wo willst du nach Minen suchen?");

                // from -2 to -3
            } else if (map[i][j] < -1) {
                int a = map[i][j];
                int b = 0;
                if (a == -2) {
                    b = 1;
                } else if (a == -3) {
                    b = 2;
                }
                System.out.println("Test: " + i + "/" + j);
                for (int k = i - b; k < map.length && k <= i + b; k++) {
                    if (k < 0)
                        k = 0;
                    for (int l = j - b; l < map[i].length && l <= j + b; l++) {
                        if (l < 0)
                            l = 0;
                        if (map[l][k] != 0) {
                            mapString[l + 1][k + 1] = "[-]";
                            rightChoices++;
                        } else {
                            mapString[l + 1][k + 1] = "[*]";
                        }
                    }
                }
                System.out.println("Du hast " + rightChoices + "/" + (100 - mineCount) + " (" + (rightChoices / (100 - mineCount) * 100) + "%) " + "des nicht verminten Gebiets auf Minen gecheckt");
                System.out.println("Es bleiben noch " + mineCount + " Minen versteckt.");
                System.out.println("Wo willst du nach Minen suchen?");
            }
        }
    }
}