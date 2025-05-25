package exceptions;

/**
 * Exceção personalizada para erros relacionados à entidade Livro.
 * <p>
 * Esta exceção é lançada quando ocorre um problema específico envolvendo
 * operações com livros no sistema, como validação de dados, regras de negócio
 * ou falhas na persistência.
 */
public class LivroException extends RuntimeException {

    /**
     * Construtor que cria uma nova exceção de livro com a mensagem de erro fornecida.
     *
     * @param message A mensagem detalhando o motivo da exceção.
     */
    public LivroException(String message) {
        super(message);
    }
}