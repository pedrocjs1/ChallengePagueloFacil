package com.PagueloFacil.ChallengePagueloFacil.repositories;


import com.PagueloFacil.ChallengePagueloFacil.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByNumber(int number);
}
