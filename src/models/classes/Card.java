package models.classes.card;
import models.enums.CardType;

public abstract class Card{
    String name;
    String lastname;
    String cardNumber;
    String cvc;
    String expiryDate;
    CardType type;

    public Card(String name, String lastname, String cardNumber, String cvc, String expiryDate) {
        this.name = name;
        this.lastname = lastname;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expiryDate = expiryDate;
        this.type = type;
    }

    public int calculateExpenses()
}