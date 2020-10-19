package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static domain.CardDeck.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class CardDeckTest {


    @Test
    @DisplayName("초기화 테스트")
    public void initializedTest() {

        CardDeck cardDeck = new CardDeck(); // 체크할 카드 묶음
        boolean check = false; //일치하는지 확인하기 위한 변수
        CardType[] types = CardType.values(); //카드의 모양의 리스트가 들어있는 변수

        for (int i = 0; i < types.length; i++) {

            CardType cardType = types[i];
            for (int j = 0; j < 14; j++) {
                Card card = new Card(makeValue(j), cardType); //각 카드의 객체를 만듬
                cardDeck.addCards(card); //카드 덱에 생성한 카드 추가
                check = cardDeck.getCards().contains(card); //제대로 값이 들어가져있는지 테스트
                assertSame(check, true);
            }
        }
    }


    @Test
    @DisplayName("랜덤 카드 뽑기 테스트")
    public  void pickTest(){

        CardDeck deck = new CardDeck();
        Card card =pickCard(deck.getCards()); //랜덤으로 카드 뽑음
        assertSame(deck.getCards().contains(card), true);//카드덱에 있는지 확이
    }

    @Test
    @DisplayName("뽑은 카드 제거 테스트")
    public void removedTest(){
        CardDeck deck = new CardDeck();
        ArrayList<Card> cardList= new ArrayList<>(); //카드 뽑은 뒤 카드덱
        Card pick = pickCard(deck.getCards()); //뽑은 카드
        assertSame(true, deck.getCards().contains(pick) );
        cardList=removeCard(deck.getCards(),pick);//카드 뽑은뒤 카드덱
        assertSame(false, cardList.contains(pick));
    }

}
