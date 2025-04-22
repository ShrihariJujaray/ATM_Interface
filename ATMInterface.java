import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        // users
        BankDatabase.addUser(new User("1001", "1234", 5000));
        BankDatabase.addUser(new User("1002", "5678", 10000));

        System.out.println(" Welcome to Secure ATM");  // Lock emoji

        // login
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();
        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (atm.login(accNo, pin)) {
            System.out.println(" Login successful!");  

            // otp validation
            String generatedOTP = OTPService.generateOTP();
            System.out.println(" Your OTP is: " + generatedOTP);  
            System.out.print("Enter OTP to continue: ");
            String enteredOTP = sc.next();

            if (atm.verifyOTP(generatedOTP, enteredOTP)) {
                System.out.println(" OTP verified. Access granted.");
                
                while (true) {
                    System.out.println("===== ATM Menu =====\n");
                    System.out.println(" 1#  Deposit");
                    System.out.println(" 2#  Withdraw");
                    System.out.println(" 3#  Balance Enquiry");
                    System.out.println(" 4# Mini Statement");
                    System.out.println(" 5#  Change PIN");
                    System.out.println(" 6#  Exit");
                    System.out.print("Choose an option: ");

                    int choice = sc.nextInt();
                    double amount;
                    String newPin;

                    switch (choice) {
                        case 1:
                            System.out.print("Enter amount to deposit: ₹");
                            amount = sc.nextDouble();
                            atm.deposit(amount);
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ₹");
                            amount = sc.nextDouble();
                            atm.withdraw(amount);
                            break;
                        case 3:
                            atm.showBalance();
                            break;
                        case 4:
                            atm.showMiniStatement();
                            break;
                        case 5:
                            System.out.print("Enter new 4-digit PIN: ");
                            newPin = sc.next();
                            if (newPin.length() == 4) {
                                atm.changePin(newPin);
                            } else {
                                System.out.println("\u274C Invalid PIN format. Must be 4 digits.");  
                            }
                            break;
                        case 6:
                            System.out.println("\uD83D\uDC4B Thank you for using Secure ATM!");  
                            System.exit(0);
                        default:
                            System.out.println("\u274C Invalid choice. Please try again.");  
                    }
                }

            } else {
                System.out.println(" Incorrect OTP. Exiting.");  
            }

        } else {
            System.out.println(" Invalid credentials. Access denied.");  
        }

        sc.close();
    }
}
