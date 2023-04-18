import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class CyberSecurityV1 {
    public static void main(String[] args) {
        Random r = new Random();
        //ArrayList<String> password = new ArrayList<String>();
        String[] password = new String[4];
        String[] find = new String[4];
        int trys;
        int tryExtern = 0;
        boolean check ;
        int bestCase = 0;
        int worstCase = 0;

        ArrayList<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("0");
        letters.add("1");
        letters.add("2");
        letters.add("!");

        for (int g = 0; g < 1000; g++) {
            trys = 0;
            check = false;
            //random Password generator (ABCabc012!) 4 digits
            for (int i = 0; i < 4; i++) {
                password[i] = letters.get(r.nextInt(letters.size()));
            }

            System.out.println("Password: " +Arrays.toString(password));

            for (int i = 0; i < 10 && !check; i++){
                find[0] = letters.get(i);

                for (int j = 0; j < 10 && !check; j++) {
                    find[1] = letters.get(j);

                    for (int k = 0; k < 10 && !check; k++) {
                        find[2] = letters.get(k);

                        for (int l = 0; l < 10 && !check; l++) {
                            find[3] = letters.get(l);
                            trys++;

                            if (Arrays.equals(find,password)){
                                System.out.println("Password is: " + Arrays.toString(find));
                                check = true;
                                System.out.println("Took " + trys + "guesses");
                            }
                        }
                    }
                }
            }
            tryExtern += trys;

            if (bestCase == 0){
                bestCase = trys;
            }
            if (worstCase == 0){
                worstCase = trys;
            }
            if (trys < bestCase){
                bestCase = trys;
            }
            if (trys > worstCase){
                worstCase = trys;
            }

        }
        System.out.println("Took " + tryExtern + " guesses");
        System.out.println("On average took " + (tryExtern / 1000) + " guesses each time");
        System.out.println("bestCase: " + bestCase);
        System.out.println("worstCase: " + worstCase);
    }
}