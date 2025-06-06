package org.uade.models;

import java.util.List;

public class DebitCardModel extends CardModel {
    private double iva = 0.21;

    public DebitCardModel(String name, String lastname, String cardNumber, String cvc, String expiryDate, double iva, ClientModel client) {
        super(name, lastname, cardNumber, cvc, expiryDate,client);
        this.iva = iva;
    }


    @Override
    public double calcularConsumo(List<ExpenseModel> consumoTotal) {
        double consumos = this.sumarConsumos(consumoTotal);
        double descuentoIva = 1.00 - iva; // 1.00 - 0.21 -> 0.79.

        return consumos * descuentoIva;
    }

    @Override
    public double calcularConsumoRealMes(List<ExpenseModel> consumos, String year, String month) {
        double impuestos = 1.00 - iva;
        double consumoTotal = 0.00;

        for(int i = 0; i < consumos.size();i++){
            ExpenseModel consumo = consumos.get(i);
            if(consumo.getYear().equals(year) && consumo.getMonth().equals(month)){
                consumoTotal += consumo.getExpense();
            }
        }

        return consumoTotal * impuestos;
    }
}
