package org.uade.dtos;

import org.uade.models.ExpenseModel;
import java.util.List;

public class CardDTO {
    private String name;
    private String lastname;
    private String cardNumber;
    private String cvc;
    private String expiryDate;
    private List<ExpenseModel> consumos;

    public CardDTO(String name, String lastname, String cardNumber, String cvc, String expiryDate, List<ExpenseModel> consumos) {
        this.name = name;
        this.lastname = lastname;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expiryDate = expiryDate;
        this.consumos = consumos;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public List<ExpenseModel> getConsumos() {
        return consumos;
    }
}
