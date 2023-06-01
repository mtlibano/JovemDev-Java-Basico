package aula05.exercicio_farmacia.models;

import lombok.Getter;

@Getter
public class Medicamento extends Produto {

    private boolean reterReceita;

    public Medicamento(String nome, int estoque, double valor, boolean reterReceita) {
        super(nome, estoque, valor);
        this.reterReceita = reterReceita;
    }

    public boolean isReterReceita() {
        return reterReceita;
    }
}