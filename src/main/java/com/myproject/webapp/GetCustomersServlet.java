package com.myproject.webapp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.myproject.dao.CustomerDao;
import com.myproject.model.CustomerModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by uyutthy on 3/2/2017.
 */
@WebServlet(name = "GetCustomerServlet")
public class GetCustomersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDao customer = new CustomerDao();
        Integer limit  = Integer.parseInt(request.getParameter("limit"));
        Integer offset = Integer.parseInt(request.getParameter("offset"));

        Gson gson = new Gson();
        JsonObject obj = new JsonObject();



        List<CustomerModel> customers = customer.getAll(limit, offset);

        String json = gson.toJson(customers);
        JsonArray ar = gson.fromJson(json,JsonArray.class);
        Integer totalRows = customer.getTotalRows();

        obj.addProperty("total", totalRows);
        obj.add("rows",ar);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(obj));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
