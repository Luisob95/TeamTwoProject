package com.example.myapplication;

public class UserManager {
    private static boolean userLoggedIn = true;
    public static boolean isUserLoggedIn(){
        return userLoggedIn;
    }
    public static void setUserLoggedIn(boolean  loggedIn)
    {
        userLoggedIn = loggedIn;
    }
}
