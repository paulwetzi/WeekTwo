public class GaudiMitStatistikV1 {
    public static void main(String[] args) {
        // Our Sentence (Not Important)
        // string sentence = ("Unter #Handy finden sich 6 große Anbieter, 2 davon sind aber die besten!“);

        //Cast to Char-Array
        char[] myText="Unter #Handy finden sich 6 große Anbieter, 2 davon sind aber die besten!".toCharArray();
        int[] myAscii = new int[myText.length];

        int capitalLetter = 0;
        int lowercaseLetter = 0;
        int number = 0;
        int otherCharacter = 0;

        //Get ASCII Value of Char
        for (int i = 0; i < myText.length; i++){
            int ascii = myText[i];
            int castAscii = (int) myText[i];

            // Save in Int-Array
            myAscii[i] = castAscii;
            System.out.println(myAscii[i]);
        }
        //Save in categories
        for (int i = 0; i < myAscii.length; i++){

            if (myAscii[i]>= 48 && myAscii[i]<= 57) {
                number = number + 1;
            } else if (myAscii[i]>= 65 && myAscii[i]<= 90) {
                capitalLetter = capitalLetter +1;
            }else if (myAscii[i]>= 97 && myAscii[i]<= 122) {
                lowercaseLetter = lowercaseLetter + 1;
            } else{
                otherCharacter = otherCharacter + 1;
            }
        }
        System.out.println("capitalletter: "+ capitalLetter);
        System.out.println("lowercaseLetter: "+ lowercaseLetter);
        System.out.println("number: "+ number);
        System.out.println("otherCharacter: "+ otherCharacter);
    }
}
