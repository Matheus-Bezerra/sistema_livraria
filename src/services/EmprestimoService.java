package services;

import exceptions.EmprestimoException;
import exceptions.LivroException;
import model.Emprestimo;
import model.Livro;
import model.Usuario;
import utils.EmprestimoValidator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public List<Emprestimo> historico(Livro livro, Usuario usuario) {
        List<Emprestimo> emprestimos = new ArrayList<>();
        return this.emprestimos.stream().filter(emp -> (livro == null || emp.getLivro() == livro) && (usuario == null || emp.getUsuario() == usuario)).toList();
    }

    public void cadastrar(Livro livro, Usuario usuario, LocalDateTime dataDevolucao) {
        EmprestimoValidator.validar(dataDevolucao);

        if (livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, usuario, dataDevolucao);
            this.emprestimos.add(emprestimo);
            livro.setDisponivel(false);

        } else {
            throw new LivroException("Livro não está disponível no momento");
        }
    }

    public void devolver(Emprestimo emprestimo) {
        if (!emprestimo.isDevolvido()) {
            emprestimo.devolverLivro();
        } else {
            throw new EmprestimoException("Esse empréstimo já foi devolvido");
        }
    }
}
