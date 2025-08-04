import java.util.*;

// Interface: Loanable
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract Class: BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    // Concrete Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited ₹" + amount + ". New balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew ₹" + amount + ". New balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Abstract Method
    public abstract double calculateInterest();

    // Display Account Summary
    public void displaySummary() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Current Balance: ₹" + balance);
        System.out.println("Interest Earned: ₹" + calculateInterest());
        if (this instanceof Loanable) {
            System.out.println("Loan Eligibility: ₹" + ((Loanable) this).calculateLoanEligibility());
        } else {
            System.out.println("Loan service not available for this account type.");
        }
        System.out.println("----------------------------------");
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account loan application for ₹" + amount + " submitted.");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; // Eligible up to 5 times balance
    }
}

// Subclass: CurrentAccount
class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest on current account
    }
}


public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 = new SavingsAccount("SB1001", "Ravi Kumar", 50000);
        BankAccount acc2 = new CurrentAccount("CA2001", "Sneha Patel", 100000);

        accounts.add(acc1);
        accounts.add(acc2);

        // Perform transactions
        acc1.deposit(10000);
        acc2.withdraw(15000);

        // Polymorphism: Process accounts uniformly
        for (BankAccount acc : accounts) {
            acc.displaySummary();
        }

        // Loan Application (only for Loanable types)
        if (acc1 instanceof Loanable) {
            ((Loanable) acc1).applyForLoan(100000);
        }
    }
}