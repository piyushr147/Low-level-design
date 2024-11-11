package state;

import machine.ATM;
import operation.OperationType;

public class SelectionState extends ATMState {

    public SelectionState(){
        System.out.println("Kindly select your operation");
    }

    @Override
    public void selectOperation(OperationType operationType){
        System.out.println("selected");
        if(operationType == OperationType.BALANCE_CHECK)
            ATM.getMachine().changeState(new CheckBalanceState());
        if(operationType == OperationType.WITHDRAW)
            ATM.getMachine().changeState(new WithdrawlState());
        if(operationType == OperationType.DEPOSIT)
            ATM.getMachine().changeState(new DepositState());
    }

    @Override()
    public void cancelSelection(){
        ATM.getMachine().changeState(new IdealState());
    }
}
