package com.example.CardSpendingAnalysis.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date transactionDate;
    public double transactionSum;
    public String transactionCategory;

    public Transactions() {
    }

    public Transactions(int id) {
        this.id = id;
    }

    public Transactions(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Transactions(double transactionSum) {
        this.transactionSum = transactionSum;
    }

    public Transactions(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public Transactions(int id, Date transactionDate, double transactionSum, String transactionCategory) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.transactionSum = transactionSum;
        this.transactionCategory = transactionCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionSum() {
        return transactionSum;
    }

    public void setTransactionSum(double transactionSum) {
        this.transactionSum = transactionSum;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", transactionDate=" + transactionDate +
                ", transactionSum=" + transactionSum +
                ", transactionCategory='" + transactionCategory + '\'' +
                '}';
    }
}
