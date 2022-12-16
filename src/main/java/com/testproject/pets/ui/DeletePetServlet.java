package com.testproject.pets.ui;

import com.testproject.pets.businesslogic.PetsDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * In this class we are delete pet
 */

@WebServlet(name = "deletePetServlet", value = "/deletePet")
public class DeletePetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Try to get id of pet and delete them from DB. If we don't find them, redirect to notfound.jsp
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            PetsDB.delete(id);
            response.sendRedirect(request.getContextPath() + "/allPetsInfo");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }

    }
}
