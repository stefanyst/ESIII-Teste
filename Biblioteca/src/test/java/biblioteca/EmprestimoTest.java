package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class EmprestimoTest {

    private Emprestimo emprestimo;
    private List<Livro> livros;

    @BeforeEach
    public void setUp() {
        emprestimo = new Emprestimo();
        livros = new ArrayList<>();
    }

    @Test
    public void testEmprestimoComListaVazia() {
        assertFalse(emprestimo.emprestar(livros), "Deve retornar false para lista de livros vazia.");
    }

    @Test
    public void testEmprestimoComUmLivro() {
        livros.add(new Livro(1));
        assertTrue(emprestimo.emprestar(livros), "Deve retornar true para uma lista com um livro.");
    }

    @Test
    public void testEmprestimoComCincoLivros() {
        for (int i = 1; i <= 5; i++) {
            livros.add(new Livro(i));
        }
        assertTrue(emprestimo.emprestar(livros), "Deve permitir empréstimo com o limite de cinco livros.");
    }

    @Test
    public void testEmprestimoComMaisDeCincoLivros() {
        for (int i = 1; i <= 6; i++) {
            livros.add(new Livro(i));
        }
        assertFalse(emprestimo.emprestar(livros), "Não deve permitir empréstimo com mais de cinco livros.");
    }

    @Test
    public void testCalculaDataDevolucaoComUmLivro() {
        livros.add(new Livro(1));
        emprestimo.emprestar(livros);
        Date dataDevolucao = emprestimo.calculaDataDevolucao(); // ajuste para minúsculo
        assertNotNull(dataDevolucao, "A data de devolução deve ser calculada para um livro.");
    }

    @Test
    public void testCalculaDataDevolucaoComTresLivros() {
        for (int i = 1; i <= 3; i++) {
            livros.add(new Livro(i));
        }
        emprestimo.emprestar(livros);
        Date dataDevolucao = emprestimo.calculaDataDevolucao(); // ajuste para minúsculo

        assertNotNull(dataDevolucao, "A data de devolução deve ser calculada.");
        // Este teste pode incluir validações adicionais para garantir que a data está corretamente ajustada
    }
}
