package irrgarten;
import java.util.ArrayList;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Player {
    
    private final int MAX_WEAPONS=2;
    private final int MAX_SHIELDS=2;
    private final int INITIAL_HEALTH=10;
    private final int HITS2LOSE=3;
    
    private String name;
    private char number;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits=0;
    
    //
    
    Player(char numero, float inteligencia, float fuerza){
        
    }
    
    public void resurrect(){
        
    }
    
    public int getRow(){
        
    }
    
    public int getCol(){
        
    }
    
    public char getNumber(){
        
    }
    
    public void setPos(int r, int c){
        
    }
    
    public boolean dead(){
        
    }
    
    public Directions move(Directions direction, ArrayList<Directions> validMoves){
        
    }
    public float attack(){
        
    }
    
    public boolean defend(float receivedAttack){
        
    }
    
    public void receiveReward(){
        
    }
    
    public String toString(){
        
    }
    
    private void receiveWeapon(Weapon w){
        
    }
    
    private void receiveShield(Shield s){
        
    }
    
    private Weapon newWeapon(){
        
    }
    
    private Shield newShield(){
        
    }
    
    private float sumWeapon(){
        
    }
    
    private float sumShield(){
        
    }
    
    private float defensiveEnergy(){
        
    }
    
    private boolean manageHit(float receivedAttack){
        
    }
    
    private void resetHits(){
        
    }
    
    private void gotWounded(){
        
    }
    private void incConsecutiveHits(){
        
    }
}
