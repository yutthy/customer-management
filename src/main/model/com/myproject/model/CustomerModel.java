package com.myproject.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by uyutthy on 3/2/2017.
 */
public class CustomerModel{

    private int id;
    private String firstName;
    private String lastName;
    private int gender;
    private Date dob;
    private String email;
    private String address;
    private String phone;
    private Date createdDate;
    private Date modifiedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getDobFormat(){
        return (new SimpleDateFormat("yyyy-MM-dd")).format(this.dob);
    }

    public String getCreatedDateFormat(){
        return (new SimpleDateFormat("yyyy-MM-dd H:m:s")).format(this.createdDate);
    }

    public String getModifiedDateFormat(){
        return (new SimpleDateFormat("yyyy-MM-dd H:m:s")).format(this.modifiedDate);
    }

    public void setDobToString(String dob){
        try {
            this.setDob((new SimpleDateFormat("yyyy-MM-dd")).parse(dob));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setCreatedDateToString(String date){
        if(date != null) {
            try {
                this.setCreatedDate((new SimpleDateFormat("yyyy-MM-dd H:m:s")).parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void setModifiedDateToString(String date){
        if(date != null) {
            try {
                this.setModifiedDate((new SimpleDateFormat("yyyy-MM-dd H:m:s")).parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
