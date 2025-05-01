package com.muriced.desafio_itau_backend.dto;

import java.util.DoubleSummaryStatistics;

import lombok.Getter;

/**
 * DTO para resposta de estatísticas de transações.
 * <p>
 * Contém informações como soma, média, mínimo, máximo e quantidade de transações,
 * todas formatadas para dois dígitos após o ponto decimal.
 * </p>
 */
@Getter
public class StatisticResponse {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    /**
     * Constrói um StatisticResponse a partir de um DoubleSummaryStatistics.
     * Os valores de soma, média, mínimo e máximo são arredondados para dois dígitos decimais.
     *
     * @param statistics estatísticas das transações
     */
    public StatisticResponse(DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.sum = roundToTwoDecimals(statistics.getSum());
        this.avg = roundToTwoDecimals(statistics.getAverage());
        this.min = roundToTwoDecimals(statistics.getMin());
        this.max = roundToTwoDecimals(statistics.getMax());
    }

    /**
     * Arredonda um valor double para dois dígitos decimais.
     *
     * @param value valor a ser arredondado
     * @return valor arredondado com duas casas decimais
     */
    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
