package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class WeaponCardDeck extends CardDeck<Weapon>{
    
    @Override
    public void addCards(){
        for (int i = 0; i < NUM_CARDS; i++){
            float protection = Dice.weaponPower();
            int uses=Dice.usesLeft();
            this.addCard(new Weapon(protection,uses));
        }
    }
}
