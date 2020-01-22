package life.light.KataBankAccount;

import java.time.LocalDate;

abstract class Transaction {

    private LocalDate date;
    protected int amount;

    public Transaction(LocalDate date, int amount) {
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
    abstract String getType();
    abstract int calculateBalance(int balance);
}
