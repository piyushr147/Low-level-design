package card;

public class CardReciever {
    private Card card;
    private static CardReciever cardReciever;

    public static CardReciever getInstance(){
        if(cardReciever == null)
            cardReciever = new CardReciever();
        return cardReciever;
    }

    public Card getCard(){
        return this.card;
    }

    public void setCard(Card card){
        this.card = card;
    }
}
