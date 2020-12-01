package domain.myEception;

public class CardLimitExeption extends RuntimeException{
    public CardLimitExeption() {
    }

    public CardLimitExeption(String message) {
        super(message);
    }
}
