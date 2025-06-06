package org.uade.models;

import java.util.ArrayList;
import java.util.List;


public abstract class CardModel {

    private final ClientModel client;
    private final String name;
    private final String lastname;
    private final String cardNumber;
    private final String cvc;
    private String expiryDate;
    private final List<ExpenseModel> consumos;

    public CardModel(String name, String lastname, String cardNumber, String cvc, String expiryDate, ClientModel client) {
        this.name = name;
        this.lastname = lastname;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expiryDate = expiryDate;
        this.client = client;
        consumos = new ArrayList<>();
    }

    protected abstract double calcularConsumo(List<ExpenseModel> consumoTotal);
    public abstract double calcularConsumoRealMes(List<ExpenseModel> consumos, String year, String month);

    protected double sumarConsumos(List<ExpenseModel> consumos){
        if (consumos.isEmpty()) return 0.00;
        double consumoTotal= 0.00;

        for (ExpenseModel expenseModel : consumos) {
            double consumo = expenseModel.getExpense();
            consumoTotal += consumo;
        }

        return consumoTotal;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public List<ExpenseModel> getConsumos() {
        return consumos;
    }

    public ClientModel getClient(){ return client; }

    public void setConsumo(ExpenseModel consumo) {
        consumos.add(consumo);
    }
}