package domain;

import domain.myEception.OverSumExecption;

import java.util.ArrayList;
import java.util.List;

public class Rule {

    private static final int A_NUMBER=1;
    private static final int J_NUMBER=11;
    private static final int Q_NUMBER=12;
    private static final int K_NUMBER=13;

    //카드의 합을 위해 숫자로 변환하는 메서드
    static private int makeNum(Card card){
        String value=card.getValue();
        int num=0;
        if(value=="A")
            num=A_NUMBER;
        else if(value=="J")
            num=J_NUMBER;
        else if(value=="Q")
            num=Q_NUMBER;
        else if(value=="K")
            num=K_NUMBER;
        else num=Integer.parseInt(value);
        return num;
    }
    //카드값의 합을 나타내는 함수
    public static int sumOfCard(Cards cardList){
        int sum=0;
        for(int i=0;i<cardList.cardSize();i++){
            sum+=makeNum(cardList.cardGet(i));
        }
        System.out.println("sum:"+sum);
        return overSum(sum);
    }
    //21을 넘으면 -1로
    private static int overSum(int sum){
        if(sum>21){
            return -1;
        }
        else return sum;
    }
    //승자를 알려주는 메서드
    public String whoIsWinner(Dealer dealer, Gamer gamer){
        int dealerSum, gamerSum;
        dealerSum=sumOfCard(dealer.openCard());
        gamerSum=sumOfCard(gamer.openCard());
        String winner="";
        if(dealerSum>=gamerSum)
            winner="Winner is dealer";
        else if(dealerSum<gamerSum)
            winner="Winner is Gamer";

        return winner;
    }
    //카드를 뽑을지 아닐지 결정하는 메서드
    void  dealerCardPickOrNot(Card card){

        if(sumOfCard(Dealer.dealerCard) >=17){
             new OverSumExecption("카드합이 17이상입니다.");

        }
    }
}
