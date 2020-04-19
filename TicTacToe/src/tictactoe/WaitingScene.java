/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.animation.RotateTransition;
import javafx.scene.ImageCursor;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BURLYWOOD;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Mayar-Elabbasy
 */

public  class WaitingScene extends AnchorPane {
    
    private    AnchorPane rootPane ;
    protected  InnerShadow innerShadow;
    protected   Label player1;
    protected   Label player2;
    protected   ImageView xPlayerImage;
    protected   ImageView oPlayerImage;
    protected final Text WaitingStatement;
    protected final Text challengeStatement;
    protected final ColorAdjust colorAdjust4; 
    protected final Lighting lighting;
    protected ImageCursor cursor;
    protected  AudioClip music3 ;
    
  
 

    public WaitingScene() {
        rootPane=new AnchorPane();
        innerShadow = new InnerShadow();
        WaitingStatement = new Text();
        challengeStatement= new Text();
        colorAdjust4 = new ColorAdjust();
        lighting = new Lighting();
        cursor = new ImageCursor(new Image("cursor.png"));
        music3 =new AudioClip(this.getClass().getResource("Music.mp3").toString());
        music3.stop();
       
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


        innerShadow.setChoke(0.25);
        innerShadow.setColor(javafx.scene.paint.Color.valueOf("PALETURQUOISE"));
        innerShadow.setHeight(85.32);
        innerShadow.setRadius(42.129999999999995);
        innerShadow.setWidth(85.2);
        setEffect(innerShadow);
       
         oPlayerImage=new ImageView("oRotate.png");
         xPlayerImage=new ImageView("xRotate.png");
  
        colorAdjust4.setBrightness(0.4);
        colorAdjust4.setContrast(.4);
        colorAdjust4.setHue(0.50);
        colorAdjust4.setSaturation(0.40);
        lighting.setDiffuseConstant(2.0);
        lighting.setSpecularConstant(1.42);
        lighting.setSpecularExponent(31.59);
        lighting.setSurfaceScale(6.36);
       
       RotateTransition rt=new RotateTransition(Duration.seconds(2),oPlayerImage);
       rt.setByAngle(360);
     
       rt.setCycleCount(RotateTransition.INDEFINITE);
       rt.play();
      
       RotateTransition rt2=new RotateTransition(Duration.seconds(1),xPlayerImage);
       rt2.setByAngle(-360);
   
       rt2.setCycleCount(RotateTransition.INDEFINITE);
       rt2.play();
       
        // 130\122
         
         oPlayerImage .setTranslateY(210);
         oPlayerImage.setTranslateX(100);
         
         xPlayerImage .setTranslateY(338);
         xPlayerImage.setTranslateX(222);
         
         WaitingStatement.setFontSmoothingType(javafx.scene.text.FontSmoothingType.LCD);
         WaitingStatement.setStrokeWidth(3);
         WaitingStatement.setStroke(javafx.scene.paint.Color.valueOf("Tan"));
         WaitingStatement.setText("JUST A FEW SECONDS");
         WaitingStatement.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
         WaitingStatement.setFont(new Font("Berlin Sans FB Demi Bold", 68.0));
         WaitingStatement .setTranslateY(140);
         WaitingStatement.setTranslateX(30);
         WaitingStatement.setFill(Color.web("BLUE"));
         WaitingStatement.setEffect(lighting);
       
        challengeStatement.setText("GET READY FOR THE CHALLENGE!");
        challengeStatement.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        challengeStatement.setFont(new Font("Berlin Sans FB Demi Bold", 35.0));
        challengeStatement.setTranslateY(180);
        challengeStatement.setTranslateX(70);
        challengeStatement.setFill(Color.web("BROWN"));
        challengeStatement.setStrokeWidth(2);
         setCursor(cursor);


            getChildren().addAll(oPlayerImage, xPlayerImage);
            getChildren().addAll(WaitingStatement,challengeStatement);
       


    }
    public Pane getRootPane(){
       return this; 
        
    }
}



    
