package com.PagueloFacil.ChallengePagueloFacil.services.implement;

import com.PagueloFacil.ChallengePagueloFacil.model.Account;
import com.PagueloFacil.ChallengePagueloFacil.repositories.AccountRepository;
import com.PagueloFacil.ChallengePagueloFacil.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl  implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account getAccountByNumber(int number) {
        return accountRepository.findByNumber(number);
    }
}
