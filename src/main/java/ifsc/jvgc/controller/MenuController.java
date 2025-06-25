package ifsc.jvgc.controller;

import ifsc.jvgc.model.*;
import ifsc.jvgc.model.modalidades.*;
import ifsc.jvgc.strategy.*;
import ifsc.jvgc.template.*;

import java.time.LocalDate;
import java.util.*;

public class MenuController {

    private final Aluno aluno = new Aluno(146846, "Ana");
    private final Requerimento requerimento = new Requerimento(aluno, LocalDate.now(), null);
    private final List<ValidacaoAtividade> validacoes = new ArrayList<>();

    private final Map<Integer, Modalidade> modalidades = new LinkedHashMap<>();

    public MenuController() {
        modalidades.put(1, new Ensino());
        modalidades.put(2, new PesquisaInovacao());
        modalidades.put(3, new Extensao());
        modalidades.put(4, new Complementacao());
    }

    public Map<Integer, Modalidade> getModalidades() {
        return modalidades;
    }

    public Modalidade getModalidade(int id) {
        return modalidades.get(id);
    }

    public Map<Integer, AtividadeComplementar> getAtividades(Modalidade modalidade) {
        return modalidade.atividades();
    }

    public String validarAtividade(Modalidade modalidade, int idAtividade, int horas) {
        AtividadeComplementar atividade = modalidade.atividades().get(idAtividade);
        if (atividade == null) return "Atividade inválida.";

        AtividadeRealizada realizada = new AtividadeRealizada(requerimento, atividade, horas, "certificado.pdf");
        ProcessoValidacaoAtividade processo = new ProcessoValidacaoPadrao();
        ValidacaoAtividade validacao = processo.validar(realizada, new ValidacaoComLimiteMaximo());
        validacoes.add(validacao);

        return "Atividade validada com sucesso.";
    }

    public String gerarParecer() {
        if (validacoes.isEmpty()) return "Nenhuma atividade validada.";

        requerimento.validar();
        Parecer parecer = new Parecer(requerimento, "", LocalDate.now());

        int totalDeclaradas = 0;
        int totalValidadas = 0;

        int count = 1;
        StringBuilder sb = new StringBuilder("\n=== PARECER DE VALIDAÇÃO ===\n");
        sb.append("Matrícula: ").append(aluno.matricula()).append("\n");
        sb.append("Data emissão: ").append(parecer.dataParecer()).append("\n");

        for (ValidacaoAtividade val : validacoes) {
            val.definirParecer(parecer);
            int declaradas = val.atividadeRealizada().horasApresentadas();
            int validadas = val.atividadeRealizada().horasValidadas();
            String desc = val.atividadeRealizada().atividade().descricao();
            int limite = val.atividadeRealizada().atividade().limiteMaximo();
            String obs = val.atividadeRealizada().observacao();

            sb.append("\nAtividade ").append(count++).append(":\n");
            sb.append("  Descrição:       ").append(desc).append("\n");
            sb.append("  Horas declaradas: ").append(declaradas).append("h\n");
            sb.append("  Limite Máximo:    ").append(limite).append("h\n");
            sb.append("  Horas validadas:  ").append(validadas).append("h\n");
            sb.append("  Observação:      ").append(obs).append("\n");

            totalDeclaradas += declaradas;
            totalValidadas += validadas;
        }

        sb.append("\nResumo geral:\n");
        sb.append("  Total de horas declaradas: ").append(totalDeclaradas).append("h\n");
        sb.append("  Total de horas validadas:  ").append(totalValidadas).append("h\n");

        return sb.toString();
    }
}
