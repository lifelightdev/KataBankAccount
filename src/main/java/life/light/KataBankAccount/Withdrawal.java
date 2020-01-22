package life.light.KataBankAccount;

import java.time.LocalDate;

public class Withdrawal extends Transaction {

    private LocalDate date;
    private int amount;

    public Withdrawal(LocalDate date, int amount) {
        super();
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
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
