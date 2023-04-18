import java.util.Random;

public class GaudiMitArrayV1 {
    public static void main(String[] args) {
        int[] myNum = {3, 4, 5, 6, 9, 7, 8, 12, 45, 67};
        int[] randomArray = new int[100];
        boolean[] boolArray = new boolean[10];

        Random r = new Random();

        for (int i = 0;i < randomArray.length; i++){
            randomArray[i] = r.nextInt(randomArray.length);
            System.out.println(randomArray[i]);
        }
        for (int i = 1;i < 10; i++){
            boolean a = boolArray[i - 1];
            if (a == true){
                a = false;
            } else{
                a = true;
            }
            boolArray[i] = a;
            System.out.println(boolArray[i]);
        }
    }
}
