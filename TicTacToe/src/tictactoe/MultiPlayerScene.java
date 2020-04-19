/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import static javafx.scene.layout.Region.USE_PREF_SIZE;
import java.util.Optional;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
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
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BURLYWOOD;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tictactoedb.Gamedb;

/**
 *
 * @author  Mayar-Elabbasy
 */


public  class MultiPlayerScene extends AnchorPane {
    
    Boolean gameEnd = false;
    Boolean player22 = true;
    Boolean flag=false;
    Button b[]=new Button[9];
    int indexValue[]={0,0,0,0,0,0,0,0,0};
    Boolean serverOnline=false;
    ImageView iv ;
    Button winner[]=new Button[3];
    int winb;
    public volatile static Boolean xturn = true ;
    public volatile static Boolean exitOk = false ;
    public volatile static int xoplay1 = 0 ;
    
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
    protected   ImageView xPlayerImage;
    protected   ImageView oPlayerImage;
    protected   ImageCursor cursor;
    protected   AudioClip music3;
    protected   AudioClip music4;
    protected   MediaPlayer videoForWinner;
    protected   Stage secondStage2;
    
     Gamedb gd = new Gamedb();
    public MultiPlayerScene(String game) {
        if(xoplay1==1)
        {
            gd.gameName=game;
            gd.insertGame();
        }
        System.out.println("in multiplayer constructor");
        rootPane=new AnchorPane();
          cursor = new ImageCursor(new Image("cursor.png"));
        goBackToMainMenuButton=new Button();
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
       
        
        oPlayerImage=new ImageView("oPlayerImage.png");
        xPlayerImage=new ImageView("xPlayerImage.png");
         player1=new Label("Player 1", xPlayerImage); 
         player1.setFont(new Font("Berlin Sans FB Demi Bold",40.0));
         player1.setTextFill(Color.web("blue"));
         player1.setContentDisplay(ContentDisplay.BOTTOM);
         player1.setAlignment(Pos.CENTER);
         player1.setTranslateY(130);
         player1.setTranslateX(100);
         player1.setStyle("-fx-background-color:white");
         
         player2=new Label("Player 2", oPlayerImage); 
         player2.setFont(new Font("Berlin Sans FB Demi Bold",40.0));
         player2.setTextFill(Color.web("red"));
         player2.setContentDisplay(ContentDisplay.BOTTOM);
         player2.setAlignment(Pos.CENTER);
         player2.setTranslateY(130);
         player2.setTranslateX(440);
         
         music3 =new AudioClip(this.getClass().getResource("Music.mp3").toString());
         music4=new AudioClip(this.getClass().getResource("Directed by Robert B. Weide.mp3").toString());
         getStylesheets().add(TicTacToe.class.getResource("Buttons.css").toExternalForm());
       
      
        b0= new Button();
        b1 = new Button();
        b2 = new Button();
        b3 = new Button();
        b4 = new Button();
        b5 = new Button();
        b6 = new Button();
        b7 = new Button();
        b8 = new Button();
        
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
 //==========iconsHandlingWhenMouseIsClicked===========
           //0
        b0.setMaxHeight(USE_PREF_SIZE);
        b0.setMaxWidth(USE_PREF_SIZE);
        b0.setMinHeight(USE_PREF_SIZE);
        b0.setMinWidth(USE_PREF_SIZE);
        b0.setMnemonicParsing(false);
        b0.setPrefHeight(108.0);
        b0.setPrefWidth(100.0);
         
        //==========iconsHandlingWhenMouseIsClicked===========
  b0.setOnMouseClicked((MouseEvent e) -> {
          if(xturn)
                    {       
                        
                         ServerPlayer.sendXBtnLoc(0); /**added by Aladdin in all setOnMouseClicked with different numbers of buttons-MultiPlayerScene*/
                         setX(b[0],0); 

                    }
                    
                    else 
                    {                                                
                        ClientPlayer.sendOBtnLoc(0); /**added by Aladdin in all setOnMouseClicked with different numbers of buttons-MultiPlayerScene*/  
                        setO(b[0],0);
                    }
      
          
});
          
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
     //==========iconsHandlingWhenMouseIsClicked===========
           
        b1.setOnMouseClicked((MouseEvent e) -> {
            if(xturn)
                    {                       
                        ServerPlayer.sendXBtnLoc(1);
                        setX(b[1],1);                        
                    }
                    
                    else 
                    {     
                         ClientPlayer.sendOBtnLoc(1);
                         setO(b[1],1);
                    }
                
});

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
         //==========iconsHandlingWhenMouseIsClicked===========
           
        b2.setOnMouseClicked((MouseEvent e) -> {
            if(xturn)
                    {                        
                        ServerPlayer.sendXBtnLoc(2);
                        setX(b[2],2);   
                    }
                    
                    else 
                    {                                                
                        ClientPlayer.sendOBtnLoc(2);
                        setO(b[2],2);
                    }       

        });

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
       
        
             //==========iconsHandlingWhenMouseIsClicked===========
           
        b3.setOnMouseClicked((MouseEvent e) -> {
            if(xturn)
                    {   
                        
                        ServerPlayer.sendXBtnLoc(3);
                        setX(b[3],3);   
                    }
                    
                    else 
                    {                                                
                        ClientPlayer.sendOBtnLoc(3);
                        setO(b[3],3);
                    }                   
        });

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
      
        
            //==========iconsHandlingWhenMouseIsClicked===========
           
        b4.setOnMouseClicked((MouseEvent e) -> {
            if(xturn)
                    {   
                        ServerPlayer.sendXBtnLoc(4);
                        setX(b[4],4);
                        
                    }
                    
                    else 
                    {                                                
                         ClientPlayer.sendOBtnLoc(4);
                        setO(b[4],4);
                    }

        });


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
   
        //==========iconsHandlingWhenMouseIsClicked===========
           
        b5.setOnMouseClicked((MouseEvent e) -> {
            if(xturn)
                    {                     
                         ServerPlayer.sendXBtnLoc(5);
                         setX(b[5],5);
                    }
                    
                    else 
                    {                                                
                        ClientPlayer.sendOBtnLoc(5);
                        setO(b[5],5);
                    }

        });


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
        
        
           //==========iconsHandlingWhenMouseIsClicked===========
           
        b6.setOnMouseClicked((MouseEvent e) -> {
             if(xturn)
                    {               
                        ServerPlayer.sendXBtnLoc(6);
                        setX(b[6],6);                        
                    }
                    
                    else 
                    {       
                        ClientPlayer.sendOBtnLoc(6);
                        setO(b[6],6);
                    }

        });

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
         //==========iconsHandlingWhenMouseIsClicked===========
           
        b7.setOnMouseClicked((MouseEvent e) -> {
            if(xturn)
                    {           
                       ServerPlayer.sendXBtnLoc(7);
                        setX(b[7],7);
                    }
                    
                    else 
                    {      
                        ClientPlayer.sendOBtnLoc(7);
                        setO(b[7],7);
                    }
        });
      

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
         //==========iconsHandlingWhenMouseIsClicked===========
           
        b8.setOnMouseClicked((MouseEvent e) -> {
            if(xturn)
                    {         
                        ServerPlayer.sendXBtnLoc(8);
                        setX(b[8],8);  

                    }
                    
                    else 
                    {                                                
                         ClientPlayer.sendOBtnLoc(8);
                        setO(b[8],8);
                    }
        });
       
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
                       music3.stop();
                       music4.stop();
//                       videoForWinner.stop();

               MainMenuFXMLBase root = new  MainMenuFXMLBase();
              goBackToMainMenuButton .getScene().setRoot(root.getRootPane());
         //  try { 
                        //  if(xturn){
                         // ServerPlayer.input.close();
                         // ServerPlayer.output.close();
                        //  }
//                          else{
//                          ClientPlayer.input.close();
//                          ClientPlayer.output.close(); 
//                          }

                         // exitOk = true;
                     //     System.out.println("You have existed  ***");
                    //  } catch (IOException ex) {
                     //     System.out.println("multiplayerScene.java go back");
                     // }
              System.out.println("You have  exited  ^_^");
            } else if (result.get() == ButtonType.CANCEL) {
           
            }
              
            }
        });
                                          
         
          goBackToMainMenuButton.setOnMouseEntered((MouseEvent event) -> {
                                goBackToMainMenuButton.setCursor(cursor);
        });

        dropShadow.setColor(javafx.scene.paint.Color.TEAL);
        dropShadow.setSpread(100);
        gridPane.setEffect(dropShadow);
        borderPane.setCenter(gridPane);
        
        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints0, columnConstraints1);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1);
        gridPane.getChildren().addAll(b0, b1, b2, b3, b4, b5, b6, b7 , b8);
        
        getChildren().addAll(borderPane, goBackToMainMenuButton, player1, player2);

    }
    Label xTurn =new Label();
    public void setX(Button b,int i)
    {
                    iv =new ImageView("X.png");
                    iv.setPickOnBounds(true);
                    b.setGraphic(iv);
                    indexValue[i]=1;
                    if(xoplay1==1)
                        gd.insertRow("x",i);
                    
                       player2.setStyle("-fx-background-color:white");
                       player1.setStyle("-fx-background-color:transparent");
                
                    b.setOnMouseClicked(null);
                    //b.setDisable(true);
                    checkWin();
                    xturn=false;

                                
    }
    
    public void setO(Button b,int i)
    {
                   iv =new ImageView("O.png");
                   iv.setPickOnBounds(true);
                    b.setGraphic(iv);
                     indexValue[i]=2;
                     if(xoplay1==1)
                        gd.insertRow("o",i);
                    b.setOnMouseClicked(null);
                      xTurn.setVisible(false);
                      player2.setStyle("-fx-background-color:transparent");
                      player1.setStyle("-fx-background-color:white");

                    //b.setDisable(true);
                    checkWin();
                    xturn=true;
    }
    
    
       public int checkWin()
    {
        for(int i = 0;i<=6;i+=3)
        {
            if(indexValue[i]==0)
                continue;
            if(indexValue[i]==indexValue[i+1] && indexValue[i]==indexValue[i+2])
            {
                winb = indexValue[i];
                winner[0]=b[i];
                winner[1]=b[i+1];
                winner[2]=b[i+2];
                flag=true;
                System.out.println(indexValue[i]);
                finishGame(indexValue[i]);
                return 0;               
            }
        }
                    
        for(int n=0;n<3;n++)
        {
            System.out.println(n+" : "+indexValue[n]+" / "+indexValue[n+3]+" / "+indexValue[n+6]);
             if(indexValue[n]==0)
                continue;
            if(indexValue[n]==indexValue[n+3] && indexValue[n]==indexValue[n+6])
            {
                winb = indexValue[n];
                winner[0]=b[n];
                winner[1]=b[n+3];
                winner[2]=b[n+6];
                flag=true;
                System.out.println(indexValue[n]);
                finishGame(indexValue[n]);
                return 0;
            }
        }

        if(indexValue[0]!=0 && indexValue[0]==indexValue[4] && indexValue[0]==indexValue[8])        
            {
                winb = indexValue[4];
                winner[0]=b[0];
                winner[1]=b[4];
                winner[2]=b[8];
                System.out.println(indexValue[4]);
                finishGame(indexValue[4]);
                return 0 ;
            }
        if(indexValue[2]!=0 && indexValue[2]==indexValue[4] && indexValue[2]==indexValue[6])
        {
            winb = indexValue[4];
            winner[0]=b[2];
                winner[1]=b[4];
                winner[2]=b[6];
            System.out.println(indexValue[4]);
                finishGame(indexValue[4]);
                return 0 ;
        }
        
        int l=0 ;
        for ( l=0;l<9;l++)//loop on btns if all btns number then draw
        {
            if(indexValue[l]==0)
                break;                                          
        }
        if (l>8)// check draw
        {
            finishGame(0);
            System.out.println(l);
        }
        return 1;
    }
    
    public void finishGame(int m)
    {
        if(m!=0)
        {
            winner[0].setStyle("-fx-background-color:MIDNIGHTBLUE;");
            winner[1].setStyle("-fx-background-color:MIDNIGHTBLUE;");
            winner[2].setStyle("-fx-background-color:MIDNIGHTBLUE;");
        }
        gameEnd=true;
        //gridPane.setDisable(true);
        for (int i =0;i<9;i++)
        {
            if(indexValue[i]==0)
             b[i].setOnMouseClicked(null);                  
        }
        
        
        switch (m)
        {
            case 0:
                if(xoplay1==1)
                    gd.updateWinner("draw");
                System.out.println("sorry its draw");
                break;
            case 1:
                if(xoplay1==1)
                    gd.updateWinner("X player");
                     System.out.println("x winner");
                     player2.setStyle("-fx-background-color:transparent");
                      player1.setStyle("-fx-background-color:gold");
                
                break;
            case 2:
                if(xoplay1==1)
                    gd.updateWinner("O player");
                   System.out.println("o winner ");
                   player1.setStyle("-fx-background-color:transparent");
                   player2.setStyle("-fx-background-color:gold");
                
                break;
            default:
                break;
        }
	drawWin(m);
    }

   public Pane getRootPane(){
       return this; 
        
    }
   	public void drawWin(int state )
        {
                     ImageView  icon;
                     Button end = null ;
                     Boolean videoFlag = false;
                     switch (state)
                     {
                         case 0 :
                             icon = new ImageView("draw.png");
                             end = new Button(" DRAW ",icon);
                            music3.stop();
                             music4.play();
                             break;
                         case 1 : 
                             icon = new ImageView("winnerIcon.png");
                             end = new Button(" X winner ",icon);
                             videoFlag =true;
                             break;
                          case 2 : 
                             icon = new ImageView("winnerIcon.png");
                             end = new Button(" O winner ",icon);
                             videoFlag =true;
                             break;  
                     }
                             
                    
                       
                   end.setPrefHeight(50.0);
                    end.setPrefWidth(320.0);

                   end.setFont(new Font("Berlin Sans FB Demi Bold", 30.0));

                   DropShadow shadow3 = new DropShadow();
                    end.setEffect(shadow3);
                    end.setId("preferencesButtons");
                    end.setLayoutX(50);
                    end.setLayoutY(720);
                    TranslateTransition  drawButtonRotate = new TranslateTransition(Duration.seconds(2),end);
                     drawButtonRotate.setDelay(Duration.seconds(1));
                     drawButtonRotate.setToX(300);
                     drawButtonRotate.setCycleCount(100);
                     drawButtonRotate.setAutoReverse(true);
                     drawButtonRotate.play();

                     getChildren().addAll(end);
        

                       music3.stop();
                        if(videoFlag && xoplay1 == winb )
                        {
                            
                            StackPane secondaryLayout2 = new StackPane();
                            videoForWinner = new MediaPlayer( new Media(getClass().getResource("winner1.mp4").toExternalForm()));
                            MediaView mediaView2 = new MediaView(videoForWinner);
                            secondaryLayout2.getChildren().addAll(mediaView2);
                            ImageCursor cursor2;
                            cursor2 = new ImageCursor(new Image("winnerIconForStage.png"));
                            secondaryLayout2.setCursor(cursor2);
                            
                            Scene secondScene2 = new Scene(secondaryLayout2, 900, 560);
                            secondStage2 = new Stage();
                            secondStage2.getIcons().add(new Image("winnerIconForStage.png"));
                            secondStage2.setTitle("Congratulations");
                            secondStage2.setResizable(false);
                            secondStage2.setX(800);
                            secondStage2.setY(60);
                            setCursor(cursor2);
                            secondStage2.setScene(secondScene2);
                            secondStage2.show();
                            videoForWinner.play();
                        }

        }

   /* Parent getRootPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}

