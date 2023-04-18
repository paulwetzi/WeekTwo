import java.sql.Array;
import java.util.Arrays;

public class GaudiMitArraysV2 {
    public static void main(String[] args) {
        char [] arr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int howMuch = 3;

        rightShift(arr, howMuch);

        //leftShift(arr, howMuch);
    }

    public static void rightShift(char [] arr, int rightShifts){
        int [] temp = new int[arr.length];
        if (rightShifts < 0){
            rightShifts += 26;
        }
        int newPosition;

        // Shift Logic Here
        for (int i = 0; i < arr.length; i++){
            newPosition = (i + rightShifts) % arr.length;
            temp[newPosition] = arr[i];
        }
        /*
        char[] thirdArray = new char[arr.length];
        for (int i = 0; i < arr.length; i++){
            int b = temp[i];
            char a = (char) b;
            thirdArray[i] = a;
        }*/
        System.out.println(java.util.Arrays.toString(arr));


    }

    public static void leftShift(int [] arr, int leftShifts){
        int [] temp = new int[arr.length];

        // Shift Logic Here
        for (int i = arr.length - 1; i > 0; i--){
            int newPosition = (i + (arr.length - leftShifts)) % arr.length;
            temp[newPosition] = arr[i];
        }


        char[] thirdArray = new char[arr.length];
        for (int i = 0; i < arr.length; i++){
            int b = temp[i];
            char a = (char) b;
            thirdArray[i] = a;
        }
        System.out.println("-" + java.util.Arrays.toString(thirdArray));
    }
}
