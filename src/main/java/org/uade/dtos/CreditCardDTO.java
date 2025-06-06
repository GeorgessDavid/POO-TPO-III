package org.uade.dtos;

import org.uade.models.ClientModel;
import org.uade.models.ExpenseModel;
import java.util.List;

public class CreditCardDTO extends CardDTO {
    private final double tax;

    public CreditCardDTO(String name, String lastname, String cardNumber, String cvc, String expiryDate, List<ExpenseModel> consumos, double tax, ClientModel client) {
        super(name, lastname, cardNumber, cvc, expiryDate, consumos, client);
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }
}