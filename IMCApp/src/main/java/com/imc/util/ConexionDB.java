package com.imc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USER = "imc_user";
    private static final String PASSWORD = "imc123";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error cargando el driver");
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
