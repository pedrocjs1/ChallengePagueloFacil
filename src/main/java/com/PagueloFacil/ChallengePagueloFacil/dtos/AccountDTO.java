package com.PagueloFacil.ChallengePagueloFacil.dtos;

import com.PagueloFacil.ChallengePagueloFacil.model.Account;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO {

    private long id;

    private Boolean active;
    private int number;

    private LocalDateTime creationDate;
    private double balance;
    private Set<TransactionDTO> transactions;
    public AccountDTO(Account account){
        this.id = account.getId();
        this.number = account.getNumber();
        this.creationDate = account.getCreationDate();
        this.transactions = account.getTransactions().stream().map(transaction -> new TransactionDTO(transaction)).collect(Collectors.toSet());
        this.active = account.getActive();
        this.balance = account.getBalance();
    }

    public long getId() {
        return id;
    }

    public Boolean getActive() {
        return active;
    }

    public int getNumber() {
        return number;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Set<TransactionDTO> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }
}
