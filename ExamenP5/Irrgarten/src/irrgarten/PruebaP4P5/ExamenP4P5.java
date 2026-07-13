/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.PruebaP4P5;

import irrgarten.Game;
import irrgarten.UI.GraphicUI;
import irrgarten.controller.Controller;

/**
 *
 * @author sergiosalgil
 */
public class ExamenP4P5 {
        public static void main(String[] args) {
        
        int nPlayers=2;
        
        Game game = new Game(nPlayers);
        GraphicUI view = new GraphicUI();
        Controller controller = new Controller(game,view);
        
        controller.play();
    }
}
