package services;

import exceptions.AutorExpection;
import exceptions.LivroException;
import filters.LivroFiltro;
import model.Autor;
import model.Livro;
import utils.LivroValidator;

import java.util.ArrayList;
import java.util.List;

public class LivroService {
    private List<Livro> livros = new ArrayList<>();
    private AutorService autorService;

    public LivroService(AutorService autorService) {
        this.autorService = autorService;
    }

    public Livro procurar(String titulo) {
        for (Livro livro : this.livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> search(LivroFiltro filtro) {
        if (filtro == null) {
            return this.livros;
        }

        return this.livros.stream()
                .filter(livro ->
                        (filtro.getDisponivel() == null || livro.isDisponivel() == filtro.getDisponivel()) &&
                                (filtro.getTitulo() == null || filtro.getTitulo().isEmpty() || livro.getTitulo().toLowerCase().contains(filtro.getTitulo().toLowerCase())) &&
                                (filtro.getAutor() == null || filtro.getAutor().isEmpty() || livro.getAutor().getNome().toLowerCase().contains(filtro.getAutor().toLowerCase())) &&
                                (filtro.getGenero() == null || livro.getGenero() == filtro.getGenero()) &&
                                (filtro.getDataCadastro() == null || !livro.getDataCadastro().isBefore(filtro.getDataCadastro()))
                )
                .toList();
    }

    public void cadastrar(Livro livro) {
        LivroValidator.validar(livro);

        Autor autor = autorService.procurar(livro.getAutor().getNome());
        if (autor == null) {
            throw new AutorExpection("Autor não cadastrado. Cadastre o autor antes de cadastrar o livro.");
        }

        livro.setAutor(autor);

        for (Livro l : this.livros) {
            if (l.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
                throw new LivroException("Já existe um livro com este título cadastrado");
            }
        }

        this.livros.add(livro);
    }
}
