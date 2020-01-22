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
        int balance = ZERO;
        StringBuilder history = new StringBuilder();
        for (Transaction transaction: transactions){
            balance = calculateBalance(balance, transaction);
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

    private int calculateBalance(int balance, Transaction transaction) {
        if (TypeTransaction.Deposit.equals(transaction.getType())) {
            balance = balance + transaction.getAmount();
        } else {
            balance = balance - transaction.getAmount();
        }
        return balance;
    }
}
