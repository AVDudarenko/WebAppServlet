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
 * In this servlet we are edit record about Pet
 */

@WebServlet(name = "editPetInfoServlet", value = "/editPetInfo")
public class EditPetInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Pet pet = PetsDB.selectOne(id);
            if (pet != null) {
                request.setAttribute("pet", pet);
                getServletContext().getRequestDispatcher("/editPetInfo.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String color = request.getParameter("color");
            String owner = request.getParameter("owner");
            Pet pet = new Pet(id, name, age, color, owner);
            PetsDB.update(pet);
            response.sendRedirect(request.getContextPath() + "/allPetsInfo");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
