import java.util.Scanner;

public class KinoVerwaltungV1{
    public static void main(String[] args) {

        int which = 1;
        int cards = 1;



        int [] seats = {0, 30, 0, 5};
        String [] upperLine = {"Filmnr.  ", "Filmname    ", "Uhrzeit   ", "Saal", "Restplätze"};
        String [] first =     {"1.       ", "Batman      ", "20:15     ", "1   ", "verfügbar "};
        String [] second =    {"2.       ", "Matrix      ", "22:00     ", "3   ", "verfügbar "};
        String [] third =     {"3.       ", "Matrix2     ", "17:00     ", "2   ", "verfügbar "};
        //String [] arrayList = {upperLine[4], first[4], second[4], third[4]};
        if (seats[1] > 0){
            first [4] = "verfügbar";
        } else{
            first [4] = "ausgebucht";
        }
        if (seats[2] > 0){
            second [4] = "verfügbar";
        } else{
            second [4] = "ausgebucht";
        }
        if (seats[3] > 0){
            third [4] = "verfügbar";
        } else{
            third [4] = "ausgebucht";
        }

        System.out.println(java.util.Arrays.toString(upperLine));
        System.out.println(java.util.Arrays.toString(first));
        System.out.println(java.util.Arrays.toString(second));
        System.out.println(java.util.Arrays.toString(third));
        System.out.println('\n');

        System.out.println("Wie viel Geld hast du?");
        Scanner scanner = new Scanner(System.in);
        int moneyTest = scanner.nextInt();
        System.out.println("Du hast: " + moneyTest + "€");

        // Loop start
        while (which != 0){
            System.out.println("Welchen Film willst du sehen? (0 zum abbrechen)");
            which = scanner.nextInt();
            System.out.println("Es sind noch " + seats[which] + " Tickets um jeweils 15€ dafür verfügbar.");

            if (seats[which] >= 1){
                System.out.println("Wie viel Karten möchtest du kaufen?");
                cards = scanner.nextInt();

                if (cards <= seats[which]){
                    seats[which] = seats[which] - cards;
                    moneyTest = moneyTest - (cards * 15);

                    System.out.println("Du kaufst " + cards + "Tickets um " + (cards * 15) + "€ und hast jetzt noch " + moneyTest + "€");
                    System.out.println('\n');

                    if (seats[1] > 0){
                        first [4] = "verfügbar";
                    } else{
                        first [4] = "ausgebucht";
                    }
                    if (seats[2] > 0){
                        second [4] = "verfügbar";
                    } else{
                        second [4] = "ausgebucht";
                    }
                    if (seats[3] > 0){
                        third [4] = "verfügbar";
                    } else{
                        third [4] = "ausgebucht";
                    }

                    System.out.println(java.util.Arrays.toString(upperLine));
                    System.out.println(java.util.Arrays.toString(first));
                    System.out.println(java.util.Arrays.toString(second));
                    System.out.println(java.util.Arrays.toString(third));
                    System.out.println('\n');
                }
            }
        }
    }
}
