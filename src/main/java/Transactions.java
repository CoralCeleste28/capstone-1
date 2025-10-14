import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Class named cellphone
public class Transactions {
    // gets the current date and time
    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();

    // Defines the format patterns for date and time
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Officially formats the date and time
    String formattedDate = currentDate.format(dateFormatter);
    String formattedTime = currentTime.format(timeFormatter);

    // Class Field Variables. Only exist here
    private String date;
    private String time;
    private String transactionDescription;
    private String vendorName;
    private int depositAmount;

    // Parameterless Constructor
    public Transactions() {
        this.date = "";
        this.time = "";
        this.transactionDescription = "";
        this.vendorName = "";
        this.depositAmount = 0;

    }

    // This constructor has five parameters
    public Transactions(String date, String time, String transactionDescription, String vendorName, int depositAmount){
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

    public int getDepositAmount(){
        return depositAmount;
    }

    // Setters
    public void setDate(String date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }

    public void setTransactionDescription(){
        this.transactionDescription = transactionDescription;
    }

    public void setVendorName(){
        this.vendorName = vendorName;
    }

    public void setDepositAmount(){
        this.depositAmount = depositAmount;
    }

    public void addDeposit(String transactionDescription, String vendorName, int depositAmount){
        System.out.print("Deposit Completed");
        System.out.println("Deposit Information Below: ");
        System.out.print("Date: " + formattedDate);
        System.out.print("Time: " + formattedTime);
        System.out.print("Description: ");
        System.out.print("Vendor: ");
        System.out.print("Amount: ");
    }

}

