/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Shield {
    
    private final float protection;
    private int uses;
    
    Shield(float proteccion, int usos){
        protection=proteccion;
        uses=usos;
    }
    
    public float protect(){
        float intensity=0;
        if(uses>0){
            intensity=protection;
            uses--;
        }
        return intensity;
    }
    
    public String toString(){
        String s="S[";
        s= s + protection + ","+ uses;
        s+="]";
        return s;
    }
    public boolean discard(){
        Dice dado=new Dice();
        return dado.discardElement(uses);
    }
}
