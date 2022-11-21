package com.margo.kata.service.impl;

import com.margo.kata.dao.TransactionRepository;
import com.margo.kata.dto.TransactionDTO;
import com.margo.kata.model.Transaction;
import com.margo.kata.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<TransactionDTO> getHistory() {
        return transactionRepository.findAll().stream().map(e -> {
            TransactionDTO dto = new TransactionDTO();
            dto.setBalanceAfter(e.getBalanceAfter());
            dto.setLabel(e.getLabel());
            dto.setTransactionDate(e.getTransactionDate());
            dto.setTransactionValue(e.getTransactionValue());
            return dto;
        }).collect(Collectors.toList());
    }
}
