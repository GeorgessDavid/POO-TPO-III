package models.controller;

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

    public Card buscarTarjeta(String numeroTarjeta){

        for(int i = 0; i < tarjetas.size();i++){
            if(tarjetas.get(i).getCardNumber().equals(numeroTarjeta)) return tarjetas.get(i);
        }

        return null;
    }
}
