package org.uade.controllers;

import org.uade.models.CardModel;
import org.uade.models.ExpenseModel;

import java.util.ArrayList;
import java.util.List;

public class TarjetaController {

    private static TarjetaController INSTANCE;
    private List<CardModel> tarjetas;

    private TarjetaController(){
        this.tarjetas = new ArrayList<>();
    }

    public static TarjetaController getInstance(){
        if(INSTANCE == null) INSTANCE = new TarjetaController();

        return INSTANCE;
    }

    public void agregarConsumo(String cardNumber, String month, String year, double expense, String businessName){
        CardModel tarjeta = buscarTarjeta(cardNumber);
        if(tarjeta == null) return;

        ExpenseModel consumo = new ExpenseModel(tarjeta,expense,month,year,businessName);
        tarjeta.setConsumo(consumo);
    }

    public CardModel buscarTarjeta(String numeroTarjeta){

        for(int i = 0; i < tarjetas.size();i++){
            if(tarjetas.get(i).getCardNumber().equals(numeroTarjeta)) return tarjetas.get(i);
        }

        return null;
    }
}
