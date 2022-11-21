package com.margo.kata.service;

import com.margo.kata.dto.TransactionDTO;

import java.util.List;

public interface HistoryService {

    List<TransactionDTO> getHistory();
}
