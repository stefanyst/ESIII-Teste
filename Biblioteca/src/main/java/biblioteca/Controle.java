package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Controle {

    public boolean emprestar(String aluno, int[] prazos, int num) {
        boolean retorno = true;
        Aluno a = new Aluno(aluno);

        if (!a.verificaAluno()) {
            System.out.println("Aluno Inexistente");
            retorno = false;
        }

        if (!a.verificaDebito()) {
            System.out.println("Aluno em Débito");
            retorno = false;
        }

        if (retorno) {
            List<Livro> livros = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                Livro l = new Livro(prazos[i]);
                if (!l.verificaLivro()) {
                    livros.add(l);
                }
            }

            if (livros.size() > 0 && livros.size() <= 5) {
                retorno = a.emprestar(livros);
            } else {
                System.out.println("Limite de livros excedido ou nenhum livro disponível");
                retorno = false;
            }
        }
        return retorno;
    }
}

