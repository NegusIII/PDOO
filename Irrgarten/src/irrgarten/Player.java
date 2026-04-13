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
        
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
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
        int size = validMoves.size();
        boolean contained = validMoves.contains(direction);
        
        if (size > 0 && !contained){
            Directions firstElement=validMoves.get(0);
            return firstElement;
        }
        else return direction;
    }
    
    public float attack(){
        return (this.strength+this.sumWeapon());
    }
    
    public boolean defend(float receivedAttack){
        return this.manageHit(receivedAttack);
    }
    
    public void receiveReward(){
        Dice dado = new Dice();
        
        int wRewards=dado.weaponReward();
        int sRewards=dado.shieldReward();
        
        for (int i = 0; i < wRewards; i++){
            Weapon wnew=this.newWeapon();
            this.receiveWeapon(wnew);
        }
        for (int i = 0; i < sRewards; i++){
            Shield snew=this.newShield();
            this.receiveShield(snew);
        }
        
        int extraHealth = dado.healthReward();
        health+=extraHealth;
    }
    
    public String toString(){
        String s="P["+name+". i:"+intelligence+", s:"+strength+", h:"+health+
                ", cH:"+consecutiveHits+"p:("+row+", "+col+")]:\n";
        for(int i = 0; i<weapons.size();i++){
            s+=weapons.get(i).toString()+"\n";
        }
        for(int i = 0; i<shields.size();i++){
            s+=shields.get(i).toString()+"\n";
        }
        return s;
    }
    
    private void receiveWeapon(Weapon w){
        Dice dado = new Dice();
        for (int i = 0; i < weapons.size(); i++){
            Weapon wi = weapons.get(i);
            boolean discard = wi.discard();
            if (discard){
                weapons.remove(wi);
            }
        }
        int size = weapons.size();
        
        if (size<MAX_WEAPONS){
            weapons.add(w);
        }
    }
    
    private void receiveShield(Shield s){
        Dice dado = new Dice();
        for (int i = 0; i < shields.size(); i++){
            Shield si = shields.get(i);
            boolean discard = si.discard();
            if (discard){
                shields.remove(si);
            }
        }
        int size = shields.size();
        
        if (size<MAX_SHIELDS){
            shields.add(s);
        }
    }
    
    private Weapon newWeapon(){
        Dice dado = new Dice();
        float power = dado.weaponPower();
        int usos=dado.usesLeft();
        Weapon arma = new Weapon(power, usos);
        return arma;
    }
    
    private Shield newShield(){
        Dice dado = new Dice();
        float protection = dado.shieldPower();
        int uses=dado.usesLeft();
        Shield escudo = new Shield(protection, uses);
        return escudo;
    }
    
    private float sumWeapon(){
        float suma = 0;
        for (int i = 0; i < weapons.size(); i++){
           suma += weapons.get(i).attack();
        }
        return suma;
    }
    
    private float sumShield(){
        float suma = 0;
        for (int i = 0; i < shields.size(); i++){
           suma += shields.get(i).protect();
        }
        return suma;
    }
    
    private float defensiveEnergy(){
        return (this.intelligence+this.sumShield());
    }
    
    private boolean manageHit(float receivedAttack){
        float defense = this.defensiveEnergy();
        if (defense < receivedAttack){
            this.gotWounded();
            this.incConsecutiveHits();
        }
        else this.resetHits();
        boolean lose;
        lose = this.dead() || HITS2LOSE==consecutiveHits;
        
        return lose;
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
