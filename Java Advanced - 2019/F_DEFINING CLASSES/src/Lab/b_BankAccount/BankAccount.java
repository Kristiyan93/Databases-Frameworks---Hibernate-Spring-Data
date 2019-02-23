package Lab.b_BankAccount;

public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;

    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountsCount;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++bankAccountsCount;
        this.balance = 0.0;
    }

    @Override
    public String toString() {
        return String.format("Account ID%d created", this.id);
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public static void setInterest(Double interest) {
        rate = interest;
    }

    public Double getInterest(Integer years) {
        return rate * getBalance() * years;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }
}
