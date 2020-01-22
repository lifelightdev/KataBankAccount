package life.light.KataBankAccount;

import java.time.LocalDate;

public class Withdrawal extends Transaction {

    public Withdrawal(LocalDate date, int amount) {
        super(date, amount);
    }

    @Override
    public String getType() {
        return TypeTransaction.Withdrawal.toString();
    }

    @Override
    public int calculateBalance(int balance) {
        return balance - amount;
    }

}
