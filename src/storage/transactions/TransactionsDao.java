package src.storage.transactions;

import java.util.List;

public interface TransactionsDao {
    List<TransactionRecord> getAllTransactions();

    void addTransaction(TransactionRecord transactionRecord);
}
