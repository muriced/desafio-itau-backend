package com.muriced.desafio_itau_backend.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * DTO para requisição de criação de uma transação.
 * <p>
 * Contém os dados necessários para registrar uma nova transação,
 * incluindo o valor e a data/hora da transação.
 * Ambos os campos são obrigatórios.
 * </p>
 */
@Getter
public class TransactionRequest {

    @NotNull
    private double valor;

    @NotNull
    private OffsetDateTime dataHora;

}