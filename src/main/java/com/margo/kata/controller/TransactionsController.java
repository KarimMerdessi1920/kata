package com.margo.kata.controller;

import com.margo.kata.dto.TransactionResponse;
import com.margo.kata.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {

    @Autowired
    TransactionsService transactionsService;

    @PostMapping("/clients/{clientId}/accounts/{iban}/withdraw")
    public ResponseEntity<TransactionResponse> withdraw(@PathVariable("clientId") String clientId, @PathVariable("iban") String iban,
                                                        @RequestParam("amount") double amount) {
        boolean response = transactionsService.withdraw(amount, iban);
        if (response) {
            return ResponseEntity.ok().body(new TransactionResponse("Withdrawal", "Withdrawal of an Amount of " + amount + " has been done successfully"));
        } else {
            return ResponseEntity.badRequest().body(new TransactionResponse("Withdrawal", "Withdrawal failure"));
        }
    }

    @PostMapping("/clients/{clientId}/accounts/{iban}/save")
    public ResponseEntity<TransactionResponse> save(@PathVariable("clientId") String clientId, @PathVariable("iban") String iban,
                                                    @RequestParam("amount") double amount, @RequestParam("label") String label) {
        transactionsService.save(amount, iban, label);
        return ResponseEntity.ok().body(new TransactionResponse("Savings", "Saving of an Amount of " + amount + " has been done successfully"));
    }
}
