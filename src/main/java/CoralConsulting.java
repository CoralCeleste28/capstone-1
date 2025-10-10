import java.util.Scanner;
public class CoralConsulting {
    public static void main(String[] args) {
        // Declare Variables
        Scanner scanner = new Scanner(System.in);
        // This boolean is for the while do-while loop below
        boolean repeatLoop = true;
        char homePageInput = scanner.nextLine().trim().toLowerCase().charAt(0);
        System.out.println("""
                    Hello!
                    Please select an option from the following: 
                    (D) Add a Deposit
                    (P) Make a Payment
                    (L) See Ledger
                    (X) Close Application
                    """);

    }
}
