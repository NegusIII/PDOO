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
    
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
    
    //
    
    Player(char number, float intelligence, float strength){
        this.number=number;
        this.intelligence=intelligence;
        this.strength=strength;
        
        health=INITIAL_HEALTH;
        name="Player#"+number;
    }
    
    public void resurrect(){
        health=INITIAL_HEALTH;
        weapons.clear();
        shields.clear();
        resetHits();
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    
    public char getNumber(){
        return number;
    }
    
    public void setPos(int row, int col){
        this.row=row;
        this.col=col;
    }
    
    public boolean dead(){
        return health==0.0;
    }
    
    public Directions move(Directions direction, ArrayList<Directions> validMoves){
        return direction;
    }
    
    public float attack(){
        
    }
    
    public boolean defend(float receivedAttack){
        
    }
    
    public void receiveReward(){
        
    }
    
    public String toString(){
        return "P["+name+". i:"+intelligence+", s:"+strength+", h:"+health+
                ", cH:"+consecutiveHits+"p:("+row+", "+col+")]";
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
        return true;   
    }
    
    private void resetHits(){
        consecutiveHits=0;
    }
    
    private void gotWounded(){
        health-=1;
    }
    
    private void incConsecutiveHits(){
        consecutiveHits++;
    }
}
