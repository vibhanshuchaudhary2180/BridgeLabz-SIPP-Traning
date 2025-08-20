package Day_3_Object_Oriented_Design_principle;

public class BankAccount {
    public static void main(String[] args) {
        Bank bank = new Bank("State Bank of India");
        Customer customer = new Customer("Rahul");
        bank.openAccount(customer, 5000);
        customer.viewBalance();
    }
}

class Customer {
    String name;
    double balance;

    Customer(String name) {
        this.name = name;
        this.balance = 0;
    }

    void viewBalance() {
        System.out.println(name + "'s Balance: ₹" + balance);
    }

    void deposit(double amount) {
        balance += amount;
    }
}

class Bank {
    String bankName;

    Bank(String bankName) {
        this.bankName = bankName;
    }

    void openAccount(Customer c, double initialDeposit) {
        System.out.println(c.name + " opened an account in " + bankName);
        c.deposit(initialDeposit);
    }
}

