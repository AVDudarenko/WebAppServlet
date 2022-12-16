package com.testproject.pets.ui;

import com.testproject.pets.businesslogic.Pet;
import com.testproject.pets.businesslogic.PetsDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * In this class we get all records from DB and send them to allPetsInfo.jsp
 */

@WebServlet(name = "allPetsInfoServlet", value = "/allPetsInfo")
public class AllPetsInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Pet> pets = PetsDB.select();
        request.setAttribute("pets", pets);
        getServletContext().getRequestDispatcher("/allPetsInfo.jsp").forward(request, response);
    }
}
