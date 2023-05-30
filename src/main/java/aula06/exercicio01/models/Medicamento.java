package aula06.exercicio01.models;

import aula06.exercicio01.enums.EnumAdmMedicamentos;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter @RequiredArgsConstructor
public class Medicamento {

    @NonNull
    private String nome;
    @NonNull
    private EnumAdmMedicamentos adm;
    private List<String> contraIndicacoes = new ArrayList<String>();
    private List<String> indicacoes = new ArrayList<String>();

    public boolean isIndicado(String sintoma) {
        return indicacoes.contains(sintoma);
    }

    public boolean isContraIndicacao(List<String> condicaoSaude) {
        return condicaoSaude.stream().anyMatch(contraIndicacoes :: contains);
    }

    public void addContraIndicacao(String contraIndicao) {
        indicacoes.add(contraIndicao);
    }

    public void addIndicacao(String indicao) {
        indicacoes.add(indicao);
    }
}