package com.example.service;

import com.example.model.Transaction;
import com.example.repository.TransactionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TransactionService {

    @Inject
    TransactionRepository repository;

    @Transactional
    public Transaction process(String message) {
        // Format pesan: product,quantity,price
        String[] parts = message.split(",");
        if (parts.length < 3) return null;

        Transaction tx = new Transaction();
        tx.product = parts[0];
        tx.quantity = Integer.parseInt(parts[1]);
        tx.price = Integer.parseInt(parts[2]);
        tx.total = tx.quantity * tx.price;

        repository.persist(tx);
        return tx;
    }
}
