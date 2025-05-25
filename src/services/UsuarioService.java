package services;

import exceptions.UsuarioException;
import model.Usuario;
import utils.EmailValidator;
import utils.SenhaValidator;
import utils.UsuarioValidator;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario login(String email, String senha) {
        for (Usuario usuario : this.usuarios) {
            if (EmailValidator.isValid(email) && usuario.getEmail().equals(email) && SenhaValidator.isValid(senha) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> search(String nome, String email) {
        return this.usuarios.stream().filter(usuario ->
                (nome == null || usuario.getNome().toLowerCase().contains(nome.toLowerCase())) &&
                        (email == null || usuario.getEmail().toLowerCase().contains(email.toLowerCase()))).toList();
    }

    public void cadastrar(Usuario usuario) {
        UsuarioValidator.validar(usuario);
        for (Usuario user : this.usuarios) {
            if (user.getEmail().equals(usuario.getEmail())) {
                throw new UsuarioException("Já existe um usuário cadastrado com esse email");
            }
        }
        this.usuarios.add(usuario);
    }
}
