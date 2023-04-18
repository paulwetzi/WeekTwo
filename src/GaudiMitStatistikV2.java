import java.util.Random;

public class GaudiMitStatistikV2 {
    public static void main(String[] args) {
        Random r = new Random();
        int i = 0;
        // Array with random numbers
        int[] rando = new int[100];
        for (i = 0; i <100; i++){
            int a = r.nextInt( 100);
            rando[i] = a;
            //System.out.println(rando[i]);
        }
        System.out.println("Array before sorting: \n");
        for ( i = 0; i < rando.length; i++){
            System.out.println(rando[i]);
        }
        sortRando(rando, rando.length);
            System.out.println("Array after sorting: \n");
            // accessing elements of the sorted array
            for ( i = 0; i < rando.length; i++){
                System.out.println(rando[i]);
            }

    }

    // Invoke own method


    //defined method to sort an array in ascending order
    private static void sortRando(int rando[], int n){
        for (int i = 1; i < n; i++){
            int j = i;
            int a = rando[i];
            while (( j > 0)&& (rando[j-1] > a)){
                rando[j] = rando[j-1];
                j--;
            }
            rando[j] = a;
    }
}}
