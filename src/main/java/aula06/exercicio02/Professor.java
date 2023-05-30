package aula06.exercicio02;

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