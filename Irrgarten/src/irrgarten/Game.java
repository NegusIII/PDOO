package irrgarten;
import java.util.ArrayList;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Game {
    
    private final int MAX_ROUNDS=10;
    private int currentPlayerIndex;
    
    
    private String log;
    
    private Labyrinth labyrinth;
    private ArrayList<Monster> monsters;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    // Métodos públicos de la clase Game
    
    Game(int nplayers){
        
        // Generar los jugadores
        
        this.players = new ArrayList<>();
        Dice dado = new Dice();
        for (int i = 0; i < nplayers; i++){
            Player actual = new Player((char)(i+'0'),dado.randomIntelligence(), dado.randomStrength());
            players.add(actual);
        }
        
        // Decidir quién empieza
        currentPlayerIndex=dado.whoStarts(nplayers);
        currentPlayer=players.get(currentPlayerIndex);
        
        monsters = new ArrayList();
        labyrinth = new Labyrinth(4,4,2,3);
        
        log="";
        
        //configureLabyrinth();
        //labyrinth.spreadPlayers(players);
        
    }
    
    public boolean finished(){
        return labyrinth.haveAWinner();
    }
    
    public boolean nextStep(Directions preferredDirection){
        throw new UnsupportedOperationException();
    }
    
    public GameState getGameState(){
        GameState estado = new GameState(labyrinth.toString(), players.toString(), 
        monsters.toString(), currentPlayerIndex, this.finished(), log);
        return estado;
    }
    //Métodos privados de la clase Game
    
    private void configureLabyrinth(){
        Dice dado = new Dice();
        Monster monstruo1= new Monster("Netanyahu", dado.randomIntelligence(), dado.randomStrength());
        Monster monstruo2= new Monster("Bin Laden", dado.randomIntelligence(), dado.randomStrength());
        Monster monstruo3= new Monster("Khamenei", dado.randomIntelligence(), dado.randomStrength());
        
        labyrinth.addMonster(3,3,monstruo1);
        labyrinth.addMonster(3,1,monstruo2);
        labyrinth.addMonster(3,0,monstruo3);
        
        //Falta colocar bloques de obstáculos
        
    }
    
    private void nextPlayer(){
        if (currentPlayerIndex==players.size()-1){
            currentPlayerIndex=0;
        }
       
        else  currentPlayerIndex++;
        
        currentPlayer = players.get(currentPlayerIndex);
    }
    
    private Directions actualDirection(Directions preferredDirection){
        throw new UnsupportedOperationException();
    }
    
    private GameCharacter combat(Monster monster){
        throw new UnsupportedOperationException();
    }
    
    private void manageReward(GameCharacter winner){
        throw new UnsupportedOperationException();
    }
    
    private void manageResurrection(){
        throw new UnsupportedOperationException();
    }
    
    private void logPlayerWon(){
        log+="El jugador ha ganado el combate\n";
    }
    
    private void logMonsterWon(){
        log+="El monstruo ha ganado el combate\n";
    }
    
    private void logResurrected(){
        log+="El jugador ha resucitado\n";
    }
    
    private void logPlayerSkipTurn(){
        log+="El jugador ha perdido su turno por estar muerto\n";
    }
    
    private void logPlayerNoOrders(){
        log+="El jugador no ha podido cumplir las órdenes\n";
    }
    
    private void logNoMonster(){
        log+="El jugador se ha movido a una celda vacía o no le ha sido posible moverse\n";
    }
    
    private void logRounds(int rounds, int max){
        log+="Se han producido "+rounds+" de "+max+" rondas de combate\n";
    }
    
}