package aula05.exercicio_farmacia2.models;

import lombok.Getter;

@Getter
public class EquipamentoMedico extends Produto {

    public EquipamentoMedico(String nome, int qtdEstoque, double valor) {
        super(nome, qtdEstoque, valor);
    }
}