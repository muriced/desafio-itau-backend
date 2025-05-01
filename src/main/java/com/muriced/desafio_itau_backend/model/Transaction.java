package com.muriced.desafio_itau_backend.model;

import java.time.OffsetDateTime;

import lombok.Getter;

@Getter
public class Transaction {

    private Double valor;
    private OffsetDateTime dataHora;

    public Transaction(final Double valor, final OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

}
