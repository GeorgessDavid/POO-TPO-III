package org.uade.dtos;

import org.uade.models.ExpenseModel;
import java.util.List;

public class DebitCardDTO extends CardDTO {
    private double iva;

    public DebitCardDTO(String name, String lastname, String cardNumber, String cvc, String expiryDate, List<ExpenseModel> consumos, double iva) {
        super(name, lastname, cardNumber, cvc, expiryDate, consumos);
        this.iva = iva;
    }

    public double getIva() {
        return iva;
    }
}