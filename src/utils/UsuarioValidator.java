package utils;

import exceptions.UsuarioException;
import model.Usuario;

/**
 * Utilitário para validação de usuários.
 */
public class UsuarioValidator {

    /**
     * Valida os dados de um usuário.
     *
     * @param usuario O usuário a ser validado.
     * @throws UsuarioException Se algum dado do usuário for inválido.
     */
    public static void validar(Usuario usuario) {
        if (!EmailValidator.isValid(usuario.getEmail())) {
            throw new UsuarioException("Email inválido");
        }
        if (!SenhaValidator.isValid(usuario.getSenha())) {
            throw new UsuarioException("Senha deve ter pelo menos 6 caracteres");
        }
        if (usuario.getNome() == null || usuario.getNome().length() < 3) {
            throw new UsuarioException("Nome deve ter pelo menos 3 caracteres");
        }
    }
}