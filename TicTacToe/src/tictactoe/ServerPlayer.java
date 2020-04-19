package tictactoe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import javafx.application.Platform;

/**
 *
 * @author muhammad Aladdin
 */
 
 
public class ServerPlayer {
    ServerSocket playerOne;
    Socket s; 
    static BufferedReader input;
    static PrintStream output;
    
    MultiPlayerScene multiGame;
    FriendsScene frGame;
    MainMenuFXMLBase base = new MainMenuFXMLBase();


    
    public ServerPlayer(MultiPlayerScene game){
        this.multiGame = game;
        try{
            System.out.println("arrived to serverplayer");
            playerOne = new ServerSocket(9427);
            //ClientPlayer c = new ClientPlayer();
            //c.connected = true;
            //waits for incoming requests and accepts it
            //System.out.println("isConnected: "+ s.isConnected());
//            int i =0;
//            while(i<1){
//                Platform.runLater(()->{
//                    WaitingScene w = new WaitingScene();
//                }); 
//            }
            s = playerOne.accept();
            //input = new DataInputStream(s.getInputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            output = new PrintStream(s.getOutputStream());
            System.out.println("server Connected");  
            game.serverOnline = true;
            comingBtn thr = new comingBtn(multiGame); //start thread from innerclass
            thr.start();
        }
        catch(IOException ioex){
            System.out.println("can't create server");
        }
    }
    
    public ServerPlayer(FriendsScene game){
        this.frGame = game;
        try{
            System.out.println("arrived to serverplayer");
            playerOne = new ServerSocket(9427);
            System.out.println(playerOne.getInetAddress().getAddress());
            System.out.println(playerOne.getLocalPort());
            System.out.println("server created");
            //ClientPlayer c = new ClientPlayer();
            //c.connected = true;
            //waits for incoming requests and accepts it
            s = playerOne.accept();
            //input = new DataInputStream(s.getInputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            output = new PrintStream(s.getOutputStream());
            System.out.println("server Connected");  
            game.serverOnline = true;
            comingBtn thr = new comingBtn(frGame); //start thread from innerclass
            thr.start();
        }
        catch(IOException ioex){
            System.out.println("can't create server");
        }
    }

    
    
    class comingBtn extends Thread{
        MultiPlayerScene multiGame;
        FriendsScene frGame;
        public comingBtn(MultiPlayerScene game) {
            this.multiGame = game;
        }
        public comingBtn(FriendsScene game) {
            this.frGame = game;
        }
        @Override
        public void run(){
            //int i =0;
           // sendXBtnLoc(4);
            System.out.println("out while of run in server");
            while(true){
                    //System.out.println("in while of run in server");
                   // System.out.println("xturn of server is: "+ GameFXMLBase.xturn);
                        if(!MultiPlayerScene.xturn || !FriendsScene.xturn){
                            System.out.println("run while true");
                            System.out.println("before getO");
                            int O = getOBtnLoc();
                            System.out.println(O);
                            System.out.println("base.multi: "+ base.multi);
                                System.out.println("base.friends: "+ base.friends);
                            Platform.runLater( () -> {
                            if(O<9){
                                if(base.multi){
                                    System.out.println("in base.multi server");
                                    multiGame.setO(multiGame.b[O], O);
                                    MultiPlayerScene.xturn = true;
                                }
                                if(base.friends){
                                    System.out.println("in base.friends server");
                                    frGame.setO(frGame.b[O], O);
                                    FriendsScene.xturn = true;
                                }
                            }      
                            });
                            System.out.println("inside if of getO");
                            if(O==10 || MultiPlayerScene.exitOk){
                                try{
                                    System.out.println("server is closing");
                                   // multiGame.serverOnline = false;
                                   // frGame.serverOnline = false;
                                    input.close();
                                    output.close();
                                    playerOne.close();
                                    s.close();
                                    break;
                                 
                                }
                                catch(IOException ex){System.out.println("in run");}
                            }
                        } 
            }
        }
    }
    
    //in case of O turn, get the button he clicked through input stream
    
    public static int getOBtnLoc(){ 
        int btnLoc = 10;
        System.out.println("in getOBtnLoc()");
        //if(!turnX){
            try{
                String btn = input.readLine();
                
                if(btn != null){
                    btnLoc = Integer.parseInt(btn);
                    System.out.println("msg recieved");
		    System.out.println("get O btn loc "+ btnLoc);
                   // turnX = true;
                }
            }
            catch(IOException ex){System.out.println("in parseInt");}
       // }   
        return btnLoc;
    }
    //to send button X clicked through output stream
    public static boolean sendXBtnLoc(int btnLoc){
        boolean success = false;
       // if(turnX){
            output.println(btnLoc);
            System.out.println("send x btn loc "+btnLoc);
        //    turnX = false;
            success = true;
       // }
        return success;
    }
}

