package exceptions;

/**
 * Exceção personalizada para erros relacionados a entidade Autor
 * <br>
 * Essa exceção é lançada quando ocorre um problema específico envolvendo operações
 * com autores no sistema, como validação ou persistência de dados.
 */

public class AutorExpection extends RuntimeException {

    /**
     * Constructor que cria uma nova exceção de autor com a mensagem de erro fornecida
     * <br>
     * @param message A mensagem detalhando o motivo da exceção
     */
    public AutorExpection(String message) {
        super(message);
    }
}
