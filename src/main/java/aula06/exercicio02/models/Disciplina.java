package aula06.exercicio02.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class Disciplina {

	@NonNull
	private String nome;
	@NonNull
	private double cargaHoraria;
	@NonNull
	private Professor professor;

}