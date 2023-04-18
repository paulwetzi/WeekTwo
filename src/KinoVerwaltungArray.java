import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KinoVerwaltungArray{
    public static void main(String[] args) {

        int which = 1;
        int cards = 1;
        ArrayList<Integer> chosenMovies = new ArrayList<Integer>();


        int [] seats = {0, 30, 0, 5};

        String[][] movies = {{"Filmnr.  ", "Filmname    ", "Uhrzeit   ", "Saal", "Restplätze"},{"1.       ", "Batman      ", "20:15     ", "1   ", "3"},{"2.       ", "Matrix      ", "22:00     ", "3   ", "4"},{"3.       ", "Matrix2     ", "17:00     ", "2   ", "0"}};

        for (int i = 1; i < movies.length; i++) {
            if (seats[i] > 0){
                movies [i][4] = "verfügbar";
            } else{
                movies [i][4] = "ausgebucht";
            }
        }


        System.out.println('\n');
        for (int i = 0; i < movies.length; i++){
            for (int j = 0; j < movies[i].length; j++){
                System.out.print(movies[i][j].toString());
            }
            System.out.println();
        }

        System.out.println('\n');
        System.out.println("Wie viel Geld hast du?");
        Scanner scanner = new Scanner(System.in);
        int moneyTest = scanner.nextInt();

        // Loop start
        while (which != 0){
            do {
                System.out.println("Welchen Film willst du sehen? (0 zum abbrechen)");
                which = scanner.nextInt();
            } while (which < 0 || which > movies.length);
            System.out.println("Es sind noch " + seats[which] + " Tickets um jeweils 15€ dafür verfügbar.");

            if (seats[which] >= 1){
                System.out.println("Wie viel Karten möchtest du kaufen?");
                cards = scanner.nextInt();

                if (cards <= seats[which] && (cards * 15) <= moneyTest){
                    seats[which] = seats[which] - cards;
                    moneyTest = moneyTest - (cards * 15);

                    for (int i = 0; i < cards; i++) {
                        chosenMovies.add(which);
                    }

                    System.out.println("Du kaufst " + cards + "Tickets um " + (cards * 15) + "€ und hast jetzt noch " + moneyTest + "€");
                    System.out.println('\n');

                    for (int i = 1; i < movies.length; i++) {
                        if (seats[i] > 0){
                            movies [i][4] = "verfügbar";
                        } else{
                            movies [i][4] = "ausgebucht";
                        }
                    }


                    for (int i = 0; i < movies.length; i++){
                        for (int j = 0; j < movies[i].length; j++){
                            System.out.print(movies[i][j].toString());
                        }
                        System.out.println();
                    }
                    System.out.println('\n');
                    System.out.println(chosenMovies);
                }else{
                    System.out.println("zu wenig Sitzplätze übrig oder zu wenig Geld");
                }
            }else{
                System.out.println("passende Kartenanzahl eingeben");
            }
        }
    }
}
