package life.light.KataBankAccount;

import java.time.LocalDate;

abstract class Transaction {
    abstract LocalDate getDate();
    abstract int getAmount();
    abstract String getType();
    abstract int calculateBalance(int balance);
}
