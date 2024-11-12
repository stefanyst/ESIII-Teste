package biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControleTest {

    @Test
    public void testEmprestimoAlunoInexistente() {
        Controle controle = new Controle();
        assertFalse(controle.emprestar("10", new int[]{1, 2, 3}, 3), "Aluno inexistente não pode realizar empréstimo.");
    }

    @Test
    public void testEmprestimoAlunoComDebito() {
        Controle controle = new Controle();
        assertFalse(controle.emprestar("4", new int[]{1, 2, 3}, 3), "Aluno com débito não pode realizar empréstimo.");
    }

    @Test
    public void testEmprestimoComMaisDeCincoLivros() {
        Controle controle = new Controle();
        assertFalse(controle.emprestar("20", new int[]{1, 2, 3, 4, 5, 6}, 6), "Não é permitido empréstimo de mais de 5 livros.");
    }

    @Test
    public void testEmprestimoLimiteMaximoLivros() {
        Controle controle = new Controle();
        assertTrue(controle.emprestar("20", new int[]{1, 2, 3, 4, 5}, 5), "Deve permitir empréstimo com limite de 5 livros.");
    }
}

