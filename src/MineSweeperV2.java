import java.util.Random;
import java.util.Scanner;

public class MineSweeperV2 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int mineCount = 0;
        boolean gameOn = true;


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
        char firstInput ;
        char secondInput ;
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
        while (gameOn){

            // Show Map(String)
            for (int g = 0; g < mapString.length; g++) {
                for (int k = 0; k < mapString[g].length; k++) {
                    System.out.print(mapString[g][k]);
                }
                System.out.println();
            }
            int i;
            int j;
            String userInput;

            do {
                // User Input
                char firstInputTry;
                char secondInputTry;
                do {

                    System.out.println("Your Try: ");
                    userInput = scanner.nextLine();
                    firstInputTry = userInput.charAt(0);   // first
                    secondInputTry = userInput.charAt(1);  // second

                } while ((firstInputTry <= 'A' && firstInputTry >= 'J') && (secondInputTry <= 0 && secondInputTry >= 9));

                // UserInput split
                firstInput = userInput.charAt(0);   // first
                secondInput = userInput.charAt(1);  // second

                // Accept 1.char == Number 2.char == Letter

                if (firstInput >= 48 && firstInput <= 57) {  // Is first Input Number ?
                    // convert char to String
                    String first = firstInput + "";  // first


                    // make int out of char
                    i = Integer.parseInt(first);
                    j = secondInput - 65;
                } else {  // Accept 2.char == Number 1.char == Letter
                    String second = secondInput + "";  // second

                    // make int out of char
                    j = firstInput - 65;
                    i = Integer.parseInt(second);

                }

                if (map[i][j] == 9)
                    System.out.println("Ist schon aufgedeckt");
                //userInput = scanner.nextLine();
            } while (map[i][j] == 9);

            // check if mine or not
            if(map[i][j] == 0){
                mapString[i + 1][j + 1] = "[*]";
                System.out.println("Du bist auf eine Mine getreten");
                System.out.println("Game Over");
                gameOn = false;
            } else{
                // Show pre-Map description
                mapString[i + 1][j + 1] = "[-]";
                map[i][j] = 9;
                rightChoices++;
                System.out.println("Du hast " + rightChoices + "/" +(100 - mineCount) + " (" +(rightChoices / (100 - mineCount) * 100 ) + "%) " + "des nicht verminten Gebiets auf Minen gecheckt");
                System.out.println("Es bleiben noch " +  mineCount + " Minen versteckt.");
                System.out.println("Wo willst du nach Minen suchen?");
            }
        }
    }
}
