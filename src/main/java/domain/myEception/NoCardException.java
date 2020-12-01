package domain.myEception;

public class NoCardException extends RuntimeException{

    public NoCardException() {
        super();
    }
    public NoCardException(String message){
        super(message);
    }
}
