import java.util.Arrays;

public class chartointtest {
    public static void main(String[] args) {
        int [][] map = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        for (int i = 0; i <map.length ; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }


    }
}
