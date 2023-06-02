package aula05.exercicio_farmacia2.models;

import lombok.Getter;

@Getter
public class Perfumaria extends Produto{

    public Perfumaria(String nome, int qtdEstoque, double valor) {
        super(nome, qtdEstoque, valor);
    }

    @Override
    public boolean vender(Venda v) {
        if (getQtdEstoque() > v.getQtd() && v.getCliente().getSaldoDevedor() < 300) {
            return super.vender(v);
        }
        return false;
    }
}