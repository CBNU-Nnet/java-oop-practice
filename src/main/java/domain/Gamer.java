package domain;

import domain.myEception.NoCardException;

import java.util.ArrayList;
import java.util.List;

public class Gamer implements Player{
    Cards gamerCard;//플레이어의 카드 리스트

    public Gamer(Cards playerCard) {
        this.gamerCard = playerCard;
    }

    @Override
    public void addCard(Card card) {

        gamerCard.toList().add(card);
    }

    @Override
    public Cards openCard() {

        if(gamerCard.toList().isEmpty())
            throw new NoCardException("보여줄 카드가 없습니다");
        return this.gamerCard;
    }
}
