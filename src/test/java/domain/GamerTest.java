package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamerTest {
    @Test
    @DisplayName("게이머 카드 뽑기")
    void gamerCardPick(){
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = new ArrayList<>();
        Gamer gamer = new Gamer(cards);
        gamer.firstPick(cardDeck);
        for(int i=0;i<gamer.gamerCards.size();i++) {
            System.out.println(gamer.openCard().get(i).getPattern());
            System.out.println(gamer.openCard().get(i).getCharacter());
        }
        System.out.println(gamer.gamerTotal);
        //assertEquals(gamer.gamercards,gamer.openCard());
    }

}
