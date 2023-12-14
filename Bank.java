package Visual;
import java.util.ArrayList;

public class Bank {
    private ArrayList<String> atms;
    private ArrayList<String> clients;
    private ArrayList<String> thieves;
    private double temperature;


    // Constructor
    public Bank(ArrayList<String> atms, ArrayList<String> clients, ArrayList<String> thieves, double temperature) {
        this.atms = atms;
        this.clients = clients;
        this.thieves = thieves;
        this.temperature = temperature;
    }

    // Getters and Setters
    public ArrayList<String> getATMs() {
        return atms;
    }

    public void setATMs(ArrayList<String> atms) {
        this.atms = atms;
    }

    public ArrayList<String> getClients() {
        return clients;
    }

    public void setClients(ArrayList<String> clients) {
        this.clients = clients;
    }

    public ArrayList<String> getThieves() {
        return thieves;
    }

    public void setThieves(ArrayList<String> thieves) {
        this.thieves = thieves;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void checkTemperature() {
        if (temperature < 20) {
            System.out.println("It's cool.");
        } else if (temperature > 30) {
            System.out.println("It's too hot.");
        } else {
            System.out.println("The temperature is moderate.");
        }
    }


    public static void main(String[] args) {
        // Creating an instance of the Bank class
        ArrayList<String> atms = new ArrayList<>();
        atms.add("ATM 1");
        atms.add("ATM 2");
        atms.add("ATM 3");
        atms.add("ATM 4");

        ArrayList<String> clients = new ArrayList<>();
        clients.add("John");
        clients.add("Alice");
        clients.add("Bob");

        ArrayList<String> thieves = new ArrayList<>();
        thieves.add("Eve");
        thieves.add("Mallory");

        Bank bank = new Bank(atms, clients, thieves, 25.5);

        // Accessing and printing the attributes
        System.out.println("ATMs: " + bank.getATMs());
        System.out.println("Clients: " + bank.getClients());
        System.out.println("Thieves: " + bank.getThieves());
        System.out.println("Temperature: " + bank.getTemperature());

        // Checking the temperature
        bank.checkTemperature();

        // Detecting a thief
        Security callSecurity = new Security(thieves);
        //callSecurity.detectThief("Mallory");
        callSecurity.isAlarmActive();
    

        String[] listofnames = {"James","Alice","Bob","John","Michael","David","William","Richard","Joseph","Thomas","Christopher","Charles","Daniel","Matthew",
        "Anthony","Mark","Donald","Steven","Andrew","Paul","Joshua","Kenneth","Kevin","Brian","George","Timothy","Ronald","Jason","Edward","Jeffrey","Ryan"
        ,"Jacob","Gary","Nicholas","Eric","Jonathan","Stephen","Larry","Justin","Scott","Brandon","Benjamin","Samuel","Gregory","Alexander","Patrick","Frank"
        ,"Raymond","Jack","Dennis","Jerry","Tyler","Aaron","Jose"};
        
        String[] listoftransactions = {"withdraw", "deposit", "pinChange", "getChange"};
        Clients [] client = new Clients[120];
        
        for (int i = 1; i < 100; i++) { // from 1 to 10
            client[i] = new Clients(listofnames, listoftransactions);
            System.out.print("Name: ");
            System.out.println(client[i].getName());
            System.out.print("Age: ");
            System.out.println(client[i].getAge());
            System.out.print("ID: ");
            System.out.println(client[i].getid());
            System.out.print("Temperment: ");
            System.out.println(client[i].getTemperment());
            System.out.print("CashInBank: ");
            System.out.println(client[i].getCashInBank());
            System.out.print("hasAcard: ");
            System.out.println(client[i].hasACard());
            System.out.print("Transactions: ");
            System.out.println(client[i].getTransactionType());
            System.out.print("Time: ");
            System.out.println(client[i].getExpectedTime());
            System.out.println("----");
            System.out.println("----");

        }
        

    }    
}