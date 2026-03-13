/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Weapon {
    private final float power;
    private int uses;
    
    Weapon(){
        Dice dado = new Dice();
        power=dado.weaponPower();
        uses=dado.usesLeft();
    }
    public float attack(){
        float intensity=0;
        if(uses>0){
            intensity=power;
            uses--;
        }
        return intensity;
    }
    
    public String toString(){
        String s="W[";
        s= s + power + ","+ uses;
        s+="]";
        return s;
    }
    
    public boolean discard(){
        Dice dado=new Dice();
        return dado.discardElement(uses);
    }
}
