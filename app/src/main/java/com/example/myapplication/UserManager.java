package com.example.myapplication;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.LocalTime;
import java.util.Vector;
import java.util.Random;
public class UserManager {
    private static boolean userLoggedIn = true;
    private static Object[][] plan = null;
    private static Object[][] exerciseEnduranceList = {
    //       Exercises     Type      1 Min Max           Type 1 = Upper Body 2 = Core 3 = Lower Body 4 = Full Body this will be for the recovery
            {"Push-ups",     1,         50},
            {"Pull-ups",     1,         50},
            {"Sit-ups",      2,         50},
            {"Squat",        3,         50},
            {"Burpees",      4,         50}
    };
    private static String[] exerciseRecoveryList = {
            "Push-ups", "Pull-ups", "Sit-ups", "Squat", "Burpees"
    };
    private static String[] exerciseMentalList = {
            "Meditate", "Breathing", "Socialize"
    };
    // Tracking array for the main stats       NOTE: IF WE DONT USE A DATABASE WE MAY NEED TO CREATE AN ARRAY GENRATER SO WE CAN TRACK ALL THE STATS IN A MORE DETAil ALSO SAVING AND LOADING LOGIC FOR THIS ARRAY  ALSO FIGURE OUT HOW TO DO IT IN A SCROLL VIEW A SCROLL VIEW Also might move the Plan Generator to its own class
    private static Object[][] userStats= {
            {"Push-ups", 25},
            {"Pull-ups", 34},
            {"Sit-ups", 23},
    };
    private static Object[][] pushupDetail = {
    //        TIME        Duration      Amount
            {"11:28", "Push-ups",    "2 Min",       23},
            {"11:50",  "Push-ups",   "2 Min",       20},
            {"12:28",   "Push-ups",  "1 Min",       12},
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
    //Probably make an override function  for the different toggle states
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Object[][] generatePlan(Object[] saved) {
        // Initialization
        Random rand = new Random();
        boolean isEndurance = false;
        int dur;
        int freq;
        int count = 0;
        String exe = null;
        LocalTime start = LocalTime.parse((CharSequence) saved[4]);
        LocalTime end = LocalTime.parse((CharSequence) saved[5]);
        Vector<String> exeGenChoice = new Vector<String>();
        if (saved[1].equals(1)) {
            exeGenChoice.add("R");
        }
        if (saved[2].equals(1)) {
            exeGenChoice.add("M");
        }
        if (saved[3].equals(1)) {
            exeGenChoice.add("E");
        }
        // All Random
        // Difficulty selector
        if (saved[0].equals(1)) {
            if (saved[6].equals(1)) { // Easy
                freq = 6;
                dur = 1;
            } else if (saved[6].equals(2)) { // Medium
                freq = 8;
                dur = 1;
            } else if (saved[6].equals(3)) { // Hard
                freq = 10;
                dur = 2;
            } else { // Nightmare
                freq = 15;
                dur = 3;
            }
            // Random Generator
            plan = new Object[freq][4];
            for (int i = 0; i <= freq-1; ++i) {
                // Random Time Generator
                int hours = start.getHour() + rand.nextInt(end.getHour() - start.getHour() + 1);
                int minutes = rand.nextInt(60);
                // Exercise Type Generator
                String exeGenSelect = exeGenChoice.get(rand.nextInt(exeGenChoice.size()));
                // Exercise Generator
                if (exeGenSelect == "R") {
                    exe = exerciseRecoveryList[rand.nextInt(exerciseRecoveryList.length)];
                } else if (exeGenSelect == "M") {
                    exe = exerciseMentalList[rand.nextInt(exerciseMentalList.length)];
                } else {
                    exe = (String) exerciseEnduranceList[rand.nextInt(exerciseEnduranceList.length)][0];
                    isEndurance = true;
                }
                // If isEndurance Logic Here
                plan[i][0] = LocalTime.of(hours, minutes);
                plan[i][1] = exe;
                plan[i][2] = dur;
                plan[i][3] = count; // If genre = endurance Find exercise and index to Max and Multiply value by a pre determined scaling value for example  1 min = 1 Max, 2 min = 1.75 Max and so on; For the complete Random generator I could have a dynamic vector that will store fractions of the time Example if freq is 4 and time is 8 to 12 it will take 4 hours divided by frequency indexing up each vectors to get a more even spread the only thing that will be random is the minutes
            }
        }
        return plan;
    }
    public static void exerciseGenerator(Object[] saved){
        // Initialization
        Random rand = new Random();
        boolean isEndurance = false;
        int durMax;
        int freq;
        int count = 0;
        String exe = null;
        Vector<String> exeGenChoice = new Vector<String>();
        if (saved[1].equals(1)) {
            exeGenChoice.add("R");
        }
        if (saved[2].equals(1)) {
            exeGenChoice.add("M");
        }
        if (saved[3].equals(1)) {
            exeGenChoice.add("E");
        }
        // All Random
        // Difficulty selector
        if (saved[0].equals(1)) {
            if (saved[6].equals(1)) { // Easy
                durMax = 1;
            } else if (saved[6].equals(2)) { // Medium
                durMax = 2;
            } else if (saved[6].equals(3)) { // Hard
                durMax = 3;
            } else { // Nightmare
                durMax = 5;
            }
    }
}}
