package domain;

public class Card {
    private CardShape pattern;
    private String character;

    public Card(CardShape pattern, String character) {
        this.pattern = pattern;
        this.character = character;
    }

    public void setPattern(CardShape pattern) {
        this.pattern = pattern;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public CardShape getPattern() {
        return pattern;
    }

    public String getCharacter() {
        return character;
    }


}
