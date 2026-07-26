package com.restaurant.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static Connection con = null;

    public static Connection requestConnection() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                String dbUrl = System.getenv("DB_URL") != null ? System.getenv("DB_URL") : "jdbc:mysql://localhost:3306/restaurant_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
                String dbUser = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
                String dbPass = System.getenv("DB_PASS") != null ? System.getenv("DB_PASS") : "Sangu@1234";

                con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC Driver Not Found! Ensure mysql-connector-j jar is in WEB-INF/lib.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to MySQL Database! Check if MySQL server is running on localhost:3306 with password Sangu@1234.");
            e.printStackTrace();
        }
        return con;
    }
}
