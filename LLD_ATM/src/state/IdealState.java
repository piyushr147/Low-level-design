package state;

import card.Card;
import card.CardReciever;
import machine.ATM;

public class IdealState extends ATMState{

    public IdealState(){
        System.out.println("ATM is in ideal state");
    }

    @Override
    public void insertCard(Card card){
        CardReciever.getInstance().setCard(card);
        ATM.getMachine().changeState(new ValidationState());
    }
}
