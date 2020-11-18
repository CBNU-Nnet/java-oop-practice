package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DealerTest {

    @Test
    @DisplayName("카드 2장을 뽑고 계산")
    void pickCard(){
        CardDeck cardDeck = new CardDeck();
        List<Card>cards = new ArrayList<>();
        Dealer dealer = new Dealer(cards);
        dealer.firstPick(cardDeck); //카드 2장을 뽑음
        dealer.pick(cardDeck);  // 이 함수 자체가 카드 포인트가 16이하인지 판단하고 16이하면 한장 더뽑고 아니면 안뽑는 함수
        for(int i = 0; i<dealer.dealerCards.size(); i++) {
            System.out.println(dealer.openCard().get(i).getPattern());
            System.out.println(dealer.openCard().get(i).getCharacter());
        }
        System.out.println(dealer.dealerTotal);
    }

    @Test
    @DisplayName("카드 3장이상 뽑을 수 없음")
    public void cardOutOfBounds(){
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = new ArrayList<>();
        Dealer dealer = new Dealer(cards);
        dealer.firstPick(cardDeck);
        dealer.firstPick(cardDeck);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,()->dealer.isOverCardSize()
        );
        assertTrue(ex.getMessage().contains("받을 수 있는 카드 수 초과"));
    }
}
