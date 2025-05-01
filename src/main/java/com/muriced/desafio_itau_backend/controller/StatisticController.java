package com.muriced.desafio_itau_backend.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muriced.desafio_itau_backend.dto.StatisticResponse;
import com.muriced.desafio_itau_backend.service.TransactionService;

/**
 * Controller responsável por fornecer estatísticas das transações financeiras.
 * <p>
 * Disponibiliza endpoint para consulta de estatísticas agregadas das transações registradas.
 * </p>
 */
@RestController
@RequestMapping("/estatisticas")
public class StatisticController {

    private final TransactionService transactionService;

    /**
     * Construtor para injeção do serviço de transações.
     *
     * @param transactionService serviço responsável pela lógica de transações
     */
    public StatisticController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Endpoint para obter as estatísticas das transações.
     * <p>
     * Retorna soma, média, mínimo, máximo e quantidade de transações dos últimos 60 segundos.
     * </p>
     *
     * @return ResponseEntity contendo o objeto StatisticResponse com os dados estatísticos
     */
    @GetMapping
    public ResponseEntity<StatisticResponse> getStatistics() {
        DoubleSummaryStatistics statistics = transactionService.getTransactionsStats();
        return ResponseEntity.ok(new StatisticResponse(statistics));
    }

}
