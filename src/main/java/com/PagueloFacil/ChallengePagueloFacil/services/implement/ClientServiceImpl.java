package com.PagueloFacil.ChallengePagueloFacil.services.implement;

import com.PagueloFacil.ChallengePagueloFacil.dtos.ClientDTO;
import com.PagueloFacil.ChallengePagueloFacil.model.Client;
import com.PagueloFacil.ChallengePagueloFacil.repositories.ClientRepository;
import com.PagueloFacil.ChallengePagueloFacil.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public Client getClientAuth(Authentication authentication) {
        return clientRepository.findByEmail(authentication.getName());
    }

    @Override
    public ClientDTO getClientById(Long id) {
        return clientRepository.findById(id).map(client -> new ClientDTO(client)).orElse(null);
    }


}
