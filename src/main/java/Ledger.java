import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Ledger {
    public static void ledgerOptions(){
        System.out.print("""
                (A) All
                (D) Deposits
                (P) Payments
                (R) Reports
                (0) Back - go back to the Ledger page
                (H) Home - go back to the home page
    """);
    }

    // Makes a list named Transactions
    private List<Transactions> transactions;

    // Constructor named Ledger. (parameter)
    public Ledger(String filePath){
        Transactions transactionsTemp;

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

                    Transactions t = new Transactions(date, time, transactionDescription, vendorName, depositAmount);
                    transactions.add(t);
                }
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
