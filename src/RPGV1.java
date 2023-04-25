import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class RPGV1 {
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
                String[][] choices = {
                        // parentID, ID, choiceTxt, resultTxt, moveToID

                        {"-1", "0", "", "Du stehst in einer Bar.", "9"},                                                        // 0. Pos   // 9 is UserInput (currentChoice)

                        {"0", "1", "Geh in die Wildnis", "Du bist in der Wildnis angekommen.", "9"},                            // 1. Pos
                        {"0", "2", "Trink ein Getränk", "Du lässt dir ein Getränk schmecken", "0"},                             // 2. Pos

                        {"1", "3", "Kämpf gegen das Monster", "Das Monster ist ein harter Gegner, aber du besiegst es.", "1"},  // 3. Pos
                        {"1", "4", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"}};           // 4. Pos

                int currentChoice = 0;


                while (true) {
                    // Code here

                    // if currentChoice == 0: String[0][3]  sout: String[1][1 and 2]  sout: String[2][1 and 2]
                    if (currentChoice == 0){
                        System.out.println(choices[0][3]);                                              // Überschrift
                        System.out.println("------------------------------");
                        System.out.println(choices[1][1] + ".) " + choices[1][2]);                      // 1.
                        System.out.println(choices[2][1] + ".) " + choices[2][2]);                      // 2.
                        System.out.println("Was willst du als nächstes tun?");
                        currentChoice = scanner.nextInt();
                       /* do {

                        }while(currentChoice < 1 && currentChoice > 2)*/
                    }if (currentChoice == 1){
                        System.out.println();
                        System.out.println(choices[1][3]);                                              // Überschrift
                        System.out.println("------------------------------");
                        System.out.println(choices[3][1] + ".) " + choices[3][2]);                      // 3,
                        System.out.println(choices[4][1] + ".) " + choices[4][2]);                      // 4.
                        System.out.println("Was willst du als nächstes tun?");
                        currentChoice = scanner.nextInt();
/*
                        while(currentChoice < 3 && currentChoice > 4){
                        }*/
                    }if (currentChoice == 2){
                        System.out.println();
                        System.out.println(choices[2][3]);
                        currentChoice = 0;
                        System.out.println();


                        /*
                        System.out.println("------------------------------");
                        System.out.println(choices[1][1] + ".) " + choices[1][2]);
                        System.out.println(choices[2][1] + ".) " + choices[2][2]);
                        System.out.println("Was willst du als nächstes tun?");*/


                        // if he chooses 3 or 4 currentChoice == 0
                        //currentChoice = scanner.nextInt();
                    }if (currentChoice == 3){
                        System.out.println();
                        System.out.println(choices[3][3]);

                        /*
                        System.out.println("------------------------------");
                        System.out.println(choices[1][1] + ".) " + choices[1][2]);
                        System.out.println(choices[2][1] + ".) " + choices[2][2]);
                        System.out.println("Was willst du als nächstes tun?");*/

                        currentChoice = 1;//scanner.nextInt();
                    }if (currentChoice == 4){
                        System.out.println();
                        System.out.println(choices[4][3]);
                        System.out.println();
                        /*
                        System.out.println("------------------------------");
                        System.out.println(choices[1][1] + ".) " + choices[1][2]);
                        System.out.println(choices[2][1] + ".) " + choices[2][2]);
                        System.out.println("Was willst du als nächstes tun?");*/

                        currentChoice = 0;//scanner.nextInt();
                    }
                }


            }
            if (option == 2) {
                String[][] choices = {
                        // parentID, ID, choiceTxt, resultTxt, moveToID

                        {"-1", "0", "", "Du stehst in einer Bar."},                                                             // 0. Pos   // 9 is UserInput (currentChoice)

                        {"0", "1", "Geh in die Wildnis", "Du bist in der Wildnis angekommen."},                                 // 1. Pos
                        {"0", "2", "Trink ein Getränk", "Du lässt dir ein Getränk schmecken", "0"},                             // 2. Pos

                        {"1", "3", "Kämpf gegen das Monster", "Das Monster ist ein harter Gegner, aber du besiegst es.", "1"},  // 3. Pos
                        {"1", "4", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"}};           // 4. Pos

                int currentChoice = 0;
                ArrayList<Integer> viableChoices = new ArrayList<>();
                ArrayList<String> viableChoisesText = new ArrayList<>();
                ArrayList<Integer> checkNextChoice = new ArrayList<>();

                while (true) {

                    // show every Array- 2. var (if current Array 1. var Number) if its the same Number
                    for (int i = 0; i < choices.length; i++) {
                        for (int j = 0; j < choices[0].length; j++) {
                            if (Integer.parseInt(choices[i][0]) == currentChoice) {
                                viableChoices.add(Integer.parseInt(choices[i][1]));
                                viableChoisesText.add(choices[i][2]);
                                break;
                            }
                        }
                    }

                    // print current Array 3. var
                    System.out.println(choices[currentChoice][3]);
                    System.out.println("---------------------------");

                    for (int i = 0; i < viableChoices.size(); i++) {
                        System.out.println(viableChoices.get(i) + ".) " + viableChoisesText.get(i));
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
                    viableChoisesText.clear();
                }

            }
            if (option == 0) {
                System.out.println("Feigling!");
            }
        }
    }
}