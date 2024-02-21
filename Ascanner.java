import java.util.Scanner;

public class Ascanner {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter an integer");
        int i = scan.nextInt();

        System.out.println("Please enter a long");
        long l = scan.nextLong();

        System.out.println("Please enter a double");
        double d = scan.nextDouble();

        System.out.println("The integer you entered is: " + i);
        System.out.println("The long you entered is: " + l);
        System.out.println("The double you entered is: " + d);

        scan.close();

    }

}