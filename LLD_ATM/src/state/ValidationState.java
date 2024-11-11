package state;

import card.Card;
import card.CardReciever;
import machine.ATM;

import java.util.Date;
import java.util.Scanner;

public class ValidationState extends ATMState {

    public ValidationState(){
        System.out.println("card is getting validated");
    }

    @Override
    public void authenticate(){
        Card card = CardReciever.getInstance().getCard();
        int currYear = new Date().getYear();
        int currMonth = new Date().getMonth();
        if(currYear > card.getExpiryYear()){
            System.out.println("This card has expired");
            ATM.getMachine().changeState(new IdealState());
        }
        else{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your pin: ");
            int number = scanner.nextInt();

            if(number != card.getPin()){
                System.out.println("Wrong pin extered");
                ATM.getMachine().changeState(new IdealState());
            }
            else{
                System.out.println("Validation done");
                ATM.getMachine().changeState(new SelectionState());
            }
        }
    }
}
