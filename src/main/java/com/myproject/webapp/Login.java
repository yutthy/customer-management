package com.myproject.webapp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.myproject.model.User;
import com.myproject.model.UserList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by uyutthy on 2/9/2017.
 */
public class Login extends HttpServlet {

    private List<User> _cached;

    @Override
    public void init() throws ServletException {
        System.out.print("Basic GetCustomerServlet Init Method Is Called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email;
        String password;
        Boolean isLogin = false;

        email = req.getParameter("email");
        password = req.getParameter("password");

        Gson gson = new Gson();
        JsonObject obj = new JsonObject();


        if(this.isLogin(email, password)){

            HttpSession session = req.getSession();
            Iterator<User> it = _cached.iterator();
            while (it.hasNext()){
                User u = (User)it.next();
                session.setAttribute("id", u.getId());
                session.setAttribute("email", u.getEmail());
                session.setAttribute("createdDate", u.getCreatedDate().toString());
                session.setAttribute("urlPhoto", u.getUrlPhoto());
            }

            isLogin = true;

        }else{
            isLogin = false;

        }

        obj.addProperty("isLogin", isLogin);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(obj.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void destroy() {
        System.out.print("Basic GetCustomerServlet Destroy Method Is Called");
    }

    private boolean isLogin(String email, String password){
        boolean isLogin = false;

        List<User> userList =  (ArrayList<User>) UserList.getAll();
        Iterator<User> it = userList.iterator();
        while (it.hasNext()){
            User user = (User)it.next();
            if(email.equals(user.getEmail()) && MD5.getMD5(password).equals(user.getPassword())){
                isLogin = true;

                //add found user to cached
                _cached = new ArrayList<User>();
                _cached.add(user);
                break;
            }
        }
        return isLogin;
    }






}
