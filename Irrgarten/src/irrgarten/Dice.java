/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import java.util.Random;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Dice {
    
    private final int MAX_USES = 5;
    private final float MAX_INTELLIGENCE = 10;
    private final float MAX_STRENGTH = 11;
    private final float RESURRECT_PROB = (float) 0.3;
    private final int WEAPONS_REWARD = 2;
    private final int SHIELDS_REWARD = 3;
    private final int HEALTH_REWARD = 5;
    private final int MAX_ATTACK = 3;
    private final int MAX_SHIELD = 2;
    
   private static Random generator = new Random();
   
   public int randomPos(int max){
       return generator.nextInt(max);
   }
   
   public int whoStarts(int nplayers){
       return generator.nextInt(nplayers);
   }
   
   public float randomIntelligence(){
       return generator.nextFloat(MAX_INTELLIGENCE);
   }
   
   public float randomStrength(){
       return generator.nextFloat(MAX_STRENGTH);
   }
   
   boolean resurrectPlayer(){
       boolean res = false;
       if (generator.nextFloat()<= RESURRECT_PROB){
           res=true;
       }
       return res;
   }
   
   int weaponReward(){
       return generator.nextInt(WEAPONS_REWARD);
   }
   
   int shieldReward(){
       return generator.nextInt(SHIELDS_REWARD);
   }
   
   int healthReward(){
       return generator.nextInt(HEALTH_REWARD);
   }
   
   float weaponPower(){
       return generator.nextFloat(MAX_ATTACK);
   }
   
   float shieldPower(){
       return generator.nextFloat(MAX_SHIELD);
   }
   
   int usesLeft(){
       return generator.nextInt(MAX_USES);
   }
   
   float intensity(float competence){
       return generator.nextFloat(competence);
   }
   
   boolean discardElement(int usesLeft){
       boolean discard = false;
       if (generator.nextFloat()<=MAX_USES/(float)usesLeft){
           discard = true;
       }
       return discard;
   }
   
}
