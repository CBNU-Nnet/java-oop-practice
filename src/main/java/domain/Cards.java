package domain;

import java.util.List;

import static domain.CardNumber.*;

public class Cards  {

    private List<Card> cards;

    public Cards(List<Card> cards){
        this.cards = cards;

    }



    public void makeDeck(CardType types[] ){
        for(int i=0;i< types.length;i++){
            initializeCards(types[i]);
        }

    }

    public void initializeCards(CardType type){
        String value;
        Card card;
        for (int j = 1; j < 14; j++) {
            value = makeValue(j);
            card = new Card(value, type);
            cards.add(card);
        }
    }

    static String makeValue(Integer j){
        String value;
        if(j==A_NUMBER.value)
            value="A";
        else if(j==J_NUMBER.value)
            value="J";
        else if(j==Q_NUMBER.value)
            value="Q";
        else if(j==K_NUMBER.value)
            value="K";
        else value=Integer.toString(j);

        return value;
    }

    List<Card> toList(){
        List<Card> cardList = null;
        for(int i=0;i<cards.size();i++){
            cardList.add(cards.get(i));
        }
        return cardList;
    }


    /*
    public class Cards{
        private List<Card> cards;
        Cards(List <Card> cards){

        }
    }*/
}
