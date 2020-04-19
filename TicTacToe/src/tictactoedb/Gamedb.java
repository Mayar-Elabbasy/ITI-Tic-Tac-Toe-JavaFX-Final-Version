/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoedb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import tictactoedb.ConnectionEstablish;

/**
 *
 * @author Amira-PC
 */
public class Gamedb  {
    PreparedStatement prs;
    ResultSet rs;
    Connection connection;
    Statement statement ;
    String query;
    private int id ;
    public String gameName;
    Movesdb md;
    String selectQuery;// to test rs each time
    // insert in table game the name of the game
    public ResultSet insertGame (){
        try{
            new ConnectionEstablish();
            connection = ConnectionEstablish.getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            //if the first time to add inthe table this will raise an error becase the set is empty
            
            selectQuery = "Select id, gameName, winner from game";//if we put this select in the constructor it will not be executed here and can check if the database is empty i think
            rs=statement.executeQuery(selectQuery);
            System.out.println(rs);
            if(rs.next()==true)
            {
                rs.afterLast(); // to increment id dynamically
                rs.previous();
                id= rs.getInt(1)+1;
            }
            else id =1;
       
            System.out.println("a new row is added");
            query= "insert into game ( id,gameName, winner)"+" values (?,?,?)";
            prs=connection.prepareStatement(query);
            prs.setInt(1, id);
            prs.setString(2, gameName);//will add the textfield content instead of the static name
            prs.setString(3,"unknown");// when we know how to get who won or lost
            prs.execute();
            //re-execute select query after insertion
            rs=statement.executeQuery(selectQuery);
            md=new Movesdb(id);
            //md.insertMove();
                
            
        }
        
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("fail to insert a row");
        }
        System.out.println(id);

        return rs;
    }
    public void insertRow (String m,int p)
    {
        md.insertMove(m,p);
    }
    
    public void updateWinner (String winner )
    {
        try{
           connection = ConnectionEstablish.getConnection();
           statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
           query="update game set winner= ? where id = ?; " ;
           prs=connection.prepareStatement(query);
           prs.setString(1,winner);// if player1 =1 if player2 =2 if draw =3
           prs.setInt(2, id);
           prs.executeUpdate();
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("fail to update winner");
        }
        
       try{
            ConnectionEstablish.closeConnection();
            System.out.println("connection closed");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("failed to close the connection");
        } 
       
    }
    
    public ResultSet retrivegame(int gid )
    {
        System.out.println("from game before r");
        md=new Movesdb(id);
        ResultSet r =md.retreiveGame(gid);
        System.out.println("from game after r");
        
        return r;
    }





    // retrive the achievemnts
    public ResultSet retriveAchievements(){
        try{
            connection = ConnectionEstablish.getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            selectQuery = "Select * from game where winner != 'unknown'";
            rs=statement.executeQuery(selectQuery);
            

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return rs;
        
    }
    
   
} 