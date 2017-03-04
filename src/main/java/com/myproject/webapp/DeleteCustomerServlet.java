package com.myproject.webapp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.myproject.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by uyutthy on 3/3/2017.
 */
@WebServlet(name = "DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        CustomerDao customer = new CustomerDao();

        boolean status;

        Gson gson = new Gson();
        JsonObject obj = new JsonObject();

        status = customer.delete(id);

        obj.addProperty("status", status);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(obj.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
