package com.example.CardSpendingAnalysis.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date incomeDate;
    public double incomeSum;
    public String incomeDescription;

    public Income() {
    }

    public Income(int id) {
        this.id = id;
    }

    public Income(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public Income(double incomeSum) {
        this.incomeSum = incomeSum;
    }

    public Income(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    public Income(int id, Date incomeDate, double incomeSum, String incomeDescription) {
        this.id = id;
        this.incomeDate = incomeDate;
        this.incomeSum = incomeSum;
        this.incomeDescription = incomeDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public double getIncomeSum() {
        return incomeSum;
    }

    public void setIncomeSum(double incomeSum) {
        this.incomeSum = incomeSum;
    }

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", incomeDate=" + incomeDate +
                ", incomeSum=" + incomeSum +
                ", incomeDescription='" + incomeDescription + '\'' +
                '}';
    }
}
