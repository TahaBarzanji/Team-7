package bankSim;

import java.io.IOException;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;



public class BankGUI extends Application{

     @FXML
     private AnchorPane MainWindow;
     @FXML
     private Button phase1Button;
     @FXML
     private Button phase2Button;
     @FXML
     private Circle client;
     @FXML 
     private Circle thief;
     @FXML
     private ImageView atm1;
     @FXML
     private ImageView atm2;
     @FXML
     private ImageView atm3;
     @FXML
     private ImageView atm4;
     @FXML
     private Rectangle atmOut;
    	 
     @FXML
     void clientInfo(MouseEvent event){
         Tooltip tooltip = new Tooltip("Client Information:\nName: Ahmed Najeeb\nAge: 21");

         Tooltip.install(client, tooltip);
     }
     @FXML
     private Circle Thief;
     
     @FXML
     void thiefInfo(MouseEvent event){
    	 Tooltip tooltip = new Tooltip("Client Information:\nName: Lemon Man\nAge: 35");

         Tooltip.install(thief, tooltip);
    	 
     
     }
     @FXML
     void atm1Info(MouseEvent event){
    	 Tooltip tooltip = new Tooltip("ATM Information:\nCash Amount: 500,000$\nStatus:Not Occupied and Working");

         Tooltip.install(atm1, tooltip);
    	 
     
     }
     @FXML
     void atm2Info(MouseEvent event){
    	 Tooltip tooltip = new Tooltip("ATM Information:\nCash Amount: 200,000$\nStatus:Not Occupied and Not Working");

         Tooltip.install(atm2, tooltip);
    	 
    	 
     
     }
     @FXML
     void atm3Info(MouseEvent event){
    	 Tooltip tooltip = new Tooltip("ATM Information:\nCash Amount: 10,000$\nStatus:Occupied and Working");

         Tooltip.install(atm3, tooltip);
    	 
     
     }
     @FXML
     void atm4Info(MouseEvent event){
    	 Tooltip tooltip = new Tooltip("ATM Information:\nCash Amount: 500,000$\nStatus:Occupied and Not Working");

         Tooltip.install(atm4, tooltip);
    	 
    	 
     
     }
     @FXML
     void atmOutInfo(MouseEvent event){
    	 Tooltip tooltip = new Tooltip("ATM Information:\nCash Amount: 500,000$\nStatus:Occupied and Working");

         Tooltip.install(atmOut, tooltip);
    	 
    	 
     
     }
     
     @FXML
     void phase1(ActionEvent event) {
    	 try {
    		 
    		 Parent phase1Window =  FXMLLoader.load(getClass().getResource("Phase1Window.fxml"));
    		 // Platform.runLater
    		 
    	  	 Polyline path1 = new Polyline();
	         path1.getPoints().addAll(new  Double[] {
	         22.0, 385.0,
	         22.0, 190.0,
	         225.0, 190.0,
	         212.5, 30.0});
	         
	         PathTransition transition = new PathTransition();
	         transition.setNode(client);
	         transition.setPath(path1);
	         transition.setInterpolator(javafx.animation.Interpolator.LINEAR);
	         transition.setDuration(Duration.seconds(20));
	         transition.setCycleCount(PathTransition.INDEFINITE);
	        
	         transition.play();
     
	     
	             Stage phase1 = new Stage();
	             phase1.setTitle("Phase1");
	             phase1.setScene(new Scene(phase1Window, 900, 400));
	             phase1.show();
	                  
	         
	     
		} catch (IOException e) {
			
			e.printStackTrace();
		}
         
         
     }
     

     @FXML
     void phase2(ActionEvent event) {
         System.out.println("Phase2");
    }
     
 

    @Override
    public void start(Stage primaryStage){
        try{
            Parent root =  FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            primaryStage.setTitle("BankSim");
            primaryStage.setScene(new Scene(root, 900, 400));
            primaryStage.setMinWidth(900); 
            primaryStage.setMinHeight(400);  
            primaryStage.show();
            

        } catch(Exception e){
            e.printStackTrace();
        }

    
   
    }
    

    public static void main(String[] args) {
        launch(args);
    }





}

