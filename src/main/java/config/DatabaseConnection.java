package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    private static final String URL = 
            "jdbc:postgresql://localhost:5432/employee_management_system";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Deepak__1044";

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException{ 
            return DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );
    }
}