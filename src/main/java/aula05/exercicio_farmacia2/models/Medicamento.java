package aula05.exercicio_farmacia2.models;

import lombok.Getter;

@Getter
public class Medicamento extends Produto {

    private boolean isReceita;

    public Medicamento(String nome, int qtdEstoque, double valor, boolean isReceita) {
        super(nome, qtdEstoque, valor);
        this.isReceita = isReceita;
    }

    @Override
    public boolean vender(Venda v) {
        if (isReceita && v.getMedico() == null) {
            return false;
        } else {
            if (getQtdEstoque() >= v.getQtd()) {
                return super.vender(v);
            }
        }
        return false;
    }
}