import java.util.ArrayList;

public class ATM {
    private User currentUser;

    // login process
    public boolean login(String accNo, String pin) {
        User user = BankDatabase.getUser(accNo);
        if (user != null && user.getPin().equals(pin)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    // OTP validation
    public boolean verifyOTP(String generatedOTP, String enteredOTP) {
        return generatedOTP.equals(enteredOTP);
    }

    public void deposit(double amount) {
        currentUser.deposit(amount);
        System.out.println(" ₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (currentUser.withdraw(amount)) {
            System.out.println(" ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println(" Insufficient balance.");
        }
    }

    public void showBalance() {
        System.out.println(" Current Balance: ₹" + currentUser.getBalance());
    }

    public void showMiniStatement() {
        System.out.println(" Mini Statement:");
        ArrayList<String> stmt = currentUser.getMiniStatement();

        if (stmt.isEmpty()) {
            System.out.println("Make some transactions dude");
        }
        else 
            for (String entry : stmt) {
                System.out.println("• " + entry);
            }
        System.out.println("Available Balance " + currentUser.getBalance());

    }

    public void changePin(String newPin) {
        currentUser.setPin(newPin);
        System.out.println(" PIN changed successfully.");
    }
}
