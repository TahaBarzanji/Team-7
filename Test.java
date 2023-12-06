package Project_Java;

public class Test {
    public static void main(String[] args) {
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
