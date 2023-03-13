package com.PagueloFacil.ChallengePagueloFacil.dtos;

import com.PagueloFacil.ChallengePagueloFacil.enums.TransactionType;
import com.PagueloFacil.ChallengePagueloFacil.model.Transaction;

import java.time.LocalDateTime;

public class TransactionDTO {

    private long id;

    private TransactionType type;
    private double amount;
    private String description;
    private LocalDateTime date;


    public TransactionDTO() {
    }

    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.amount = transaction.getAmount();
        this.date = transaction.getDate();
        this.description = transaction.getDescription();
        this.type = transaction.getType();

    }

    public long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
