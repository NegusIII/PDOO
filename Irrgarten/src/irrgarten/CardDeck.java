package irrgarten;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Sergio Salvador Gil
 * @param <T>
 */
public abstract class CardDeck <T extends CombatElement>{
    
    protected static final int NUM_CARDS=3;
    
    private ArrayList<T> cardDeck;
    
    public CardDeck(){
        cardDeck=new ArrayList<>();
        this.addCards();
    }
    
    protected abstract void addCards();
    
    protected void addCard(T card){
        cardDeck.add(card);
    }
    
    public T nextCard(){
        if (cardDeck.isEmpty()){
            this.addCards();
            Collections.shuffle(cardDeck);
        }
        return cardDeck.remove(0);
    }
}
