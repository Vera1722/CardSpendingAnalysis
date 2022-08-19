package com.example.CardSpendingAnalysis.controller;

import com.example.CardSpendingAnalysis.model.Transactions;
import com.example.CardSpendingAnalysis.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/transactions")
    public String findAll(Model model) {
        List<Transactions> transactions = transactionRepository.findAll();
        Collections.sort(transactions, new Comparator<Transactions>() {
            @Override
            public int compare(Transactions o1, Transactions o2) {
                return o1.transactionDate.compareTo(o2.transactionDate);
            }
        });
        model.addAttribute("transactions", transactions);
        double sum = 0;
        for (int i = 0; i < transactions.size(); i++) {
            sum += transactions.get(i).transactionSum;
        }
        model.addAttribute("sum", String.format("%.2f", sum));
        return "transactions";
    }

    @GetMapping("/delete-transaction")
    public String delete(@RequestParam int id) {
        transactionRepository.deleteById(id);
        return "redirect:transactions";
    }

    @GetMapping("/add-transaction")
    public String add() {
        return "add-transaction";
    }

    @PostMapping("/add-transaction")
    public String add(@ModelAttribute Transactions transactions) {
        transactionRepository.save(transactions);
        return "redirect:transactions";
    }

    @GetMapping("/update-transaction")
    public String update(@RequestParam int id, Model model) {
        Transactions transactions = transactionRepository.findById(id).get();
        model.addAttribute("transactions", transactions);
        return "update-transaction";
    }

    @PostMapping("/update-transaction")
    public String update(@ModelAttribute Transactions transactions) {
        transactionRepository.save(transactions);
        return "redirect:transactions";
    }
}
