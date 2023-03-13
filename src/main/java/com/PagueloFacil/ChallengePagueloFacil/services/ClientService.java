package com.PagueloFacil.ChallengePagueloFacil.services;

import com.PagueloFacil.ChallengePagueloFacil.dtos.ClientDTO;
import com.PagueloFacil.ChallengePagueloFacil.model.Client;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ClientService {

    void saveClient(Client client);

    List<ClientDTO> getAllClients();

    Client getClientByEmail(String email);

    Client getClientAuth(Authentication authentication);
}
