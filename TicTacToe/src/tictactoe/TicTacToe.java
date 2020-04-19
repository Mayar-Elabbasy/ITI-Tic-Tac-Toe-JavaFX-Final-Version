/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//import tictactoedb.*;

/**
 *
 * @author Mayar-Elabbasy
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
     MainMenuFXMLBase root = new  MainMenuFXMLBase();  
     Scene   scene = new Scene(root, 700, 800);
        
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
  
        
        // ==============game icon=========
        primaryStage.getIcons().add(new Image("gameIcon.png"));
     
        primaryStage.setOnCloseRequest(e -> {
        System.exit(0);
   
     });
        
          primaryStage.show();
          }
        
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
