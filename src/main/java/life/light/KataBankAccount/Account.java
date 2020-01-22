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
        balance = depositTransaction.calculateBalance(balance);
    }

    public void withdrawal(Transaction withdrawalTransaction) {
        transactions.add(withdrawalTransaction);
        balance = withdrawalTransaction.calculateBalance(balance);
    }

    public String history() {
        int balance = ZERO;
        StringBuilder history = new StringBuilder();
        for (Transaction transaction: transactions){
            balance = transaction.calculateBalance(balance);
            history.append(getLineOfHistory(balance, transaction));
        }
        return history.toString();
    }

    private String getLineOfHistory(int balance, Transaction transaction) {
        String columnSeparator = " | ";
        String line = transaction.getType() +
                columnSeparator +
                transaction.getDate() +
                columnSeparator +
                transaction.getAmount() +
                columnSeparator +
                balance +
                System.getProperty("line.separator");
        return line;
    }

}
