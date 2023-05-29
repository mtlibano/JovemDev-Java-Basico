package aula06.exercicio02;

import java.util.List;
import java.util.ArrayList;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class Aluno {
	
	private String nome;
	private List<Disciplina> disciplina = new ArrayList<>();
	

}
