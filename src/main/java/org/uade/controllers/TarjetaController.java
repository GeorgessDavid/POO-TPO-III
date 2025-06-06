package org.uade.controllers;

import org.uade.dtos.CardDTO;
import org.uade.dtos.CreditCardDTO;
import org.uade.dtos.DebitCardDTO;
import org.uade.exceptions.CardAlreadyRegisteredException;
import org.uade.models.CardModel;
import org.uade.models.CreditCardModel;
import org.uade.models.DebitCardModel;


import java.util.ArrayList;
import java.util.List;

public class TarjetaController {

    private static TarjetaController instance;
    private final List<CardModel> tarjetas;

    private TarjetaController() {
        this.tarjetas = new ArrayList<>();
    }

    public static TarjetaController getInstance() {
        if (instance == null) instance = new TarjetaController();

        return instance;
    }

    public CardModel buscarTarjeta(String numeroTarjeta) {
        for (CardModel tarjeta : tarjetas) {
            if (tarjeta.getCardNumber().equals(numeroTarjeta)) return tarjeta;
        }

        return null;
    }

    public void crearTarjeta(CardDTO card) {
        if (this.verifyByCardNumber(card.getCardNumber())) {
            throw new CardAlreadyRegisteredException("La tarjeta ya existe en el sistema.");
        }

        if (card instanceof CreditCardDTO) {
            CreditCardModel creditCard = new CreditCardModel(card.getName(), card.getLastname(), card.getCardNumber(), card.getCvc(), card.getExpiryDate(), ((CreditCardDTO) card).getTax(),card.getClient());
            this.tarjetas.add(creditCard);
            return;
        }

        if (card instanceof DebitCardDTO) {
            DebitCardModel debitCard = new DebitCardModel(card.getName(), card.getLastname(), card.getCardNumber(), card.getCvc(), card.getExpiryDate(), ((DebitCardDTO) card).getIva(), card.getClient());
            this.tarjetas.add(debitCard);
        }

    }

    private boolean verifyByCardNumber(String cardNumber){
        for (CardModel tarjeta : tarjetas) {
            if (tarjeta.getCardNumber().equals(cardNumber)) return true;
        }

        return false;
    }
}
