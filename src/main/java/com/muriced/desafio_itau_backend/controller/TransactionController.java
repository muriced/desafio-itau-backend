package com.muriced.desafio_itau_backend.controller;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muriced.desafio_itau_backend.dto.TransactionRequest;
import com.muriced.desafio_itau_backend.model.Transaction;
import com.muriced.desafio_itau_backend.service.TransactionService;

import jakarta.validation.Valid;

/**
 * Controller responsável pelo gerenciamento das transações financeiras.
 * <p>
 * Disponibiliza endpoints para criação e remoção de transações.
 * </p>
 */
@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    /**
     * Construtor para injeção do serviço de transações.
     *
     * @param transactionService serviço responsável pela lógica de transações
     */
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Endpoint para criar uma nova transação.
     * <p>
     * Retorna 201 caso a transação seja criada com sucesso.
     * Retorna 422 caso a data seja futura ou o valor seja menor ou igual a zero.
     * </p>
     *
     * @param request dados da transação a ser criada
     * @return ResponseEntity sem corpo, apenas com o status HTTP
     */
    @PostMapping
    public ResponseEntity<Void> addTransaction(@Valid @RequestBody TransactionRequest request) {
        if (request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0) {
            return ResponseEntity.unprocessableEntity().build();
        }

        transactionService.addTransaction(new Transaction(request.getValor(), request.getDataHora()));
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();

    }

    /**
     * Endpoint para remover todas as transações registradas.
     * <p>
     * Retorna 200 em caso de sucesso.
     * </p>
     *
     * @return ResponseEntity sem corpo, apenas com o status HTTP
     */
    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        transactionService.clearTransactions();
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }

}
