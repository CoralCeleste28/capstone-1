import java.util.Scanner;
public class CoralConsulting {
    public static void main(String[] args) {
        // Declare Variables
        Scanner scanner = new Scanner(System.in);
        // This boolean is for the while do-while loop below
        boolean repeatLoop = true;
        // Read next line and look at the first index
        char homePageInput = scanner.next().trim().toLowerCase().charAt(0);

        // do-while loop
        do {
            System.out.println("""
                    Hello!
                    Please select an option from the following: 
                    (D) Add a Deposit
                    (P) Make a Payment
                    (L) See Ledger
                    (X) Close Application
                    """);

            if (homePageInput == 'd') {

            } else if (homePageInput == 'p') {

            } else if (homePageInput == 'l') {

            } else if (homePageInput == 'x'){

            }


        } while (repeatLoop == true);
        scanner.close();

    }
}
