package domain;

public class Card {

   private String value;
   private CardType shape;

    public Card(String value, CardType shape) {
        this.value = value;
        this.shape = shape;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CardType getShape() {
        return shape;
    }

    public void setShape(CardType shape) {
        this.shape = shape;
    }
}
