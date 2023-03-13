package com.PagueloFacil.ChallengePagueloFacil.dtos;

import com.PagueloFacil.ChallengePagueloFacil.model.Client;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {

    private Set<AccountDTO> accountDTO;

    private long id;

    private String firstName, lastName, email;

    public ClientDTO(Client client){
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.accountDTO = client.getAccounts().stream().map(account -> new AccountDTO(account)).collect(Collectors.toSet());

    }

    public Set<AccountDTO> getAccountDTO() {
        return accountDTO;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
