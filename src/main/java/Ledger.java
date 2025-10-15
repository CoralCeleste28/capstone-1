import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ledger {
    // Makes a list named Transactions
    private List<Transactions> transactions;

    Scanner scanner = new Scanner(System.in);

    // Constructor named Ledger. (parameter)
    public Ledger(String filePath) {

        // Updates the list to be an array list
        this.transactions = new ArrayList<>();

        try {
            // Makes an object that can read a line at a time from the transactions.csv file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            // Makes a header and tells the computer to skip the header
            String header = reader.readLine();


            String line;
            // While-Loop
            // When line is = to reader and there is no text, the loop is finished
            while ((line = reader.readLine()) != null) {
                // Make an array named parts. Split by '|'
                String[] parts = line.split("\\|");

                // If the array has 5 parts.
                // This is because we want all 5 pieces of information to make a transaction
                if (parts.length == 5) {
                    // names each index
                    String date = parts[0];
                    String time = parts[1];
                    String transactionDescription = parts[2];
                    String vendorName = parts[3];
                    double depositAmount = Double.parseDouble(parts[4]);

                    // Transaction named t. Needs 5 parameters.
                    Transactions t = new Transactions(date, time, transactionDescription, vendorName, depositAmount);
                    // Add it to the end of the transa
                    transactions.add(t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get all transactions from transactions list
    public List<Transactions> getAllTransactions() {
        return this.transactions;
    }

    public void all() {
        // Go through all transactions and assign each transaction to tempTransaction
        for (Transactions tempTransaction : this.transactions) {
            System.out.println(tempTransaction);
        }
    }

    public void allDeposits () {
        for (Transactions tempTransactions : this.transactions){
            if (tempTransactions.getDepositAmount() > 0 ){
                System.out.println(tempTransactions);
            }
        }
    }

    public void allPayments() {
        for (Transactions tempTransactions : this.transactions){
            if (tempTransactions.getDepositAmount() < 0 ){
                System.out.println(tempTransactions);
            }
        }
    }

    public void reportsMenu(Ledger ledger) {
        System.out.print("""
                Select a Filter Below:
                1) Month To Date
                2) Previous Month
                3) Year To Date
                4) Previous Year
                5) Search by Vendor - prompt the user for the vendor name and display all entries for that vendor
                0) Back
                """);
        char homePageInput = scanner.next().trim().toLowerCase().charAt(0);
        scanner.nextLine();

        switch (homePageInput){
            case '1' -> ledger.monthToDate();
//            case '2' ->
//            case '3' ->
//            case '4' ->
//            case '5' ->
//            case '0' ->
        }
    }

    public void monthToDate(){
        // Creates a LocalDate object for today's date and names it today
        LocalDate today = LocalDate.now();
        // Get current date and change the day to 1 (The month stays the same)
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        // Creates a DateTimeFormatter named dateFormatter
        // Defines the format pattern for the date (desired format)
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Transactions tempTransactions : this.transactions){
            // Getting date of transaction and formatting it to dateFormatter and then converting it to local date object
            // This is so the computer can compare the LocalDate to the other LocalDates
            LocalDate transactionDate = LocalDate.parse(tempTransactions.getDate().trim(),dateFormatter);
            // If the date is NOT before the 1st AND is NOT after today
            if (!transactionDate.isBefore(firstDayOfMonth) && !transactionDate.isAfter(today)){
                System.out.println(tempTransactions);
            }
        }
    }

    public void previousMonth(){
        // Creates a LocalDate object for today's date and names it today
        LocalDate today = LocalDate.now();
        // Get current date and change the day to 1 (The month stays the same)
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        // Creates a DateTimeFormatter named dateFormatter
        // Defines the format pattern for the date (desired format)
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Transactions tempTransactions : this.transactions){
            // Getting date of transaction and formatting it to dateFormatter and then converting it to local date object
            // This is so the computer can compare the LocalDate to the other LocalDates
            LocalDate transactionDate = LocalDate.parse(tempTransactions.getDate(),dateFormatter);
            // If the date is NOT before the 1st AND is NOT after today
            if (!transactionDate.isBefore(firstDayOfMonth) && !transactionDate.isAfter(today)){
                System.out.println(tempTransactions);
            }
        }
    }







}
