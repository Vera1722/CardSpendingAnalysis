package com.example.CardSpendingAnalysis.repository;
import com.example.CardSpendingAnalysis.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Integer> {
}
