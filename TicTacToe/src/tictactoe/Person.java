/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import javafx.beans.property.SimpleStringProperty;


    public class Person {
 
       SimpleStringProperty idGame;
        SimpleStringProperty Gamename;
         SimpleStringProperty winner;
 
         Person(String idGame, String Gamename, String winner) {
            this.idGame = new SimpleStringProperty(idGame);
            this.Gamename = new SimpleStringProperty(Gamename);
            this.winner = new SimpleStringProperty(winner);
        }
 
        public String getFirstName() {
            return idGame.get();
        }
 
        public void setFirstName(String fName) {
            idGame.set(fName);
        }
 
        public String getLastName() {
            return Gamename.get();
        }
 
        public void setLastName(String fName) {
            Gamename.set(fName);
        }
 
        public String getEmail() {
            return winner.get();
        }
 
        public void setEmail(String fName) {
            winner.set(fName);
        }
    }
