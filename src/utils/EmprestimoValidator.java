package utils;

import exceptions.EmprestimoException;

import java.time.LocalDateTime;

/**
 * Utilitário para validação de regras relacionadas a empréstimos.
 */
public class EmprestimoValidator {

    /**
     * Valida a data de devolução de um empréstimo.
     *
     * @param dataDevolucao A data de devolução a ser validada.
     * @throws EmprestimoException Se a data de devolução for inválida.
     */
    public static void validar(LocalDateTime dataDevolucao) {
        LocalDateTime dataAtual = LocalDateTime.now();

        if (dataDevolucao.isBefore(dataAtual)) {
            throw new EmprestimoException("Data de devolução não pode ser menor que a data atual.");
        }

        if (dataDevolucao.isAfter(dataAtual.plusMonths(1))) {
            throw new EmprestimoException("Data de devolução não pode ser maior que 1 mês a partir de hoje.");
        }
    }
}