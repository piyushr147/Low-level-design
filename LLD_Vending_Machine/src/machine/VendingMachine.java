package machine;

import controller.ProductController;
import states.State;
import states.concreteStateImpl.IdleState;

import java.util.Scanner;

public class VendingMachine {
    private State currentState;
    private int currentBalance;

    public VendingMachine(){
        currentState = new IdleState();
        currentBalance = 0;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void addBalance(int balance) {
        this.currentBalance += balance;
    }

    public void resetBalance() {
        this.currentBalance = 0;
    }
}
