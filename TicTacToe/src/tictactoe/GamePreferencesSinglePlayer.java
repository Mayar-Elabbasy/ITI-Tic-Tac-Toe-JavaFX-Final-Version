/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BURLYWOOD;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 *
 * @author Mayar-Elabbasy
 */

public  class GamePreferencesSinglePlayer extends AnchorPane {
    
  private AnchorPane rootPane ;
  protected  InnerShadow innerShadow;
  protected  BorderPane borderPane;
  protected  DropShadow dropShadow;
  protected ImageView xPlayerImage;
  protected ImageView oPlayerImage;
  protected ImageView  yesIcon;
  protected ImageView  noIcon;
  protected ImageCursor cursor;
  protected ImageCursor yesCursor;
  protected ImageCursor noCursor;
  
  


  

    public GamePreferencesSinglePlayer() {
         rootPane=new AnchorPane();
     
         innerShadow = new InnerShadow();
         borderPane = new BorderPane();
         cursor = new ImageCursor(new Image("cursor.png"));
         yesCursor=new ImageCursor(new Image("yesIcon.png"));
         noCursor=new ImageCursor(new Image("iconfinder_no_1815.png"));
         getStylesheets().add(TicTacToe.class.getResource("Buttons.css").toExternalForm());
     
    
         dropShadow = new DropShadow();
         oPlayerImage=new ImageView("O.png");
         xPlayerImage=new ImageView("X.png");
         Label  player1=new Label("Player 1", xPlayerImage); 
         player1.setFont(new Font("Berlin Sans FB Demi Bold",30.0));
         player1.setTextFill(Color.web("blue"));
         player1.setContentDisplay(ContentDisplay.BOTTOM);
         player1 .setAlignment(Pos.CENTER);
         player1 .setTranslateY(200);
         player1 .setTranslateX(150);
         
         Label  player2=new Label("Player 2", oPlayerImage); 
         player2.setFont(new Font("Berlin Sans FB Demi Bold",30.0));
         player2.setTextFill(Color.web("red"));
         player2.setContentDisplay(ContentDisplay.BOTTOM);
         player2 .setAlignment(Pos.CENTER);
         player2 .setTranslateY(200);
         player2 .setTranslateX(400);
         Label label = new Label();
         label .setTranslateY(120);
         label .setTranslateX(250);
         label.setText("Players");
         label.setFont(new Font("Berlin Sans FB Demi Bold",60.0));
         label.setTextFill(Color.web("navy"));
        
          Label recordingQuestion= new Label();
          recordingQuestion .setTranslateY(450);
          recordingQuestion.setTranslateX(100);
          recordingQuestion.setText("Do you want to record the game?");
          recordingQuestion.setFont(new Font("Berlin Sans FB Demi Bold",35.0));
          recordingQuestion.setTextFill(Color.web("navy"));
   
         yesIcon=new ImageView("yesIcon.png");
         Button acceptButton = new Button("Yes",yesIcon );
         acceptButton .setTranslateY(500);
         acceptButton.setTranslateX(200);
         acceptButton.setTextFill(Color.web("green"));
         acceptButton.setId("aprovelButtons");
         acceptButton.setCursor( yesCursor);

          noIcon=new ImageView("iconfinder_no_1815.png");
          Button declineButton = new Button("No",noIcon );
          declineButton .setTranslateY(500);
          declineButton.setTranslateX(400);
          declineButton.setTextFill(Color.web("red"));
          declineButton.setId("aprovelButtons");
          declineButton.setCursor( noCursor);


        Label gameNameLabel = new Label();
        gameNameLabel .setTranslateY(390);
        gameNameLabel.setTranslateX(155);
        gameNameLabel.setText("Game Name:");
        gameNameLabel.setFont(new Font("Berlin Sans FB Demi Bold",35.0));
        gameNameLabel.setTextFill(Color.web("navy"));

         TextField  gameName = new TextField();
         gameName .setTranslateY(400);
         gameName .setTranslateX(385);
         gameName.setStyle("-fx-background-color: TRANSPARENT; -fx-border-color: navy;-fx-border-radius: 20 20 20 20;");


         Button goBackToMainMenuButton = new Button("Go back to main menu");
         goBackToMainMenuButton .setTranslateY(680);
         goBackToMainMenuButton.setTranslateX(180);
         goBackToMainMenuButton.setOnAction(new EventHandler<ActionEvent>() {
          
            @Override
            public void handle(ActionEvent e) {
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Do you want to exit?");
                alert.getDialogPane().setBackground(new Background(new BackgroundFill(Color.rgb(160, 255, 230), CornerRadii.EMPTY, Insets.EMPTY)));
                alert.getDialogPane().setGraphic(new ImageView("X.png"));
                alert.getDialogPane().setCursor(cursor);
                alert.initStyle(StageStyle.UNDECORATED);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.getDialogPane().setStyle("  -fx-padding: 10px;   -fx-font-size: 25px;  -fx-font-weight:bold;  -fx-font-family: \"Berlin Sans FB Demi\"; -fx-text-fill: green;");

        Optional<ButtonType> result = alert.showAndWait();
           if (result.get() == ButtonType.OK){
                    AudioClip music3 =new AudioClip(this.getClass().getResource("Music.mp3").toString());

                       music3.stop();
               MainMenuFXMLBase root = new  MainMenuFXMLBase();
             goBackToMainMenuButton .getScene().setRoot(root.getRootPane());
              System.out.println("You have  exited  ^_^");
            } else if (result.get() == ButtonType.CANCEL) {
           
            }
              
            }
        });
        
        
        goBackToMainMenuButton.setPrefHeight(70.0);
        goBackToMainMenuButton.setPrefWidth(350.0);
        
          DropShadow shadow = new DropShadow();
          goBackToMainMenuButton.setEffect(shadow);          
          goBackToMainMenuButton.setId("preferencesButtons");
          
        Button startPlayingButton = new Button("Start Playing");
        startPlayingButton  .setTranslateY(600);
        startPlayingButton .setTranslateX(180);
        startPlayingButton.setOnAction(new EventHandler<ActionEvent>() {
                               @Override
                               public void handle(ActionEvent e) {
                                   
                                if(!(gameName.getText().equals("")))
                                {
                                    
                                   
                                 GameFXMLBase root2=new GameFXMLBase(gameName.getText());
                                startPlayingButton.getScene().setRoot(root2.getRootPane());
                                }else {
                                         Alert alert;
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("To start the game you have to enter the game name first");
                alert.getDialogPane().setBackground(new Background(new BackgroundFill(Color.rgb(160, 255, 230), CornerRadii.EMPTY, Insets.EMPTY)));
                alert.getDialogPane().setGraphic(new ImageView("X.png"));
                alert.getDialogPane().setCursor(cursor);
                alert.initStyle(StageStyle.UNDECORATED);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.getDialogPane().setStyle("  -fx-padding: 10px;   -fx-font-size: 25px;  -fx-font-weight:bold;  -fx-font-family: \"Berlin Sans FB Demi\"; -fx-text-fill: green;");
                alert.showAndWait();
                                }
     
                               }
                           });
          startPlayingButton .setPrefHeight(70.0);
          startPlayingButton .setPrefWidth(350.0);
          startPlayingButton .setFont(new Font("Berlin Sans FB Demi Bold", 33.0));
          startPlayingButton .setEffect(shadow);         
          startPlayingButton.setId("preferencesButtons");
                //==========backgroudColors===================

          Rectangle colors = new Rectangle(this.getWidth(), this.getHeight(),
                new LinearGradient(0f, 1f, 0f, 0f, true, CycleMethod.NO_CYCLE, new 
                Stop[]{
                                new Stop(0, Color.web("#FFFFFF")),
                                new Stop(0.80, Color.web("PALETURQUOISE")),
                                new Stop( 0.10, BURLYWOOD),
                                new Stop(1, Color.web("#000000"))
                               ,}));
                                   colors.widthProperty().bind(this.widthProperty());
                                   colors.heightProperty().bind(this.heightProperty());
            getChildren().add(colors);
      
        setId("AnchorPane");
        setPrefHeight(709.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: lightgray;");
        
     

        innerShadow.setChoke(0.25);
        innerShadow.setColor(javafx.scene.paint.Color.valueOf("PALETURQUOISE"));
        innerShadow.setHeight(85.32);
        innerShadow.setRadius(42.129999999999995);
        innerShadow.setWidth(85.2);
        setEffect(innerShadow);
        
        
        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane,0.0);
        AnchorPane.setTopAnchor(borderPane, 0.0);
        borderPane.setLayoutX(0);
        borderPane.setLayoutY(0);
        borderPane.setPrefHeight(360.0);
        borderPane.setPrefWidth(300.0);
        borderPane.getChildren().addAll(player1, player2);

       
       getChildren().addAll(player1, player2 ,label,startPlayingButton,goBackToMainMenuButton,gameName,  gameNameLabel, recordingQuestion,acceptButton,declineButton);
   
    }
    
    public Pane getRootPane(){
       return this; 
        
    }
}
