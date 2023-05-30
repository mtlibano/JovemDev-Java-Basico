package aula06.exercicio02;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class Aluno {

	@NonNull
	private String nome;
	private List<Disciplina> disciplinas;
	private Map<Disciplina, List<Double>> notas;

	public void adicionarDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
		notas.put(disciplina, new ArrayList<>());
	}
}