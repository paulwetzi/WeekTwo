import java.lang.reflect.Array;
import java.util.Arrays;
import java.lang.Math;
import java.util.Random;

public class GaudiMitStatistikV3 {
    public static void main(String[] args) {
        int [] urliste = {11, 8, 53, 3, 6, 3}; // Die noch ungeordnete „Urliste“ nach dem Muster
        Random random = new Random();
        for (int i = 0; i < urliste.length; i++) {
            urliste[i] = random.nextInt(100);
        }
        int [] aufsteigend = sortRando(urliste); //   Den aufsteigend geordneten Array nach dem Muster
        int arithmetisch = arithmetischFunction(aufsteigend); // Arithmetisches Mittel
        int spannweite =  spannweiteFunction(aufsteigend); // Spannweite (auch „Bereich“ genannt)      // größter minus kleinten Wert
        int median = medianFunction(aufsteigend); // Median-Wert (falls die Array-Länge gerade ist, nimm den Durchschnitt der beiden mittleren!)
        int[] modal = modalFunction(aufsteigend); // Modal-Wert (Zahl, die am häufigsten vorkommt) falls es mehrere Werte gibt, die am häufigsten vorkommen, wähle nur 1 aus)
        int absolut = absolutfunction(aufsteigend); //Mittlere absolute Abweichung



        System.out.println("Urliste: " + Arrays.toString(urliste));
        System.out.println("Aufsteigend sortiert: " + Arrays.toString(aufsteigend));
        System.out.println("Arithmetisches Mittel: " + arithmetisch);
        System.out.println("Spannweite: " + spannweite);
        System.out.println("Median: " + median);
        System.out.println("Modalwert: " + modal[0] + "von" + modal[1]);
        System.out.println("Mittlere absolute Abweichung: " + absolut);
    }
    
    //defined method to sort an array in ascending order
    private static int[] sortRando(int urliste[]){
        /*
        int n = urliste.length;
        int[] urliste2 = urliste.clone();
        for (int i = 1; i < n; i++){
            int j = i;
            int a = urliste2[i];
            while (( j > 0)&& (urliste2[j-1] > a)){
                urliste2[j] = urliste2[j-1];
                j--;
            }
            urliste2[j] = a;
            
        }
        return urliste2;*/
        int[] urlisteClone = urliste.clone();
        Arrays.sort(urlisteClone);

        return urlisteClone;
    }

    // Arithmetisches Mittel
    private static int arithmetischFunction (int[] aufsteigend){

        int sumNum = 0;
        for (int num : aufsteigend){
            sumNum += num;
        }
        sumNum = sumNum / aufsteigend.length;
        return sumNum;
    }

    // Spannweite
    private static int spannweiteFunction (int[] aufsteigend){

        int first = aufsteigend[0];
        int second = aufsteigend[aufsteigend.length - 1];
        int sum = second - first;

        System.out.println(first);
        System.out.println(second);

        return sum;
    }

    // Median-Wert
    private static int medianFunction (int[] aufsteigend){
        int num = 0;

        if (aufsteigend.length % 2 > 0){ // wenn es ein ungerad langes Array ist nimm den Mittleren Wert
            for (int i = 0; i < aufsteigend.length; i++) {
                if (aufsteigend[i] <= aufsteigend.length / 2)
                    num = aufsteigend[i];
            }
        } else { // ansonsten (gerades Array) nimm die beiden Mittleren Werte und Dividiere sie durch 2
            int sum = 0;
            int[] cloneAufsteigend = aufsteigend.clone();
            for (int i = 0; i < cloneAufsteigend.length / 2 - 1; i++) {
                cloneAufsteigend[i] = 0;
            }
            for (int i = cloneAufsteigend.length - 1; i >= cloneAufsteigend.length/2 + 1; i--) {
                cloneAufsteigend[i] = 0;
            }
            for (int i = 0; i < aufsteigend.length; i++) {
                if (cloneAufsteigend[i] != 0)
                    sum += cloneAufsteigend[i];
            }
            num = sum / 2;
        }
        return num;
    }

    // Modal-Wert
    public static int[] modalFunction (int[] aufsteigend){
        int counter = 0;
        int[] indexCounter = new int[aufsteigend.length];
        int value = 0;
        int[] total = new int[2];

        for (int i = 0; i < aufsteigend.length; i++) {
            for (int j = 0; j < aufsteigend.length; j++) {
                if (aufsteigend[i] == aufsteigend[j]){
                    counter++;
                }
            }
            indexCounter[i] = counter;
            counter = 0;
        }
        for (int i = 0; i < indexCounter.length; i++) {
            if (indexCounter[i] > counter) {
                counter = indexCounter[i];
                value = aufsteigend[i];
            }
        }
        total[0] = counter;
        total[1] = value;
        return total;
    }

    //Mittlere absolute Abweichung
    public static int absolutfunction(int [] aufsteigend){  // https://de.khanacademy.org/math/statistics-probability/summarizing-quantitative-data/other-measures-of-spread/a/mean-absolute-deviation-mad-review

        int sumAll = 0;
        int arithmetischesMittel = 0;
        int [] minusMittel = new int[aufsteigend.length];
        int endValue = 0;

        for (int i = 0; i < aufsteigend.length; i++) {
            sumAll += aufsteigend[i];
        }
        arithmetischesMittel = sumAll/ aufsteigend.length;

        for (int i = 0; i < aufsteigend.length; i++) {
            minusMittel[i] = Math.abs(aufsteigend[i] - arithmetischesMittel);
        }
        for (int i = 0; i < minusMittel.length; i++) {
            endValue += minusMittel[i];
        }

        endValue = endValue / minusMittel.length;

        return endValue;
    }
}