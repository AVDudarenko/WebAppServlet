package com.example.webappservlet;

import data.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * In this class, we are connected to MySQL DB.
 */

@WebServlet(name = "petsServlet", value = "/pets")
public class PetsServlet extends HttpServlet {

    static String dbms = "mysql";
    static String serverName = "localhost";
    static String portNumber = "3306";
    static String dbName = "pets";
    static String userOfDataBase = "root";
    static String passwordOfDataBase = "26061995";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try (Connection connection = getDBConnection();) {

            writer.println("Connection to PetsDB success!");
        } catch (Exception ex) {
            writer.println("Connection failed...");
            writer.println(ex);
        } finally {
            writer.close();
        }
    }

    /**
     * Method for connect to database
     *
     * @return - return connection object
     * @throws SQLException
     */
    private static Connection getDBConnection() throws SQLException {
        Connection conn;
        Properties connectionProps = new Properties();
        connectionProps.put("user", userOfDataBase);
        connectionProps.put("password", passwordOfDataBase);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        if (!dbName.isEmpty() && dbName != null) {
            conn = DriverManager.getConnection(
                    "jdbc:" + dbms + "://" +
                            serverName +
                            ":" + portNumber + "/"
                            + dbName,
                    connectionProps);
        } else {
            conn = DriverManager.getConnection(
                    "jdbc:" + dbms + "://" +
                            serverName +
                            ":" + portNumber + "/",
                    connectionProps);
        }

        System.out.println("Connected to database");
        return conn;
    }
}
