import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CoralConsulting {
    public static void main(String[] args) {
        // Declare Variables
        String filePath = "src/main/resources/transactions.csv";
        ArrayList<Transactions> transactions = new ArrayList<>();
        Transactions newDeposit = new Transactions();
        newDeposit.addDeposit(newDeposit.getTransactionDescription(), newDeposit.getVendorName(), newDeposit.getDepositAmount());
        transactions.add(newDeposit);


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String header = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by '|'
                String[] parts = line.split("\\|");

                if (parts.length == 5) {
                            String date = parts[0];
                            String time = parts[1];
                            String transactionDescription = parts[2];
                            String vendorName = parts[3];
                            double depositAmount = Double.parseDouble(parts[4]);
                }
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

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
