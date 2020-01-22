package life.light.KataBankAccount;

import java.time.LocalDate;

public class Deposit extends Transaction {

    public Deposit(LocalDate date, int amount) {
        super(date, amount);
    }

    @Override
    public String getType() {
        return TypeTransaction.Deposit.toString();
    }

    @Override
    public int calculateBalance(int balance) {
        return balance + amount;
    }

}
