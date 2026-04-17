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
    private float power;
    private int uses;
    
    Weapon(float poder, int usos){
        power=poder;
        uses=usos;
    }
    public float attack(){
        float intensity=0;
        if(uses>0){
            intensity=power;
            uses--;
        }
        return intensity;
    }
    
    @Override
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
