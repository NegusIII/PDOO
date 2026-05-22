/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package irrgarten.main;
import irrgarten.Game;
import irrgarten.UI.TextUI;
import irrgarten.UI.GraphicUI;
import irrgarten.controller.Controller;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Main {

    public static void main(String[] args) {
        
        int nPlayers=8;
        
        Game game = new Game(nPlayers);
        GraphicUI view = new GraphicUI();
        Controller controller = new Controller(game,view);
        
        controller.play();
    }
    
}
