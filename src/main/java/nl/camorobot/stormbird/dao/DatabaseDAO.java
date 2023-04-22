package nl.camorobot.stormbird.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DatabaseDAO {
    public Connection connect(){
        /** Create database connection */
        String connectionUrl = "jdbc:sqlserver://localhost;database=Stormbird;user=sa;password=23Kn@10#15";
        Connection con = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            DriverManager.registerDriver(new SQLServerDriver());
            return con = DriverManager.getConnection(connectionUrl);
        }
        catch (SQLException e) {
//            throw new DatabaseConnectionException(e);
        }
        catch (Exception e) {
//            throw new DatabaseConnectionException((SQLException) e);
        }
        return con;
    }
}
