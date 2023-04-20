public class RPGV1 {
    public static void main(String[] args) {

        String[][] choices = {
        // parentID, ID, choiceTxt, resultTxt, moveToID

        {"-1", "0", "", "Du stehst in einer Bar."},                                                             // 0. Pos

        {"0", "1", "Geh in die Wildnis", "Du bist in der Wildnis angekommen."},                                 // 1. Pos
        {"0", "2", "Trink ein Getränk", "Du lässt dir ein Getränk schmecken", "0"},                             // 2. Pos

        {"1", "3", "Kämpf gegen das Monster", "Das Monster ist ein harter Gegner, aber du besiegst es.", "1"},  // 3. Pos
        {"1", "4", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"}};           // 4. Pos

        int currentChoice = 0;



        for(String[] a : choices){
            for (String b : a){
                System.out.println(b);

            }
        }
    }
}
