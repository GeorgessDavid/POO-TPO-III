package org.uade.dtos;

import org.uade.models.ClientModel;
import org.uade.models.ExpenseModel;
import java.util.List;

public class DebitCardDTO extends CardDTO {
    private double iva;

    public DebitCardDTO(String name, String lastname, String cardNumber, String cvc, String expiryDate, List<ExpenseModel> consumos, double iva, ClientModel client) {
        super(name, lastname, cardNumber, cvc, expiryDate, consumos, client);
        this.iva = iva;
    }

    public double getIva() {
        return iva;
    }
}