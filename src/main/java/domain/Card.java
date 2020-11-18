package domain;

public class Card {
    private CardShape pattern;
    private String character;
    private int point;

    public int getPoint() {
        return point;
    }

    public Card(CardShape pattern, String character) {
        this.pattern = pattern;
        this.character = character;
        this.point=cardPoint(character);
    }
    private int cardPoint(String character){
        if(character.equals("A"))
            return 1;
        else if(character.equals("K")||character.equals("Q")||character.equals("J"))
            return 10;
        else
            return Integer.parseInt(character);
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
