package org.uade.models;
import java.util.List;

public class CreditCardModel extends CardModel {
    private double tax;

    public CreditCardModel(String name, String lastname, String cardNumber, String cvc, String expiryDate, double tax, ClientModel client) {
        super(name, lastname, cardNumber, cvc, expiryDate, client);
        this.tax = tax;
    }

    @Override
    public double calcularConsumo(List<ExpenseModel> consumos) {
        double consumo = this.sumarConsumos(consumos);
        double impuestos = this.tax + 1.00;

        return consumo * impuestos;
    }

    @Override
    public double calcularConsumoRealMes(List<ExpenseModel> consumos, String year, String month) {
        double impuestos = this.tax + 1.00;
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
