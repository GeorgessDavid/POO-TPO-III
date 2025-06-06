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
        double consumo = this.calcularConsumo(consumoTotal);
        double total = (1.00 - iva) * consumo;
//        1.00 - iva sería 1.00 - 0.21, lo que quedaría 0.79 que, al multiplicarlo por el consumo total se descuenta como tal.
        return total;
    }
}
