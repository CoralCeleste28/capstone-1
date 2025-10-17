import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ledger {
    // Transactions are made up of 5 class field variables
    // The ledger is made up of a list of transactions
    // The transactions as defined bt the information in the transactions class
    private final List<Transactions> transactions;

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
                    String date = parts[0].trim();
                    String time = parts[1].trim();
                    String transactionDescription = parts[2].trim();
                    String vendorName = parts[3].trim();
                    double depositAmount = Double.parseDouble(parts[4].trim());

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

    public void ledgerMenu(Ledger ledger){
        System.out.print("""
                Ledger Menu
                (A) All
                (D) Deposits
                (P) Payments
                (R) Reports
                (H) Home Page
                """);

        char ledgerMenuInput = scanner.next().trim().toLowerCase().charAt(0);

        switch (ledgerMenuInput){
            case 'a' -> ledger.all();
            case 'd' -> ledger.allDeposits();
            case 'p' -> ledger.allPayments();
            case 'r' -> ledger.reportsMenu(ledger);
        }
    }

    public void allDeposits () {
        // Read every transaction in the array list of transactions
        // and treat each line as a transaction
        for (Transactions tempTransactions : this.transactions){
            // This will reorganize the file by date
            // for(int i = Transactions.size() -1; i >= 0; i--)
            if (tempTransactions.getTransactionAmount() > 0 ){
                System.out.println(tempTransactions);
            }
        }
    }

    public void allPayments() {
        for (Transactions tempTransactions : this.transactions){
            if (tempTransactions.getTransactionAmount() < 0 ){
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
                5) Search by Vendor
                0) Back
                """);

        char homePageInput = scanner.next().trim().toLowerCase().charAt(0);
        scanner.nextLine();

        switch (homePageInput){
            case '1' -> ledger.monthToDate();
            case '2' -> ledger.previousMonth();
            case '3' -> ledger.yearToDate();
            case '4' -> ledger.previousYear();
            case '5' -> ledger.searchByVendor();
            case '0' -> ledger.ledgerMenu(ledger);
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

        // Creates a YearMonth object named previous month and sets it to one minus the month
        YearMonth previousMonth = YearMonth.now().minusMonths(1);
        // Creates a LocalDate object named startOfPreviousMonth for the 1st day of the previous month
        LocalDate startOfPreviousMonth = previousMonth.atDay(1);
        // Creates a LocalDate object named endOfPreviousMonth. The computer knows what the last day is so it does not have to be set
        LocalDate endOfPreviousMonth = previousMonth.atEndOfMonth();
        // Creates a DateTimeFormatter named dateFormatter
        // Defines the format pattern for the date (desired format)
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Transactions tempTransactions : this.transactions){
            // Getting date of transaction and formatting it to dateFormatter and then converting it to local date object
            // This is so the computer can compare the LocalDate to the other LocalDates
            LocalDate transactionDate = LocalDate.parse(tempTransactions.getDate(),dateFormatter);
            // If the date is NOT before the 1st AND is NOT after today
            if (!transactionDate.isBefore(startOfPreviousMonth) && !transactionDate.isAfter(endOfPreviousMonth)){
                System.out.println(tempTransactions);
            }
        }
    }
    private void yearToDate() {
        // Creates a LocalDate object for today's date and names it today
        LocalDate today = LocalDate.now();
        // Creates a LocalDate named startOfYear and sets it to getting the localDate and changing the date to the 1st day of the year
        LocalDate startOfYear = LocalDate.of(today.getYear(), 1, 1);
        // Creates a DateTimeFormatter named dateFormatter
        // Defines the format pattern for the date (desired format)
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // For each transaction in the list of transactions
        for (Transactions tempTransactions : this.transactions){
            // Getting date of transaction and formatting it to dateFormatter and then converting it to local date object
            // This is so the computer can compare the LocalDate to the other LocalDates
            LocalDate transactionDate = LocalDate.parse(tempTransactions.getDate(),dateFormatter);
            // If the date is NOT before the 1st of the year AND is NOT after today
            if (!transactionDate.isBefore(startOfYear) && !transactionDate.isAfter(today)){
                System.out.println(tempTransactions);
            }
        }
    }

    private void previousYear() {
        // Creates a LocalDate object for today's date and names it today
        LocalDate today = LocalDate.now();

        // Creates a DateTimeFormatter named dateFormatter
        // Defines the format pattern for the date (desired format)
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int previousYear = today.getYear() - 1;
        LocalDate startOfPreviousYear = LocalDate.of(previousYear, 1, 1);
        LocalDate endOfPreviousYear = LocalDate.of(previousYear, 12, 31);
        // For each transaction in the list of transactions
        for (Transactions tempTransactions : this.transactions){
            // Getting date of transaction and formatting it to dateFormatter and then converting it to local date object
            // This is so the computer can compare the LocalDate to the other LocalDates
            LocalDate transactionDate = LocalDate.parse(tempTransactions.getDate(),dateFormatter);
            // If the date is NOT before the 1st of the previous year AND is NOT after the end of the previous year
            if (!transactionDate.isBefore(startOfPreviousYear) && !transactionDate.isAfter(endOfPreviousYear)){
                System.out.println(tempTransactions);
            }
        }
    }

    private void searchByVendor() {
        System.out.print("Vendor Name: ");
        String vendorName = scanner.nextLine().trim();
        // For each transaction in the transaction list
        for (Transactions tempTransaction : this.transactions){
            // if
            // tempTransactions vendor's name is the same as user input (ignore casing)
            if (tempTransaction.getVendorName().equalsIgnoreCase(vendorName)){
                System.out.println(tempTransaction);
            }
        }
    }


}
