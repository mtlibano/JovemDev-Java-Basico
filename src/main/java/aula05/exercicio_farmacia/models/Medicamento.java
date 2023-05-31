package aula05.exercicio_farmacia.models;

import lombok.Getter;

@Getter
public class Medicamento extends Produto {

    public Medicamento(String nome, int estoque, double valor) {
        super(nome, estoque, valor);
    }

    //private boolean reterReceita;

}