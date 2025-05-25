package utils;

/**
 * Utilitário para validação de senhas.
 */
public class SenhaValidator {

    /**
     * Verifica se a senha fornecida é válida.
     *
     * @param senha A senha a ser validada.
     * @return {@code true} se a senha for válida, {@code false} caso contrário.
     */
    public static boolean isValid(String senha) {
        return senha != null && senha.length() >= 6;
    }
}