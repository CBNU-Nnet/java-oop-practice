package domain;

public class Rule {
    public int dealerPoint;
    public int gamerPoint;

    public Rule() {
        this.dealerPoint = 0;
        this.gamerPoint = 0;
    }
    public void Winner(Dealer dealer,Gamer gamer){
        dealerPoint=dealer.dealerTotal;
        gamerPoint=gamer.gamerTotal;
        for(Card card: dealer.dealerCards)
            System.out.println(card.getPoint());
        if(dealerPoint>21)
            dealerPoint=0;
        if(gamerPoint>21)
            gamerPoint=0;
        if(dealerPoint>gamerPoint)
            System.out.println("Dealer is winner");
        else if(dealerPoint==gamerPoint) {
            System.out.println("Draw");
        }
        else {
            System.out.println("Gamer is winner");
        }
    }
    private int calcPoint(int point){
        if(point>21)
            return -1;
        else
            return point;
    }
}
