package com.example.myapplication;

public class UserManager {
    private static boolean userLoggedIn = true;
    //                                              ALSO SAVING AND LOADING LOGIC FOR THIS ARRAY  ALSO FIGURE OUT HOW TO DO IT IN A SCROLL VIEW A SCROLL VIEW
    // Tracking array for the main stats       NOTE: IF WE DONT USE A DATABASE WE MAY NEED TO CREATE AN ARRAY GENRATER SO WE CAN TRACK ALL THE STATS IN A MORE DETAil
    private static Object[][] userStats= {
            {"Push-ups", 25},
            {"Calories", 34},
            {"Sit-ups", 23},
            {"Breaks", 5},
            {"Meditation",3}
    };
    public static boolean isUserLoggedIn(){
        return userLoggedIn;
    }
    public static void setUserLoggedIn(boolean  loggedIn)
    {
        userLoggedIn = loggedIn;
    }
    public static Object[][] getCurrentStat(){
        return userStats;
    }
}
