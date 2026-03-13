/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class TestP1 {
    
    public static void main() {
        
        GameState estado = new GameState("Namibia", "a", "", 0, false, "");
        
        System.out.println("Labyrinth: " + estado.getLabyrinth());
        System.out.println("Players: " + estado.getPlayers());
        System.out.println("Monsters: " + estado.getMonsters());
        System.out.println("Current Player: " + estado.getCurrentPlayer());
        System.out.println("Winner? " + estado.isWinner());
        System.out.println("Log: " + estado.getLog());
        
        
    }
}
