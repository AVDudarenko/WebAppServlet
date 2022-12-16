package com.testproject.pets.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import static com.testproject.pets.businesslogic.DataBaseConnection.getDBConnection;

/**
 * Servlet for working with information from DB.
 */

@WebServlet(name = "petsServlet", value = "/pets")
public class PetsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try (Connection connection = getDBConnection()) {
            writer.println("Connection to PetsDB success!");
        } catch (Exception ex) {
            writer.println("Connection failed...");
            writer.println(ex);
        } finally {
            writer.close();
        }
    }


}
