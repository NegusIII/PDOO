package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Game {
    
    private final int MAX_ROUNDS=10;
    
    
    private String log;
    
    private Labyrinth labyrinth;
    private ArrayList<Monster> monsters;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    // Métodos públicos de la clase Game
    
    Game(int nplayers){
        
    }
    
    public boolean finished(){
        
    }
    
    public boolean nextStep(Directions preferredDirection){
        
    }
    
    public GameState getGameState(){
        
    }
    
    //Métodos privados de la clase Game
    
    private void configureLabyrinth(){
        
    }
    
    private void nextPlayer(){
        
    }
    
    private Directions actualDirection(Directions preferredDirection){
        
    }
    
    private GameCharacter combat(Monster monster){
        
    }
    
    private void manageReward(GameCharacter winner){
        
    }
    
    private void manageResurrection(){
        
    }
    
    private void logPlayerWon(){
        
    }
    
    private void logMonsterWon(){
        
    }
    
    private void logResurrected(){
        
    }
    
    private void logPlayerSkipTurn(){
        
    }
    
    private void logPlayerNoOrders(){
        
    }
    
    private void logNoMonster(){
        
    }
    
    private void logRounds(int rounds, int max){
        
    }
    
}