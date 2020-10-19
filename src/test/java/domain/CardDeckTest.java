package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class CardDeckTest {


    @ParameterizedTest
    @ValueSource(strings = {"SPADE","HEART","DIAMOND","CLUB"})
    @DisplayName("Carddeck")
    public void Carddeck(String pattern){
        String character;
        CardDeck cardDeck = new CardDeck();
        List<Card> cards=new ArrayList<>();
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
                cards.add(card);
                cardDeck.addCard(card);
            }
    }
    @Test
    @DisplayName("카드 뽑기")
    void PickTest(){
        CardDeck cardDeck = new CardDeck();
        Card card = cardDeck.pick();
        System.out.println(card.getPattern());
        System.out.println(card.getCharacter());
        assertSame(cardDeck.getCards().contains(card),true);
    }

    @Test
    @DisplayName("카드 뽑은 후 삭제")
    void RemoveTest(){
        CardDeck cardDeck = new CardDeck();
        Card card = cardDeck.remove_card();
        assertSame(cardDeck.getCards().contains(card),false);

    }
}
