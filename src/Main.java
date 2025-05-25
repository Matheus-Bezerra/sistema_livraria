import app.Biblioteca;
import enums.Genero;
import exceptions.EmprestimoException;
import exceptions.LivroException;
import filters.LivroFiltro;
import model.Autor;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Usuario usuario = null;

        boolean cadastrado = false;

        while (!cadastrado) {
            System.out.print("Digite o nome do usuário para cadastro: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o email: ");
            String email = scanner.nextLine();

            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();

            usuario = new Usuario(nome, email, senha);

            try {
                biblioteca.cadastrarUsuario(usuario);
                System.out.println("Usuário cadastrado com sucesso!\n");
                cadastrado = true;  // Sai do loop
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                System.out.println("Tente novamente.\n");
            }
        }

        // Login
        Usuario usuarioLogado = null;

        while (usuarioLogado == null) {
            System.out.println("=== Login ===");
            System.out.print("Digite o email: ");
            String loginEmail = scanner.nextLine();

            System.out.print("Digite a senha: ");
            String loginSenha = scanner.nextLine();

            usuarioLogado = biblioteca.login(loginEmail, loginSenha);

            if (usuarioLogado != null) {
                System.out.println("Login realizado com sucesso! Bem-vindo, " + usuarioLogado.getNome());
            } else {
                System.out.println("Login falhou. Email ou senha incorretos. Tente novamente.\n");
            }
        }

        boolean sistemaAtivo = true;

        while (sistemaAtivo) {
            System.out.println("\n=== Sistema de Biblioteca ===");
            System.out.println("1 - Cadastrar Autor");
            System.out.println("2 - Consultar Autor");
            System.out.println("3 - Cadastrar Livro");
            System.out.println("4 - Consultar Livro");
            System.out.println("5 - Listar Livros com Filtro");
            System.out.println("6 - Pegar Livro emprestado");
            System.out.println("7 - Devolver Livro");
            System.out.println("8 - Consultar Histórico de Empréstimos");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do Autor: ");
                    String nomeAutor = scanner.nextLine();

                    LocalDate dataNascimento = null;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    while (dataNascimento == null) {
                        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                        String data = scanner.nextLine();

                        try {
                            dataNascimento = LocalDate.parse(data, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de data inválido! Use o formato dd/MM/yyyy. Tente novamente.");
                        }
                    }

                    try {
                        biblioteca.cadastrarAutor(nomeAutor, dataNascimento);
                        System.out.println("Autor cadastrado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar autor: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Nome do Autor para consulta: ");
                    String nomeAutor = scanner.nextLine();

                    Autor autor = biblioteca.consultarAutor(nomeAutor);
                    if (autor != null) {
                        System.out.println("Autor encontrado: " + autor.getNome());
                    } else {
                        System.out.println("Autor não encontrado.");
                    }
                }
                case 3 -> {
                    System.out.print("Título do Livro: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Nome do Autor: ");
                    String nomeAutor = scanner.nextLine();

                    Genero genero = null;
                    while (genero == null) {
                        System.out.print("Gênero: ");
                        String generoInput = scanner.nextLine().toUpperCase();

                        try {
                            genero = Genero.valueOf(generoInput);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Gênero inválido! Valores permitidos:");
                            for (Genero g : Genero.values()) {
                                System.out.println(" - " + g.name());
                            }
                            System.out.println("Digite novamente.");
                        }
                    }

                    Autor autor = new Autor(nomeAutor, null);
                    Livro livro = new Livro(titulo, autor, genero);

                    try {
                        biblioteca.cadastrarLivro(livro);
                        System.out.println("Livro cadastrado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar livro: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Título do Livro para consulta: ");
                    String titulo = scanner.nextLine();

                    Livro livro = biblioteca.consultarLivro(titulo);
                    if (livro != null) {
                        System.out.println("Livro encontrado: " + livro.getTitulo());
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                }
                case 5 -> {
                    System.out.print("Título (opcional): ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor (opcional): ");
                    String autor = scanner.nextLine();

                    Genero genero = null;
                    while (true) {
                        System.out.print("Gênero (opcional): ");
                        String generoStr = scanner.nextLine();

                        if (generoStr.isEmpty()) {
                            break;
                        }

                        try {
                            genero = Genero.valueOf(generoStr.toUpperCase());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Gênero inválido! Valores permitidos:");
                            for (Genero g : Genero.values()) {
                                System.out.println(" - " + g.name());
                            }
                            System.out.println("Digite novamente ou deixe em branco para não filtrar por gênero.");
                        }
                    }

                    System.out.print("Disponível? (sim/nao/opcional): ");
                    String dispInput = scanner.nextLine();

                    Boolean disponivel = null;
                    if (dispInput.equalsIgnoreCase("sim")) disponivel = true;
                    else if (dispInput.equalsIgnoreCase("nao")) disponivel = false;

                    LivroFiltro filtro = new LivroFiltro(
                            disponivel,
                            titulo.isEmpty() ? null : titulo,
                            autor.isEmpty() ? null : autor,
                            genero,
                            null
                    );

                    List<Livro> livros = biblioteca.consultarLivros(filtro);

                    if (!livros.isEmpty()) {
                        System.out.println("Livros encontrados:");
                        livros.forEach(System.out::println);
                    } else {
                        System.out.println("Nenhum livro encontrado com esse filtro.");
                    }
                }
                case 6 -> {
                    System.out.print("Título do Livro para empréstimo: ");
                    String tituloEmprestimo = scanner.nextLine();
                    Livro livroEmprestimo = biblioteca.consultarLivro(tituloEmprestimo);

                    if (livroEmprestimo == null) {
                        System.out.println("Livro não encontrado.");
                        break;
                    }

                    System.out.print("Data de devolução (dd/MM/yyyy HH:mm): ");
                    String dataDevStr = scanner.nextLine();
                    LocalDateTime dataDevolucao;
                    try {
                        dataDevolucao = LocalDateTime.parse(dataDevStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                    } catch (Exception e) {
                        System.out.println("Data inválida.");
                        break;
                    }

                    try {
                        biblioteca.pegarLivro(livroEmprestimo, usuario, dataDevolucao);
                        System.out.println("Empréstimo cadastrado com sucesso!");
                    } catch (EmprestimoException | LivroException e) {
                        System.out.println("Erro ao cadastrar empréstimo: " + e.getMessage());
                    }
                }

                case 7 -> {
                    System.out.print("Título do Livro para devolução: ");
                    String tituloDevolucao = scanner.nextLine();
                    Livro livroDevolucao = biblioteca.consultarLivro(tituloDevolucao);

                    if (livroDevolucao == null) {
                        System.out.println("Livro não encontrado.");
                        break;
                    }

                    List<Emprestimo> historico = biblioteca.consultarHistoricoEmprestimos(livroDevolucao, usuario);

                    Emprestimo emprestimoAtivo = null;
                    for (Emprestimo e : historico) {
                        if (!e.isDevolvido()) {
                            emprestimoAtivo = e;
                            break;
                        }
                    }

                    if (emprestimoAtivo == null) {
                        System.out.println("Nenhum empréstimo ativo encontrado para esse livro e usuário.");
                        break;
                    }

                    try {
                        biblioteca.devolverLivro(emprestimoAtivo);
                        System.out.println("Livro devolvido com sucesso!");
                    } catch (EmprestimoException e) {
                        System.out.println("Erro ao devolver livro: " + e.getMessage());
                    }
                }
                case 8 -> {
                    System.out.print("Título do Livro para consultar histórico: ");
                    String titulo = scanner.nextLine();
                    Livro livro = null;
                    if (!titulo.isEmpty()) {
                        livro = biblioteca.consultarLivro(titulo);
                        if (livro == null) {
                            System.out.println("Livro não encontrado.");
                            break;
                        }
                    }

                    List<Emprestimo> historico = biblioteca.consultarHistoricoEmprestimos(livro, usuario);
                    if (historico.isEmpty()) {
                        System.out.println("Nenhum empréstimo encontrado com esse filtro.");
                    } else {
                        System.out.println("Histórico de Empréstimos:");
                        for (Emprestimo e : historico) {
                            System.out.println(e);
                        }
                    }
                }
                case 9 -> {
                    sistemaAtivo = false;
                    System.out.println("Saindo do sistema... Até logo!");
                }

                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }


        scanner.close();
    }
}