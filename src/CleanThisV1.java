public class CleanThisV1 {
    public static void main(String[] args) {
        int age = 3;
        boolean vip = true;
        boolean withAdult = true;
        if (age >= 18)
            System.out.println("Grünes Band");
        else if (age >= 16)
            System.out.println("Gelbes Band");
        else if (age >= 4 && withAdult)
            System.out.println("Rotes Armband");
        else
            System.out.println("kein Zutritt");
        //if ((vip && age > 3) && (!((age >=4) && ((age <=15))) || withAdult)){
        if ((age >= 16 || age >= 4 && withAdult) && vip) {
            System.out.println("Goldenes Band");
        } else
            System.out.println("kein Zutritt");
    }
}