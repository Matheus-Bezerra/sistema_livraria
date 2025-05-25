package utils;

import exceptions.LivroException;
import model.Livro;

public class LivroValidator {

    public static void validar(Livro livro) {
        if (livro == null) {
            throw new LivroException("model.Livro não pode ser nulo");
        }
        if (livro.getTitulo() == null || livro.getTitulo().length() < 3) {
            throw new LivroException("Título deve ter pelo menos 3 caracteres");
        }
        if (livro.getAutor() == null) {
            throw new LivroException("model.Autor não pode ser nulo");
        }
        if (livro.getGenero() == null) {
            throw new LivroException("Gênero não pode ser nulo");
        }
    }
}
