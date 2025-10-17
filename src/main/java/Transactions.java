// Used to write text to files
import java.io.FileWriter;
// Handles errors that might happen while writing to a file
import java.io.IOException;
// These imports are for the local date and time
// The third import formats the date and time
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
    // Variables that make up a transaction
    private String date;
    private String time;
    private String transactionDescription;
    private String vendorName;
    private double depositAmount;

    // Parameterless Constructor
    // Runs when a new transaction is made without the user inputs
    public Transactions() {
        // Get the local date/time right now and format it to the indicated variable
        this.date = formattedDate;
        this.time = formattedTime;
        // Initializes the field with its respective data type
        this.transactionDescription = "";
        this.vendorName = "";
        this.depositAmount = 0;
    }

    // This constructor has five parameters
    // Passes the user input into the transaction and sets it as the variable
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

    public void updateTransaction(String transactionDescription, String vendorName, double depositAmount){
        this.date = formattedDate;
        this.time = formattedTime;
        this.transactionDescription = transactionDescription;
        this.vendorName = vendorName;
        this.depositAmount = depositAmount;

        System.out.println("------------------------------------");
        System.out.println("Transaction Information Below: ");
        System.out.println("Date: " + this.date);
        System.out.println("Time: " + this.time);
        System.out.println("Description: " + this.transactionDescription);
        System.out.println("Vendor: " + this.vendorName);
        System.out.println("Amount: " + this.depositAmount);
        System.out.println("------------------------------------");
    }

    public void saveDepositTransaction(String filePath){
        //
        try(FileWriter writer = new FileWriter(filePath,true)){
            writer.write(this.date + "|" + this.time + "|" + this.transactionDescription + "|" + this.vendorName + "|" + this.depositAmount + "\n");
        }catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }

    }
    public void savePaymentTransaction(String filePath){
        // changes the value of the user input to negative since it is a payment
        this.depositAmount = this.depositAmount * -1;
        //***********************
        // Try catch with resources
        // Create a new file writer named writer and have it add
        try(FileWriter writer = new FileWriter(filePath,true)){
            writer.write(this.date + "|" + this.time + "|" + this.transactionDescription + "|" + this.vendorName + "|" + this.depositAmount + "\n");
            // Exception needed for writer and reader
        }catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }
    }

    // Had to fix bug and override reference numbers
    @Override
    // Make a method String named toString
    // Doesn't have to be called. Default for printing
    public String toString() {
        // format for toString
        return this.date + " | " + this.time + " | " + this.transactionDescription + " | " + this.vendorName + " | " + this.depositAmount;
    }
}

