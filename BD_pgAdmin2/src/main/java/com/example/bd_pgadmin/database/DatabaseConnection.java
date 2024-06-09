package com.example.bd_pgadmin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static Connection dbLink;

    public static Connection getConnection() {
        String dbName = "ProyekAkhir";
        String dbUser = "postgres";
        String dbPass = "passwordmu";
        String url = "jdbc:postgresql://localhost:5432/" + dbName;
        try {
            dbLink = DriverManager.getConnection(url, dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbLink;
    }

    public static Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }
}