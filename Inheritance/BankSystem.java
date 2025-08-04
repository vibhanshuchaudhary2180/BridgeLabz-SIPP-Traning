// Base class
class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

// Subclass 1
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Savings Account with Interest Rate: " + interestRate + "%");
    }
}

// Subclass 2
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Checking Account with Withdrawal Limit: $" + withdrawalLimit);
    }
}

// Subclass 3
class FixedDepositAccount extends BankAccount {
    private int termMonths;

    public FixedDepositAccount(String accountNumber, double balance, int termMonths) {
        super(accountNumber, balance);
        this.termMonths = termMonths;
    }

    public void displayAccountType() {
        System.out.println("Fixed Deposit Account with Term: " + termMonths + " months");
    }
}


public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA001", 5000, 4.5);
        CheckingAccount ca = new CheckingAccount("CA001", 3000, 1000);
        FixedDepositAccount fda = new FixedDepositAccount("FDA001", 10000, 12);

        sa.displayAccountType();
        ca.displayAccountType();
        fda.displayAccountType();
    }
}
