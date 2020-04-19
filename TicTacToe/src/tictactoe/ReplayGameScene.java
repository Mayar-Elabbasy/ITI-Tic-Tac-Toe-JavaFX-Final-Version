/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.sql.ResultSet;
import java.sql.SQLException;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
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
import tictactoedb.*;

/**
 *
 * @author Mayar-Elabbasy
 */


public  class ReplayGameScene extends AnchorPane {
    Boolean xturn = true ;
    Button b[]=new Button[9];
    int id ;
    
    
    private    AnchorPane rootPane ;

    protected  InnerShadow innerShadow;
    protected  BorderPane borderPane;
    protected   GridPane gridPane;
    protected   ColumnConstraints columnConstraints;
    protected   ColumnConstraints columnConstraints0;
    protected   ColumnConstraints columnConstraints1;
    protected   RowConstraints rowConstraints;
    protected   RowConstraints rowConstraints0;
    protected   RowConstraints rowConstraints1;
    protected   Button b0;
    protected   Button b1;
    protected   Button b2;
    protected   Button b3;
    protected   Button b4;
    protected   Button b5;
    protected   Button b6;
    protected   Button b7;
    protected   Button b8;
    protected   DropShadow dropShadow;
    protected   Label player1;
    protected   Label player2;
    protected   Button goBackToMainMenuButton;
    protected   Button playButton;
    protected  Button backButton;
    protected  ImageView xPlayerImage;
    protected  ImageView oPlayerImage;
    protected  ImageView  playIcon;
    protected  ImageView  backIcon;
    protected  ImageCursor cursor;    
  
    
  
    

  
    Gamedb gd = new Gamedb();
    public ReplayGameScene(int gameId) {
        id = gameId;
        rootPane=new AnchorPane();
        goBackToMainMenuButton=new Button();
        backIcon=new ImageView("backIcon.png");
        playIcon=new ImageView("Play.png");
        backButton = new Button("", backIcon);
        playButton= new Button("",playIcon );
        innerShadow = new InnerShadow();
        borderPane = new BorderPane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        dropShadow = new DropShadow();
        cursor = new ImageCursor(new Image("cursor.png"));
        getStylesheets().add(TicTacToe.class.getResource("Buttons.css").toExternalForm());
       
        
         oPlayerImage=new ImageView("oPlayerImage.png");
         xPlayerImage=new ImageView("xPlayerImage.png");
         player1=new Label("Player 1", xPlayerImage); 
         player1.setFont(new Font("Berlin Sans FB Demi Bold",40.0));
         player1.setTextFill(Color.web("blue"));
         player1.setContentDisplay(ContentDisplay.BOTTOM);
         player1 .setAlignment(Pos.CENTER);
         player1 .setTranslateY(130);
         player1 .setTranslateX(100);
               
         player2=new Label("Player 2", oPlayerImage); 
         player2.setFont(new Font("Berlin Sans FB Demi Bold",40.0));
         player2.setTextFill(Color.web("red"));
         player2.setContentDisplay(ContentDisplay.BOTTOM);
         player2 .setAlignment(Pos.CENTER);
         player2 .setTranslateY(130);
         player2 .setTranslateX(440);
           
          
        b0 = new Button();
        b[0]=b0;
        b1 = new Button();
        b[1]=b1;
        b2 = new Button();
        b[2]=b2;
        b3 = new Button();
        b[3]=b3;
        b4 = new Button();
        b[4]=b4;
        b5 = new Button();
        b[5]=b5;
        b6 = new Button();
        b[6]=b6;
        b7 = new Button();
        b[7]=b7;
        b8 = new Button();
        b[8]=b8;
       
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
        
        
        AnchorPane.setBottomAnchor(borderPane, 400.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane,0.0);
        AnchorPane.setTopAnchor(borderPane, 350.0);
        borderPane.setLayoutX(150.0);
        borderPane.setLayoutY(0);
        borderPane.setPrefHeight(360.0);
        borderPane.setPrefWidth(300.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setMaxHeight(USE_PREF_SIZE);
        gridPane.setMaxWidth(USE_PREF_SIZE);
        gridPane.setMinHeight(USE_PREF_SIZE);
        gridPane.setMinWidth(USE_PREF_SIZE);
        gridPane.setPrefHeight(350.0);
        gridPane.setPrefWidth(320.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);
        

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(b0, 0);
        GridPane.setRowIndex(b0, 0);
        b0.setMaxHeight(USE_PREF_SIZE);
        b0.setMaxWidth(USE_PREF_SIZE);
        b0.setMinHeight(USE_PREF_SIZE);
        b0.setMinWidth(USE_PREF_SIZE);
        b0.setMnemonicParsing(false);
        b0.setPrefHeight(108.0);
        b0.setPrefWidth(100.0);
           

        GridPane.setColumnIndex(b1, 1);
        GridPane.setRowIndex(b1, 0);
        b1.setLayoutX(10.0);
        b1.setLayoutY(9.0);
        b1.setMaxHeight(USE_PREF_SIZE);
        b1.setMaxWidth(USE_PREF_SIZE);
        b1.setMinHeight(USE_PREF_SIZE);
        b1.setMinWidth(USE_PREF_SIZE);
        b1.setMnemonicParsing(false);
        b1.setPrefHeight(108.0);
        b1.setPrefWidth(100.0);


        GridPane.setColumnIndex(b2, 2);
        GridPane.setRowIndex(b2, 0);
        b2.setLayoutX(10.0);
        b2.setLayoutY(9.0);
        b2.setMaxHeight(USE_PREF_SIZE);
        b2.setMaxWidth(USE_PREF_SIZE);
        b2.setMinHeight(USE_PREF_SIZE);
        b2.setMinWidth(USE_PREF_SIZE);
        b2.setMnemonicParsing(false);
        b2.setPrefHeight(108.0);
        b2.setPrefWidth(100.0);
     

        GridPane.setColumnIndex(b3, 0);
        GridPane.setRowIndex(b3, 1);
        b3.setLayoutX(10.0);
        b3.setLayoutY(9.0);
        b3.setMaxHeight(USE_PREF_SIZE);
        b3.setMaxWidth(USE_PREF_SIZE);
        b3.setMinHeight(USE_PREF_SIZE);
        b3.setMinWidth(USE_PREF_SIZE);
        b3.setMnemonicParsing(false);
        b3.setPrefHeight(108.0);
        b3.setPrefWidth(100.0);
       
        
        GridPane.setColumnIndex(b4, 1);
        GridPane.setRowIndex(b4, 1);
        b4.setLayoutX(10.0);
        b4.setLayoutY(9.0);
        b4.setMaxHeight(USE_PREF_SIZE);
        b4.setMaxWidth(USE_PREF_SIZE);
        b4.setMinHeight(USE_PREF_SIZE);
        b4.setMinWidth(USE_PREF_SIZE);
        b4.setMnemonicParsing(false);
        b4.setPrefHeight(108.0);
        b4.setPrefWidth(100.0);
      

        GridPane.setColumnIndex(b5, 2);
        GridPane.setRowIndex(b5, 1);
        b5.setLayoutX(10.0);
        b5.setLayoutY(9.0);
        b5.setMaxHeight(USE_PREF_SIZE);
        b5.setMaxWidth(USE_PREF_SIZE);
        b5.setMinHeight(USE_PREF_SIZE);
        b5.setMinWidth(USE_PREF_SIZE);
        b5.setMnemonicParsing(false);
        b5.setPrefHeight(108.0);
        b5.setPrefWidth(100.0);
      

        GridPane.setColumnIndex(b6, 0);
        GridPane.setRowIndex(b6, 2);
        b6.setLayoutX(10.0);
        b6.setLayoutY(9.0);
        b6.setMaxHeight(USE_PREF_SIZE);
        b6.setMaxWidth(USE_PREF_SIZE);
        b6.setMinHeight(USE_PREF_SIZE);
        b6.setMinWidth(USE_PREF_SIZE);
        b6.setMnemonicParsing(false);
        b6.setPrefHeight(108.0);
        b6.setPrefWidth(100.0);
        


        GridPane.setColumnIndex(b7, 1);
        GridPane.setRowIndex(b7, 2);
        b7.setLayoutX(210.0);
        b7.setLayoutY(224.0);
        b7.setMaxHeight(USE_PREF_SIZE);
        b7.setMaxWidth(USE_PREF_SIZE);
        b7.setMinHeight(USE_PREF_SIZE);
        b7.setMinWidth(USE_PREF_SIZE);
        b7.setMnemonicParsing(false);
        b7.setPrefHeight(108.0);
        b7.setPrefWidth(100.0);

      

        GridPane.setColumnIndex(b8, 2);
        GridPane.setRowIndex(b8, 2);
        b8.setLayoutX(210.0);
        b8.setLayoutY(224.0);
        b8.setMaxHeight(USE_PREF_SIZE);
        b8.setMaxWidth(USE_PREF_SIZE);
        b8.setMinHeight(USE_PREF_SIZE);
        b8.setMinWidth(USE_PREF_SIZE);
        b8.setMnemonicParsing(false);
        b8.setPrefHeight(108.0);
        b8.setPrefWidth(100.0);

        
        
         goBackToMainMenuButton.setPrefHeight(70.0);
         goBackToMainMenuButton.setPrefWidth(200.0);
         goBackToMainMenuButton.setLayoutX(250.0);
         goBackToMainMenuButton.setLayoutY(35.0);
         goBackToMainMenuButton.setText(" Main Menu");

            
         DropShadow shadow = new DropShadow();
          goBackToMainMenuButton.setEffect(shadow);                                 
         goBackToMainMenuButton.setId("preferencesButtons");
       
       
       //===========goBackToMainMenuButtonHandling==========
      
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
                                        
          goBackToMainMenuButton.setOnMouseEntered((MouseEvent event) -> {
                                goBackToMainMenuButton.setCursor(cursor);
        });
             
      
   backButton .setTranslateY(40);
   backButton.setTranslateX(50);
   backButton.setPrefHeight(50.0);
   backButton.setPrefWidth(50.0);
   backButton.setEffect(shadow);                                 
   backButton.setId("preferencesButtons");
    backButton.setOnAction(new EventHandler<ActionEvent>() {
          
            @Override
            public void handle(ActionEvent e) {
                  Alert alert;
                  alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Confirmation");
                  alert.setHeaderText("Are you sure you want to go back?");
                  alert.getDialogPane().setBackground(new Background(new BackgroundFill(Color.rgb(160, 255, 230), CornerRadii.EMPTY, Insets.EMPTY)));
                  alert.getDialogPane().setGraphic(new ImageView("O.png"));
                  alert.getDialogPane().setCursor(cursor);
                  alert.initStyle(StageStyle.UNDECORATED);
                  alert.initModality(Modality.APPLICATION_MODAL);
                  alert.getDialogPane().setStyle("  -fx-padding: 10px;   -fx-font-size: 25px;  -fx-font-weight:bold;  -fx-font-family: \"Berlin Sans FB Demi\"; -fx-text-fill: green;");
                   Optional<ButtonType> result = alert.showAndWait();
                   if (result.get() == ButtonType.OK){
                            AudioClip music3 =new AudioClip(this.getClass().getResource("Music.mp3").toString());
                            music3.stop();
                             AchievementsScene root=new AchievementsScene();
                            
                           backButton.getScene().setRoot(root.getRootPane());
                             System.out.println("You have  exited  ^_^");
                     } else if (result.get() == ButtonType.CANCEL) {

                     }

                     }
                 });
  
   
  playButton .setTranslateY(205);
  playButton.setTranslateX(300);
  playButton.setTextFill(Color.web("green"));
  playButton.setFont(new Font("Berlin Sans FB Demi Bold",20.0));   
  playButton.setPrefHeight(70.0);
  playButton.setPrefWidth(100.0);
  playButton.setEffect(shadow);                   
  playButton.setId("preferencesButtons");

          playButton.setOnMouseClicked((MouseEvent e) -> {
           
//                    drawreply();
                Runnable mm= new Runnable(){
                      
                    @Override
                    public void run()
                    {
                        repliyng(); }
                };
                Thread bb=new Thread(mm);
                bb.setDaemon(true);
                bb.start();
         });                            
                            
                            
          goBackToMainMenuButton.setOnMouseEntered((MouseEvent event) -> {
                                goBackToMainMenuButton.setCursor(cursor);
        });
          
     
        dropShadow.setColor(javafx.scene.paint.Color.TEAL);
        dropShadow.setSpread(100);
        gridPane.setEffect(dropShadow);
        borderPane.setCenter(gridPane);

   
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(b0);
        gridPane.getChildren().add(b1);
        gridPane.getChildren().add(b2);
        gridPane.getChildren().add(b3);
        gridPane.getChildren().add(b4);
        gridPane.getChildren().add(b5);
        gridPane.getChildren().add(b6);
        gridPane.getChildren().add(b7);
        gridPane.getChildren().add(b8);
        getChildren().add(borderPane);

       getChildren().addAll(goBackToMainMenuButton,playButton,backButton);
       getChildren().addAll(player1, player2);
 

    }
    

    
    public void repliyng()
    {
        System.out.println("before rs replay");
       ResultSet rs= gd.retrivegame(id);
       System.out.println(rs);
       Boolean flag = true;
       int position =-1;
        try
        {
            while (rs.next())
            {
                position = rs.getInt(4);
                Button q = b[position];
                ImageView e ;
                if(flag)
                {
                    e =new ImageView("X.png");
                    e.setPickOnBounds(true);
                    flag = false ;
                }
                else
                {
                    e =new ImageView("O.png");
                    e.setPickOnBounds(true);
                    flag=true;
                }
                
                Platform.runLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        q.setGraphic(e);
                    }
                });
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(GameFXMLBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(GameFXMLBase.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    
    public Pane getRootPane(){
       return this; 
        
    }
}


