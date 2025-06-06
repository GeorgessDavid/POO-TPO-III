package org.uade.models;

import java.util.List;

public class DebitCardModel extends CardModel {
    private final double iva;

    public DebitCardModel(String name, String lastname, String cardNumber, String cvc, String expiryDate, double iva, ClientModel client) {
        super(name, lastname, cardNumber, cvc, expiryDate,client);
        this.iva = iva;
    }


    @Override
    public double calcularConsumo(List<ExpenseModel> consumoTotal) {
        double descuentoIva = 1.00 - iva;
        double consumos = this.sumarConsumos(consumoTotal);

        return consumos * descuentoIva;
    }

    @Override
    public double calcularConsumoRealMes(List<ExpenseModel> consumos, String year, String month) {
        double descuentoIva = 1.00 - iva;
        double consumoTotal = 0.00;

        for (ExpenseModel consumo : consumos) {
            if (consumo.getYear().equals(year) && consumo.getMonth().equals(month)) {
                consumoTotal += consumo.getExpense();
            }
        }

        return consumoTotal * descuentoIva;
    }
}
