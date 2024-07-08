package src.storage.warehouse;

import src.ingredient.Ingredient;
import src.storage.OracleDsSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDaoDbImpl implements WarehouseDao {

    private static WarehouseDaoDbImpl self = null;

    private WarehouseDaoDbImpl() {
    }

    public static WarehouseDaoDbImpl getInstance() {
        if (self == null) self = new WarehouseDaoDbImpl();
        return self;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        String sql = "SELECT * FROM warehouse";

        List<Ingredient> ingredients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = OracleDsSingleton.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();


            while (resultSet.next()) {
                Ingredient ingredient = this.extractIngredient(resultSet);
                ingredients.add(ingredient);
            }
        } catch (Exception e) {
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
        return ingredients;
    }

    private Ingredient extractIngredient(ResultSet resultSet) throws Exception {
        String name = resultSet.getString("name");
        int value = resultSet.getInt("value");

        return new Ingredient(name, value);
    }

    @Override
    public void withdrawIngredient(String name, int delta) {
        String sql = "UPDATE warehouse SET value = value - ? WHERE name = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = OracleDsSingleton.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, delta);
            statement.setString(2, name);

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

    @Override
    public void depositIngredient(String name, int delta) {
        String sql = "UPDATE warehouse SET value = value + 1000 * ? WHERE name = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = OracleDsSingleton.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, delta);
            statement.setString(2, name);

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
