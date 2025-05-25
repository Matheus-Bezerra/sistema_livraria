package services;

import exceptions.AutorExpection;
import model.Autor;

import java.util.ArrayList;
import java.util.List;

public class AutorService {
    private List<Autor> autores = new ArrayList<>();

    public Autor procurar(String nome) {
        for (Autor autor : this.autores) {
            if (autor.getNome().equalsIgnoreCase(nome)) {
                return autor;
            }
        }
        return null;
    }


    public List<Autor> search(String nome) {
        return this.autores.stream().filter(autor -> autor.getNome().toLowerCase().contains(nome.toLowerCase())).toList();
    }

    public void cadastrar(Autor autor) {
        if(autor != null && autor.getNome().length() < 3) {
            throw new AutorExpection("Nome deve ter pelo menos 3 caracteres");
        }
        this.autores.add(autor);
    }
}
