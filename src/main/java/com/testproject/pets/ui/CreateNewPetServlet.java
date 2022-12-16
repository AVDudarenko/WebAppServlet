package com.testproject.pets.ui;

import com.testproject.pets.businesslogic.Pet;
import com.testproject.pets.businesslogic.PetsDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * In this class we create new pet
 */

@WebServlet(name = "createNewPetServlet", value = "/createNewPet")
public class CreateNewPetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/createNewPet.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String color = request.getParameter("color");
            String owner = request.getParameter("owner");
            Pet pet = new Pet(name, age, color, owner);
            PetsDB.insert(pet);
            response.sendRedirect(request.getContextPath() + "/allPetsInfo");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/createNewPet.jsp").forward(request, response);
        }
    }
}
