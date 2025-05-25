package filters;

import java.time.LocalDateTime;

public class LivroFiltro {
    private Boolean disponivel;
    private String titulo;
    private String autor;
    private String genero;
    private LocalDateTime dataCadastro;

    public LivroFiltro(Boolean disponivel, String titulo, String autor, String genero, LocalDateTime dataCadastro) {
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

    public String getGenero() {
        return this.genero;
    }

    public LocalDateTime getDataCadastro() {
        return this.dataCadastro;
    }

}
