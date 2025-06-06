package org.uade.models;
import java.util.List;

public class CreditCardModel extends CardModel {
    private double tax;

    public CreditCardModel(String name, String lastname, String cardNumber, String cvc, String expiryDate, double tax) {
        super(name, lastname, cardNumber, cvc, expiryDate);
        this.tax = tax;
    }



    @Override
    protected double calcularConsumo(List<ExpenseModel> consumos) {
        double consumo = this.sumarConsumos(consumos);
        double total = consumo * (this.tax + 1.00);

        return total;
    }
}
