package com.myproject.model;

import com.myproject.webapp.MD5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by uyutthy on 2/9/2017.
 */
public class UserList {

    public static List<User> getAll(){
        String[] arrEmail = {
                "admin@gmail.com",
                "lence@gmail.com",
                "flora@gmail.com",
                "test@gmail.com",
                "frank@gmail.com",
                "jeck@gmail.com",
                "rosa@gmail.com",
                "lina@gmail.com",
                "dana@gmail.com",
                "keck@gmail.com"
        };

        String[] arrPhoto = {
                "admin.png",
                "no_photo.png",
                "no_photo.png",
                "no_photo.png",
                "no_photo.png",
                "no_photo.png",
                "no_photo.png",
                "no_photo.png",
                "no_photo.png",
                "no_photo.png"
        };


        List<User> userList = new ArrayList<User>();
        for(int i = 0; i < 10; i++){
            Date curDate = new Date();
            userList.add(new User(i+1, arrEmail[i], MD5.getMD5(arrEmail[i]), curDate, arrPhoto[i]));
        }
        return userList;
    }
}
