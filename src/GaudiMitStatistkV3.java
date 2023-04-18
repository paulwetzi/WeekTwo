import java.util.Arrays;
import java.util.Random;

public class GaudiMitStatistkV3 {
    public static void main(String[] args) {
        Random r = new Random();
        // Array with random numbers
        int[] rando = new int[100];
        int[] sorted = new int[100];
        int safe = 0;
        boolean ok = false;
        for (int i = 0; i <100; i++){
            int a = r.nextInt( 101);
            rando[i] = a;
            //System.out.println(rando[i]);
        }
        for (int c = 0; !ok; c++){
            ok = true;
            for (int i = 1; i < rando.length - c; i++){
                if (rando[i] < rando[i - 1]){
                    safe = rando[i];
                    rando[i] = rando[i - 1];
                    rando[i - 1] = safe;
                    ok = false;
                }
            }

            //System.out.println(rando[c]);
        }
        System.out.println(Arrays.toString(rando));
    }
}
