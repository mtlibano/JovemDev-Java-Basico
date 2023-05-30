package aula06.exercicio02;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class Aluno {

	@NonNull
	private String nome;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private Map<Disciplina, double[]> notas = new HashMap<Disciplina, double[]>();

	public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        notas.put(disciplina, new double[3]);
    }

    public void adicionarNotas(Disciplina disciplina, double[] notas) {
        this.notas.put(disciplina, notas);
    }
    
    public double calcularMedia(Disciplina disciplina) {
        double[] notasDisciplina = notas.get(disciplina);
        double soma = 0;
        for (double nota : notasDisciplina) {
            soma += nota;
        }
        return soma / notasDisciplina.length;
    }
}