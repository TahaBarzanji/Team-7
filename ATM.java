import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ATM {

    private boolean[] isAvailable;
    private List<List<Client>> atmQueues;

    // Inner class representing a client
    private static class Client {
        private int accountNumber;
        private double balance;

        public Client(int accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }
    }
   
    //Constructor to initialize the ATM with the specified number of ATM slots.
    public ATM(int numATMs) {
        isAvailable = new boolean[numATMs];

        // Initialize all ATMs as available
        for (int i = 0; i < numATMs; i++) {
            isAvailable[i] = true;
        }
        
        atmQueues = new ArrayList<>();
        
        // Create a unique queue for each ATM
        for (int i = 0; i < numATMs; i++) {
            atmQueues.add(new ArrayList<>());
        }
    }

    public void addClientToQueue(int atmIndex, int accountNumber, double balance) {
        // Check if the ATM index is valid
        if (atmIndex >= 0 && atmIndex < atmQueues.size()) {
            List<Client> queue = atmQueues.get(atmIndex);
            Client client = new Client(accountNumber, balance);

            // Add the client to the queue of the specified ATM
            queue.add(client);
            System.out.println("Client with account number " + accountNumber + " added to the queue of ATM ");

        } else {
            System.out.println("Invalid ATM index.");
        }
    }

    public boolean processNextClient(int atmIndex, TransactionType transactionType, double amount) {
        
         // Check if the ATM index is valid
         if (atmIndex >= 0 && atmIndex < atmQueues.size()) {
             List<Client> queue = atmQueues.get(atmIndex);
             
             // Check if the ATM is currently available
             if (!isAvailable[atmIndex]) {
                 System.out.println("ATM " + (atmIndex) + " is currently on hold. Please wait for your turn.");
                 return false;
             }
             
             // Check if there are clients in the queue
             if (queue.isEmpty()) {
                 System.out.println("No clients in the queue of ATM ");
                 return false;
             }
             
             // Get the next client from the queue
             Client client = queue.get(0);
             
             System.out.println("Processing client with account number " + client.getAccountNumber());
 
             switch (transactionType) {
                 case WITHDRAWAL:
                     if (client.getBalance() >= amount) {
                         // Perform withdrawal transaction
                         client.balance -= amount;
                         System.out.println("Withdrawal of " + amount + " successful. New balance: " + client.getBalance());
                         return true;
                     } else {
                         System.out.println("Insufficient balance for withdrawal. Balance: " + client.getBalance());
                         return false;
                     }
                 case DEPOSIT:
                     // Perform deposit transaction
                     client.balance += amount;
                     System.out.println("Deposit of " + amount + " successful. New balance: " + client.getBalance());
                     return true;
                 case CHECK_BALANCE:
                     // Perform balance inquiry transaction
                     System.out.println("Balance for account number " + client.getAccountNumber() + ": " + client.getBalance());
                     return true;
                 default:
                     System.out.println("Invalid transaction type.");
                     return false;
             }
         } else {
             System.out.println("Invalid ATM index.");
             return false;
         }
    }

    public void clearQueueForVIP(int atmIndex) {
        
         // Check if the ATM index is valid
         if (atmIndex >= 0 && atmIndex < atmQueues.size()) {
             List<Client> queue = atmQueues.get(atmIndex);
             
             // Clear the entire queue of the specified ATM
             queue.clear();
             
             System.out.println("Queue of ATM " + (atmIndex + 4) + " cleared for VIP person.");
         } else {
             System.out.println("Invalid ATM index.");
         }
    }

    public enum TransactionType {
        WITHDRAWAL,
        DEPOSIT,
        CHECK_BALANCE
    }

    public static void main(String[] args) {
        ATM ATM1 = new ATM(3);
        ATM ATM2 = new ATM(3);
        ATM ATM3 = new ATM(3);
        ATM ATM4 = new ATM(3);

        // Add clients to the queues of each ATM
        ATM1.addClientToQueue(0, 123456, 6000.0);
        ATM1.addClientToQueue(1, 557214, 6000.0);
        ATM1.addClientToQueue(2, 875583, 6000.0);


        ATM2.addClientToQueue(0, 789012, 6000.0);
        ATM3.addClientToQueue(0, 345678, 6000.0);
        ATM4.addClientToQueue(0, 901234, 6000.0);
        

        // Process transactions for each ATM
        System.out.println("ATM 1");
        ATM1.processNextClient(0, TransactionType.WITHDRAWAL, generateRandomNumber());
        System.out.println();

        System.out.println("ATM 2");
        ATM2.processNextClient(0, TransactionType.DEPOSIT, generateRandomNumber());
        System.out.println();
        
        System.out.println("ATM 3");
        ATM3.processNextClient(0, TransactionType.CHECK_BALANCE, 0.0);
        System.out.println();

        System.out.println("ATM 4");
        ATM4.processNextClient(0, TransactionType.CHECK_BALANCE, 0.0);
        System.out.println();

        System.out.println("ATM 4");
        ATM4.clearQueueForVIP(0);
        System.out.println();


        System.out.println();
        System.out.println();
        System.out.println("/////// SECOND PHASE /////////");

        System.out.println("ATM 1");
        ATM1.processNextClient(1, TransactionType.WITHDRAWAL, generateRandomNumber());
        System.out.println();
        
        System.out.println("ATM 2");
        ATM2.processNextClient(0, TransactionType.DEPOSIT, generateRandomNumber());
        System.out.println();
        
        System.out.println("ATM 3");
        ATM3.processNextClient(0, TransactionType.CHECK_BALANCE, 0.0);
        System.out.println();

        System.out.println("ATM 4");
        ATM4.processNextClient(0, TransactionType.CHECK_BALANCE, 0.0);
        System.out.println();
    }

    private static int generateRandomNumber() {
        int min = 50;
        int max = 6000;

        Random random = new Random();
        
         // Generate a random number between min and max (inclusive)
         int randomNum = random.nextInt((max - min) + 1) + min;

         // Set the ones place to 0
         randomNum -= randomNum % 100;

         // Set the tens place to either 0 or 5
         int tensDigit = randomNum % 1000 / 100;
         
          if (tensDigit != 0 && tensDigit != 5) {
              int offset = random.nextInt(2) * 5;
              randomNum -= tensDigit * 100;
              randomNum += offset * 10;
          }
          
          return randomNum;
    }
}
