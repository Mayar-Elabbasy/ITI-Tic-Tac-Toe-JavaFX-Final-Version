/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoedb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Timestamp;
import tictactoedb.ConnectionEstablish;

/**
 *
 * @author Amira-PC
 */
public class Movesdb {
    PreparedStatement prs;
    ResultSet rs;
    Connection connection;
    Statement statement ;
    String query;
    int move_id ;
    String selectQuery;// to test rs each time
    Timestamp CURRENT_TIMESTAMP;
    int gameId = 0;

    public Movesdb(int id)
    {
        gameId=id;
    }

    public Movesdb()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // insert in table move the name of the game
    public ResultSet insertMove(String m,int p){
        try{
            connection= ConnectionEstablish.getConnection();
            statement= connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            selectQuery= "select move_id, game_id, symbolXO, time, loc from moves";
            rs=statement.executeQuery(selectQuery);
            if(rs.next()==true)
            {
                rs.afterLast(); // to increment id dynamically
                rs.previous();
                move_id= rs.getInt(1)+1;
            }
            else move_id =1;
            
            System.out.println("a new row is added in moves table");
            query= "insert into moves(move_id, symbolXO, time, loc , game_id)"+" values(?,?,?,?,?)"; 
            prs=connection.prepareStatement(query);
            prs.setInt(1, move_id);
            prs.setString(2, m);//prints x or o
            prs.setTimestamp(3, CURRENT_TIMESTAMP);
            prs.setInt(4,p);// in which loc the x or o is inserted
            prs.setInt(5, gameId);
            
            
            
            prs.execute();

            rs=statement.executeQuery(selectQuery);



        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("failed to insert row");
        }
        try{
            ConnectionEstablish.closeConnection();
            System.out.println("connection closed");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("failed to close the connection");
        }
        return rs;
    }
  //  retreive certain game
    public ResultSet retreiveGame(int gId){
        try{
            System.out.println("from moves before connect");
            connection = ConnectionEstablish.getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            selectQuery = "Select game_id, symbolXO,time, loc  from moves where game_id ="+ "'"+ gId +"'";
            rs=statement.executeQuery(selectQuery);
            System.out.println("from moves after r ");
            System.out.println(rs);
            int rowCount=0;
            if (rs.last()){
                rowCount = rs.getRow()-1;
                rs.beforeFirst();
            }           
      
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("failed to retreive game");
        }
        
        return rs;
    }
    
}
