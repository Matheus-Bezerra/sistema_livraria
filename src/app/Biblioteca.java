package app;

import filters.LivroFiltro;
import model.Emprestimo;
import model.Livro;
import model.Usuario;
import services.EmprestimoService;
import services.LivroService;
import services.UsuarioService;

import java.time.LocalDateTime;
import java.util.List;

public class Biblioteca {
    private UsuarioService usuarioService = new UsuarioService();
    private LivroService livroService = new LivroService();
    private EmprestimoService emprestimoService = new EmprestimoService();

    public List<Usuario> consultarUsuarios(String nome, String email) {
        return usuarioService.search(nome, email);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarioService.cadastrar(usuario);
    }

    public List<Livro> consultarLivros(LivroFiltro filtro) {
        return livroService.search(filtro);
    }

    public void cadastrarLivro(Livro livro) {
        livroService.cadastrar(livro);
    }

    public List<Emprestimo> consultarHistoricoEmprestimos(Livro livro, Usuario usuario) {
        return emprestimoService.historico(livro, usuario);
    }

    public void emprestarLivro(Livro livro, Usuario usuario, LocalDateTime dataDevolucao) {
        emprestimoService.cadastrar(livro, usuario, dataDevolucao);
    }

    public void devolverLivro(Emprestimo emprestimo) {
        emprestimoService.devolver(emprestimo);
    }
}
