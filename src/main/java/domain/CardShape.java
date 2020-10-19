package domain;

public enum CardShape {
    SPADE("♠", "SPADE"),
    HEART("♥", "HEART"),
    DIAMOND("♦", "DIAMOND"),
    CLUB("♣", "CLUB");

    private String shape;
    private String title;

    CardShape(String shape, String title) {
        this.shape = shape;
        this.title = title;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
