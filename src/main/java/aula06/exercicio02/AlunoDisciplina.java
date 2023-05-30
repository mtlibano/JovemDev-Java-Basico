package aula06.exercicio02;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class AlunoDisciplina {

	@NonNull
	private int matricula;
	@NonNull
	private double[] notas = new double[3];
	@NonNull
	private Aluno aluno;
	@NonNull
	private Disciplina disciplina;

}