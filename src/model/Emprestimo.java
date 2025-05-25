package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Emprestimo {
    private String id;
    private Livro livro;
    private Usuario usuario;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private boolean devolvido;

    public Emprestimo(Livro livro, Usuario usuario, LocalDateTime dataDevolucao) {
        this.id = UUID.randomUUID().toString();
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDateTime.now();
        this.dataDevolucao = dataDevolucao;
        this.devolvido = false;
    }

    public String getId() {
        return this.id;
    }

    public Livro getLivro() {
        return this.livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return this.dataDevolucao;
    }

    public boolean isDevolvido() {
        return this.isDevolvido();
    }

    public void devolverLivro() {
        this.devolvido = true;
        this.dataDevolucao = LocalDateTime.now();
        this.livro.setDisponivel(true);
    }

}
