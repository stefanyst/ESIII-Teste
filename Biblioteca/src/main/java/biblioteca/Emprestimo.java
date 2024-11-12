package biblioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Emprestimo {

    Date dataEmprestimo = new Date();
    Date dataPrevista = new Date();
    Date dataAux = new Date();
    String nome;
    List<Item> itens = new ArrayList<>();

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * Método responsável por realizar o empréstimo.
     * @param livros Lista de livros para o empréstimo.
     * @return true se o empréstimo foi realizado com sucesso, false caso contrário.
     */
    public boolean emprestar(List<Livro> livros) {
        if (livros.isEmpty() || livros.size() > 5) {
            System.out.println("Erro: quantidade inválida de livros.");
            return false;
        }

        for (Livro livro : livros) {
            itens.add(new Item(livro));
        }

        calculaDataDevolucao();
        return !itens.isEmpty();
    }

    /**
     * Método responsável por calcular a data de devolução.
     * Se houver mais de 2 itens, adiciona dias extras.
     * @return Data de devolução calculada.
     */
    public Date calculaDataDevolucao() {
        Date date = new Date();

        for (Item item : itens) {
            dataAux = item.calculaDataDevolucao(date);
            if (dataPrevista.compareTo(dataAux) < 0) {
                dataPrevista = dataAux;
            }
        }

        // Condição: adicionar dias extras se houver mais de 2 itens
        if (itens.size() > 2) {
            int extraDays = (itens.size() - 2) * 2;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataPrevista);
            calendar.add(Calendar.DATE, extraDays);
            dataPrevista = calendar.getTime();
        }

        for (Item item : itens) {
            item.setDataDevolucao(dataPrevista);
        }

        return dataPrevista;
    }
}
