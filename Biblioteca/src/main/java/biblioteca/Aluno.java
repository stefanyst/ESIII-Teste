package biblioteca;

import java.util.List;

public class Aluno {
    String RA;

    public Aluno(String nome) {
        super();
        this.RA = nome;
    }

    public String getNome() {
        return RA;
    }

    public void setNome(String nome) {
        this.RA = nome;
    }

    /**
     * Verifica se o aluno existe. Retorna falso quando RA = "10" indicando um aluno inexistente.
     */
    public boolean verificaAluno() {
        return !this.RA.equals("10");
    }

    /**
     * Verifica se o aluno possui débitos. Se RA = 4, indica débito.
     */
    public boolean verificaDebito() {
        Debito debito = new Debito(Integer.parseInt(this.RA));
        return debito.verificaDebito();
    }

    public boolean emprestar(List<Livro> livros) {
        Emprestimo e = new Emprestimo();
        return e.emprestar(livros);
    }
}

