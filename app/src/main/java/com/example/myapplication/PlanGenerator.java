package com.example.myapplication;
import java.util.Random;
import java.util.Vector;
public class PlanGenerator {

    public static Vector<String> generatePlan() {
        // initialize
        Vector<String> focusChoice = new Vector<>();
        Vector <String> breakPlan = new Vector<>();
        String exe = null;
        Random rand = new Random();
        int dur = Settings.getDuration();
// CHeck what toggles where selected and add them to the choice vector
        if (Settings.getRecovery())   { focusChoice.add("R"); }
        if (Settings.getMental())     { focusChoice.add("M"); }
        if (Settings.getEndurance())  { focusChoice.add("E"); }
        // for every 1 in duration cycle through and select a random focus choice and exercise in that catagory
        for (int i = 0; i < dur; ++i) {
            // select a random choice from the vector
            String focusSelect = focusChoice.get(rand.nextInt(focusChoice.size()));
            // select a random workout in the corresponding vector
            switch (focusSelect) {
                case "R":
                    exe = Settings.getExeRecovery().get(rand.nextInt(Settings.getExeRecovery().size()));
                    break;
                case "M":
                    exe = Settings.getExeMental().get(rand.nextInt(Settings.getExeMental().size()));
                    break;
                default:
                    exe = Settings.getExeEndurance().get(rand.nextInt(Settings.getExeEndurance().size()));
                    break;
            }
            breakPlan.add(exe);
        }
        return breakPlan;
    }
}
