package com.example.myapplication;

public class RandomizerSettings {
    // Variables
    private static boolean genreRecovery;
    private static boolean genreMental;
    private static boolean genreEndurance;
    private static int difficulty;
    private static int duration;
    private static int frequency;
    // Getters
    public static boolean getRecovery() { return genreRecovery; }
    public static boolean getMental() { return genreMental; }
    public static boolean getEndurance() { return genreEndurance; }
    public static int getDifficulty() { return difficulty; }
    public static int getDuration() { return duration; }
    public static int getFrequency() { return frequency; }
    // Setters
    public static void setRecovery(boolean  value) { genreRecovery = value; }
    public static void setMental(boolean  value) { genreMental = value; }
    public static void setEndurance(boolean  value) { genreEndurance = value; }
    public static void setDifficulty(int  value) { difficulty = value; }
    public static void setDuration(int  value) { duration = value; }
    public static void setFrequency(int  value) { frequency = value; }

}
