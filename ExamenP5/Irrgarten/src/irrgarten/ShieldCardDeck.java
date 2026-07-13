package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class ShieldCardDeck extends CardDeck<Shield>{
    
    @Override
    public void addCards(){
        for (int i = 0; i < NUM_CARDS; i++){
            float protection = Dice.shieldPower();
            int uses=Dice.usesLeft();
            this.addCard(new Shield(protection,uses));
        }
    }
}
