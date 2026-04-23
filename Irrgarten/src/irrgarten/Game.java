package irrgarten;
import java.util.ArrayList;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Game {
    
    private static final int MAX_ROUNDS=10;
    private int currentPlayerIndex;
    
    
    private String log;
    
    private Labyrinth labyrinth;
    private ArrayList<Monster> monsters;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    // Métodos públicos de la clase Game
    
    public Game(int nplayers){
        
        // Generar los jugadores
        
        this.players = new ArrayList<>();
        Dice Dice = new Dice();
        for (int i = 0; i < nplayers; i++){
            Player actual = new Player((char)(i+'0'),Dice.randomIntelligence(), Dice.randomStrength());
            players.add(actual);
        }
        
        // Decidir quién empieza
        currentPlayerIndex=Dice.whoStarts(nplayers);
        currentPlayer=players.get(currentPlayerIndex);
        
        monsters = new ArrayList();
        labyrinth = new Labyrinth(7,5,2,3);
        
        log="";
        
        configureLabyrinth();
        labyrinth.spreadPlayers(players);
        
    }
    
    public boolean finished(){
        return labyrinth.haveAWinner();
    }
    
    public boolean nextStep(Directions preferredDirection){
        log ="";
        boolean dead = currentPlayer.dead();
        
        if (!dead){
            
            Directions direction = this.actualDirection(preferredDirection);
            if (direction != preferredDirection){
                logPlayerNoOrders();
            }
            Monster monster = labyrinth.putPlayer(direction, currentPlayer);
            
            if (monster == null){
                this.logNoMonster();
            }
            else{
                GameCharacter winner = combat(monster);
                this.manageReward(winner);
            }
            
        }
        else this.manageResurrection();
        
        boolean endGame = this.finished();
        
        if (!endGame){
            this.nextPlayer();
        }
        
        return endGame;
    }
    
    public GameState getGameState(){
        String playersStr="";
        String monstersStr="";
        
        for (int i = 0; i < players.size(); i++){
            playersStr+=players.get(i).toString()+"\n";
        }
        for (int i = 0; i < monsters.size(); i++){
            monstersStr+=monsters.get(i).toString()+"\n";
        }
        
        GameState estado = new GameState(labyrinth.toString(), playersStr, 
        monstersStr, currentPlayerIndex, this.finished(), log);
        return estado;
    }
    //Métodos privados de la clase Game
    
    private void configureLabyrinth(){
        Monster monstruo1= new Monster("Netanyahu", Dice.randomIntelligence(), Dice.randomStrength());
        Monster monstruo2= new Monster("Bin Laden", Dice.randomIntelligence(), Dice.randomStrength());
        Monster monstruo3= new Monster("Khamenei", Dice.randomIntelligence(), Dice.randomStrength());
        
        labyrinth.addMonster(3,3,monstruo1);
        labyrinth.addMonster(1,4,monstruo2);
        labyrinth.addMonster(5,2,monstruo3);
        monsters.add(monstruo1);
        monsters.add(monstruo2);
        monsters.add(monstruo3);
        
        labyrinth.addBlock(Orientation.HORIZONTAL, 2,0,3);
        labyrinth.addBlock(Orientation.HORIZONTAL, 1,3,1);
    }
    
    private void nextPlayer(){
        if (currentPlayerIndex==players.size()-1){
            currentPlayerIndex=0;
        }
       
        else  currentPlayerIndex++;
        
        currentPlayer = players.get(currentPlayerIndex);
    }
    
    private Directions actualDirection(Directions preferredDirection){
        int row = currentPlayer.getRow();
        int col = currentPlayer.getCol();
        
        ArrayList<Directions> validMoves=labyrinth.validMoves(row,col);
        
        return currentPlayer.move(preferredDirection, validMoves);
    }
    
    private GameCharacter combat(Monster monster){
        int rounds = 0;
        GameCharacter winner = GameCharacter.PLAYER;
        
        float playerAttack=currentPlayer.attack();
        boolean lose = monster.defend(playerAttack);
        
        while (!lose && (rounds < MAX_ROUNDS)){
            winner = GameCharacter.MONSTER;
            rounds++;
            
            float monsterAttack = monster.attack();
            lose = currentPlayer.defend(monsterAttack);
            
            if (!lose){
                playerAttack = currentPlayer.attack();
                winner = GameCharacter.PLAYER;
                lose = monster.defend(playerAttack);
            }
        }
        this.logRounds(rounds, MAX_ROUNDS);
        return winner;
    }
    
    private void manageReward(GameCharacter winner){
        
        if (winner==GameCharacter.PLAYER){
            currentPlayer.receiveReward();
            this.logPlayerWon();
        }
        else this.logMonsterWon();
    }
    
    private void manageResurrection(){
        Dice Dice = new Dice();
        
        boolean resurrect = Dice.resurrectPlayer();
        
        if (resurrect){
            currentPlayer.resurrect();
            this.logResurrected();
        }
        else this.logPlayerSkipTurn();
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