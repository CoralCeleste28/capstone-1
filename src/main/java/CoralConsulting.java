import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CoralConsulting {
    public static void main(String[] args) {
        // Declare Variables
        String filePath = "src/main/resources/transactions.csv";

        // Make a ledger named ledger with the transaction.csv
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
            // Read next line and look at the first index
            char homePageInput = scanner.next().trim().toLowerCase().charAt(0);
            // scans the line look  into this!!
            scanner.nextLine();

            if (homePageInput == 'd') {
                System.out.println("Enter Transaction Description: ");
                String transactionDescription = scanner.nextLine().trim();

                System.out.println("Enter Vendor Name: ");
                String vendorName = scanner.nextLine().trim();

                System.out.println("Enter Deposit Amount: ");
                double depositAmount = Double.parseDouble(scanner.nextLine().trim());

                // Create and log new deposit
                Transactions newDeposit = new Transactions();
                // Calls addDeposit method in Transactions class
                newDeposit.addDeposit(transactionDescription,vendorName,depositAmount);
                // Adds a transaction to the list
                // Calls the saveTransaction method
                // Opens the csv file and adds the line
                newDeposit.saveTransaction(filePath);

            } else if (homePageInput == 'p') {
                System.out.println("Enter Payment Description: ");
                String transactionDescription = scanner.nextLine().trim();

                System.out.println("Enter Vendor Name: ");
                String vendorName = scanner.nextLine().trim();

                System.out.println("Enter Payment Amount: ");
                double depositAmount = Double.parseDouble(scanner.nextLine().trim());

                Transactions newDeposit = new Transactions();
                newDeposit.addDeposit(transactionDescription,vendorName,depositAmount);
                newDeposit.savePaymentTransaction(filePath);

            } else if (homePageInput == 'l') {
                System.out.print("""
                (A) All
                (D) Deposits
                (P) Payments
                (R) Reports
                (0) Ledger
                (H) Home Page
                """);

                homePageInput = scanner.next().trim().toLowerCase().charAt(0);

                 switch (homePageInput){
                     case 'a' -> ledger.all();
                     case 'd' -> ledger.allDeposits();
                     case 'p' -> ledger.allPayments();
                     case 'r' -> ledger.reportsMenu(ledger);

                 }



            } else if (homePageInput == 'x'){

            }

        } while (repeatLoop == true);
        scanner.close();

    }
}
