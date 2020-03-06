/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temperature;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author MOMEN
 */
public class Temperature extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label EnterL = new Label("Enter Celsius temperature :");
        TextField InputTF = new TextField();

        
        ToggleGroup ch = new ToggleGroup();
        RadioButton chose1 = new RadioButton("Fahrenhieit");
        RadioButton chose2 = new RadioButton("Kelvin");
        chose1.setSelected(true);
        chose1.setToggleGroup(ch);
        chose2.setToggleGroup(ch);

        Label resultL = new Label();

        
        HBox chose = new HBox(20 ,chose1 , chose2);
        chose.setAlignment(Pos.CENTER);
        

        InputTF.setOnKeyReleased(new EventHandler<KeyEvent>() {
        public void handle(KeyEvent ke) {
         if(!InputTF.getText().equals("")  ){
         String valueS = InputTF.getText();   
        double valueD = Double.parseDouble(valueS);
        

        if (chose1.isSelected()) {
            double F = valueD * 9 / 5 + 32 ;
            resultL.setText("New Temperature in is: " + F);
        } else if (chose2.isSelected()) {
            double K = valueD + 273.15;
            resultL.setText("New Temperature in is: " + K);
        }       
        }else resultL.setText("Plese Enter value");   
    }
        }
        );
        
        
        
        chose1.setOnMouseClicked(new EventHandler<MouseEvent>() {
         public void handle(MouseEvent me) {   
         if(!InputTF.getText().equals("")){
         String valueS = InputTF.getText();   
        double valueD = Double.parseDouble(valueS);
        if (chose1.isSelected()) {
            double F = valueD * 9 / 5 + 32 ;
            resultL.setText("New Temperature in is: " + F);
        } 
        
        }else resultL.setText("Plese Enter value");
            
    }
        }
        );

        chose2.setOnMouseClicked(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
         if(!InputTF.getText().equals("")  ){
         String valueS = InputTF.getText();   
        double valueD = Double.parseDouble(valueS);
        if (chose2.isSelected()) {
            double K = valueD + 273.15;

            resultL.setText("New Temperature in is: " + K);
        }
       
        }else resultL.setText("Plese Enter value");
            
    }
        });
      
        VBox s = new VBox(10,EnterL, InputTF, chose, resultL);
        s.setAlignment(Pos.CENTER);

        Scene scene = new Scene(s, 400, 200);
        primaryStage.setTitle("Temperature converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
