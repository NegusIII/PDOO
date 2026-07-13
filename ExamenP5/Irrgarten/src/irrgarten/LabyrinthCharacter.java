
package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public abstract class LabyrinthCharacter {
    protected static final int INVALID_POS=-1;
    
    private String name;
    private float intelligence;
    private float strength;
    private float health;
    private int row,col;
    
    public LabyrinthCharacter(String name, float intelligence, float strength, float health){
        this.name=name;
        this.intelligence=intelligence;
        this.strength=strength;
        this.health=health;
        row=col=INVALID_POS;
    }
    
    public LabyrinthCharacter(LabyrinthCharacter other){
        this.name = other.name;
        this.intelligence = other.intelligence;
        this.strength = other.strength;
        this.health = other.health;
        this.row = other.row;
        this.col = other.col;
    }
    
    public boolean dead(){
        return health==0.0f;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    
    protected float getIntelligence(){
        return intelligence;
    }

    protected float getStrength() {
        return strength;
    }

    protected float getHealth() {
        return health;
    }
    
    protected void setHealth(float health) {
        this.health = health;
    }
    
    public void setPos(int row, int col){
        this.row=row;
        this.col=col;
    }
    
    @Override
    public String toString(){
        return name + " [i:" + intelligence + ", s:" + strength + ", h:" + health + ", p(" + row + "," + col + ")]";
    }
    
    protected void gotWounded(){
        health-=1;
    }
    
    public abstract float attack();
    public abstract boolean defend(float receivedAttack);
}
