package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Gamer implements Player{


    public List<Card> gamerCards;
    public int gamerTotal;

    public Gamer(List<Card> gamercards) {
        this.gamerCards = gamercards;
        this.gamerTotal=0;
    }
    @Override
    public List<Card> openCard(){
        return gamerCards;
    }
    public void firstPick(CardDeck cardDeck){
        gamerCards.add(cardDeck.pickAndRemove());
        gamerCards.add(cardDeck.pickAndRemove());
        total(gamerCards);
    }
    @Override
    public void total(List<Card> cards){
        cards=gamerCards;
        for(Card card:cards) {
            this.gamerTotal += card.getPoint();
        }
    }
    public void pick(CardDeck cardDeck){
        gamerCards.add(cardDeck.pickAndRemove());
        this.gamerTotal+=gamerCards.get(lastCardIndex()).getPoint();

    }

    private int lastCardIndex(){
        return gamerCards.size()-1;
    }
}
