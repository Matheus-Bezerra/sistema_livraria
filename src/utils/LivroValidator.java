package utils;

import exceptions.LivroException;
import model.Livro;

/**
 * Utilitário para validação de regras relacionadas a livros.
 */
public class LivroValidator {

    /**
     * Valida os dados de um livro.
     *
     * @param livro O livro a ser validado.
     * @throws LivroException Se algum dado do livro for inválido.
     */
    public static void validar(Livro livro) {
        if (livro == null) {
            throw new LivroException("Livro não pode ser nulo");
        }
        if (livro.getTitulo() == null || livro.getTitulo().length() < 3) {
            throw new LivroException("Título deve ter pelo menos 3 caracteres");
        }
        if (livro.getAutor() == null) {
            throw new LivroException("Autor não pode ser nulo");
        }
        if (livro.getGenero() == null) {
            throw new LivroException("Gênero não pode ser nulo");
        }
    }
}