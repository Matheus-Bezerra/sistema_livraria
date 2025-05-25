package exceptions;

/**
 * Exceção personalizada para erros relacionados a operações de empréstimo.
 * <p>
 * Esta exceção é lançada quando ocorre um problema específico envolvendo
 * operações de empréstimo no sistema, como validações, regras de negócio
 * ou problemas na persistência dos dados.
 */
public class EmprestimoException extends RuntimeException {

    /**
     * Construtor que cria uma nova exceção de empréstimo com a mensagem de erro fornecida.
     *
     * @param message A mensagem detalhando o motivo da exceção.
     */
    public EmprestimoException(String message) {
        super(message);
    }
}