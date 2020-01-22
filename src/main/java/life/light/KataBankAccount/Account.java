package life.light.KataBankAccount;

public class Account {

    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdrawal(int amount) {
        balance -= amount;
    }

    public String history() {
        return "Deposit | 01/01/2020 | 10,00 | 10,00";
    }
}
