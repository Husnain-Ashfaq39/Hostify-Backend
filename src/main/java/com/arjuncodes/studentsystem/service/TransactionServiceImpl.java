package com.arjuncodes.studentsystem.service.impl;

import com.arjuncodes.studentsystem.model.Transaction;
import com.arjuncodes.studentsystem.repository.TransactionRepository;
import com.arjuncodes.studentsystem.service.TransactionService;
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
