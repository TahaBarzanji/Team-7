import java.util.ArrayList;
import java.util.Scanner;


public class ATM {

    private boolean atmAvailability;    // Whether the ATM is currently available for use
    private String atmType;             // The type of the ATM
    private int cashAvailable;          // The available cash in the ATM


    // Constructor for ATM
    public ATM(boolean atmAvailability, String atmType, ArrayList<Integer> cashAvailable) {
        this.atmAvailability = atmAvailability;
        this.atmType = atmType;
        this.cashAvailable = cashAvailable;
    }

    // Withdraws money from the ATM
    public String withdrawal(int accountId, int pin, int amount) {
    // Get account balance
    int accountBalance = getAccountBalance(accountId);

    // Check for overdraft
    if (this.atmAvailability && this.cashAvailable >= amount && accountBalance >= amount) {
        // Check PIN
        if (this.pinQueue.contains(pin)) {
            // Withdraw cash from account
            updateAccountBalance(accountId, accountBalance - amount);

            // Deduct amount from ATM cash
            this.cashAvailable -= amount;

            // Update change
            this.change = accountBalance - amount;

            // Return success message with remaining cash in ATM
            return "Successful withdrawal of " + amount + " from account. Remaining cash in ATM: " + this.cashAvailable;
        } else {
            return "Invalid PIN";
        }
    } 
    else {
        if (!this.atmAvailability) {
            return "ATM is currently unavailable";
        } else if (this.cashAvailable < amount) {
            return "ATM does not have sufficient cash for the withdrawal";
        } else {
            return "Account does not have sufficient balance for the withdrawal";
        }
    }
}

/*  public boolean withdrawl(int amount) {
        // Check if ATM is available
        if (!isAvailabe()) {
            System.out.println("ATM is not available");
            return false;
        }
        // Check if enough money is available in the ATM
        if (!isAmountAvailable(amount)) {
            System.out.println("Insufficient funds");
            return false;
        }
        // Withdraw the amount
        withdrawAmount(amount);
        System.out.println("Withdrawal successful");
        return true;
    }
*/

    // Deposits money into the ATM
    public String deposit(int accountId, int pin, int amount) {
    // Check PIN
        if (this.pinQueue.contains(pin)) {
            // Add amount to account balance
            int newBalance = updateAccountBalance(accountId, getAccountBalance(accountId) + amount);

            // Update change
            this.change = newBalance;

            // Return success message
            return "Successful deposit of " + amount + " into account. New account balance: " + newBalance;
        } 
        else {
            return "Invalid PIN";
        }
}            
        
/*
        // Add the deposited amount to the available cash
        if (this.atmAvailability) {
            this.cashAvailable += amount;
            return true;
        }
        return false;
    }
*/

    // Changes the PIN of the ATM
    public boolean pinChange(String oldPin, String newPin) {
        // Check if ATM is available
        if (!isAvailabe()) {
            System.out.println("ATM is not available");
            return false;
        }
        // PIN change process should be implemented here, this is a placeholder
        System.out.println("PIN changed successfully");
        return true;
    }

/*
    // Checks if the given amount is available in the ATM
    private boolean isAmountAvailable(int amount) {
        for (int i = cashAvailable.size() - 1; i >= 0; i--) {
            int currentAmount = cashAvailable.get(i);
            while (currentAmount <= amount) {
                amount -= currentAmount;
                if (amount == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // Withdraws the given amount from the ATM
    private void withdrawAmount(int amount) {
        for (int i = cashAvailable.size() - 1; i >= 0; i--) {
            int currentAmount = cashAvailable.get(i);
            while (currentAmount <= amount) {
                amount -= currentAmount;
                cashAvailable.remove(i);
                if (amount == 0) {
                    return;
                }
            }
        }
    }
*/
    // Reads the card number
    public int cardReader() {
        // Check if ATM is available
        if (!isAvailabe()) {
            System.out.println("ATM is not available");
            return -1;
        }
        System.out.println("Please insert your card");
        Scanner scanner = new Scanner(System.in);
        int cardNumber = scanner.nextInt();
        return cardNumber;
    }

    // Changes the availability of the ATM
    public void changeAvailability() {
        atmAvailability = !atmAvailability;
    }

    // Prints the change of the ATM
    public void getChange() {
        System.out.println("Your change: " + cashAvailable);
    }

    // Clears the current line of output
    public void clearLine() {
        System.out.print("\033[2K");
    }

    // Displays the welcome message of the ATM
    public void welcomeMessage() {
        System.out.println("Welcome to our ATM");
    }

    // Main method for the ATM
    public static void main(String[] args) {
        ATM atm = new ATM(true, "CashPlus", new ArrayList<>(Arrays.asList(100, 50, 20, 10, 5, 2, 1)));
        atm.welcomeMessage();
        while (true) {
            int cardNumber = atm.cardReader();
            if (cardNumber == -1) {
                break;
            }
            atm.pinChange("1234", "5678");
            atm.deposit(1000);
            atm.withdrawl(500);
            atm.getChange();
        }
    }
}