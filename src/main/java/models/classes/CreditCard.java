package models.classes;
import java.util.List;

public class CreditCard extends Card{
    private double tax;

    public CreditCard(String name, String lastname, String cardNumber, String cvc, String expiryDate, double tax) {
        super(name, lastname, cardNumber, cvc, expiryDate);
        this.tax = tax;
    }



    @Override
    protected double calcularConsumo(List<Expense> consumos) {
        double consumo = this.sumarConsumos(consumos);
        double total = consumo * (this.tax + 1.00);

        return total;
    }
}
