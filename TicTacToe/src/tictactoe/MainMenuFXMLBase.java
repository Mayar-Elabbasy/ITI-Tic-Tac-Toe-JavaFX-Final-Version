/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import static java.lang.Math.random;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Separator;
import javafx.scene.effect.Blend;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BURLYWOOD;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Mayar-Elabbasy
 */

public class MainMenuFXMLBase extends AnchorPane {
    
           public static boolean multi = false; /**added by Aladdin */
           public static boolean friends = false; /**added by Aladdin */
           
           private final  AnchorPane rootPane ;
           protected final AnchorPane anchorPane;
           protected final Button singlePlayerButton;
           protected final InnerShadow buttonsInnerShadow;
           protected final ColorAdjust colorAdjust;
           protected final Button multiplayerButton;
           protected final Button friendsButton;
           protected final Button achievementsButton;
           protected final Button aboutButton;
           protected final Button exitButton;   
           protected final Separator separator;
           protected final DropShadow dropShadow;
           protected final Separator separator0;
           protected final DropShadow dropShadow0;
           protected final Blend blend;
           protected final InnerShadow innerShadow4;
           protected final BorderPane borderPane;
           protected final Text ticTacToe;
           protected final ColorAdjust colorAdjust4;
           protected final Reflection reflection;
           protected final Lighting lighting;
           protected final StackPane doubleCircleStackPane;
           protected final Circle circle;
           protected final Circle circle0;
           protected final Circle circle1;
           protected final StackPane stackPane0;
           protected final Line line;
           protected final Line line0;
           protected final StackPane stackPane1;
           protected final Line line1;
           protected final Line line2;
           protected final StackPane stackPane2;
           protected final Line line3;
           protected final Line line4;
           protected final StackPane stackPane3;
           protected final Circle circle2;
           protected final Circle circle3;
           protected final StackPane stackPane4;
           protected final Circle circle4;
           protected final Circle circle5;
           protected final InnerShadow gameInnerShadow;
           protected ImageView  soundOffIcon;
           protected ImageView soundOnIcon;
           protected ImageCursor cursor;
           protected DropShadow shadow;
           protected Button  soundOffButton;
           protected Button soundOnButton;
  
           
public MainMenuFXMLBase() {
        
           rootPane=new AnchorPane();
           anchorPane = new AnchorPane();
           singlePlayerButton = new Button();
           buttonsInnerShadow = new InnerShadow();
           colorAdjust = new ColorAdjust();
           multiplayerButton = new Button();
           friendsButton=new Button();
           achievementsButton = new Button();
           aboutButton = new Button();
           exitButton = new Button();
           separator = new Separator();
           dropShadow = new DropShadow();
           separator0 = new Separator();
           dropShadow0 = new DropShadow();
           blend = new Blend();
           innerShadow4 = new InnerShadow();
           borderPane = new BorderPane();
           ticTacToe = new Text();
           colorAdjust4 = new ColorAdjust();
           reflection = new Reflection();
           lighting = new Lighting();
           doubleCircleStackPane = new StackPane();
           circle = new Circle();
           circle0 = new Circle();
           circle1 = new Circle();
           stackPane0 = new StackPane();
           line = new Line();
           line0 = new Line();
           stackPane1 = new StackPane();
           line1 = new Line();
           line2 = new Line();
           stackPane2 = new StackPane();
           line3 = new Line();
           line4 = new Line();
           stackPane3 = new StackPane();
           circle2 = new Circle();
           circle3 = new Circle();
           stackPane4 = new StackPane();
           circle4 = new Circle();
           circle5 = new Circle();
           gameInnerShadow = new InnerShadow();
           shadow = new DropShadow();
           cursor = new ImageCursor(new Image("cursor.png"));
           soundOffIcon=new ImageView("soundOffIcon.png");
           soundOnIcon=new ImageView("soundOnIcon.png");
           soundOffButton = new Button("",soundOffIcon );
           soundOnButton = new Button("",soundOnIcon );
           getStylesheets().add(TicTacToe.class.getResource("Buttons.css").toExternalForm());

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

                                                                           //=============animatedRectangle================

           final Rectangle rectPath = new Rectangle (0, 0, 60, 60);
           rectPath.setArcHeight(10);
           rectPath.setArcWidth(10);
           rectPath.setFill(Color.valueOf("BURLYWOOD"));

           Path path = new Path();
           path.getElements().add(new MoveTo(50,50));
           path.getElements().add(new CubicCurveTo(380, 0, 1000, 120, 250, 120));
           path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 400, 240));
           PathTransition pathTransition = new PathTransition();
           pathTransition.setDuration(Duration.millis(4000));
           pathTransition.setPath(path);
           pathTransition.setNode(rectPath);
           pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
           pathTransition.setCycleCount(Timeline.INDEFINITE);
           pathTransition.setAutoReverse(true);
           getChildren().addAll(rectPath );
           pathTransition.play();

                                         //======================animatedCircles=======================
            Group circles = new Group();
             for (int i = 0; i < 10; i++) {
            Circle circle = new Circle(30, Color.web("BLACK",0));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("WHITE", 1));
            circle.setStrokeWidth(10);
            circles.getChildren().add(circle);
            }

            Timeline timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            for (Node circle: circles.getChildren()) {
                        timeline.getKeyFrames().addAll(
                                 new KeyFrame(Duration.ZERO, // set start position at 0
                                 new KeyValue(circle.translateXProperty(), random() *800),
                                 new KeyValue(circle.translateYProperty(), random() *600) ),
                                 new KeyFrame(new Duration(40000), // set end position at 40s
                                 new KeyValue(circle.translateXProperty(), random() * 800),
                                 new KeyValue(circle.translateYProperty(), random() * 600))
                                  );
             }
          // play 40s of animation
            getChildren().add(circles);
           timeline.play();

            setPrefHeight(709.0);
            setPrefWidth(700.0);
            
            AnchorPane.setBottomAnchor(anchorPane, 25.0);
            AnchorPane.setLeftAnchor(anchorPane, 112.0);
            AnchorPane.setRightAnchor(anchorPane, 111.0);
            AnchorPane.setTopAnchor(anchorPane, 275.0);
            anchorPane.setLayoutX(112.0);
            anchorPane.setLayoutY(229.0);
            anchorPane.setPrefHeight(396.0);
            anchorPane.setPrefWidth(440.0);

            AnchorPane.setLeftAnchor(singlePlayerButton, 103.0);
            AnchorPane.setRightAnchor(singlePlayerButton, 90.0);
            AnchorPane.setTopAnchor(singlePlayerButton, 0.0);
            singlePlayerButton.setId("generalStyleForButtons");
            singlePlayerButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
            singlePlayerButton.setLayoutX(119.0);
            singlePlayerButton.setMnemonicParsing(false);
            singlePlayerButton.setText("SINGLE PLAYER");
            singlePlayerButton.setStyle(" -fx-background-radius: 0;") ;
            buttonsInnerShadow.setChoke(0.85);
            buttonsInnerShadow.setColor(javafx.scene.paint.Color.valueOf("TOMATO"));
            colorAdjust.setContrast(.2); 
            buttonsInnerShadow.setInput(colorAdjust);
            singlePlayerButton.setEffect(buttonsInnerShadow);

             //==========================singlePlayerButtonHandling===================
             
            singlePlayerButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                                                GamePreferencesSinglePlayer root =new GamePreferencesSinglePlayer();
                                                singlePlayerButton .getScene().setRoot(root.getRootPane());
                                                }
            });      
            singlePlayerButton.setOnMouseEntered((event) -> {
                        singlePlayerButton.setEffect(shadow);
                        singlePlayerButton.setStyle(" -fx-background-radius: 30; ")  ;
            });             
            singlePlayerButton.setOnMouseExited((event) -> {
                        singlePlayerButton.setEffect(buttonsInnerShadow);
                        singlePlayerButton.setStyle(null);
                        singlePlayerButton.setStyle(" -fx-background-radius: 0; ")  ;
            });
                        
            AnchorPane.setLeftAnchor(multiplayerButton, 103.0);
            AnchorPane.setRightAnchor(multiplayerButton, 90.0);
            multiplayerButton.setLayoutX(119.0);
            multiplayerButton.setLayoutY(80.0);
            multiplayerButton.setMnemonicParsing(false);
            multiplayerButton.setText("MULTIPLAYER");
            multiplayerButton.setStyle(" -fx-background-radius: 0; ") ;
            multiplayerButton.setId("generalStyleForButtons");
            multiplayerButton.setEffect(buttonsInnerShadow);
            
             //==========================multiplayerButtonHandling===================
           
            multiplayerButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                                    GameInformationMultiPlayer root =new GameInformationMultiPlayer();
                                    multiplayerButton.getScene().setRoot(root.getRootPane());

                                    /**added by Aladdin to enable setX for multiple scene in ClientPlayer.java-MainMenuFXMLBase.java*/
                                     System.out.println("clicked on multi");
                                      multi = true;
                                    }
             });
            multiplayerButton.setOnMouseEntered((event) -> {
                                                multiplayerButton.setEffect(shadow);
                                                multiplayerButton.setStyle(" -fx-background-radius: 30; ") ;
            });
            multiplayerButton.setOnMouseExited((event) -> {
                                                multiplayerButton.setStyle(null);
                                                multiplayerButton.setEffect(buttonsInnerShadow);
                                                multiplayerButton.setStyle(" -fx-background-radius: 0; ")  ;
             });
                        
            AnchorPane.setLeftAnchor(friendsButton, 103.0);
            AnchorPane.setRightAnchor(friendsButton, 90.0);
            friendsButton.setLayoutX(124.0);
            friendsButton.setLayoutY(161.0);
            friendsButton.setMnemonicParsing(false);
            friendsButton.setStyle(" -fx-background-radius: 0;") ;
            friendsButton.setText("FRIENDS");
            friendsButton.setId("generalStyleForButtons");
            friendsButton.setEffect(buttonsInnerShadow);
        
           //==========================friendsButtonHandling===================
           
            friendsButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                                    GamePreferencesFriends root2 =new GamePreferencesFriends();
                                    multiplayerButton.getScene().setRoot(root2.getRootPane());      
                        /**added by Aladdin to enable setX for friends scene in ClientPlayer.java-MainMenuFXMLBase.java*/
                       System.out.println("clicked on friends");
                        friends = true;
                        }
            });
            friendsButton .setOnMouseEntered((event) -> {
                                                friendsButton .setEffect(shadow);
                                                friendsButton.setStyle(" -fx-background-radius: 30; ") ;
            });
            friendsButton .setOnMouseExited((event) -> {
                                                friendsButton .setStyle(null);
                                                friendsButton.setEffect(buttonsInnerShadow);        
            });

            AnchorPane.setLeftAnchor(achievementsButton, 103.0);
            AnchorPane.setRightAnchor(achievementsButton, 90.0);
            achievementsButton.setLayoutX(120.0);
            achievementsButton.setLayoutY(242.0);
            achievementsButton.setMnemonicParsing(false);
            achievementsButton.setText("ACHIEVEMENTS");
            achievementsButton.setStyle(" -fx-background-radius: 0;") ;
            achievementsButton.setId("generalStyleForButtons");
            achievementsButton.setEffect(buttonsInnerShadow);
            
            //==========================achievementsButtonHandling===================
            
            achievementsButton.setOnAction((ActionEvent event) -> {
                        AchievementsScene root3=new AchievementsScene();
                        achievementsButton.getScene().setRoot(root3.getRootPane());              
            });
            achievementsButton .setOnMouseEntered((event) -> { 
                        achievementsButton.setEffect(shadow);
                        achievementsButton.setStyle(" -fx-background-radius: 30; ") ;
            }); 
            achievementsButton.setOnMouseExited((event) -> {
                        achievementsButton.setStyle(null);
                        achievementsButton.setEffect(buttonsInnerShadow);       
                        achievementsButton.setStyle(" -fx-background-radius: 0; ") ;
            });

            AnchorPane.setLeftAnchor(aboutButton, 103.0);
            AnchorPane.setRightAnchor(aboutButton, 90.0);
            aboutButton.setLayoutX(118.0);
            aboutButton.setLayoutY(323.0);
            aboutButton.setMnemonicParsing(false);
            aboutButton.setText("ABOUT US");
            aboutButton.setStyle(" -fx-background-radius: 0;") ;
            aboutButton.setId("generalStyleForButtons");
            aboutButton.setEffect(buttonsInnerShadow);

            //==========================aboutButtonHandling===================
        
            aboutButton.setOnAction(ActionEvent-> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("                                                                                                                                      Welcome");
                        alert.setHeaderText( "This game was made by Java Monsters :");
                        LinearGradient lg1;
                        lg1 = new LinearGradient(0, 1, 0.5, 0, true, CycleMethod.NO_CYCLE, new Stop(0f,Color.TAN), new Stop(1.5f,Color.GOLD), new Stop(0.5f,Color.WHITE), new Stop(1f,Color.PALETURQUOISE));
                        alert.getDialogPane().setBackground(new Background(new BackgroundFill(lg1, CornerRadii.EMPTY, Insets.EMPTY)));
                        alert.getDialogPane().setGraphic(new ImageView("javaMonster.jpg"));
                        alert.getDialogPane().setCursor(cursor);
                        alert.initStyle(StageStyle.UTILITY);
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setStyle("-fx-padding: 10px; -fx-font-size: 30px;  -fx-font-weight:bold;  -fx-font-family: \"Berlin Sans FB Demi\"; -fx-text-fill: green;");
                        alert.getDialogPane().setBorder(new Border(new BorderStroke(Color.TEAL, BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
   
                        alert.setContentText( "✿  Amira Abdelhalim: was responsible for game logic and Database\n"
                                + "✿ Gehad Samir: was responsible for game logic and Database\n"
                                + "✿ Mayar Yasser Elabbasy: was responsible for GUI and switching scenes\n"
                                + "✿ Muhammed Alaeldien:  was responsible for Network\n"
                                + "✿ Osama Ragab:  was responsible for game logic and Database");
                        alert.showAndWait();
            });
            aboutButton.setOnMouseEntered((event) -> {
                        aboutButton.setEffect(shadow);
                        aboutButton.setStyle(" -fx-background-radius: 30; ") ;
            });   
            aboutButton.setOnMouseExited((event) -> {
                        aboutButton.setStyle(null);
                        aboutButton.setEffect(buttonsInnerShadow);      
            });

            AnchorPane.setLeftAnchor(exitButton, 103.0);
            AnchorPane.setRightAnchor(exitButton, 90.0);
            exitButton.setLayoutX(119.0);
            exitButton.setLayoutY(404.0);
            exitButton.setMnemonicParsing(false);
            exitButton.setText("EXIT");
            exitButton.setId("generalStyleForButtons");
            exitButton.setEffect(buttonsInnerShadow);
        
           //==========================exitButtonHandling===================
        
            exitButton.setOnAction(ActionEvent-> {
                        Alert alert;
                        alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.getDialogPane().setBackground(new Background(new BackgroundFill(Color.rgb(160, 255, 230), CornerRadii.EMPTY, Insets.EMPTY)));
                        alert.getDialogPane().setGraphic(new ImageView("X.png"));
                        alert.getDialogPane().setCursor(cursor);
                        alert.initStyle(StageStyle.UNDECORATED);
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setStyle("-fx-padding: 10px;   -fx-font-size: 25px;  -fx-font-weight:bold;  -fx-font-family: \"Berlin Sans FB Demi\"; -fx-text-fill: green;");
                        alert.setTitle("Confirmation");
                        alert.setHeaderText("Are you sure you want to exit?");
                        Optional<ButtonType> result = alert.showAndWait();
                                    if (result.get() == ButtonType.OK){
                                                System.exit(0);
                                                System.out.println("You have  exited  ^_^");
                                    } else if (result.get() == ButtonType.CANCEL) {}
             });
            exitButton.setOnMouseEntered((event) -> {
                        exitButton.setEffect(shadow);
                        exitButton.setStyle(" -fx-background-radius: 30; ") ;
            });            
            exitButton.setOnMouseExited((event) -> {
                         exitButton.setStyle(null);
                         exitButton.setEffect(buttonsInnerShadow);       
            });
 
                         
            //========== I used separator only for design (act like borders to the main menu)========
            AnchorPane.setLeftAnchor(separator, 103.0);
            separator.setLayoutX(117.0);
            separator.setOrientation(javafx.geometry.Orientation.VERTICAL);
            separator.setPrefHeight(458.0);

            dropShadow.setColor(javafx.scene.paint.Color.valueOf("#1712ac"));
            dropShadow.setHeight(71.35);
            dropShadow.setRadius(35.099999999999994);
            dropShadow.setSpread(0.51);
            dropShadow.setWidth(71.05);
            separator.setEffect(dropShadow);

            AnchorPane.setRightAnchor(separator0, 86.4);
            separator0.setLayoutX(360.0);
            separator0.setOrientation(javafx.geometry.Orientation.VERTICAL);
            separator0.setPrefHeight(458.0);

            dropShadow0.setColor(javafx.scene.paint.Color.valueOf("#1712ac"));
            dropShadow0.setHeight(71.19999999999999);
            dropShadow0.setRadius(35.0625);
            dropShadow0.setSpread(0.51);
            dropShadow0.setWidth(71.05);
            separator0.setEffect(dropShadow0);

            blend.setMode(javafx.scene.effect.BlendMode.SCREEN);

            innerShadow4.setBlurType(javafx.scene.effect.BlurType.GAUSSIAN);
            innerShadow4.setChoke(1.0);

            innerShadow4.setColor(javafx.scene.paint.Color.valueOf("#13f817"));
            innerShadow4.setHeight(1.0);
            innerShadow4.setRadius(0.0);
            innerShadow4.setWidth(0.0);
            blend.setTopInput(innerShadow4);
            anchorPane.setEffect(blend);

            anchorPane.setCursor(cursor);

            AnchorPane.setLeftAnchor(borderPane, 160.0);
            AnchorPane.setRightAnchor(borderPane, 141.0);
            borderPane.setLayoutX(160.0);
            borderPane.setLayoutY(81.0);
            borderPane.setPrefHeight(134.0);
            borderPane.setPrefWidth(399.0);

            BorderPane.setAlignment(ticTacToe, javafx.geometry.Pos.CENTER);
            ticTacToe.setFontSmoothingType(javafx.scene.text.FontSmoothingType.LCD);
            ticTacToe.setStrikethrough(true);
            ticTacToe.setText("Tic Tac T0e");
            ticTacToe.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            ticTacToe.setFont(new Font("Berlin Sans FB Demi Bold", 85.0));

            colorAdjust4.setBrightness(0.4);
            colorAdjust4.setContrast(.4);
            colorAdjust4.setHue(0.50);
            colorAdjust4.setSaturation(0.40);

            reflection.setBottomOpacity(0.03);
            reflection.setFraction(0.79);
            reflection.setTopOpacity(0.39);

            lighting.setDiffuseConstant(2.0);
            lighting.setSpecularConstant(1.42);
            lighting.setSpecularExponent(31.59);
            lighting.setSurfaceScale(6.36);
            reflection.setInput(lighting);
            colorAdjust4.setInput(reflection);
            ticTacToe.setEffect(colorAdjust4);
            borderPane.setTop(ticTacToe);

            doubleCircleStackPane.setLayoutX(12.0);
            doubleCircleStackPane.setLayoutY(206.0);
            doubleCircleStackPane.setPrefHeight(150.0);
            doubleCircleStackPane.setPrefWidth(200.0);

            circle.setFill(javafx.scene.paint.Color.valueOf("#5935e800"));
            circle.setId("circle");
            circle.setRadius(54.0);
            circle.setStroke(javafx.scene.paint.Color.BLACK);
            circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            circle.setStrokeWidth(12.0);
            circle.setStyle("-fx-stroke-dash-array: 40;");

            circle0.setFill(javafx.scene.paint.Color.valueOf("#5935e800"));
            circle0.setRadius(30.0);
            circle0.setStroke(javafx.scene.paint.Color.BLACK);
            circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            circle0.setStrokeWidth(10.0);
            circle0.setStyle("-fx-stroke-dash-array: 30;");
            circle0.setId("circle0");

            circle1.setFill(javafx.scene.paint.Color.valueOf("#5935e800"));
            circle1.setLayoutX(110.0);
            circle1.setLayoutY(86.0);
            circle1.setRadius(54.0);
            circle1.setStroke(javafx.scene.paint.Color.valueOf("#1712ac"));
            circle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            circle1.setStrokeWidth(12.0);
            circle1.setStyle("-fx-stroke-dash-array: 40;");

            AnchorPane.setLeftAnchor(stackPane0, 526.0);
            AnchorPane.setRightAnchor(stackPane0, 14.0);
            AnchorPane.setTopAnchor(stackPane0, 260.0);

            stackPane0.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
            stackPane0.setLayoutX(541.0);
            stackPane0.setLayoutY(293.0);
            stackPane0.setPrefHeight(88.0);
            stackPane0.setPrefWidth(123.0);

            line.setEndX(10.0);
            line.setEndY(10.0);
            line.setFill(javafx.scene.paint.Color.valueOf("#3d27ab"));
            line.setRotate(-57.1);
            line.setStartX(-100.0);
            line.setStroke(javafx.scene.paint.Color.valueOf("#3d27ab"));
            line.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
            line.setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin.BEVEL);
            line.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            line.setStrokeWidth(10.0);

            line0.setEndX(10.0);
            line0.setEndY(10.0);
            line0.setFill(javafx.scene.paint.Color.valueOf("#3d27ab"));
            line0.setLayoutX(170.0);
            line0.setLayoutY(20.0);
            line0.setRotate(-143.7);
            line0.setStartX(-100.0);
            line0.setStroke(javafx.scene.paint.Color.valueOf("#3d27ab"));
            line0.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
            line0.setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin.BEVEL);
            line0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            line0.setStrokeWidth(10.0);

            AnchorPane.setRightAnchor(stackPane1, 28.600000000000023);

            stackPane1.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
            stackPane1.setLayoutX(541.0);
            stackPane1.setLayoutY(583.0);
            stackPane1.setPrefHeight(88.0);
            stackPane1.setPrefWidth(123.0);

            line1.setEndX(10.0);
            line1.setEndY(10.0);
            line1.setFill(javafx.scene.paint.Color.valueOf("#de83c600"));
            line1.setLayoutX(170.0);
            line1.setLayoutY(20.0);
            line1.setRotate(-143.7);
            line1.setStartX(-90.0);
            line1.setStroke(javafx.scene.paint.Color.valueOf("#3d27ab"));
            line1.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
            line1.setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin.BEVEL);
            line1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            line1.setStrokeWidth(10.0);

            line2.setEndX(10.0);
            line2.setEndY(10.0);
            line2.setFill(javafx.scene.paint.Color.valueOf("#de83c600"));
            line2.setRotate(-59.0);
            line2.setStartX(-100.0);
            line2.setStroke(javafx.scene.paint.Color.valueOf("#3d27ab"));
            line2.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
            line2.setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin.BEVEL);
            line2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            line2.setStrokeWidth(10.0);

            AnchorPane.setLeftAnchor(stackPane2, 50.0);
            stackPane2.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
            stackPane2.setLayoutX(34.0);
            stackPane2.setLayoutY(433.0);
            stackPane2.setPrefHeight(50.0);
            stackPane2.setPrefWidth(123.0);

            line3.setEndX(10.0);
            line3.setEndY(10.0);
            line3.setFill(javafx.scene.paint.Color.valueOf("#de83c600"));
            line3.setLayoutX(170.0);
            line3.setLayoutY(20.0);
            line3.setRotate(-143.7);
            line3.setStartX(-90.0);
            line3.setStroke(javafx.scene.paint.Color.valueOf("#3d27ab"));
            line3.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
            line3.setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin.BEVEL);
            line3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            line3.setStrokeWidth(10.0);

            line4.setEndX(10.0);
            line4.setEndY(10.0);
            line4.setFill(javafx.scene.paint.Color.valueOf("#de83c600"));
            line4.setRotate(-59.0);
            line4.setStartX(-100.0);
            line4.setStroke(javafx.scene.paint.Color.valueOf("#3d27ab"));
            line4.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
            line4.setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin.BEVEL);
            line4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            line4.setStrokeWidth(10.0);

            stackPane3.setLayoutX(-1.0);
            stackPane3.setLayoutY(528.0);
            stackPane3.setPrefHeight(150.0);
            stackPane3.setPrefWidth(200.0);

            circle2.setFill(javafx.scene.paint.Color.valueOf("#5935e800"));
            circle2.setRadius(54.0);
            circle2.setStroke(javafx.scene.paint.Color.valueOf("#1712ac"));
            circle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            circle2.setStrokeWidth(12.0);
            circle2.setStyle("-fx-stroke-dash-array: 40;");

            circle3.setFill(javafx.scene.paint.Color.valueOf("#91ffd900"));
            circle3.setRadius(30.0);
            circle3.setStroke(javafx.scene.paint.Color.valueOf("BLACK"));
            circle3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            circle3.setStrokeWidth(10.0);
            circle3.setStyle("-fx-stroke-dash-array: 30;");

            AnchorPane.setRightAnchor(stackPane4, -6.0);
            AnchorPane.setTopAnchor(stackPane4, 350.0);
            stackPane4.setLayoutX(506.0);
            stackPane4.setLayoutY(410.0);
            stackPane4.setPrefHeight(150.0);
            stackPane4.setPrefWidth(200.0);

            circle4.setFill(javafx.scene.paint.Color.valueOf("#5935e800"));
            circle4.setRadius(54.0);
            circle4.setStroke(javafx.scene.paint.Color.valueOf("#1712ac"));
            circle4.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            circle4.setStrokeWidth(12.0);
            circle4.setStyle("-fx-stroke-dash-array: 40;");

            circle5.setFill(javafx.scene.paint.Color.valueOf("#91ffd900"));
            circle5.setRadius(30.0);
            circle5.setStroke(javafx.scene.paint.Color.valueOf("BLACK"));
            circle5.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            circle5.setStrokeWidth(10.0);
            circle5.setStyle("-fx-stroke-dash-array: 30;");

            gameInnerShadow.setBlurType(javafx.scene.effect.BlurType.GAUSSIAN);
            gameInnerShadow.setChoke(0.25);
            gameInnerShadow.setColor(javafx.scene.paint.Color.valueOf("PALETURQUOISE"));
            gameInnerShadow.setHeight(85.43);
            gameInnerShadow.setRadius(42.1575);
            gameInnerShadow.setWidth(85.2);
            setEffect(gameInnerShadow);

            soundOffButton .setTranslateY(700);
            soundOffButton.setTranslateX(30);
            soundOffButton.setPrefHeight(30.0);
            soundOffButton.setPrefWidth(20.0);
            soundOffButton.setEffect(shadow);
            soundOffButton.setId("sound");
            AudioClip music =new AudioClip(this.getClass().getResource("Music.mp3").toString());
            music.play();
            soundOffButton.setOnAction(ActionEvent-> {
                        music.stop();
            });

            soundOnButton .setTranslateY(700);
            soundOnButton.setTranslateX(120);
            soundOnButton.setPrefHeight(30.0);
            soundOnButton.setPrefWidth(20.0);
            soundOnButton.setEffect(shadow);
            soundOnButton.setId("sound");
            soundOnButton.setOnAction(ActionEvent-> {
                        music.play();
            });

            anchorPane.getChildren().addAll(singlePlayerButton, multiplayerButton, friendsButton, achievementsButton, aboutButton, exitButton, separator, separator0);
            getChildren().addAll(anchorPane, borderPane, doubleCircleStackPane, stackPane0, stackPane1, stackPane2, stackPane3, stackPane4, soundOffButton, soundOnButton);
            doubleCircleStackPane.getChildren().addAll(circle, circle0, circle1);
            stackPane0.getChildren().addAll(line, line0);
            stackPane1.getChildren().addAll(line1, line2);
            stackPane2.getChildren().addAll(line3, line4);
            stackPane3.getChildren().addAll(circle2, circle3);
            stackPane4.getChildren().addAll(circle4, circle5);
            }
    
            public Pane getRootPane(){
                   return this; 

            } 
}
