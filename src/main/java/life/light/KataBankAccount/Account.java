package life.light.KataBankAccount;

public class Account {

    private int balance = 0;

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        balance =+ amount;
    }
}
