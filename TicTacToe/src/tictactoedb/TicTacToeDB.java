/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoedb;

import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amira-PC
 */
public class TicTacToeDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Gamedb g = new Gamedb();
        g.insertGame();
        //Movesdb m= new Movesdb();
//        g.insertRow("o");
        
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TicTacToeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
//        g.insertRow("x");
       
    }
    
}
