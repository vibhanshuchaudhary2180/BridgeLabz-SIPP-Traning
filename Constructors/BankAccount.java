class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accNo, String holder, double balance) {
        this.accountNumber = accNo;
        this.accountHolder = holder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accNo, String holder, double balance) {
        super(accNo, holder, balance);
    }

    public void showAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: ₹" + getBalance());
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("7890", "Shreya", 10000);
        sa.deposit(2000);
        sa.showAccount();
    }
}