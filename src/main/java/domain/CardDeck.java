package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardDeck {

    List<Card> cards=new ArrayList<>();
    private static final int PATTERN_A=1;
    private static final int PATTERN_J=11;
    private static final int PATTERN_Q=12;
    private static final int PATTERN_K=13;
    private static final int CARD_DECK_SIZE=13;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    private static String[] patterns={
            CardShape.CLUB.name(),
            CardShape.DIAMOND.name(),
            CardShape.HEART.name(),
            CardShape.SPADE.name()
    };

    public List<Card> create(){
        List<Card> cards = new ArrayList<>();
        for(int i=0;i<4;i++){
            makeCarddeck(patterns[i]);
        }
        return Collections.unmodifiableList(cards);
    }

    public CardDeck() {
       makeDeck(patterns);
    }

    private void makeDeck(String[] patterns){
        for(int i=0;i<4;i++)
            makeCarddeck(patterns[i]);
    }

    //카드덱 만들기
    private void makeCarddeck(String pattern) {
        for(int i=1;i<=CARD_DECK_SIZE;i++){
            String character =numberToPattern(i);
            Card card = new Card(CardShape.valueOf(pattern), character);
            this.cards.add(card);
        }
    }
    private String numberToPattern(int number){
        if (number == PATTERN_A)
            return "A";
        else if (number == PATTERN_J)
            return "J";
        else if (number == PATTERN_Q)
            return "Q";
        else if (number == PATTERN_K)
            return "K";
        else
            return String.valueOf(number);
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    //카드덱에서 카드 한장 뽑기(인덱스 추출)
    private int drawCardIndex(){
        Random random = new Random();
        return random.nextInt(cards.size());
    }

    //카드덱에서 해당 인덱스에 있는 카드 삭제
    public Card pickAndRemove(){
        Card pickcard = cards.get(drawCardIndex());
        this.cards.remove(pickcard);
        return pickcard;
    }
}
