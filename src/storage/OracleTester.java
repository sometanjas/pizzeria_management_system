package src.storage;

import src.storage.OracleDsSingleton;

import java.sql.*;
public class OracleTester {
    public static void main(String[] args) {
        OracleDsSingleton ora = OracleDsSingleton.getInstance();
        try {
            Connection con = ora.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Highscore";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String last = rs.getString("Name");
                System.out.println("Name: " + last);
            }
        } catch (SQLException e) {}
    }
}