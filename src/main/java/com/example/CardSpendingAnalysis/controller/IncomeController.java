package com.example.CardSpendingAnalysis.controller;

import com.example.CardSpendingAnalysis.model.Income;
import com.example.CardSpendingAnalysis.model.Transactions;
import com.example.CardSpendingAnalysis.repository.IncomeRepository;
import com.example.CardSpendingAnalysis.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class IncomeController {
    @Autowired
    IncomeRepository incomeRepository;

    @GetMapping("/income")
    public String findAll(Model model) {
        List<Income> incomes = incomeRepository.findAll();
        Collections.sort(incomes, new Comparator<Income>() {
            @Override
            public int compare(Income o1, Income o2) {
                return o1.incomeDate.compareTo(o2.incomeDate);
            }
        });
        model.addAttribute("income", incomes);
        double sum =0;
        for (int i = 0; i < incomes.size(); i++) {
            sum+=incomes.get(i).incomeSum;
        }
        model.addAttribute("sum",  String.format( "%.2f", sum));
        return "income";
    }

    @GetMapping("/delete-income")
    public String delete(@RequestParam int id) {
        incomeRepository.deleteById(id);
        return "redirect:income";
    }

    @GetMapping("/add-income")
    public String add() {
        return "add-income";
    }

    @PostMapping("/add-income")
    public String add(@ModelAttribute Income income) {
        incomeRepository.save(income);
        return "redirect:income";
    }

    @GetMapping("/update-income")
    public String update(@RequestParam int id, Model model) {
        Income income = incomeRepository.findById(id).get();
        model.addAttribute("income", income);
        return "update-income";
    }

    @PostMapping("/update-income")
    public String update(@ModelAttribute Income income) {
        incomeRepository.save(income);
        return "redirect:income";
    }
}
