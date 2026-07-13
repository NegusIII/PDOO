/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Monster extends LabyrinthCharacter{
    
    private static final int INITIAL_HEALTH=5;
    
    // Métodos públicos de la clase Monster
    
    public Monster(String name, float intelligence, float strength){
        super(name,intelligence,strength,INITIAL_HEALTH);
    }
    
    @Override
    public float attack(){
        return Dice.intensity(this.getStrength());
    }
    
    @Override
    public boolean defend(float receivedAttack){
        boolean isDead= this.dead();
        
        if (!isDead){
            
            float defensiveEnergy = Dice.intensity(this.getIntelligence());
            
            if(defensiveEnergy < receivedAttack){
                this.gotWounded();
                isDead=this.dead();
            }
        }
        return isDead;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
