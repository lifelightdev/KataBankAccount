package life.light.KataBankAccount;

import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private int amount;
    private TypeTransaction type;

    public Transaction(LocalDate date, int amount, TypeTransaction type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public TypeTransaction getType() {
        return type;
    }
}
