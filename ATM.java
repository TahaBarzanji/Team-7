import java.util.LinkedList;
import java.util.Queue;

/**
 * `ATMSimulation` class simulates an ATM machine with transaction functionalities and a client queue.

 * This class allows clients to perform withdrawal, deposit, and check balance transactions using the ATM.
 * It also supports a client queue where clients can wait for their turn to use the ATM.
 * Additionally, it provides a method to clear the queue when a VIP person arrives to use the ATM.
 */
public class ATM {

    // Flag to indicate whether the ATM is available or on hold
    private boolean isAvailable;

    // Queue to hold the clients waiting for their turn at the ATM
    private Queue<Client> clientQueue;

    /**
     * `Client` class represents a client with an account number and balance.
     */
    private static class Client {
        private int accountNumber;
        private double balance;

        /**
         * Constructor to initialize the client with an account number and balance.
         *
         * @param accountNumber The account number of the client.
         * @param balance The balance of the client's account.
         */
        public Client(int accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        /**
         * Getter for the client's account number.
         *
         * @return Returns the account number of the client.
         */
        public int getAccountNumber() {
            return accountNumber;
        }

        /**
         * Getter for the client's balance.
         *
         * @return Returns the balance of the client's account.
         */
        public double getBalance() {
            return balance;
        }
    }

    /**
     * Constructor to initialize the ATM simulation.
     */
    public ATM() {
        isAvailable = true;
        clientQueue = new LinkedList<>();
    }

    /**
     * Checks whether the ATM is available or on hold.
     *
     * @return Returns true if the ATM is available, false otherwise.
     */
    public boolean isATMAvailable() {
        return isAvailable;
    }

    /**
     * Adds a client to the client queue.
     *
     * @param accountNumber The account number of the client.
     * @param balance The balance of the client's account.
     */
    public void addClientToQueue(int accountNumber, double balance) {
        Client client = new Client(accountNumber, balance);
        clientQueue.add(client);
        System.out.println("Client with account number " + accountNumber + " added to the queue.");
    }

    /**
     * Processes the next client in the queue by performing a transaction.
     *
     * @param transactionType The type of transaction to perform (withdrawal, deposit, or check balance).
     * @param amount The amount to withdraw or deposit. Ignored for check balance transactions.
     * @return Returns true if the transaction is successful, false otherwise.
     */
    public boolean processNextClient(TransactionType transactionType, double amount) {
        if (!isAvailable) {
            System.out.println("ATM is currently on hold. Please wait for your turn.");
            return false;
        }

        if (clientQueue.isEmpty()) {
            System.out.println("No clients in the queue.");
            return false;
        }

        Client client = clientQueue.poll();
        System.out.println("Processing client with account number " + client.getAccountNumber());

        switch (transactionType) {
            case WITHDRAWAL:
                if (client.getBalance() >= amount) {
                    client.balance -= amount;
                    System.out.println("Withdrawal of " + amount + " successful. New balance: " + client.getBalance());
                    return true;
                } else {
                    System.out.println("Insufficient balance for withdrawal. Balance: " + client.getBalance());
                    return false;
                }
            case DEPOSIT:
                client.balance += amount;
                System.out.println("Deposit of " + amount + " successful. New balance: " + client.getBalance());
                return true;
            case CHECK_BALANCE:
                System.out.println("Balance for account number " + client.getAccountNumber() + ": " + client.getBalance());
                return true;
            default:
                System.out.println("Invalid transaction type.");
                return false;
        }
    }

    /**
     * Clears the client queue when a VIP person arrives to use the ATM.
     */
    public void clearQueueForVIP() {
        clientQueue.clear();
        System.out.println("Queue cleared for VIP person.");
    }

    /**
     * Enum representing the types of transactions that can be performed.
     */
    public enum TransactionType {
        WITHDRAWAL,
        DEPOSIT,
        CHECK_BALANCE
    }

    /**
     * Main method to demonstrate the ATM simulation.
     */
    public static void main(String[] args) {
        ATM atm = new ATM();

        // Add clients to the queue
        atm.addClientToQueue(123456, 1000.0);
        atm.addClientToQueue(789012, 500.0);
        atm.addClientToQueue(345678, 2000.0);
        atm.addClientToQueue(901234, 1500.0);
        atm.addClientToQueue(567890, 3000.0);

        // Process transactions for 5 clients
        for (int i = 0; i < 3; i++) {
            System.out.println("ATM " + (i + 1));
            atm.processNextClient(TransactionType.WITHDRAWAL, 200.0);
            System.out.println();
            System.out.println("ATM " + (i + 2));
            atm.processNextClient(TransactionType.DEPOSIT, 100.0);
            System.out.println();
            System.out.println("ATM " + (i + 3));
            atm.processNextClient(TransactionType.CHECK_BALANCE, 0.0);
            System.out.println();
        }

        // Clear the queue for VIP person
        System.out.println();
        atm.clearQueueForVIP();
    }
}
