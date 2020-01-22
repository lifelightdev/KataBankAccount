package life.light.KataBankAccount;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final static int ZERO = 0;
    private int balance = ZERO;
    private List<Transaction> transactions = new ArrayList<>();

    public int getBalance() {
        return balance;
    }

    public void deposit(Transaction depositTransaction) {
        transactions.add(depositTransaction);
        balance += depositTransaction.getAmount();
    }

    public void withdrawal(Transaction withdrawalTransaction) {
        transactions.add(withdrawalTransaction);
        balance -= withdrawalTransaction.getAmount();
    }

    public String history() {
        String columnSeparator = " | ";
        int balance = ZERO;
        StringBuilder history = new StringBuilder();
        for (Transaction transaction: transactions){
            if (TypeTransaction.Deposit.equals(transaction.getType())) {
                balance = balance + transaction.getAmount();
            } else {
                balance = balance - transaction.getAmount();
            }
            history.append(transaction.getType())
                    .append(columnSeparator)
                    .append(transaction.getDate())
                    .append(columnSeparator)
                    .append(transaction.getAmount())
                    .append(columnSeparator)
                    .append(balance)
                    .append(System.getProperty("line.separator"));
        }
        return history.toString();
    }
}
