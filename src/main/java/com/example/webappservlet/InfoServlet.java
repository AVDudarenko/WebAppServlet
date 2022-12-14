package com.example.webappservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * In this servlet we send data of attributes in info.jsp. And then we show them on the page.
 */
@WebServlet(name = "infoServlet", value = "/info")
public class InfoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("name", "Sasha");
        request.setAttribute("message", "I love Java");
        request.setAttribute("isEnable", "true");

        getServletContext().getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
