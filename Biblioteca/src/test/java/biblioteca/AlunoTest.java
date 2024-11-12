package biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlunoTest {

    @Test
    public void testAlunoInexistente() {
        Aluno aluno = new Aluno("10");
        assertFalse(aluno.verificaAluno(), "Aluno com RA 10 deve ser considerado inexistente.");
    }

    @Test
    public void testAlunoExistente() {
        Aluno aluno = new Aluno("20");
        assertTrue(aluno.verificaAluno(), "Aluno com RA 20 deve ser considerado existente.");
    }

    @Test
    public void testAlunoRAEmBranco() {
        Aluno aluno = new Aluno("");
        assertTrue(aluno.verificaAluno(), "Aluno com RA vazio deve ser tratado como existente.");
    }

    @Test
    public void testAlunoComDebito() {
        Aluno aluno = new Aluno("4");
        assertFalse(aluno.verificaDebito(), "Aluno com RA 4 deve ser considerado com débito.");
    }

    @Test
    public void testAlunoSemDebito() {
        Aluno aluno = new Aluno("2");
        assertTrue(aluno.verificaDebito(), "Aluno com RA 2 deve ser considerado sem débito.");
    }
}

