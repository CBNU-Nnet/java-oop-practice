package domain;

public enum CardNumber {

    A_NUMBER(1),J_NUMBER(11),
    Q_NUMBER(12),K_NUMBER(13);
    int value;

    CardNumber(int value) {
        this.value = value;
    }



}

