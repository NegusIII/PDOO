package irrgarten;
import java.util.ArrayList;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Player extends LabyrinthCharacter{
    
    private static final int MAX_WEAPONS=2;
    private static final int MAX_SHIELDS=3;
    private static final int INITIAL_HEALTH=10;
    private static final int HITS2LOSE=3;
    
    private char number;
    private int consecutiveHits=0;
    
    private WeaponCardDeck weaponCardDeck;
    private ShieldCardDeck shieldCardDeck;
    
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
    
    
    public Player(char number, float intelligence, float strength){
        super("Player#"+number,intelligence,strength,INITIAL_HEALTH);
        this.number=number;
        
        this.weaponCardDeck = new WeaponCardDeck();
        this.shieldCardDeck = new ShieldCardDeck();
        
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
    }
    public Player(Player other){
        super(other);
        
        this.number=other.number;
        this.consecutiveHits = other.consecutiveHits;
        
        this.weaponCardDeck = other.weaponCardDeck;
        this.shieldCardDeck = other.shieldCardDeck;
        
        this.weapons = new ArrayList<>(other.weapons);
        this.shields = new ArrayList<>(other.shields);
    }
    
    public void resurrect(){
        this.setHealth(INITIAL_HEALTH);
        weapons.clear();
        shields.clear();
        resetHits();
    }

    public char getNumber(){
        return number;
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
    
    @Override
    public float attack(){
        return (this.getStrength()+this.sumWeapon());
    }
    
    @Override
    public boolean defend(float receivedAttack){
        return this.manageHit(receivedAttack);
    }
    
    public void receiveReward(){
        
        int wRewards=Dice.weaponReward();
        int sRewards=Dice.shieldReward();
        
        for (int i = 0; i < wRewards; i++){
            Weapon wnew=this.newWeapon();
            this.receiveWeapon(wnew);
        }
        for (int i = 0; i < sRewards; i++){
            Shield snew=this.newShield();
            this.receiveShield(snew);
        }
        
        int extraHealth = Dice.healthReward();
        this.setHealth(this.getHealth()+extraHealth);
    }
    
    @Override
    public String toString(){
        String s=super.toString()+"\nConsecutive hits:" + consecutiveHits+"\nweapons:";
        for(int i = 0; i<weapons.size();i++){
            s+=weapons.get(i).toString()+"      ";
        }
        s+="\nshields:";
        for(int i = 0; i<shields.size();i++){
            s+=shields.get(i).toString()+"      ";
        }
        return s;
    }
    
    private void receiveWeapon(Weapon w){
        weapons.removeIf(wi -> wi.discard());
        int size = weapons.size();
        
        if (size<MAX_WEAPONS){
            weapons.add(w);
        }
    }
    
    private void receiveShield(Shield s){
        shields.removeIf(si -> si.discard());
        int size = shields.size();
        
        if (size<MAX_SHIELDS){
            shields.add(s);
        }
    }
    
    private Weapon newWeapon(){
        return weaponCardDeck.nextCard();
    }
    
    private Shield newShield(){
        return shieldCardDeck.nextCard();
    }
    
    protected float sumWeapon(){
        float suma = 0;
        for (int i = 0; i < weapons.size(); i++){
           suma += weapons.get(i).attack();
        }
        return suma;
    }
    
    protected float sumShield(){
        float suma = 0;
        for (int i = 0; i < shields.size(); i++){
           suma += shields.get(i).protect();
        }
        return suma;
    }
    
    protected float defensiveEnergy(){
        return (this.getIntelligence()+this.sumShield());
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
    
    private void incConsecutiveHits(){
        consecutiveHits++;
    }
}
