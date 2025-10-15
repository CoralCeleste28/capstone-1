// These imports are for the local date and time
// The third import formats the date and time
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Class named Transactions
public class Transactions {
    // gets the current date and time
    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();

    // Defines the format patterns for date and time
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Officially formats the date and time
    String formattedDate = currentDate.format(dateFormatter);
    String formattedTime = currentTime.format(timeFormatter);

    // Class Field Variables. Only exist here
    private String date;
    private String time;
    private String transactionDescription;
    private String vendorName;
    private double depositAmount;

    // Parameterless Constructor
    public Transactions() {
        this.date = LocalDate.now().format(dateFormatter);
        this.time = LocalTime.now().format(timeFormatter);
        this.transactionDescription = "";
        this.vendorName = "";
        this.depositAmount = 0;
    }

    // This constructor has five parameters
    public Transactions(String date, String time, String transactionDescription, String vendorName, double depositAmount){
        this.date = date;
        this.time = time;
        this.transactionDescription = transactionDescription;
        this.vendorName = vendorName;
        this.depositAmount = depositAmount;
    }

    // Getters
    // Methods to get information
    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public String getTransactionDescription(){
        return transactionDescription;
    }

    public String getVendorName(){
        return vendorName;
    }

    public double getDepositAmount(){
        return depositAmount;
    }

    // Setters
    public void setDate(String date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }

    public void setTransactionDescription(String transactionDescription){
        this.transactionDescription = transactionDescription;
    }

    public void setVendorName(String vendorName){
        this.vendorName = vendorName;
    }

    public void setDepositAmount(Double depositAmount){
        this.depositAmount = depositAmount;
    }

    public void addDeposit(String transactionDescription, String vendorName, double depositAmount){
        this.date = LocalDate.now().format(dateFormatter);
        this.time = LocalTime.now().format(timeFormatter);
        this.transactionDescription = transactionDescription;
        this.vendorName = vendorName;
        this.depositAmount = depositAmount;

        System.out.println("Deposit Completed");
        System.out.println("Deposit Information Below: ");
        System.out.println("Date: " + this.date);
        System.out.println("Time: " + this.time);
        System.out.println("Description: " + this.transactionDescription);
        System.out.println("Vendor: " + this.vendorName);
        System.out.println("Amount: " + this.depositAmount);
    }

    public void saveTransaction(String filePath){
        try(FileWriter writer = new FileWriter(filePath,true)){
             writer.write(this.date + " | " + this.time + " | " + this.transactionDescription + " | " + this.vendorName + " | " + this.depositAmount + "\n");
        }catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }

    }


}

