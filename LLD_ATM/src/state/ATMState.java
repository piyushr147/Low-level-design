package state;

import card.Card;
import currency.Currency;
import operation.OperationType;

public abstract class ATMState {
    public void insertCard(Card card){
        System.out.println("can't insert card at this state");
    }

    public void authenticate(){
        System.out.println("can't authenticate card at this state");
    }

    public void selectOperation(OperationType operationType){
        System.out.println("can't select operation at this state");
    }

    public void withdrawCash(int amount){
        System.out.println("can't withdraw cash at this state");
    }

    public int checkBalance(){
        System.out.println("can't check balance at this state");
        return 0;
    }

    public void depositCash(Currency currency){
        System.out.println("can't deposit any cash at this state");
    }

    public void cancelSelection(){
        System.out.println("can't cancel operation at this state");
    }

    public void performOperation(){
        System.out.println("can't perform operation at this state");
    }
}
