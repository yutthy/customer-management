package com.myproject.webapp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.myproject.dao.CustomerDao;
import com.myproject.model.CustomerModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by uyutthy on 3/3/2017.
 */
@WebServlet(name = "SaveUpdateCustomerServlet")
public class SaveUpdateCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id           = Integer.parseInt(request.getParameter("id"));
        String firstName    = request.getParameter("firstName");
        String lastName     = request.getParameter("lastName");
        Integer gender      = Integer.parseInt(request.getParameter("gender"));
        String strDob       = request.getParameter("dob").toString();
        String email        = request.getParameter("email");
        String address      = request.getParameter("address");
        String phone        = request.getParameter("phone");

        Date dob = null;
        Date now = new Date();
        Date current = new Date();
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat parser1= new SimpleDateFormat("yyyy-MM-dd H:m:s");
        try {
            dob = parser.parse(strDob);
            now = parser1.parse(current.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        CustomerModel customer = new CustomerModel();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setGender(gender);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setDob(dob);


        Gson gson = new Gson();
        JsonObject obj = new JsonObject();

        boolean status;

        CustomerDao customerDao = new CustomerDao();
        if(id == 0){
            customer.setCreatedDate(now);
            status = customerDao.addNew(customer);
        }
        else {
            customer.setModifiedDate(now);
            status = customerDao.update(id,  customer);
        }


        obj.addProperty("status", status);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(obj.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
