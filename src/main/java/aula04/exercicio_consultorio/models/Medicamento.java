package aula04.exercicio_consultorio.models;

import aula04.exercicio_consultorio.enums.EnumAdmMedicamentos;
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
    private List<String> contraIndicacoes = new ArrayList<>();
    private List<String> indicacoes = new ArrayList<>();

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