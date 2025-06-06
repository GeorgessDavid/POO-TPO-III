package org.uade.dtos;

import org.uade.models.ExpenseModel;
import java.util.List;

public class CreditCardDTO extends CardDTO {
    private double tax;

    public CreditCardDTO(String name, String lastname, String cardNumber, String cvc, String expiryDate, List<ExpenseModel> consumos, double tax) {
        super(name, lastname, cardNumber, cvc, expiryDate, consumos);
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }
}