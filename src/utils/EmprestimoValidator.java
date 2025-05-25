package utils;

import exceptions.EmprestimoException;

import java.time.LocalDateTime;

public class EmprestimoValidator {
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
