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
    
    GameState(String laberinto, String jugadores, String monstruos, int actual,
            boolean ganador, String registro){
        labyrinth=laberinto;
        players=jugadores;
        monsters=monstruos;
        currentPlayer=actual;
        winner=ganador;
        log=registro;
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


