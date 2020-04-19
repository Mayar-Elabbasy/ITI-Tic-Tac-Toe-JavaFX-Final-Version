/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoedb;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Amira-PC
 */
public class ConnectionEstablish {
    private static String userName= "root";
    private static String password= "";
    private static String FirstCon= "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String NewdbCon= "jdbc:mysql://localhost:3306/tictactoegame?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static Connection dbConnection;
    
    Statement st ;
    String createdb , createGame, createMove;
    //creating database if not exist
    public ConnectionEstablish(){
        try {
            
            dbConnection = DriverManager.getConnection(FirstCon,userName,password);
            st= dbConnection.createStatement();
            createdb ="create database if not exists tictactoegame;";
            st.executeUpdate(createdb);
            System.out.println("after add tictactoegame ");
            System.out.println("mysql connection is closed");
            dbConnection = DriverManager.getConnection(NewdbCon,userName,password);

           
                st.execute("use tictactoegame;");
                System.out.println("use done ");
                createGame="create table if not exists game(ID int(10) primary key auto_increment , "
                        + "GameName varchar(50), "
                        + "Winner varchar(15));";
                      
                st.executeUpdate(createGame);
                System.out.println("game table is created");
                createMove="create table if not exists moves(move_id int(10) primary key auto_increment ,"
                        + "symbolXO varchar(50),"
                        + "time timestamp,"
                        + "loc int(10),"
                        + "game_id int(10),"
                        + "foreign key(game_id) references game(id));";
                st.executeUpdate(createMove);
                System.out.println("moves table is created");
                
         
            System.out.println("database created!!!!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEstablish.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("could not create");
        }
        
    }
    
    //static to be able to call it wherever
    public static Connection getConnection() throws SQLException{
        try{
            dbConnection = DriverManager.getConnection(NewdbCon,userName,password);
            System.out.println("Database Connected");
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connection Failed");
        }
        return dbConnection;
    }
    
    public static void closeConnection() throws SQLException{
        try{
            dbConnection.close();
            System.out.println("Database Closed");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
}


