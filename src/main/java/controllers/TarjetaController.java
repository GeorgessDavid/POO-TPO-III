package controllers;

import models.classes.*;
import java.util.ArrayList;
import java.util.List;

public class TarjetaController {

    private static TarjetaController INSTANCE;
    private List<Card> tarjetas;

    private TarjetaController(){
        this.tarjetas = new ArrayList<>();
    }

    public static TarjetaController getInstance(){
        if(INSTANCE == null) INSTANCE = new TarjetaController();

        return INSTANCE;
    }

    public void agregarConsumo(String cardNumber, String month, String year, double expense, String businessName){
        Card tarjeta = buscarTarjeta(cardNumber);
        if(tarjeta == null) return;

        Expense consumo = new Expense(tarjeta,expense,month,year,businessName);
        tarjeta.setConsumo(consumo);
    }

    public Card buscarTarjeta(String numeroTarjeta){

        for(int i = 0; i < tarjetas.size();i++){
            if(tarjetas.get(i).getCardNumber().equals(numeroTarjeta)) return tarjetas.get(i);
        }

        return null;
    }
}
