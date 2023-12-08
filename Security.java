/**
 * This class represents a security system for a bank.
 */
public class Security {
    private boolean alarmStatus;

    /**
     * Constructor to initialize the security system with the alarm status set to false.
     */
    public Security() {
        this.alarmStatus = false;
    }

    /**
     * Getter for the alarm status.
     *
     * @return Returns the current alarm status.
     */
    public boolean isAlarmActive() {
        return alarmStatus;
    }

    /**
     * Simulates the detection of a thief in the bank.
     * Activates the alarm and triggers the safety procedures.
     */
    public void detectThief() {
        alarmStatus = true;
        activateSafetyProcedures();
    }

    /**
     * Activates the safety procedures for the bank.
     * This method can be customized to include specific actions like locking doors, notifying authorities, etc.
     */
    private void activateSafetyProcedures() {
        // Code to activate safety procedures goes here
        System.out.println("Safety procedures activated. Please remain calm and follow instructions.");
    }

// Usage Example for SecuritySystem
    public static void main(String[] args) {
        Security securitySystem = new Security();

        // Simulate the detection of a thief
        securitySystem.detectThief();

        // Check the alarm status
        if (securitySystem.isAlarmActive()) {
            System.out.println("Alarm is active. Safety procedures have been initiated.");
        } else {
            System.out.println("No alarm detected.");
        }
    }
}