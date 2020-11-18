package domain;

import java.util.List;

public interface Player {
    public List<Card> openCard();
    public void firstPick(CardDeck cardDeck);
    public void total(List<Card> cards);

}
