package com.itland.naumenko.itjava.web;


import com.itland.naumenko.itjava.dao.UserDao;
import com.itland.naumenko.itjava.dao.UserDaoImpl;
import com.itland.naumenko.itjava.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/")
public class UserServlet extends HttpServlet {

    private final UserDao userDao;

    public UserServlet() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listUser(req, resp);
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDao.getUsers();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("list-user.jsp");
        dispatcher.forward(req, resp);
    }
}
