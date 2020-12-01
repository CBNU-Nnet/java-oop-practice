package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RuleTest {
    @Test
    @DisplayName("우승자를 가리는 테스트")
    public void winnerTest(){
        CardDeck cardDeck= new CardDeck();
        ArrayList<Card> gamerCard= new ArrayList<>();
        ArrayList<Card> dealerCard= new ArrayList<>();
        Dealer dealer = new Dealer(dealerCard);
        Gamer gamer = new Gamer(gamerCard);
        Rule rule = new Rule();
        for(int i=0;i<3;i++){
            Card dealerPick = cardDeck.pickCard();
            dealer.addCard(dealerPick);
            Card gamerPick= cardDeck.pickCard();
            gamer.addCard(gamerPick);
        }
        if(rule.sumOfCard(dealer.openCard()) >rule.sumOfCard(gamer.openCard()))
           assertEquals( rule.whoIsWinner(dealer,gamer),"Winner is dealer");

        else if(rule.sumOfCard(dealer.openCard()) <rule.sumOfCard(gamer.openCard()))
        assertEquals( rule.whoIsWinner(dealer,gamer),"Winner is gamer");

        else  assertEquals( rule.whoIsWinner(dealer,gamer),"Draw");
    }
}
