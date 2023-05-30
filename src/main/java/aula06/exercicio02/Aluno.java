package aula06.exercicio02;

import java.util.List;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class Aluno {

	@NonNull
	private String nome;
	@NonNull
	private List<Disciplina> disciplinas;
}