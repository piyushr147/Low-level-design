package card;

import java.util.Date;

public abstract class Card {
    private int cardNumber;
    private int cvv;
    private int expiryYear;
    private int expiryMonth;
    private int balance;
    private int pin;

    private Card(int cardNumber,int cvv,int expiryYear,int expiryMonth){
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public int getPin() {
        return pin;
    }

    public void changePin(int pin) {
        this.pin = pin;
    }

    public int getBalance(){
        return this.balance;
    }
}
