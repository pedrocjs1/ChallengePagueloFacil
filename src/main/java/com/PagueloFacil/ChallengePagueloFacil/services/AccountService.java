package com.PagueloFacil.ChallengePagueloFacil.services;

import com.PagueloFacil.ChallengePagueloFacil.model.Account;

public interface AccountService {

    void saveAccount(Account account);

    Account getAccountByNumber(int number);
}
