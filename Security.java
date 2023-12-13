import java.util.ArrayList;
/*
 * This class represents a security system for a bank.
 */
public class Security {
    private boolean alarmStatus;
    public ArrayList<String> thieves;

    /*
     * Constructor to initialize the security system.
     */
    public Security(ArrayList<String> thieves) {
        this.alarmStatus = false;
        this.thieves = thieves;
    }

    /*
     * Getter for the alarm status.
     * @return Returns the current alarm status.
     */
    public boolean isAlarmActive() {
        if (alarmStatus == true) {
            System.out.println("We wo we wo");
        } 
        else {
            System.out.println(".....");
        }
        return alarmStatus;
    }

    /*
     * The detection of a thief in the bank.
     * Activates the alarm and triggers the safety procedures.
     */
    public void detectThief(String thiefName) {
        if (thieves.contains(thiefName)) {
            alarmStatus = true;
            System.out.println("Alarm is active. Safety procedures have been initiated.");
            activateSafetyProcedures();
        }
        else{
            System.out.println("No alarm detected.");
        }
    }
    
    
    /*
     * Activates the safety procedures for the bank.
     */
    private void activateSafetyProcedures() {
        System.out.println("Safety procedures activated. Please remain calm and follow instructions.");
    }
