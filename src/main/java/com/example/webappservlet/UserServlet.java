package com.example.webappservlet;

import data.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet who create new User and then sed user data to user.jsp
 */
@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User sasha = new User("Sasha", 27);
        req.setAttribute("user", sasha);
        getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
    }
}
