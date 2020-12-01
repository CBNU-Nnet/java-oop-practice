package domain;

import domain.myEception.CardLimitExeption;
import domain.myEception.NoCardException;
import domain.myEception.OverSumExecption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DealerTest {

    @Test
    @DisplayName("카드 합에 따라 뽑을 지 안뽑을지 테스트")
    public void pickTest(){

        CardDeck cardDeck= new CardDeck();
        ArrayList<Card> dealerCard= new ArrayList<>();
        Dealer dealer = new Dealer(dealerCard);
        Rule rule = new Rule();
        int sum=0;
        for(int i=0;i<2;i++){
            Card card = cardDeck.pickCard();
            dealerCard.add(card);
        }
        sum=rule.sumOfCard(dealerCard);
        Card newCard= cardDeck.pickCard();

        if(sum<16){
            dealer.PickOrNot(newCard);
            System.out.println(sum);
            assertEquals(3,dealerCard.size());
        }
        else {
            //System.out.println(sum);
            dealer.PickOrNot(newCard);
            OverSumExecption thrown =assertThrows(
                    OverSumExecption.class,
                    ()-> dealer.PickOrNot(newCard));
            assertEquals(thrown.getMessage(), "카드합이 17이상입니다.");
        }

    }
    @Test
    @DisplayName("카드가 없을 때 테스트")
    void nocardTest(){

        ArrayList<Card> dealerCard= new ArrayList<>();
        Dealer dealer = new Dealer(dealerCard);
        Rule rule = new Rule();

        NoCardException thrown=assertThrows(
                NoCardException.class,
                ()->dealer.openCard()
                );
        assertEquals(thrown.getMessage(),"보여줄 카드가 없습니다");
    }

    @Test
    @DisplayName("카드가 3개 이상일때 테스트")
    void cardLimitTest(){
        CardDeck cardDeck= new CardDeck();
        ArrayList<Card> dealerCard= new ArrayList<>();
        Dealer dealer = new Dealer(dealerCard);
        int sum=0;
        for(int i=0;i<3;i++){
            Card card = cardDeck.pickCard();
            dealer.addCard(card);
        }
       ;

        CardLimitExeption thrown = assertThrows(CardLimitExeption.class,
                () -> dealer.addCard(cardDeck.pickCard()));
        System.out.println(dealer.openCard().size());
        assertEquals(thrown.getMessage(),"더이상 추가할 수 없습니다");
    }
}
