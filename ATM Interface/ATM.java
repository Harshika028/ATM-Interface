import java.util.ArrayList;
import java.util.Scanner;

class User {
    private String userID;
    private String userPIN;
    private double accountBalance;
    private ArrayList<String> transactionHistory;

    public User(String userID, String userPIN) {
        this.userID = userID;
        this.userPIN = userPIN;
        this.accountBalance = 1000.0; // Initial balance
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String enteredUserID, String enteredPIN) {
        return userID.equals(enteredUserID) && userPIN.equals(enteredPIN);
    }

    public void showBalance() {
        System.out.println("Your balance is $" + accountBalance);
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > accountBalance) {
            System.out.println("Invalid amount or insufficient balance.");
        } else {
            accountBalance -= amount;
            transactionHistory.add("Withdrawal: $" + amount);
            System.out.println("Withdrawal successful.");
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            accountBalance += amount;
            transactionHistory.add("Deposit: $" + amount);
            System.out.println("Deposit successful.");
        }
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class ATM {
    public static void main(String[] args) {
        User user = new User("123456", "5678"); // Replace with your user ID and PIN
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your user ID: ");
        String enteredUserID = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String enteredPIN = scanner.nextLine();

        if (user.authenticate(enteredUserID, enteredPIN)) {
            System.out.println("Welcome to the ATM!");
            while (true) {
                System.out.println("---------------------------");
                System.out.println("Choose an option:");
                System.out.println("1. Show Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Show Transaction History");
                System.out.println("5. Quit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        user.showBalance();
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        user.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        user.deposit(depositAmount);
                        break;
                    case 4:
                        user.showTransactionHistory();
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid user ID or PIN. Access denied.");
        }
    }
}

