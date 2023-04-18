import  java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineSweeperV1 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int mineCount = 0;

        int [][] map = new int[][]{  // Safes Random Numbers -3 to 0
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}};

        String [][] mapString = new String[][]{
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
                int rndCount = r.nextInt(-3,1);
                map [i][j] = rndCount;
                if (rndCount == 0){
                    mineCount++;
                }
            }
        }
        while (true){

            // Show Map(String)
            for (int g = 0; g < mapString.length; g++) {
                for (int k = 0; k < mapString[g].length; k++) {
                    System.out.print(mapString[g][k]);
                }
                System.out.println();
            }

            // User Input
            String userInput = scanner.nextLine();
            // UserInput split
            firstInput = userInput.charAt(0);
            secondInput = userInput.charAt(1);

            // convert char to String
            String first = firstInput+"";
            String second = secondInput+"";

            // make int out of char
            int i = Integer.parseInt(first);
            int j = secondInput - 65;

            // check if mine or not
            if(map[i][j] == 0){
                mapString[i][j] = "[*]";
                System.out.println("Du bist auf eine Mine getreten");
                System.out.println("Game Over");
                System.exit(0);
            }

            // Show pre-Map description
            mapString[i][j] = "[-]";
            rightChoices++;
            System.out.println("Du hast " + rightChoices + "/" +(100 - mineCount) + " (" +(rightChoices / (100 - mineCount) * 100 ) + "%) " + "des nicht verminten Gebiets auf Minen gecheckt");
            System.out.println("Es bleiben noch " +  mineCount + " Minen versteckt.");
            System.out.println("Wo willst du nach Minen suchen?");


        }
    }
}
