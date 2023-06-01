package aula04.exercicio_aluno.models;

import aula04.exercicio_aluno.enums.EnumFormacao;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class Professor {

	@NonNull
	private String nome;
	@NonNull
	private EnumFormacao formacao;

}