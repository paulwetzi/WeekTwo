import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class KinoVerwaltungV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        ArrayList<Integer> chosenMovies = new ArrayList<Integer>();
        ArrayList<Integer> chosenSnacks = new ArrayList<Integer>();
        System.out.println("Wie viel Geld hast du?");
        double moneyTest = scanner.nextDouble();

        while (option != 6) {
            System.out.println("Was willst du als nächstes tun? ");
            System.out.println("1. Ticket kaufen");
            System.out.println("2. Snacks kaufen");
            System.out.println("3. Film ansehen");
            System.out.println("4. Snacks essen");
            System.out.println("5. Beim Gewinnsspiel mitmachen");
            System.out.println("6. Kino verlassen");
            System.out.println("Kontostand: " + moneyTest);
            option = scanner.nextInt();

            if (option == 1) {
                int which = 1;
                int cards = 1;

                int[] seats = {0, 30, 0, 5};

                String[][] movies = {{"Filmnr.  ", "Filmname    ", "Uhrzeit   ", "Saal ", "Restplätze"},
                                     {"1.       ", "Batman      ", "20:15     ", "1   ", "3"},
                                     {"2.       ", "Matrix      ", "22:00     ", "3   ", "4"},
                                     {"3.       ", "Matrix2     ", "17:00     ", "2   ", "0"}};

                for (int i = 1; i < movies.length; i++) {
                    if (seats[i] > 0) {
                        movies[i][4] = " verfügbar";
                    } else {
                        movies[i][4] = " ausgebucht";
                    }
                }
                System.out.println('\n');
                for (int i = 0; i < movies.length; i++) {
                    for (int j = 0; j < movies[i].length; j++) {
                        System.out.print(movies[i][j].toString());
                    }
                    System.out.println();
                }
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



                // Loop start

            } else if (option == 2) {
                int which = 1;
                int buying = 1;
                int[] snacksLeft = {0, 3, 4, 8};
                double[] storage = {0, 1, 2, 3.5};

                String[][] snacks = {{"Nr", "Snack      ", "Preis ", "Auf Lager?"},
                        {"1.", "Popcorn    ", "1.00  ", "auf Lager"},
                        {"2.", "Chips      ", "2.00  ", "auf Lager"},
                        {"3.", "Schokolade ", "3.50  ", "auf Lager"}};

                for (int i = 1; i < snacks.length; i++) {
                    if (snacksLeft[i] > 0) {
                        snacks[i][3] = "Auf Lager";
                    } else {
                        snacks[i][3] = "Nicht Lagernd";
                    }
                }

                System.out.println('\n');
                for (int i = 0; i < snacks.length; i++) {
                    for (int j = 0; j < snacks[i].length; j++) {
                        System.out.print(snacks[i][j].toString());
                    }
                    System.out.println();
                }
                System.out.println('\n');

                while (which > 0) {
                    do {
                        System.out.println("Welchen Snack möchtest du kaufen? (0 zum abbrechen)");
                        which = scanner.nextInt();
                    } while (which < 0 || which > snacks.length);
                    System.out.println("Es sind noch " + snacksLeft[which] + " " + snacks[which][1] + " um jeweils " + snacks[which][2] + "€ verfügbar.");

                    if (snacksLeft[which] >= 1) {
                        System.out.println("Wie viel " + snacks[which][1] + "möchtest du kaufen?");
                        buying = scanner.nextInt();

                        if (buying <= snacksLeft[which] && buying <= moneyTest) {
                            snacksLeft[which] = snacksLeft[which] - buying;
                            moneyTest = moneyTest - (storage[which] * buying);

                            for (int i = 0; i < buying; i++) {
                                chosenSnacks.add(which);
                            }

                            System.out.println("Du kaufst " + buying + snacks[1][which] + "um " + (buying * storage[which]) + "€ und hast jetzt noch " + moneyTest + "€");
                            System.out.println('\n');

                            for (int i = 1; i < snacks.length; i++) {
                                if (snacksLeft[i] > 0) {
                                    snacks[i][3] = "Auf Lager";
                                } else {
                                    snacks[i][3] = "Nicht Lagernd";
                                }
                            }


                            System.out.println('\n');
                            for (int i = 0; i < snacks.length; i++) {
                                for (int j = 0; j < snacks[i].length; j++) {
                                    System.out.print(snacks[i][j].toString());
                                }
                                System.out.println();
                            }
                            System.out.println('\n');
                            System.out.println(chosenSnacks);
                        } else {
                            System.out.println("zu wenig Snacks übrig oder zu wenig Geld");
                        }
                    } else {
                        System.out.println("passende Snackanzahl eingeben");
                    }
                }


            } else if (option == 3) {
                int cards = 1;
                String[][] movies = {{"Filmnr.  ", "Filmname    ", "Uhrzeit   ", "Saal ", "Karten in Besitz"},
                                     {"1.       ", "Batman      ", "20:15     ", "1    ", ""},
                                     {"2.       ", "Matrix      ", "22:00     ", "3    ", ""},
                                     {"3.       ", "Matrix2     ", "17:00     ", "2    ", ""}};

                while (cards != 0){
                    int[] safe = {0, 0, 0, 0};
                    //sort chosenMovies to safe
                    for (int i = 0; i < chosenMovies.size(); i++) {
                        safe[chosenMovies.get(i)]++;
                    }

                    System.out.println(Arrays.toString(safe));

                    //sort safe to movies(String)
                    for (int i = 1; i < safe.length; i++) {
                        movies[i][4] = Integer.toString(safe[i]);
                    }
                    System.out.println('\n');
                    System.out.println("Welchen Film (für den du noch ein Ticket hast) möchtest du sehen? (0 für abbrechen)");
                    for (int i = 0; i < movies.length; i++) {
                        for (int j = 0; j < movies[i].length; j++) {
                            System.out.print(movies[i][j].toString());
                        }
                        System.out.println();
                    }
                    do {
                        cards = scanner.nextInt();

                    } while (!chosenMovies.contains(Integer.valueOf(cards)) && (cards != 0));
                    chosenMovies.remove(Integer.valueOf(cards));
                }

            } else if (option == 4) {
                int cards = 1;
                String[][] snacks = {{"Nr", "Snack      ", "Wert ", "im Besitz?"},
                                     {"1.", "Popcorn    ", "1.00  ", "auf Lager"},
                                     {"2.", "Chips      ", "2.00  ", "auf Lager"},
                                     {"3.", "Schokolade ", "3.50  ", "auf Lager"}};

                while (cards != 0){
                    int[] safe = {0, 0, 0, 0};
                    //sort chosenSnacks to safe
                    for (int i = 0; i < chosenSnacks.size(); i++) {
                        safe[chosenSnacks.get(i)]++;
                    }

                    System.out.println(Arrays.toString(safe));

                    //sort safe to snacks(String)
                    for (int i = 1; i < safe.length; i++) {
                        snacks[i][3] = Integer.toString(safe[i]);
                    }
                    System.out.println('\n');
                    System.out.println("Welchen Snack (den du im Besitz hast) möchtest du essen? (0 für abbrechen)");
                    for (int i = 0; i < snacks.length; i++) {
                        for (int j = 0; j < snacks[i].length; j++) {
                            System.out.print(snacks[i][j].toString());
                        }
                        System.out.println();
                    }
                    do {
                        cards = scanner.nextInt();

                    } while (!chosenSnacks.contains(Integer.valueOf(cards)) && (cards != 0));
                    chosenSnacks.remove(Integer.valueOf(cards));
                }

            } else if (option == 5) {
                Random r = new Random();
                int a=1;
                int b=1;
                int c=a+b;
                int counter = 10;
                int RandomNum;
                int randomNum = r.nextInt( 201);
                System.out.println(randomNum);
                boolean checkRandom = false;

                while (!(c == randomNum) && c < 200){
                    System.out.println(a +"+"+ b +"="+ c);
                    a = b;
                    b = c;
                    c = a + b;
                    if (randomNum == c){
                        checkRandom = true;
                    }
                }
                if (randomNum % 10 == 0){
                    checkRandom = true;
                }
                if (checkRandom == true){
                    System.out.println(randomNum + " ist eine Fibonacci-Nummer! Du gewinnst 20€!");
                    moneyTest = moneyTest + 20;
                } else {
                    System.out.println(randomNum + " ist KEINE Fibonacci-Nummer! Leider nicht gewonnen.");
                    moneyTest = moneyTest - 5;
                }
                System.out.println();


            } else if (option == 6) {
                System.out.println("Du verlässt das Kino. Auf wiedersehen!");
            } else {
                System.out.println("falsche Eingabe");
            }
        }
    }
}
