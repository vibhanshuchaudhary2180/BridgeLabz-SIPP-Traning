package Day_2_static_Final.Level_1;

class BankAccount {
    static String bankName = "State Bank of India";
    static int totalAccounts = 0;

    private String accountHolderName;
    final String accountNumber;

    BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Bank Name: " + bankName);
        }
    }
}
