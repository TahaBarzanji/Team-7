package Project_Java;
import java.util.Random;


public abstract class People {
    private String name;
    private int age;
    private int id;
    private int temperment; // this will determine their patience//
    Random random = new Random();

    protected String getName(){
        return name;
    }
    protected int getAge(){
        return age;
    }    
    protected int getid(){
        return id;
    }
    protected int getTemperment(){
        return temperment;
    }
    protected void generatePerson(String[] listofnames){
        
        name = listofnames[random.nextInt(listofnames.length)] + " " + listofnames[random.nextInt(listofnames.length)];
        age = random.nextInt(50) + 18;
        id = random.nextInt(999999999)+ 1000000000;
        if(age>49){
            temperment = random.nextInt(4) + 5;
        
        }
        else{temperment = random.nextInt(4) + 1;}
        
    }
    
    

}
