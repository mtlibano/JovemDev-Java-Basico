package aula05.exercicio_farmacia.models;

import lombok.Getter;

@Getter
public class EquipMedico extends Produto {

    public EquipMedico(String nome, int estoque, double valor) {
        super(nome, estoque, valor);
    }
}