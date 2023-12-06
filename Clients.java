package Project_Java;

import java.util.ArrayList;

public class Clients extends People {
    private double cashInBank;
    private boolean hasBankCard;
    private ArrayList<String> transactions = new ArrayList<String>();
    public int ExpectedTime;
    String TypeOfClient;
    // Constructor to make the above variables//
    public Clients(String[] listofnames, String[] listoftransactions){
        generatePerson(listofnames);
        cashInBank = random.nextDouble() * 40000;
        if(random.nextDouble() >= 0.95){
            hasBankCard = false;
            transactions.add("getCard");
            
        }else{hasBankCard = true;}
        if(random.nextDouble() >= 0.5){
        transactions.add(listoftransactions[0]);

        }else{transactions.add(listoftransactions[random.nextInt(listoftransactions.length)]);}
        
        if(random.nextDouble() >= 0.9){
            TypeOfClient = "VIP";
        }else{TypeOfClient = "normal";}
        random = null;
    }

    public double getCashInBank() {
        return cashInBank;
    }

    public void modifyCashInBank(double amount,int type)/*type = 1 add , type = 2 deduct*/{
        if(type == 1){
            cashInBank = cashInBank + amount;

        }
        if(type == 2){
            if(Math.abs(amount) <= cashInBank){
                cashInBank = cashInBank - Math.abs(amount);
            }
        }
    }

    public boolean hasACard(){
        return hasBankCard;
    }

    /*public int generateCardNum(){
        return 5;
    }*/

    public int getExpectedTime(){
        if(transactions.contains("withdraw")){
            ExpectedTime = ExpectedTime + 3;
        }
        if(transactions.contains("getCard")){
            ExpectedTime += 10;
        }
        if(transactions.contains("deposit")){
            ExpectedTime += 5;
        }
        if(transactions.contains("pinChange")){
            ExpectedTime += 7;
        }
        if(transactions.contains("getChange")){
            ExpectedTime += 9;
        }
        
        return ExpectedTime;
    }

    public ArrayList<String> getTransactionType() {
        return transactions;
        
    }

    public void evacuate(){
        transactions.clear();
    }

    public String determineClient(){
        return TypeOfClient;
    }

    public void servedByEmployee(){
        ;
    }
}
