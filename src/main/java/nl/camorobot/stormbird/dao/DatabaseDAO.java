package nl.camorobot.stormbird.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseDAO {
    Dotenv dotenv = null;

    public Connection connect(){
        dotenv = Dotenv.configure().load();

        /** Create database connection */
        String connectionUrl = String.format("jdbc:sqlserver://localhost;database=Stormbird;user=sa;password=%s", dotenv.get("DBPASS"));
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
