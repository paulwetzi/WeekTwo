public class KleinerAlgorithmusV1 {
    public static void main(String[] args) {
        int a=1;
        int b=1;
        int c=a+b;
        int counter = 10;

        for (int i = 1; i <= counter; i++){
            System.out.println(a +"+"+ b +"="+ c);
            a = b;
            b = c;
            c = a + b;
        }
    }
}
