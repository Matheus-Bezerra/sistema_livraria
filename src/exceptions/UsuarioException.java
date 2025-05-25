package exceptions;

/**
 * Exceção personalizada para erros relacionados à entidade Usuário.
 * <p>
 * Esta exceção é lançada quando ocorre um problema específico envolvendo
 * operações com usuários no sistema, como validação de dados, autenticação
 * ou persistência.
 */
public class UsuarioException extends RuntimeException {

    /**
     * Construtor que cria uma nova exceção de usuário com a mensagem de erro fornecida.
     *
     * @param mensagem A mensagem detalhando o motivo da exceção.
     */
    public UsuarioException(String mensagem) {
        super(mensagem);
    }
}