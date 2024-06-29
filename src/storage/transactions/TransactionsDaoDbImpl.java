package src.storage.transactions;

import src.storage.OracleDsSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionsDaoDbImpl implements TransactionsDao {

    private static TransactionsDaoDbImpl self = null;

    private TransactionsDaoDbImpl() {
    }

    public static TransactionsDaoDbImpl getInstance() {
        if (self == null) self = new TransactionsDaoDbImpl();
        return self;
    }

    @Override
    public List<TransactionRecord> getAllTransactions() {
        String sql = "SELECT * FROM transactions";

        List<TransactionRecord> records = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = OracleDsSingleton.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();


            while (resultSet.next()) {
                TransactionRecord record = this.extractTransaction(resultSet);
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return records;
    }

    private TransactionRecord extractTransaction(ResultSet resultSet) throws SQLException {
        int value = resultSet.getInt("value");
        Integer orderId = resultSet.getInt("order_id");
        Integer transactionId = resultSet.getInt("transaction_id");
        return new TransactionRecord(value, orderId, transactionId);
    }

    @Override
    public void addTransaction(TransactionRecord transactionRecord) {
        String sql = "INSERT INTO transactions (value, order_id) VALUES (?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = OracleDsSingleton.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, transactionRecord.getValue());
            if (transactionRecord.isOrder()) {
                statement.setInt(2, transactionRecord.getOrderID());
            } else {
                statement.setNull(2, Types.INTEGER);
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
