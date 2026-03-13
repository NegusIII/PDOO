/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class GameState {
    private String labyrinth;
    private String players;
    private String monsters;
    private int currentPlayer;
    private boolean winner;
    private String log;
    
    GameState(){
        labyrinth="";
        players="";
        monsters="";
        currentPlayer=0;
        winner=false;
        log="";
    }
    
    public String getLabyrinth(){
        return labyrinth;
    }
    public String getPlayers(){
        return players;
    }
    public String getMonsters(){
        return monsters;
    }
    public int getCurrentPlayer(){
        return currentPlayer;
    }
    public boolean isWinner(){
        return winner;
    }
    public String getLog(){
        return log;
    }
}


