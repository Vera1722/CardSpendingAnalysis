package com.example.CardSpendingAnalysis.repository;

import com.example.CardSpendingAnalysis.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
    }
