import java.util.Scanner;

public class CoralConsulting {
    public static void main(String[] args) {
        // Declare Variables
        // Makes a scanner named scanner that reads user input
        Scanner scanner = new Scanner(System.in);

        // This boolean is for the while do-while loop below
        boolean repeatLoop = true;

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
            // Read next line and look at the first index
            char homePageInput = scanner.next().trim().toLowerCase().charAt(0);

            if (homePageInput == 'd') {
                System.out.println("Enter Transaction Description: ");
                String transactionDescription = scanner.nextLine().trim();


                System.out.println("Enter Vendor Name: ");
                String vendorName = scanner.nextLine().trim();

                System.out.println("Enter Deposit Amount: ");
                int depositAmount = Integer.parseInt(scanner.nextLine().trim());
            } else if (homePageInput == 'p') {

            } else if (homePageInput == 'l') {

            } else if (homePageInput == 'x'){

            }


        } while (repeatLoop == true);
        scanner.close();

    }
}
