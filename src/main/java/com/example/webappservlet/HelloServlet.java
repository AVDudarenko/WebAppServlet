package com.example.webappservlet;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        double numberOne = Double.parseDouble(request.getParameter("numberOne"));
        double numberTwo = Double.parseDouble(request.getParameter("numberTwo"));
        String operationType = request.getParameter("operation");

        if (!isDivideByNull(numberOne, numberTwo)) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("<p>" + numberOne + "</p>");
            out.println("<p>" + numberTwo + "</p>");
            out.println("<p>" + operationType + "</p>");
            out.println("<p>" + "Result of operation: " + calculateData(numberOne, numberTwo, operationType) + "</p>");
            out.println("<p> <a href= errorPage>" + "Can I divide by null?" + "</a> </p>");
            out.println("</body></html>");
        } else {
            redirectToErrorPage(request, response);
        }

    }

    public void destroy() {
    }

    private int increaseParameterNumber(HttpServletRequest request) {

        return Integer.parseInt(request.getParameter("numberOne")) * 2;
    }

    private double calculateData(double numberOne, double numberTwo, String operationType) {
        double result = 0.0;

        switch (operationType) {
            case "Divide" -> result = numberOne / numberTwo;

            case "Multiply" -> result = numberOne * numberTwo;

            case "Sum" -> result = numberOne + numberTwo;

            case "Subtraction" -> result = numberOne - numberTwo;

        }
        return result;
    }

    private boolean isDivideByNull(double numberOne, double numberTwo) {
        return (numberOne == 0.0 || numberTwo == 0.0);
    }

    private void redirectToErrorPage(HttpServletRequest request, HttpServletResponse response) {
        String path = "/errorPage";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}