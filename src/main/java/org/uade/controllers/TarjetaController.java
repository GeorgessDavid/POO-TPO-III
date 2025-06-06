package org.uade.controllers;

import org.uade.dtos.CardDTO;
import org.uade.dtos.CreditCardDTO;
import org.uade.dtos.DebitCardDTO;
import org.uade.exceptions.CardNotFoundException;
import org.uade.models.CardModel;
import org.uade.models.CreditCardModel;
import org.uade.models.DebitCardModel;
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

    public void crearTarjeta(CardDTO card) {
        if (this.verifyByCardNumber(card.getCardNumber())) {
            throw new CardAlreadyRegisteredException("La tarjeta ya existe en el sistema.");
        }

        if (card instanceof CreditCardDTO) {
            CreditCardModel creditCard = new CreditCardModel(card.getName(), card.getLastname(), card.getCardNumber(), card.getCvc(), card.getExpiryDate(), ((CreditCardDTO) card).getTax());
            this.tarjetas.add(creditCard);
            return;
        }

        if (card instanceof DebitCardDTO) {
            DebitCardModel debitCard = new DebitCardModel(card.getName(), card.getLastname(), card.getCardNumber(), card.getCvc(), card.getCvc(), ((DebitCardDTO) card).getIva());
            this.tarjetas.add(debitCard);
            return;
        }

    }


    private boolean verifyByCardNumber(String cardNumber){
        for(int i = 0; i < tarjetas.size();i++){
            if(tarjetas.get(i).getCardNumber().equals(cardNumber)) return true;
        }
        return false;
    }
}
