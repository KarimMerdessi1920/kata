package com.margo.kata.controller;

import com.margo.kata.dto.TransactionDTO;
import com.margo.kata.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/clients/{clientId}/accounts/{iban}/history")
    public ResponseEntity<List<TransactionDTO>> checkHistory(@PathVariable("iban") String iban) {
        return ResponseEntity.ok().body(historyService.getHistory());
    }
}
