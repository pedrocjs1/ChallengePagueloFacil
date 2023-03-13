package com.PagueloFacil.ChallengePagueloFacil.controller;


import com.PagueloFacil.ChallengePagueloFacil.dtos.ClientDTO;
import com.PagueloFacil.ChallengePagueloFacil.model.Account;
import com.PagueloFacil.ChallengePagueloFacil.model.Client;
import com.PagueloFacil.ChallengePagueloFacil.services.AccountService;
import com.PagueloFacil.ChallengePagueloFacil.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.PagueloFacil.ChallengePagueloFacil.utils.utils.randomNumber;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/clients")
    public List<ClientDTO> getClients() {
        return clientService.getAllClients();
    }


    @GetMapping("/clients/current")
    public ClientDTO getClientCurrent(Authentication authentication) {
        return new ClientDTO(clientService.getClientAuth(authentication));
    }


    @PostMapping("/createClient")
    public ResponseEntity<Object> register(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password
    ) {
        if (firstName.isEmpty()) {
            return new ResponseEntity<>("Missing firstName", HttpStatus.FORBIDDEN);
        }
        if (lastName.isEmpty()) {
            return new ResponseEntity<>("Missing lastName", HttpStatus.FORBIDDEN);
        }
        if (email.isEmpty()) {
            return new ResponseEntity<>("Missing email", HttpStatus.FORBIDDEN);
        }
        if (password.isEmpty()) {
            return new ResponseEntity<>("Missing password", HttpStatus.FORBIDDEN);
        }
        if (clientService.getClientByEmail(email) !=  null) {
            return new ResponseEntity<>("Email already in use", HttpStatus.FORBIDDEN);
        }

        Client client = new Client(firstName, lastName, email, passwordEncoder.encode(password));
        clientService.saveClient(client);
        Account account = new Account(randomNumber(10000,99999), LocalDateTime.now(), 200, client, true);
        accountService.saveAccount(account);
        return new ResponseEntity<>("Client Created", HttpStatus.CREATED);
    }




}
