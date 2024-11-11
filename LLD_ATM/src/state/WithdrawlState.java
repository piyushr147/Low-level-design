package state;

import WithdrawlHandler.WithdrawlHandler;
import WithdrawlHandler.TwoThousandWithdrawlHandler;
import WithdrawlHandler.FiveHundredWithdrawlHandler;
import WithdrawlHandler.OneHundredWithdrawlHandler;
import card.CardReciever;
import machine.ATM;

public class WithdrawlState extends ATMState{

    public WithdrawlState(){
        System.out.println("Now you can withdraw amount from bank");
    }

    @Override
    public void withdrawCash(int amount){
        if(amount > CardReciever.getInstance().getCard().getBalance()){
            System.out.println("your balance is less");
            ATM.getMachine().changeState(new SelectionState());
        }
        else{
            WithdrawlHandler withdrawlHandler = new TwoThousandWithdrawlHandler(new FiveHundredWithdrawlHandler(new OneHundredWithdrawlHandler(null)));

            if(withdrawlHandler.applyChain(amount))
                System.out.println("Money deducted and withdrawn successfully");
            else
                System.out.println("Issue in deducting money please try later");
            ATM.getMachine().changeState(new SelectionState());
        }
    }
}
