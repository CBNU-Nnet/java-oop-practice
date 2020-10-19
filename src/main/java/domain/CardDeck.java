package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDeck {

    List<Card> cards=new ArrayList<>();

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
    public CardDeck() {
       make_deck(patterns);
    }

    public void make_deck(String[] patterns){
        for(int i=0;i<4;i++)
            make_carddeck(patterns[i]);
    }

    //카드덱 만들기
    public void make_carddeck(String pattern){
        String character;

            for (int i = 0; i < 14; i++) {
                if (i == 0)
                    character = "A";
                else if (i == 11)
                    character = "J";
                else if (i == 12)
                    character = "Q";
                else if (i == 13)
                    character = "K";
                else
                    character = String.valueOf(i);
                Card card = new Card(CardShape.valueOf(pattern),character);
                this.cards.add(card);
            }

        }
    public void addCard(Card card){
        this.cards.add(card);
    }

    //카드덱에서 카드 한장 뽑기(인덱스 추출)
    public int draw_card_index(){
        Random random = new Random();
        return random.nextInt(cards.size());
    }
    //카드 뽑기
    public Card pick(){
        return cards.get(draw_card_index());
    }

    //카드덱에서 해당 인덱스에 있는 카드 삭제
    public Card remove_card(){
        Card pickcard = pick();
        this.cards.remove(pickcard);
        return pickcard;
    }
}
