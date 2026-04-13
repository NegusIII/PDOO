package irrgarten.UI;

import irrgarten.Directions;
import irrgarten.GameState;
import java.util.Scanner;


public class TextUI {
    
    private static Scanner in = new Scanner(System.in);
    
    private char readChar() {
        String s = in.nextLine();     
        return s.charAt(0);
    }
    

    public Directions nextMove() {
        System.out.print("Where? ");
        
        Directions direction = Directions.DOWN;
        boolean gotInput = false;
        
        while (!gotInput) {
            char c = readChar();
            switch(c) {
                case 'w':
                    System.out.print(" UP\n");
                    direction = Directions.UP;
                    gotInput = true;
                    break;
                case 's':
                    System.out.print(" DOWN\n");
                    direction = Directions.DOWN;
                    gotInput = true;
                    break;
                case 'd':
                    System.out.print("RIGHT\n");
                    direction = Directions.RIGHT;
                    gotInput = true;
                    break;
                case 'a':
                    System.out.print(" LEFT\n");
                    direction = Directions.LEFT;
                    gotInput = true;    
                    break;
            }
        }    
        return direction;
    }
    
    public void showGame(GameState gameState) {  
        String game="Game:\n";
        game+=gameState.getLabyrinth()+"\n";
        game+="Current Player:" + gameState.getCurrentPlayer() + "\n";
        game+="Players:\n";
        game+=gameState.getPlayers()+"\n";
        game+="Monsters:\n";
        game+=gameState.getMonsters()+"\n";
        game+="Log:";
        game+=gameState.getLog()+"\n";
        
        if (gameState.isWinner()){
            game+="Game has finished";
        }
        
        System.out.println(game);
    }
    
}