package com.muriced.desafio_itau_backend.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.muriced.desafio_itau_backend.model.Transaction;

public class TransactionService {

    // Lógica para lidar com transações
    // Inclui métodos para criar, deletar e recuperar transações

    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    // Método para criar uma transação
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Método para recuperar as estatísticas das transações
    public DoubleSummaryStatistics getTransactionsStats() {
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
                .filter(transaction -> transaction.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }

    // Método para deletar transações
    public void clearTransactions() {
        transactions.clear();
    }

}
