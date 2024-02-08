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
    private static ScheduleListener scheduleListener;
    private static int between;

    public interface ScheduleListener {
        void onScheduleEventTriggered();
    }

    // Getters
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long getMinTilEvent() {
        refreshTime();
        return minTilEvent;
    }

    public static boolean getIsOn() {
        return isOn;
    }

    // Set ScheduleListener
    public static void setScheduleListener(ScheduleListener listener) {
        scheduleListener = listener;
    }

    // Start Scheduler
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void startScheduler() {
        // Initialize
        scheduler = Executors.newScheduledThreadPool(1);
        start = LocalTime.now();
        isOn = true;
        between = Settings.getFrequency();
        // Schedule a task
        mainSchedule(between);
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
        Duration diff = Duration.between(LocalTime.now(), nextExe);
        minTilEvent = diff.toMinutes();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void mainSchedule(int betweenTime){
        nextExe = LocalTime.now().plusMinutes(betweenTime);
        scheduler.schedule(() -> {
            // Action on event
            scheduleListener.onScheduleEventTriggered();
        }, betweenTime, TimeUnit.MINUTES);
        refreshTime();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void exeSchedule(int betweenTime){
        nextExe = LocalTime.now().plusMinutes(betweenTime);
        scheduler.schedule(() -> {

        }, betweenTime, TimeUnit.MINUTES);
        refreshTime();
    }


}
