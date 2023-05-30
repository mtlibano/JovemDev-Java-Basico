package aula06.exercicio02;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private static List<Professor> bdProfessor = new ArrayList<Professor>();
    private static List<Aluno> bdAluno = new ArrayList<Aluno>();
    private static List<Disciplina> bdDisciplina = new ArrayList<Disciplina>();

    public static Professor addProfessor(Professor p) {
        bdProfessor.add(p);
        return p;
    }

    public static Disciplina addDisciplina(Disciplina d) {
        bdDisciplina.add(d);
        return d;
    }

    public static Aluno addAluno(Aluno a) {
        bdAluno.add(a);
        return a;
    }

    public static void matricularAluno(Aluno aluno, Disciplina disciplina) {
        aluno.adicionarDisciplina(disciplina);
    }
    
    public static void informarNotas(Aluno aluno, Disciplina disciplina, double[] notas) {
        aluno.adicionarNotas(disciplina, notas);
    }
    
    public static void listarDisciplinasAlunoMedia(Aluno aluno) {
        System.out.println("Disciplinas matriculadas pelo aluno " + aluno.getNome() + ":");
        for (Disciplina disciplina : aluno.getDisciplinas()) {
            double media = aluno.calcularMedia(disciplina);
            System.out.println("- " + disciplina.getNome() + " (Média: " + media + ")");
        }
    }

    public static void listarDisciplinasPosGraduacao() {
        System.out.println("Disciplinas lecionadas por professores com pós-graduação:");
        for (Disciplina disciplina : bdDisciplina) {
            Professor professor = disciplina.getProfessor();
            if (professor.getFormacao().equals(EnumFormacao.POS_GRADUACAO)) {
                System.out.println("- " + disciplina.getNome());
            }
        }
    }

    public static Aluno getAlunoNome(String nome) {
        return bdAluno.stream().filter(aluno -> aluno.getNome().equals(nome)).findFirst().orElse(null);
    }

    public static Disciplina getDisciplinaNome(String nome) {
        return bdDisciplina.stream().filter(disciplina -> disciplina.getNome().equals(nome)).findFirst().orElse(null);
    }

    public List<Professor> listAllProf() {
        return bdProfessor;
    }

    public List<Disciplina> listAllDisciplina() {
        return bdDisciplina;
    }

    public List<Aluno> listAllAluno() {
        return bdAluno;
    }

    public void clearData() {
        bdProfessor.clear();
        bdAluno.clear();
        bdDisciplina.clear();
    }
}