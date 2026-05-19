/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public abstract class CombatElement {
    private float effect;
    private int uses;
    
    public CombatElement(float effect, int uses){
        this.effect=effect;
        this.uses=uses;
    }
    
    protected float produceEffect(){
        float intensity=0;
        if(uses>0){
            intensity=effect;
            uses--;
        }
        return intensity;
    }
    public boolean discard(){
        return Dice.discardElement(uses);
    }
    
    @Override
    public String toString(){
        String s="[";
        s= s + effect + ","+ uses;
        s+="]";
        return s;
    }
}
