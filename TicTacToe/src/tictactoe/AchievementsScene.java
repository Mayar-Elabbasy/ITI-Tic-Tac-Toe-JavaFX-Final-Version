/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.temporal.ValueRange;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BURLYWOOD;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import tictactoedb.Gamedb;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Callback;
/**
 *
 * @author Mayar-Elabbasy
 */


public  class AchievementsScene extends AnchorPane  {
    
     ResultSet rs;
     Connection connection;
     Statement statement ;
     String sql;

    private AnchorPane rootPane ;
    protected final BorderPane borderPane;
    protected final BorderPane tableViewPane;
    private final TableView tableView;
    int re;
    protected ImageCursor cursor;
    protected Button replayButton;
  
        
       private ObservableList<ObservableList> data;
 
      //CONNECTION DATABASE
    public void buildData() {
            Gamedb gd = new Gamedb();
            data = FXCollections.observableArrayList();
            try
            {
            ResultSet rs = gd.retriveAchievements();
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>()
                {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                         return new SimpleStringProperty(param.getValue().get(j).toString());
                             
                    }
                });
                 getStylesheets().add(TicTacToe.class.getResource("Table.css").toExternalForm());
                 getStylesheets().add(TicTacToe.class.getResource("Buttons.css").toExternalForm());
                col.setPrefWidth(227.3);
                col.setId("col");
           
                tableView.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }
 
           
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                 re=Integer.parseInt(row.get(0));
                int a;
                a=11;
     
                  for (int i = 10; i<=re; i++) {
                    //Iterate Column
                      System.out.println("row dataaa"+row.get(0));
                }
               // else{System.out.println("failed");}
                
                row.get(0);
              //  System.out.println("row dataaa"+row.get(0));
                System.out.println("Row [1] added " + row);
                data.add(row);
              //  System.out.println("Row [1] added to data " + data);
 
            }
 
            //FINALLY ADDED TO TableView
            tableView.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
	//end is here 

      
    public AchievementsScene() {
     tableView = new TableView();
     DropShadow shadow = new DropShadow();
        buildData();
 
              DynamicTable d = new DynamicTable();
        
        cursor = new ImageCursor(new Image("cursor.png"));
        borderPane = new BorderPane();
        tableViewPane = new BorderPane();
         replayButton = new Button("Replay");

        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane, 0.0);
        AnchorPane.setTopAnchor(borderPane, 400.0);
        borderPane.setLayoutX(0.0);
        borderPane.setLayoutY(500.0);
        borderPane.setPrefHeight(400.0);
        borderPane.setPrefWidth(400.0);

        BorderPane.setAlignment(tableViewPane, javafx.geometry.Pos.CENTER);
         
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
            
        Lighting lighting= new Lighting();   
        lighting.setDiffuseConstant(2.0);
        lighting.setSpecularConstant(1.42);
        lighting.setSpecularExponent(31.59);
        lighting.setSurfaceScale(5.36);
        
        
        Text questionText= new Text();
        questionText .setTranslateY(190);
        questionText.setTranslateX(15);
        questionText.setText("IF YOU WANT TO REPLAY THE GAME");
        questionText.setFontSmoothingType(javafx.scene.text.FontSmoothingType.LCD);
        questionText.setFont(new Font("Berlin Sans FB Demi Bold",40.0));
        questionText.setFill(Color.web("Navy"));
        questionText.setEffect(lighting);

  
        Label gameIdLabel = new Label();
        gameIdLabel .setTranslateY(220);
        gameIdLabel.setTranslateX(100);
        gameIdLabel.setText("ENTER GAME ID:");
        gameIdLabel.setFont(new Font("Berlin Sans FB Demi Bold",35.0));
        gameIdLabel.setTextFill(Color.web("navy"));
        gameIdLabel.setEffect(lighting);
          
          
        TextField  gameId = new TextField();
        gameId .setTranslateY(227);
        gameId .setTranslateX(400);
        gameId.setStyle("-fx-background-color: TRANSPARENT; -fx-border-color: navy;-fx-border-radius: 20 20 20 20;");
        
//        ObservableList<Gamedb> list=FXCollections.observableArrayList();
        gameId.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Gamedb retGame = new Gamedb();
                ResultSet rs =retGame.retriveAchievements(); 
//                tableView.
                
            }
        });
        
        Button goBackToMainMenuButton = new Button("Go Back To Main Menu");
        goBackToMainMenuButton .setTranslateY(50);
        goBackToMainMenuButton.setTranslateX(170);
        goBackToMainMenuButton.setOnAction(new EventHandler<ActionEvent>() {
          
            @Override
            public void handle(ActionEvent e) {
                  Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
  
        alert.setTitle("Confirmation");
        alert.setHeaderText("Do you want to go back to main menu?");
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
        goBackToMainMenuButton.setEffect(shadow);          
        goBackToMainMenuButton.setId("preferencesButtons");

          replayButton .setTranslateY(300);
          replayButton.setTranslateX(240);
          replayButton.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
            public void handle(ActionEvent e) {
                
                try{
                 String m = gameId.getText();
        int r = Integer.parseInt(gameId.getText());
       
          ValueRange range = ValueRange.of(0, re);
          String pattern="[a-zA-z]+";
          boolean num=true;
          
          
              Double number = Double.parseDouble(pattern);
          }
          catch(NumberFormatException e2)
          {System.out.println("false");
          
          }
      
          
try{
            int r = Integer.parseInt(gameId.getText());
             ValueRange range = ValueRange.of(0, re);
             String pattern="[a-zA-z]+";
              boolean num=true;
            if(range.isValidValue(r)) {
               System.out.println("in range");
              
                  ReplayGameScene root2=new  ReplayGameScene(Integer.parseInt(gameId.getText()));                   
                  replayButton.getScene().setRoot(root2.getRootPane());}
             else {
                        System.out.println("not in range");
                        }          
            }     
                  catch(NumberFormatException e3)
                  {System.out.println("false");
                    Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please enter any id from the table below ONLY ");
            alert.getDialogPane().setBackground(new Background(new BackgroundFill(Color.rgb(160, 255, 230), CornerRadii.EMPTY, Insets.EMPTY)));
            alert.getDialogPane().setGraphic(new ImageView("O.png"));
            alert.getDialogPane().setCursor(cursor);
            alert.initStyle(StageStyle.UNDECORATED);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setStyle("  -fx-padding: 10px;   -fx-font-size: 20px;  -fx-font-weight:bold;  -fx-font-family: \"Berlin Sans FB Demi\"; -fx-text-fill: green;");
             alert.showAndWait();}
                    
            }
        });
        
        
        replayButton.setPrefHeight(70.0);
        replayButton.setPrefWidth(200.0);
        replayButton.setEffect(shadow);       
        replayButton.setId("preferencesButtons");
 
        tableView.setTableMenuButtonVisible(true);
        tableViewPane.setId("tableViewPane");
        tableViewPane.setCenter(tableView);
         borderPane.setCenter(tableViewPane);
        getChildren().addAll(borderPane, gameId ,gameIdLabel,goBackToMainMenuButton,replayButton, questionText);
    
    }
       public Pane getRootPane(){
       return this; 
        
    }   
}
