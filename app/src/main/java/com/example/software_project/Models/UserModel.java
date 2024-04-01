package com.example.software_project.Models;

public class UserModel {
    public static String image = null;
    public String name ;
    public String email;
    public String password;

    public UserModel()
    {
        //this is the default constructor
    }



    public UserModel(String image,String name, String email, String password) {
        this.image = image;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
