package state;

import card.CardReciever;

public class CheckBalanceState extends ATMState{

    public CheckBalanceState(){
        System.out.println("Checking user balance..");
    }

    @Override
    public int checkBalance(){
        int balance = CardReciever.getInstance().getCard().getBalance();
        System.out.println("your current balance is: "+balance);
        return balance;
    }
}
