package com.example.controller;

import Service.UserService;
import model.User;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "userServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String action = request.getParameter("page");

        if (action.equalsIgnoreCase("newUser")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/register.jsp");
            requestDispatcher.forward(request, response);
        }

        if (action.equalsIgnoreCase("register")) {

            User user = new User();
            user.setUserName(request.getParameter("userName"));
            user.setFullName(request.getParameter("fullName"));
            user.setPassword(request.getParameter("password"));
            new UserService().insertUser(user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        doPost(request, response);

    }

    public void destroy() {
    }
}