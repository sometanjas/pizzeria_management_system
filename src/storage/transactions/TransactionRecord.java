package src.storage.transactions;

public class TransactionRecord {
    int value;
    Integer orderID;
    Integer transactionID;

    public TransactionRecord(int value, Integer orderID, Integer transactionID) {
        this.value = value;
        this.orderID = orderID;
        this.transactionID = transactionID;
    }

    public static TransactionRecord NewPurchaseTransactionRecord(int value) {
        if (value > 0) {
            value = -1 * value;
        }
        return new TransactionRecord(value, null, null);
    }

    public static TransactionRecord NewOrderTransactionRecord(int value, int orderID) {
        if (value < 0) {
            value = -1 * value;
        }
        return new TransactionRecord(value, orderID, null);
    }

    public boolean isOrder() {
        return orderID != null;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public int getValue() {
        return value;
    }

}
