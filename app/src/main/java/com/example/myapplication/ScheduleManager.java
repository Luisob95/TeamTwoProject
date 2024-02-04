package com.example.myapplication;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleManager {
    // Variables
    private static ScheduledExecutorService scheduler;
    private static LocalTime start;
    private static LocalTime nextExe;
    private static long minTilEvent;
    private static boolean isOn = false;

    // Getters
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long getMinTilEvent(){
        refreshTime();
        return minTilEvent;
    }
    public static boolean getIsOn(){
        return isOn;
    }
// Start Scheduler
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void startScheduler() {
        // Initialize
        scheduler = Executors.newScheduledThreadPool(1);
        start = LocalTime.now();
        isOn =true;
        int between = Settings.getFrequency();
        nextExe = start.plusMinutes(between);
        scheduler.scheduleAtFixedRate(() -> {
            // Action on event

        }, 0, between, TimeUnit.MINUTES);
        refreshTime();
    }
// Stop Scheduler
    public static void stopScheduler() {
        if (scheduler != null) {
            scheduler.shutdown();
            isOn = false;
        }
    }
// Refresh is mostly for screen text refresher
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void refreshTime() {
        Duration diff = Duration.between(LocalTime.now(),nextExe);
        minTilEvent = diff.toMinutes();
    }
}
