import java.util.ArrayList;

public class User {
    private String accountNumber;
    private String pin;
    private double balance;
    private ArrayList<String> miniStatement;

    
    public User(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.miniStatement = new ArrayList<>();
    }

    // for getting data in other files of object created...
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String newPin) {
        this.pin = newPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        miniStatement.add("Deposited ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        miniStatement.add("Withdrawn ₹" + amount);
        return true;
    }

    public ArrayList<String> getMiniStatement() {
        
        return miniStatement;
    }
}
