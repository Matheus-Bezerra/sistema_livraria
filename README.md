# 📚 Sistema de Biblioteca em Java

Um sistema simples de gerenciamento de biblioteca implementado em Java, utilizando boas práticas de programação orientada a objetos. Permite realizar cadastro de usuários, autores, livros, além de efetuar empréstimos, devoluções e consultas utilizando filtros personalizados.

---

## 🚀 Funcionalidades

- ✅ Cadastro e consulta de usuários  
- ✅ Cadastro e consulta de autores  
- ✅ Cadastro e consulta de livros  
- ✅ Filtro de livros por título, autor, gênero e disponibilidade  
- ✅ Empréstimo e devolução de livros  
- ✅ Consulta de histórico de empréstimos  
- ✅ Sistema de login e autenticação simples  
- ✅ Persistência de dados em memória  

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Orientação a Objetos (POO)
- Tratamento de Exceções
- Enumerações
- Coleções Java (`List`, `Map`)
- `Scanner` para entrada de dados via terminal

---

## 🏛️ Estrutura do Sistema

```plaintext
model      → Classes de domínio como Autor, Livro, Emprestimo, Usuario.
exceptions → Tratamento de exceções específicas como EmprestimoException e LivroException.
enums      → Enumeração de Gêneros literários.
filters    → Implementação do filtro de livros.
app        → Classe Biblioteca com regras de negócio e persistência em memória.
services   → Serviços que encapsulam a lógica principal de operações do sistema.
Main       → Classe principal com a interface via terminal para interação com o sistema.
```

## 🏃‍♂️ Como Executar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

### 2. Compile o projeto

```bash
javac Main.java
```
### 3. Execute o sistema

```bash
java Main
```

### 4. Interaja com o sistema
Siga as instruções exibidas no terminal para utilizar as funcionalidades da biblioteca.

---

## 💡 Exemplos de Uso

- ✅ Cadastro de usuário
- ✅ Login
- ✅ Cadastro de autor
- ✅ Cadastro de livro
- ✅ Consulta de livros com filtros
- ✅ Realização de empréstimo
- ✅ Devolução de livro
- ✅ Consulta ao histórico de empréstimos

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com foco no aprendizado e prática dos seguintes conceitos de programação em Java:

- Modelagem de classes
- Criação e utilização de enums
- Manipulação de coleções
- Tratamento de exceções personalizadas
- Entrada e saída de dados via terminal
- Implementação de filtros de consulta

---

## 🤝 Contribuições

Contribuições são sempre bem-vindas!

Se você deseja sugerir melhorias, reportar problemas ou enviar novas funcionalidades:

- Abra uma **issue**
- Envie um **pull request**

Obrigado por colaborar!

---

## 📝 Licença

Este projeto está licenciado sob a **Licença MIT**.  
Sinta-se livre para utilizar, modificar e distribuir conforme as condições da licença.

---

## 📩 Contato

- **GitHub:** [Matheus-Bezerra](https://github.com/Matheus-Bezerra)  
- **Email:** matheusbwzerra002@gmail.com
- **Telefone:** (11) 97661-1929
