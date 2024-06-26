package src.storage.order;

import src.storage.OracleDsSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoDbImpl implements OrderDao {

    private static OrderDaoDbImpl self = null;

    private OrderDaoDbImpl() {
    }

    public static OrderDaoDbImpl getInstance() {
        if (self == null) self = new OrderDaoDbImpl();
        return self;
    }

    @Override
    public List<OrderRecord> getAllOrders() {
        String sql = "SELECT * FROM orders";

        List<OrderRecord> orderRecords = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = OracleDsSingleton.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();


            while (resultSet.next()) {
                OrderRecord orderRecord = this.extractOrder(resultSet);
                orderRecords.add(orderRecord);
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
        return orderRecords;
    }

    private OrderRecord extractOrder(ResultSet resultSet) throws SQLException {
        boolean lieferung = resultSet.getBoolean("lieferung");
        int lpz = resultSet.getInt("lpz");
        String firstname = resultSet.getString("firstname");
        String secondname = resultSet.getString("secondname");
        String address = resultSet.getString("address");
        int floor = resultSet.getInt("floor");
        String telefon = resultSet.getString("telefon");
        int orderid = resultSet.getInt("orderid");
        OrderRecord or = new OrderRecord(lieferung, lpz, firstname, secondname, address, floor, telefon);
        or.setOrderID(orderid);
        return or;
    }

    @Override
    public void addOrder(OrderRecord orderRecord) {
        String sql = "INSERT INTO orders (lieferung, plz, firstname, secondname, address, floor, telefon, orderid) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = OracleDsSingleton.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, orderRecord.isLieferung());
            statement.setInt(2, orderRecord.getPlz());
            statement.setString(3, orderRecord.getFirstname());
            statement.setString(4, orderRecord.getSecondname());
            statement.setString(5, orderRecord.getAddress());
            statement.setInt(6, orderRecord.getFloor());
            statement.setString(7, orderRecord.getTelefon());
            statement.setInt(8, orderRecord.getOrderID());

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
