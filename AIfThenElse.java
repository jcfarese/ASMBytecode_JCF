import java.util.Scanner;

public class AIfThenElse {
    
    public static void main(String[] args) {
        
    
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please type an integer");
        int i = scan.nextInt();

        if (i<10) {

            System.out.println("int is less than 10");
            
        }else{

            System.out.println("int is equal to or greater than 10");
            
            }
        
        scan.close();        

    }
}
