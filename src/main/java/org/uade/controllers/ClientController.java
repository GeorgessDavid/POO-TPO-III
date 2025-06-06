package org.uade.controllers;

import org.uade.exceptions.ClientAlreadyRegisteredException;
import org.uade.models.ClientModel;
import org.uade.dtos.ClientDTO;

import java.util.ArrayList;
import java.util.List;

public class ClientController {

    private static ClientController instance;
    private List<ClientModel> clientes;

    private ClientController() {
        clientes = new ArrayList<>();
    }

    public static ClientController getInstance() {
        if(instance == null) instance = new ClientController();

        return instance;
    }

    public void agregarCliente(ClientDTO client){
        if(clienteExiste(client.getDni())) throw new ClientAlreadyRegisteredException("El cliente ya existe en el sistema");

        ClientModel newClient = new ClientModel(client.getName(),client.getLastName(),client.getDni());
        clientes.add(newClient);
    }

    private boolean clienteExiste(int dni){

        for(ClientModel cliente : clientes){
            if(cliente.getDni() == dni) return true;
        }

        return false;
    }
}
