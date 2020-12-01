package domain;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

    private static Cards cards;
    public CardDeck( Cards cards) {
        this.cards=cards;
        cards.makeDeck(types);
    }

    //static List<Card> cards= new ArrayList<>();

    public  Cards getCards() {
        return cards;
    }


    private static final CardType[] types={
            CardType.HEART,CardType.SPADE,CardType.CLOVER,CardType.DIAMOND
    };


    static Card card;



    //카드 하나를 뽑아주는 메서드
    public static Card pickCard(){
        int index= cards.toList().size()-1;
        int valueIndex=(int)(Math.random()*index+1);
        removeCard(cards.toList().get(valueIndex));
        return cards.toList().get(valueIndex);
    }


    //뽑은 카드 제거해주는 메서드
    public static void removeCard(Card pick){

       // Card pick = pickCard(cards);
        System.out.println(pick.getValue()+ pick.getShape());
        for(int i=0;i< cards.toList().size();i++){
            if(pick.getShape()== cards.toList().get(i).getShape() && pick.getValue()== cards.toList().get(i).getValue())
                cards.toList().remove(i);
            else continue;
        }
        //System.out.println(cards.contains(pick));


    }


}
