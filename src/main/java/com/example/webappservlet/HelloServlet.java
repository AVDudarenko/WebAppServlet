package com.example.webappservlet;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        double numberFirst = Double.parseDouble(request.getParameter("numberOne"));
        double numberSecond = Double.parseDouble(request.getParameter("numberTwo"));
        String operationType = request.getParameter("operation");
        double resultOfOperation = 0;

        switch (operationType) {
            case "Divide":
                resultOfOperation = numberFirst / numberSecond;
                break;
            case "Multiply":
                resultOfOperation = numberFirst * numberSecond;
                break;
            case "Sum":
                resultOfOperation = numberFirst + numberSecond;
                break;
            case "SubtractionSubtraction":
                resultOfOperation = numberFirst - numberSecond;
                break;

        }

        try {
            writer.println("<h2>Result of operation: " + resultOfOperation + "</h2>");
        } finally {
            writer.close();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            String numberOne = request.getParameter("numberOne");
            String numberTwo = request.getParameter("numberTwo");
            String operation = request.getParameter("operation");
            writer.println("<p>numberOne: " + numberOne + "</p>");
            writer.println("<p>numberTwo: " + numberTwo + "</p>");
            writer.println("<p>Operation: " + operation + "</p>");
        }
    }

    public void destroy() {
    }

    private int increaseParameterNumber(HttpServletRequest request) {

        return Integer.parseInt(request.getParameter("number")) * 2;
    }
}