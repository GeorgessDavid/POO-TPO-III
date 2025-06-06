package org.uade.controllers;

import org.uade.dtos.ExpenseDTO;
import org.uade.exceptions.CardNotFoundException;
import org.uade.models.CardModel;
import org.uade.models.ExpenseModel;

public class ConsumoController {

    private static ConsumoController instance;
    private final TarjetaController tarjetaController;

    private ConsumoController() {
        this.tarjetaController = TarjetaController.getInstance();
    }

    public static ConsumoController getInstance() {
        if (instance == null) instance = new ConsumoController();

        return instance;
    }

    public double calcularConsumoRealMes(String numeroTarjeta, String month, String year){
        CardModel card = tarjetaController.buscarTarjeta(numeroTarjeta);

        if(card == null) throw new CardNotFoundException("La tarjeta no existe en el sistema");

        return card.calcularConsumoRealMes(card.getConsumos(),month, year);
    }

    public void agregarConsumo(String cardNumber, ExpenseDTO expense) {
        CardModel tarjeta = tarjetaController.buscarTarjeta(cardNumber);

        if (tarjeta == null) {
            throw new CardNotFoundException(cardNumber);
        }

        ExpenseModel consumo = new ExpenseModel(expense.getCard(), expense.getExpense(), expense.getMonth(), expense.getYear(), expense.getPlace());
        tarjeta.setConsumo(consumo);
    }

}
