
package irrgarten;

import java.util.ArrayList;

/**
 *
 * @author Sergio Salvador Gil
 */
public class FuzzyPlayer extends Player{
    public FuzzyPlayer (Player other){
        super(other);
    }
    
    @Override
    public Directions move(Directions direction, ArrayList<Directions> validMoves){
        return (Dice.nextStep(super.move(direction, validMoves), validMoves, this.getIntelligence()));
    }
    @Override
    public float attack(){
        return (Dice.intensity(this.getStrength())+this.sumWeapon());
    }
    
    @Override
    protected float defensiveEnergy(){
        return (Dice.intensity(this.getIntelligence())+this.sumShield());
    }
    
    @Override
    public String toString(){
        return "Fuzzy"+super.toString();
    }
}
