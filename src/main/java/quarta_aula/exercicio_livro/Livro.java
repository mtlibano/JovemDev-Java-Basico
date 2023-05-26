package quarta_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {

    private String titulo;
    private double preco;
    private List<Autor> autores = new ArrayList<>();

    public void cadastrar(List<Autor> listaAutores) {
        boolean validarTitulo = false;
        while (!validarTitulo) {
            titulo = JOptionPane.showInputDialog("Digite o título do livro").toLowerCase().trim();
            if (!titulo.equalsIgnoreCase("")) {
                validarTitulo = true;
            } else {
                JOptionPane.showMessageDialog(null, "Título inválido");
            }
        }

        boolean validarPreco = false;
        while (!validarPreco) {
            try {
                preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do livro (R$)"));
                if (preco > 0) {
                    validarPreco = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
            }
        }

        int op = 0;
        int count = 0;
        Autor autor = new Autor();
        do {
            count++;
            autor = Util.mostrarOpcoesAutores(listaAutores);
            autores.add(autor);
            if (count < 4) {
                String[] opcoes = {"Sim", "Não"};
                op = JOptionPane.showOptionDialog(null, "Cadastrar novo AUTOR?", "Lista de Autores", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            } else {
                JOptionPane.showMessageDialog(null, "Número máximo de autores (4)");
                break;
            }
        } while (op != 1 || count == 4);
    }

    public String toString() {
        return "Título: " + titulo + ", R$ " + preco;
    }

    public String listAutores() {
        String print = "Livro: " + titulo + "\n";
        for (Autor autor : autores) {
            print += autor.toString() + "\n";
        }
        return print;
    }
}