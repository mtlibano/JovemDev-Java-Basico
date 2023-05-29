package aula06.exercicio02;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class Disciplina {
	
	private String nome;
	private double cargaHoraria;
	private Professor professor;

}
