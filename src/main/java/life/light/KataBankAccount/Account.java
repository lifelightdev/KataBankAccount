package life.light.KataBankAccount;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int balance = 0;
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
        int balance = 0;
        StringBuilder history = new StringBuilder();
        for (Transaction transaction: transactions){
            if (TypeTransaction.Deposit.equals(transaction.getType())) {
                balance = balance + transaction.getAmount();
            } else {
                balance = balance - transaction.getAmount();
            }
            history.append(transaction.getType())
                    .append(" | ")
                    .append(transaction.getDate())
                    .append(" | ")
                    .append(transaction.getAmount())
                    .append(" | ")
                    .append(balance)
                    .append(" \n");
        }
        return history.toString();
    }
}
