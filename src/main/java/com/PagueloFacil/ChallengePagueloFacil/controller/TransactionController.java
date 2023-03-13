package com.PagueloFacil.ChallengePagueloFacil.controller;


import com.PagueloFacil.ChallengePagueloFacil.enums.TransactionType;
import com.PagueloFacil.ChallengePagueloFacil.model.Account;
import com.PagueloFacil.ChallengePagueloFacil.model.Client;
import com.PagueloFacil.ChallengePagueloFacil.model.Transaction;
import com.PagueloFacil.ChallengePagueloFacil.services.AccountService;
import com.PagueloFacil.ChallengePagueloFacil.services.ClientService;
import com.PagueloFacil.ChallengePagueloFacil.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;
    @Autowired
    private TransactionService transactionService;

    @Transactional
    @PostMapping("/transactions")
    public ResponseEntity<Object> createTransaction(Authentication authentication,
                                                    @RequestParam String description,
                                                    @RequestParam Double amount,
                                                    @RequestParam int originAccountNumber,
                                                    @RequestParam int targetAccountNumber) {


        Client client = clientService.getClientAuth(authentication);
        Account originAccount = accountService.getAccountByNumber(originAccountNumber);
        Account targetAccount = accountService.getAccountByNumber(targetAccountNumber);

        if (description.isEmpty() || amount == null || amount.isNaN()) {
            return new ResponseEntity<>("Invalid amount", HttpStatus.FORBIDDEN);
        }
        if (amount <= 0) {
            return new ResponseEntity<>("Invalid amount", HttpStatus.FORBIDDEN);
        }

        if (originAccountNumber == targetAccountNumber) {
            return new ResponseEntity<>("Cannot transfer to own account", HttpStatus.FORBIDDEN);
        }

        if (originAccount == null) {
            return new ResponseEntity<>("Invalid origin account", HttpStatus.FORBIDDEN);
        }

        if (targetAccount == null) {
            return new ResponseEntity<>("Invalid target account", HttpStatus.FORBIDDEN);
        }

        if (!client.getAccounts().contains(originAccount)) {
            return new ResponseEntity<>("You are not the account owner", HttpStatus.FORBIDDEN);
        }

        if (originAccount.getBalance() < amount) {
            return new ResponseEntity<>("You don't have enough balance", HttpStatus.FORBIDDEN);
        }

        if (originAccount == targetAccount) {
            return new ResponseEntity<>("Invalid target account", HttpStatus.FORBIDDEN);
        }

        originAccount.setBalance(originAccount.getBalance() - amount);
        Transaction transactionDebit = new Transaction(TransactionType.DEBIT,
                amount,
                "Transfer sent to " + targetAccountNumber + " - " + description,
                LocalDateTime.now(),
                originAccount);

        targetAccount.setBalance(targetAccount.getBalance() + amount);
        Transaction transactionCredit = new Transaction(TransactionType.CREDIT,
                amount,
                "Transfer received from " + originAccountNumber + " - " + description,
                LocalDateTime.now(),
                targetAccount);

        transactionService.saveTransaction(transactionDebit);
        transactionService.saveTransaction(transactionCredit);

        accountService.saveAccount(originAccount);
        accountService.saveAccount(targetAccount);

        return new ResponseEntity<>("Transaction success", HttpStatus.CREATED);

    }
}
