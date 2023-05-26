package quarta_aula.exercicio_livro;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PrincipalLivro {

    public static void main(String[] args) {

        List<Livro> listaLivro = new ArrayList<Livro>();
        List<Autor> listaAutor = new ArrayList<Autor>();

        int op = 0;
        do {
            op = Util.menuPrincipal();
            switch (op) {
                case 1:
                    Util.cadastrarAutor(listaAutor);
                    break;
                case 2:
                    Util.cadastrarLivro(listaLivro, listaAutor);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, Util.listarTodosLivros(listaLivro));
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, Util.buscarPorAutor(listaLivro, listaAutor));
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, Util.buscarPorValor(listaLivro));
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, Util.listarLivrosAutoresCriancas(listaLivro));
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, Util.listarLivrosPorSexo(listaLivro));
                    break;
            }
        } while (op != 8);
    }
}