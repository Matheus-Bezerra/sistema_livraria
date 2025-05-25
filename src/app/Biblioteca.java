package app;

import filters.LivroFiltro;
import model.Autor;
import model.Emprestimo;
import model.Livro;
import model.Usuario;
import services.AutorService;
import services.EmprestimoService;
import services.LivroService;
import services.UsuarioService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Biblioteca {
    private UsuarioService usuarioService = new UsuarioService();
    public AutorService autorService = new AutorService();
    private LivroService livroService = new LivroService(autorService);
    private EmprestimoService emprestimoService = new EmprestimoService();

    public Usuario login(String email, String senha) {
        return usuarioService.login(email, senha);
    }

    public List<Usuario> consultarUsuarios(String nome, String email) {
        return usuarioService.search(nome, email);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarioService.cadastrar(usuario);
    }

    public Autor consultarAutor(String nome) {
        return autorService.procurar(nome);
    }

    public void cadastrarAutor(String nome, LocalDate dataNascimento) {
        Autor autor = new Autor(nome, dataNascimento);
        autorService.cadastrar(autor);
    }

    public Livro consultarLivro(String titulo) {
        return livroService.procurar(titulo);
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

    public void pegarLivro(Livro livro, Usuario usuario, LocalDateTime dataDevolucao) {
        emprestimoService.cadastrar(livro, usuario, dataDevolucao);
    }

    public void devolverLivro(Emprestimo emprestimo) {
        emprestimoService.devolver(emprestimo);
    }
}
