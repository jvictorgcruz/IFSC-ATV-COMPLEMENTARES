package ifsc.jvgc.controller;

import ifsc.jvgc.model.*;
import ifsc.jvgc.model.modalidade.tipos.Modalidade;
import ifsc.jvgc.model.requerimento.Requerimento;
import ifsc.jvgc.model.modalidade.ModalidadeTipo;

import java.time.LocalDate;
import java.util.*;

public class MenuController {

    private final Matricula matricula;
    private final Requerimento requerimento;
    private final List<ValidacaoAtividade> validacoes = new ArrayList<>();
    private final Map<Modalidade, Integer> horasValidadasPorModalidade = new HashMap<>();
    private final Map<AtividadeComplementar, Integer> horasValidadasPorAtividade = new HashMap<>();

    public MenuController(Matricula matricula) {
        this.matricula = matricula;
        this.requerimento = new Requerimento(matricula, LocalDate.now(), null);
    }

    public List<ModalidadeTipo> getModalidades() {
        return Arrays.asList(ModalidadeTipo.values());
    }

    public Modalidade getModalidadeById(int id) {
        ModalidadeTipo tipo = ModalidadeTipo.fromId(id);
        return tipo != null ? tipo.modalidade() : null;
    }

    public Map<Integer, AtividadeComplementar> getAtividades(Modalidade modalidade) {
        return modalidade.atividades();
    }

    public String validarAtividade(Modalidade modalidade, int idAtividade, int horas) {
        AtividadeComplementar atividade = modalidade.atividades().get(idAtividade);
        if (atividade == null) return "Atividade inválida.";

        int horasMinimas = matricula.horasMinimasComplementaresCurso();
        int limiteModalidade = (int) (horasMinimas * modalidade.proporcaoPermitida());

        int acumuladoModalidade = horasValidadasPorModalidade.getOrDefault(modalidade, 0);
        int restanteModalidade = limiteModalidade - acumuladoModalidade;

        int acumuladoAtividade = horasValidadasPorAtividade.getOrDefault(atividade, 0);
        int restanteAtividade = atividade.limiteMaximo() - acumuladoAtividade;

        int horasPermitidas = Math.min(horas, Math.min(restanteModalidade, restanteAtividade));

        // Se a regra não permitir registro de atividade sem restante para o tipo de modalidade/atividade
        // if (horasPermitidas == 0){
        //    return "Não há limite restante para essa atividade";
        //}

        AtividadeRealizada realizada = new AtividadeRealizada(requerimento, atividade, horas,
                restanteModalidade, restanteAtividade, "certificado.pdf");
        ProcessoValidacaoAtividade processo = new ProcessoValidacaoAtividade();

        ValidacaoAtividade validacao = processo.validar(realizada);
        validacoes.add(validacao);
        horasValidadasPorModalidade.put(modalidade, acumuladoModalidade + horasPermitidas);
        horasValidadasPorAtividade.put(atividade, acumuladoAtividade + horasPermitidas);

        // Se a regra permitir registro de atividade mesmo sem restante para o tipo de modalidade/atividade
        if (validacao.horasValidadas() == 0) {
            return "Atividade não possui limite restante (validada com 0h)";
        }

        return "Atividade validada com " + validacao.horasValidadas() + "h";
    }

    public boolean temValidacoes(){
        return !validacoes.isEmpty();
    }

    public String gerarParecer(String textoParecer, boolean deferido) {
        requerimento.avaliar(deferido);
        Parecer parecer = new Parecer(requerimento, textoParecer, LocalDate.now());
        requerimento.avaliar(deferido);

        int totalDeclaradas = 0;
        int totalValidadas = 0;

        int count = 1;
        StringBuilder textoFinalParecer = new StringBuilder("\n=== PARECER DE VALIDAÇÃO ===\n");
        textoFinalParecer.append("Status do requerimento: ").append(requerimento.nomeDoEstado()).append("\n");

        if (!deferido) {
            return textoFinalParecer.toString();
        }

        textoFinalParecer.append("Matrícula: ").append(matricula.id()).append("\n");
        textoFinalParecer.append("Parecer: ").append(parecer.texto()).append("\n");
        textoFinalParecer.append("Data emissão: ").append(parecer.dataParecer()).append("\n");

        for (ValidacaoAtividade val : validacoes) {
            val.definirParecer(parecer);
            int declaradas = val.horasApresentadasAtividade();
            int restantesModalidade = val.horasRestantesModalidade();
            int restantesAtividade = val.horasRestantesAtividade();
            String porAtividade = val.descricaoHorasPorAtividade();
            int validadas = val.horasValidadas();
            String desc = val.descricaoAtividade();
            String obs = val.observacaoAtividade();

            textoFinalParecer.append("\nAtividade ").append(count++).append(":\n");
            textoFinalParecer.append("  Descrição:       ").append(desc).append("\n");
            textoFinalParecer.append("  Horas declaradas: ").append(declaradas).append("h\n");
            textoFinalParecer.append("  Horas restantes da modalidade: ").append(restantesModalidade).append("h\n");
            textoFinalParecer.append("  Horas restantes da atividade complementar: ").append(restantesAtividade)
                    .append("h\n");
            textoFinalParecer.append("  Horas por atividade: ").append(porAtividade).append("\n");
            textoFinalParecer.append("  Horas validadas:  ").append(validadas).append("h\n");
            textoFinalParecer.append("  Observação:      ").append(obs).append("\n");

            totalDeclaradas += declaradas;
            totalValidadas += validadas;
        }

        textoFinalParecer.append("\nResumo geral:\n");
        textoFinalParecer.append("  Total de horas declaradas: ").append(totalDeclaradas).append("h\n");
        textoFinalParecer.append("  Total de horas validadas:  ").append(totalValidadas).append("h\n\n");

        int horasMinimas = matricula.horasMinimasComplementaresCurso();

        if (totalValidadas >= horasMinimas) {
            textoFinalParecer.append("Aluno atingiu as horas mínimas exigidas pelo curso (")
                    .append(horasMinimas).append("h).\n");
        } else {
            textoFinalParecer.append("Aluno NÃO atingiu as horas mínimas exigidas pelo curso (")
                    .append(horasMinimas).append("h).\n");
        }

        return textoFinalParecer.toString();
    }
}
