package org.uade.models;

import java.util.List;

public class DebitCardModel extends CardModel {
    private double iva = 0.21;

    public DebitCardModel(String name, String lastname, String cardNumber, String cvc, String expiryDate, double iva) {
        super(name, lastname, cardNumber, cvc, expiryDate);
        this.iva = iva;
    }


    @Override
    protected double calcularConsumo(List<ExpenseModel> consumoTotal) {
        double consumos = this.sumarConsumos(consumoTotal);
        double descuentoIva = 1.00 - iva; // 1.00 - 0.21 -> 0.79.

        return consumos * descuentoIva;
    }
}
