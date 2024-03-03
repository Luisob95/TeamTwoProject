package com.example.myapplication;
import java.util.Arrays;
import java.util.Vector;

public class Settings {          //NOTE NOT SURE IF THIS IS A GOOD WAY OF DOING IT AND PROBABLY WILL MOVE SOME OF THE DATA TO A DATABASE
    // Variables
    private static boolean userLoggedIn = true;
    public static boolean startSelected = true;
    private static boolean genreRecovery;
    private static boolean genreMental;
    private static boolean genreEndurance;
    private static int duration;
    private static int frequency;
    private static Vector<String> exeEndurance = new Vector<>(
            Arrays.asList("Push-ups", "Squats", "Sit-ups")
    );
    private static Vector<String> exeMental = new Vector<>(
            Arrays.asList("Breathing", "Socialize", "Walk")
    );
    private static Vector<String> exeRecovery = new Vector<>(
            Arrays.asList("Jog", "Jumping Jacks", "Stretch")
    );

    // Getters
    public static boolean getRecovery() {
        return genreRecovery;
    }

    public static boolean getMental() {
        return genreMental;
    }

    public static boolean getEndurance() {
        return genreEndurance;
    }

    public static int getDuration() {
        return duration;
    }

    public static int getFrequency() {
        return frequency;
    }

    public static boolean getLoggedIn() {
        return userLoggedIn;
    }

    public static Vector<String> getExeEndurance() {
        return exeEndurance;
    }

    ;

    public static Vector<String> getExeRecovery() {
        return exeRecovery;
    }

    ;

    public static Vector<String> getExeMental() {
        return exeMental;
    }

    ;

    // Setters
    public static void setRecovery(boolean value) {
        genreRecovery = value;
    }

    public static void setMental(boolean value) {
        genreMental = value;
    }

    public static void setEndurance(boolean value) {
        genreEndurance = value;
    }

    public static void setDuration(int value) {
        duration = value;
    }

    public static void setFrequency(int value) {
        frequency = value;
    }

    public static void setLoggedIn(boolean loggedIn) {
        userLoggedIn = loggedIn;
    }

    public static void setExeEndurance(Vector<String> value) {
        exeEndurance = value;
    }

    public static void setExeMental(Vector<String> value) {
        exeMental = value;
    }

    public static void setExeRecovery(Vector<String> value) {
        exeRecovery = value;
    }

    private static Vector<Vector<Object>> userStats = new Vector<Vector<Object>>() {{
        //                                    Exercise    Time    Amount
        add(new Vector<Object>(Arrays.asList("Push-ups", "12:45", 25)));
        add(new Vector<Object>(Arrays.asList("Pull-ups", "12:50", 34)));
        add(new Vector<Object>(Arrays.asList("Sit-ups", "15:32", 23)));
        add(new Vector<Object>(Arrays.asList("Sit-ups", "15:32", 23)));
        add(new Vector<Object>(Arrays.asList("Sit-ups", "15:32", 23)));
        add(new Vector<Object>(Arrays.asList("Sit-ups", "15:32", 23)));
        add(new Vector<Object>(Arrays.asList("Sit-ups", "15:32", 23)));
        add(new Vector<Object>(Arrays.asList("Sit-ups", "15:32", 23)));

    }};

    public static Object[][] trackedUserStats = {
            {"Push-ups", 34},
            {"Sit-ups", 80},
            {"Breaks", 3},
            {"Endurance", 4},
            {"minmax", 4}
    };

    public static Vector<Vector<Object>> getCurrentStat() {
        return userStats;
    }

    public static Object[][] getTrackedUserStats() {
        return trackedUserStats;
    }
}
// NOTE IT WOULD BE COOL TO MAKE THE A MAX TIME FOR THE VECTOR TO THEN ROLL ON THE AMOUNT OF TIME YOU PERFORM THAT EXERCISE
// FIND THE CORRESPONDING VECTOR AND PULLING A RANDOM EXERCISE FROM IT                  Maybe have the corosponding body part so it doesnt choos push-ups after handstand presses Only needed for endurance and could just add a second roll inside the if
// Tracking array for the main stats       NOTE: IF WE DONT USE A DATABASE WE MAY NEED TO CREATE AN ARRAY GENRATER SO WE CAN TRACK ALL THE STATS IN A MORE DETAil ALSO SAVING AND LOADING LOGIC FOR THIS ARRAY  ALSO FIGURE OUT HOW TO DO IT IN A SCROLL VIEW A SCROLL VIEW Also might move the Plan Generator to its own class//    Type 1 = Upper Body 2 = Core 3 = Lower Body 4 = Full Body this will be for the recovery