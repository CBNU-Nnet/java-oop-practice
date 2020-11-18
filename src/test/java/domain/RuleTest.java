package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RuleTest {

    @Test
    @DisplayName("게임 승리자")
    public void winnerTest(){
        CardDeck cardDeck = new CardDeck();
        List<Card> dealerCardlist=new ArrayList<>();
        List<Card> gamerCardList = new ArrayList<>();
        Dealer dealer=new Dealer(dealerCardlist);
        Gamer gamer=new Gamer(gamerCardList);
        Rule rule=new Rule();
        gamer.firstPick(cardDeck);
        dealer.firstPick(cardDeck);
        dealer.pick(cardDeck);
        rule.Winner(dealer,gamer);
    }
}
