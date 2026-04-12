/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Monster {
    
    private final int INITIAL_HEALTH=5;
    private final int INVALID_POS=-1;
    
    private String name;
    private float intelligence;
    private float strength;
    private float health;   
    private int row;
    private int col;
    
    // Métodos públicos de la clase Monster
    
    Monster(String name, float intelligence, float strength){
        this.name=name;
        this.intelligence=intelligence;
        this.strength=strength;
        health=INITIAL_HEALTH;
        row=col=INVALID_POS;
    }
    
    public boolean dead(){
        return health==0.0;
    }
    
    public float attack(){
        Dice dado = new Dice();
        return dado.intensity(strength);
    }
    
    public boolean defend(float receivedAttack){
        boolean isDead= this.dead();
        
        if (!isDead){
            Dice dado = new Dice();
            
            float defensiveEnergy = dado.intensity(intelligence);
            
            if(defensiveEnergy < receivedAttack){
                this.gotWounded();
                isDead=this.dead();
            }
        }
        return isDead;
    }
    
    public void setPos(int row, int col){
        this.row=row;
        this.col=col;
    }
    
    public String toString(){
        return "M["+name+". i:"+intelligence+", s:"+strength+", h:"+health+", p:("+row+", "+col+")]";
    }
    
    private void gotWounded(){
        health-=1;
    }
}
