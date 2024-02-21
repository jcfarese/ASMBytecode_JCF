import java.util.Scanner;

public class Accumulator {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int count = 0;
        int sum = 0;

        while(i<10){
            System.out.println("Please enter an integer");
            count = scan.nextInt();
            sum += count;
            
            System.out.println("The sum of the numbers in the accumulator is: ");
            System.out.println(sum);
            i++;
        }
           

        System.out.println("The loop has ended, the final accumulation is: ");
        System.out.println(sum);

        scan.close();

    }
    
}
