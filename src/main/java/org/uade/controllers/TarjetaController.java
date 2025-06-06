package org.uade.controllers;

import org.uade.models.CardModel;
import org.uade.models.CreditCardModel;
import org.uade.models.ExpenseModel;
import org.uade.exceptions.CardNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class TarjetaController {

    private static TarjetaController INSTANCE;
    private List<CardModel> tarjetas;

    private TarjetaController() {
        this.tarjetas = new ArrayList<>();
    }

    public static TarjetaController getInstance() {
        if (INSTANCE == null) INSTANCE = new TarjetaController();

        return INSTANCE;
    }

    public void agregarConsumo(String cardNumber, String month, String year, double expense, String businessName) {
        CardModel tarjeta = buscarTarjeta(cardNumber);

        ExpenseModel consumo = new ExpenseModel(tarjeta, expense, month, year, businessName);
        if (tarjeta == null) {
            throw new CardNotFoundException(cardNumber);
        }
        tarjeta.setConsumo(consumo);
    }

    public CardModel buscarTarjeta(String numeroTarjeta) {

        for (int i = 0; i < tarjetas.size(); i++) {
            if (tarjetas.get(i).getCardNumber().equals(numeroTarjeta)) return tarjetas.get(i);
        }

        return null;
    }

    public void crearTarjetaCredito(String name, String lastname, String cardNumber, String cvc, String expiryDate, double tax) {
        if (this.verifyByCardNumber(cardNumber)) {
            throw new IllegalArgumentException("La tarjeta ya existe en el sistema.");
        }
        CreditCardModel creditCard = new CreditCardModel(name, lastname, cardNumber, cvc, expiryDate, tax);
        this.tarjetas.add(creditCard);

    }

    private boolean verifyByCardNumber(String cardNumber) {
        for (int i = 0; i < tarjetas.size(); i++) {
            if (tarjetas.get(i).getCardNumber().equals(cardNumber)) return true;
        }
        return false;
    }
}
