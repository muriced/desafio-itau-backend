package com.muriced.desafio_itau_backend.model;

import java.time.OffsetDateTime;

import lombok.Getter;

/**
 * Modelo que representa uma transação financeira.
 * <p>
 * Contém o valor da transação e a data/hora em que ela ocorreu.
 * </p>
 */
@Getter
public class Transaction {

    /**
     * Valor da transação.
     */
    private Double valor;

    /**
     * Data e hora da transação no formato ISO 8601.
     */
    private OffsetDateTime dataHora;

    /**
     * Construtor para criar uma nova instância de Transaction.
     *
     * @param valor    valor da transação
     * @param dataHora data e hora da transação
     */
    public Transaction(final Double valor, final OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

}
