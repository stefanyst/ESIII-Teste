package biblioteca;

public class Livro {
    Titulo titulo;
    int codigo;

    public Livro(int codigo) {
        titulo = new Titulo(codigo);
        this.codigo = codigo;
    }

    public int verPrazo() {
        return titulo.getPrazo();
    }

    public boolean verificaLivro() {
        return this.codigo == 3;
    }
}

