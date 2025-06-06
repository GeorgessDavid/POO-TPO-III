package org.uade.models;

import java.util.ArrayList;
import java.util.List;


public abstract class CardModel {
    String name;
    String lastname;
    String cardNumber;
    String cvc;
    String expiryDate;
    List<ExpenseModel> consumos;

    public CardModel(String name, String lastname, String cardNumber, String cvc, String expiryDate) {
        this.name = name;
        this.lastname = lastname;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expiryDate = expiryDate;
        consumos = new ArrayList<>();
    }

    protected abstract double calcularConsumo(List<ExpenseModel> consumoTotal);

    protected double sumarConsumos(List<ExpenseModel> consumos){
        if(consumos.isEmpty()) return 0.00;

        double consumoTotal= 0.00;
        for(int i = 0; i < consumos.size(); i++){
            double consumo = consumos.get(i).getExpense();
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

    public void setConsumo(ExpenseModel consumo) {
        consumos.add(consumo);
    }
}