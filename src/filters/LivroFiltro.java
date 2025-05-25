package filters;

import enums.Genero;

import java.time.LocalDateTime;

public class LivroFiltro {
    private Boolean disponivel;
    private String titulo;
    private String autor;
    private Genero genero;
    private LocalDateTime dataCadastro;

    public LivroFiltro(Boolean disponivel, String titulo, String autor, Genero genero, LocalDateTime dataCadastro) {
        this.disponivel = disponivel;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.dataCadastro = dataCadastro;
    }

    public Boolean getDisponivel() {
        return this.disponivel;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getAutor() {
        return this.autor;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public LocalDateTime getDataCadastro() {
        return this.dataCadastro;
    }

}
