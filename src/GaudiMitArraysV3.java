import java.sql.Array;

public class GaudiMitArraysV3 {
    public static void main(String[] args) {
        int howMuch = -4;
        int[] oldArray = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90};
        int[] newArray = shiftMultiple(oldArray, howMuch);
        char[] thirdArray = new char[newArray.length];
        for (int i = 0; i < oldArray.length; i++){
            int b = newArray[i];
            char a = (char) b;
            thirdArray[i] = a;
        }
        System.out.println(java.util.Arrays.toString(newArray));
        System.out.println(java.util.Arrays.toString(thirdArray));
    }

    public static int[] shiftMultiple(int[] arr, int count){
        for (int i = 0; i < count; i++)
            shiftArrayRight(arr);
        return arr;
    }

    public static int [] shiftArrayRight(int[] array1){
        int tempVariable = array1[array1.length - 1];
        for (int i = array1.length - 2; i > -1; i--){
            array1[i + 1] = array1[i];
        }
        array1[0] = tempVariable;
        return array1;
    }

    public static void printArray(int[] arr){
        for (int x : arr)
            System.out.println(x + ",");
    }

}

