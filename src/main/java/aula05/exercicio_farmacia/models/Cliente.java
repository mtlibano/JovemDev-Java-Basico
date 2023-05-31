package aula05.exercicio_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Cliente {

    private String nome;
    private double saldo;
}
