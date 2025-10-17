// import for scanner
import java.util.Scanner;

public class CoralConsulting {
    public static void main(String[] args) {
        // Declare Variables
        String filePath = "src/main/resources/transactions.csv";

        // Make a ledger object named ledger with the transaction.csv
        // This is needed to call the ledger class methods
        Ledger ledger = new Ledger(filePath);

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
            // Read next line and look at the first index, disregard case format
            char homePageInput = scanner.nextLine().trim().toLowerCase().charAt(0);

            // == compares
            // = sets value to
            if (homePageInput == 'd') {
                System.out.print("Enter Transaction Description: ");
                // Makes the user input into a variable
                String transactionDescription = scanner.nextLine().trim();

                System.out.print("Enter Vendor Name: ");
                String vendorName = scanner.nextLine().trim();

                System.out.print("Enter Deposit Amount: ");
                // Had to parse this variable because it is a double
                // turns the String (user input) into a double
                // This is because of scanner.nextLine- it can only read strings
                double depositAmount = Double.parseDouble(scanner.nextLine().trim());

                // Create and log new deposit
                // Creates a Transactions object using the transactions class by the name of newDeposit
                Transactions newDeposit = new Transactions();
                // newDeposit variable
                // Calls addDeposit method in Transactions class
                newDeposit.updateTransaction(transactionDescription,vendorName,depositAmount);
                // Calls the saveTransaction method
                // Opens the csv file and adds the line
                newDeposit.saveDepositTransaction(filePath);

            } else if (homePageInput == 'p') {
                System.out.print("Enter Payment Description: ");
                String transactionDescription = scanner.nextLine().trim();

                System.out.print("Enter Vendor Name: ");
                String vendorName = scanner.nextLine().trim();

                System.out.print("Enter Payment Amount: ");
                double depositAmount = Double.parseDouble(scanner.nextLine().trim());

                Transactions newPayment = new Transactions();
                newPayment.updateTransaction(transactionDescription,vendorName,depositAmount);
                newPayment.savePaymentTransaction(filePath);

            } else if (homePageInput == 'l') {
                // Calls ledgerMenu method
                // ledger object. ledgerMenu method (parameter ledger)
                ledger.ledgerMenu(ledger);

            } else if (homePageInput == 'x'){
                System.out.print("Goodbye!");
                // Time to leave the loop!
                repeatLoop = false;
            }

        } while (repeatLoop);
        scanner.close();

    }
}
