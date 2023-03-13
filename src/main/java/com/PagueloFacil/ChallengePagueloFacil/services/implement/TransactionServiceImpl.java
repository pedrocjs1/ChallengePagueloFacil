package com.PagueloFacil.ChallengePagueloFacil.services.implement;

import com.PagueloFacil.ChallengePagueloFacil.model.Transaction;
import com.PagueloFacil.ChallengePagueloFacil.repositories.TransactionRepository;
import com.PagueloFacil.ChallengePagueloFacil.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
