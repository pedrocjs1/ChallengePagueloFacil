package com.PagueloFacil.ChallengePagueloFacil.repositories;

import com.PagueloFacil.ChallengePagueloFacil.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
