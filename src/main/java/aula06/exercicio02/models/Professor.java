package aula06.exercicio02.models;

import aula06.exercicio02.enums.EnumFormacao;
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