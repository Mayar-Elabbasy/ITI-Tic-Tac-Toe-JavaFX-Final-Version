///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package tictactoe;
//
//import java.io.IOException;
//import java.io.PrintStream;
//import java.net.InetAddress;
//import java.net.Socket;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.NetworkInterface;
//import java.net.SocketException;
//import java.net.UnknownHostException;
//import java.util.ArrayList;
//import java.util.Enumeration;
//import javafx.application.Platform;
// 
//
///**
// *
// * @author muhammad Aladdin
// */
// 
// 
//public class ClientPlayer {
//    Socket playerTwo; 
//    //DataInputStream input;
//    static BufferedReader input;
//    static PrintStream output;
//    InetAddress ipConnect;
//    //static IP ipNetwork = new IP();
//    
//    
//    //boolean turnX = false; //instead of xturn used in GameFXMLBase.java
//    //public  volatile boolean connected = true;
//    
//    MultiPlayerScene multiGame;
//    FriendsScene frGame;
//        
//    public ClientPlayer(MultiPlayerScene game){
//        this.multiGame = game;
//        try{
//            System.out.println("client is her");
//            playerTwo = new Socket( InetAddress.getLocalHost(),9427);
//            input = new BufferedReader(new InputStreamReader(playerTwo.getInputStream()));
//            output = new PrintStream(playerTwo.getOutputStream());
//            comingBtn th = new comingBtn(multiGame); //start thread from innerclass
//            th.start();
//            //connected = true; 
//            
//            System.out.println("Connected");
//         }
//            catch(IOException ioex){ioex.printStackTrace();}
//            try {
//              // input.close();
//                // output.close();
//              // playerTwo.close();
//            }
//            catch(Exception ex){ex.printStackTrace();}
//        
//    }
//    
//    public ClientPlayer(FriendsScene game){
//        this.frGame = game;
//        
//            System.out.println("client is her"); 
//            //for(int i =1;i<255;i++){
//               // if(connect(i)){
//               //   InetAddress ip = ipConnect;
//                try{
//                     playerTwo = new Socket("172.16.3.73",9427); //should IP generated 
//                     //System.out.println("ip is: " + InetAddress.getLocalHost());
//                     input = new BufferedReader(new InputStreamReader(playerTwo.getInputStream()));
//                        output = new PrintStream(playerTwo.getOutputStream());
//                     comingBtn th = new comingBtn(frGame); //start thread from innerclass
//                    th.start();            
//                    System.out.println("Connected");
//                }
//                catch(IOException ioex){ioex.printStackTrace();}
//               // }
//            
//         //}
//    }
//        
//    class comingBtn extends Thread{
//        FriendsScene frGame;
//        MultiPlayerScene multiGame;
//        
//        public comingBtn(MultiPlayerScene game) {
//            this.multiGame = game;
//        }
//        
//        public comingBtn(FriendsScene game) {
//            this.frGame = game;
//        }
//        
//        @Override
//        public void run(){
//           //sendOBtnLoc(7);
//           System.out.println("out while of run in client");
//           while(true){
//               //System.out.println("in while of run in client");
//               //System.out.println("xturn of client is: "+ GameFXMLBase.xturn);
//                     if(MultiPlayerScene.xturn || FriendsScene.xturn){
//                         
//			System.out.println("run while true");
//			System.out.println("before getX");
//			
//                        int x = getXBtnLoc();  //should return this value to scene or call function setX here. 
//			System.out.println("x is in " + x);
//                        Platform.runLater( () -> {
//                            if(x <9){
//                                System.out.println("should go to setX with " + x);
//                                System.out.println("base.multi: " + MainMenuFXMLBase.multi);
//                                System.out.println("base.friends: " + MainMenuFXMLBase.friends);
//                                
//                                if(MainMenuFXMLBase.multi){
//                                    System.out.println("in base.multi client");
//                                    multiGame.setX(multiGame.b[x], x);
//                                    MultiPlayerScene.xturn = false;
//                                }
//                                if(MainMenuFXMLBase.friends) {
//                                    System.out.println("in base.friends client");
//                                    frGame.setX(frGame.b[x],x);
//                                    FriendsScene.xturn = false;
//                                }
//                            } 
//                        });
//                            
//                        if(x==10 || MultiPlayerScene.exitOk ){
//                          try{
//                            System.out.println("server is closed");
//                            input.close();
//                            output.close();
//                            playerTwo.close();
//                            break;
//                          }
//                          catch(Exception ex){System.out.println("catch of close in client");}
//                        }
//                    }		
//          }
//        }
//    }
//    
//    
//    //in case of X turn, get the button he clicked through input stream
//    public static int getXBtnLoc(){ 
//        int btnLoc = 10;
//            System.out.println("in getXBtnLoc()");
//     
//            try{
//                String btn = input.readLine();
//		System.out.println(btnLoc);
//                if(btn != null){
//                    btnLoc = Integer.parseInt(btn);
//		    System.out.println("msg recieved");
//		    System.out.println("get X btn loc " +btnLoc);
//                    //turnX = true;
//                }
//                //game.setX(game.b[btnLoc],btnLoc);
//            }
//            catch(Exception ex){System.out.println("exception of getXbBtnLoc");}  
//        return btnLoc;
//    }
//    //to send button X clicked through output stream
//    public static boolean sendOBtnLoc(int btnLoc){
//        boolean success = false;
//       // if(turnX){
//            output.println(btnLoc);
//            System.out.println("send O btn loc"+btnLoc);
//       //     turnX = false;
//            success = true;
//       // }
//        return success;
//    } 
//    
//    public boolean connect(int i)
//    {   
//            byte[] ip = null;
//	    try {
//                ip = InetAddress.getLocalHost().getAddress();
//		System.out.println("myIp: "+InetAddress.getByAddress(ip).toString());
//	    } catch (Exception e) {
//                 System.out.println("error in getting my ip address");                           
//	    }
//            try {
//                ip[3] = (byte)i;
//                InetAddress address = InetAddress.getByAddress(ip);
//                String ipString = address.toString().substring(1);
//                System.out.println("isReachable = " + address.isReachable(200));
//                if (address.isReachable(200)) {
//                    ipConnect=address;
//                    System.out.println("ping successed at ip: " + ipString);
//                    return true;
//                } 
//            } 
//            catch (IOException e) {
//                    System.out.println("there is no server to be connected to");
//              }             
//            return false;
//    }
//}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import javafx.application.Platform;
 

/**
 *
 * @author muhammad Aladdin
 */
 
 
public class ClientPlayer {
    Socket playerTwo; 
    //DataInputStream input;
    static BufferedReader input;
    static PrintStream output;
    InetAddress ipConnect;
    //static IP ipNetwork = new IP();
    
    
    //boolean turnX = false; //instead of xturn used in GameFXMLBase.java
    //public  volatile boolean connected = true;
    
    MultiPlayerScene multiGame;
    FriendsScene frGame;
        
    public ClientPlayer(MultiPlayerScene game){
        this.multiGame = game;
        try{
            System.out.println("client is her");
            playerTwo = new Socket(InetAddress.getLocalHost(),9427);
            input = new BufferedReader(new InputStreamReader(playerTwo.getInputStream()));
            output = new PrintStream(playerTwo.getOutputStream());
            comingBtn th = new comingBtn(multiGame); //start thread from innerclass
            th.start();
            //connected = true; 
            
            System.out.println("Connected");
         }
            catch(IOException ioex){ioex.printStackTrace();}
    }
    
    public ClientPlayer(FriendsScene game){
        this.frGame = game;
        
            System.out.println("client is hereeeee"); 
            for(int i = 70;i<255;i++){
                System.out.println("in for loop");
                if(connect(i)){
                 InetAddress ip = ipConnect;
                 try{
                    System.out.println("client's try");
                     playerTwo = new Socket(ip,9427); //should IP generated 
                     System.out.println("ip is: " + ip);
                     input = new BufferedReader(new InputStreamReader(playerTwo.getInputStream()));
                     output = new PrintStream(playerTwo.getOutputStream());
                     comingBtn th = new comingBtn(frGame); //start thread from innerclass
                     th.start();            
                     System.out.println("Connected");
                     break;
                }
                catch(IOException ioex){System.out.println("catch of ClientPlayer friends");}
               }
            
         }
    }
        
    class comingBtn extends Thread{
        FriendsScene frGame;
        MultiPlayerScene multiGame;
        
        public comingBtn(MultiPlayerScene game) {
            this.multiGame = game;
        }
        
        public comingBtn(FriendsScene game) {
            this.frGame = game;
        }
        
        @Override
        public void run(){
           //sendOBtnLoc(7);
           System.out.println("out while of run in client");
           while(true){
               //System.out.println("in while of run in client");
               //System.out.println("xturn of client is: "+ GameFXMLBase.xturn);
                     if(MultiPlayerScene.xturn || FriendsScene.xturn){
                         
			System.out.println("run while true");
			System.out.println("before getX");
			
                        int x = getXBtnLoc();  //should return this value to scene or call function setX here. 
			System.out.println("x is in " + x);
                        Platform.runLater( () -> {
                            if(x <9){
                                System.out.println("should go to setX with " + x);
                                System.out.println("base.multi: " + MainMenuFXMLBase.multi);
                                System.out.println("base.friends: " + MainMenuFXMLBase.friends);
                                
                                if(MainMenuFXMLBase.multi){
                                    System.out.println("in base.multi client");
                                    multiGame.setX(multiGame.b[x], x);
                                    MultiPlayerScene.xturn = false;
                                }
                                if(MainMenuFXMLBase.friends) {
                                    System.out.println("in base.friends client");
                                    frGame.setX(frGame.b[x],x);
                                    FriendsScene.xturn = false;
                                }
                            } 
                        });
                            
                        if(x==10 || MultiPlayerScene.exitOk ){
                          try{
                            System.out.println("client is closed");
                            input.close();
                            output.close();
                            playerTwo.close();
                            break;
                          }
                          catch(Exception ex){System.out.println("catch of close in client");}
                        }
                    }		
          }
        }
    }
    
    
    //in case of X turn, get the button he clicked through input stream
    public static int getXBtnLoc(){ 
        int btnLoc = 10;
            System.out.println("in getXBtnLoc()");
     
            try{
                String btn = input.readLine();
		System.out.println(btnLoc);
                if(btn != null){
                    btnLoc = Integer.parseInt(btn);
		    System.out.println("msg recieved");
		    System.out.println("get X btn loc " +btnLoc);
                    //turnX = true;
                }
                //game.setX(game.b[btnLoc],btnLoc);
            }
            catch(Exception ex){System.out.println("exception of getXbBtnLoc");}  
        return btnLoc;
    }
    //to send button X clicked through output stream
    public static boolean sendOBtnLoc(int btnLoc){
        boolean success = false;
       // if(turnX){
            output.println(btnLoc);
            System.out.println("send O btn loc"+btnLoc);
       //     turnX = false;
            success = true;
       // }
        return success;
    } 
    
    public boolean connect(int i)
    {   
            byte[] ip = null;
	    try {
                ip = InetAddress.getLocalHost().getAddress();
		System.out.println("myIp: " + InetAddress.getByAddress(ip).toString());
	    } catch (Exception e) {
                 System.out.println("error in getting my ip address");                           
	    }
            try {
                ip[3] = (byte)i;
                InetAddress address = InetAddress.getByAddress(ip);
                String ipString = address.toString().substring(1);
                System.out.println("ip in network" + ipString);
                System.out.println("isReachable = " + address.isReachable(100));
                if (address.isReachable(100)) {
                    ipConnect=address;
                    System.out.println("ping successed at ip: " + ipString);
                    return true;
                } 
            } 
            catch (IOException e) {
                    System.out.println("there is no server to be connected to");
              }             
            return false;
    }

}

