package ifsc.jvgc.controller;

import ifsc.jvgc.model.entities.*;
import ifsc.jvgc.model.entities.modalidades.*;
import ifsc.jvgc.model.enums.ModalidadeTipo;
import ifsc.jvgc.model.template.*;

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
        return tipo != null ? tipo.getModalidade() : null;
    }

    public Map<Integer, AtividadeComplementar> getAtividades(Modalidade modalidade) {
        return modalidade.atividades();
    }

    public String validarAtividade(Modalidade modalidade, int idAtividade, int horas) {
        AtividadeComplementar atividade = modalidade.atividades().get(idAtividade);
        if (atividade == null) return "Atividade inválida.";

        int horasMinimas = matricula.curso().horasMinimasComplementares();
        int limiteModalidade = (int) (horasMinimas * modalidade.proporcaoPermitida());

        int acumuladoModalidade = horasValidadasPorModalidade.getOrDefault(modalidade, 0);
        int restanteModalidade = limiteModalidade - acumuladoModalidade;

        int acumuladoAtividade = horasValidadasPorAtividade.getOrDefault(atividade, 0);
        int restanteAtividade = atividade.limiteMaximo() - acumuladoAtividade;

        int horasPermitidas = Math.min(horas, Math.min(restanteModalidade, restanteAtividade));
        AtividadeRealizada realizada = new AtividadeRealizada(requerimento, atividade, horas,
                restanteModalidade, restanteAtividade, "certificado.pdf");
        ProcessoValidacaoAtividade processo = new ProcessoValidacaoPadrao();

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
        textoFinalParecer.append("Matrícula: ").append(matricula.id()).append("\n");
        textoFinalParecer.append("Status do requerimento: ").append(requerimento.estado().nome()).append("\n");
        textoFinalParecer.append("Parecer: ").append(parecer.texto()).append("\n");
        textoFinalParecer.append("Data emissão: ").append(parecer.dataParecer()).append("\n");

        for (ValidacaoAtividade val : validacoes) {
            val.definirParecer(parecer);
            int declaradas = val.atividadeRealizada().horasApresentadas();
            int restantesModalidade = val.atividadeRealizada().horasRestantesModalidade();
            int restantesAtividade = val.atividadeRealizada().horasRestantesAtividade();
            String porAtividade = val.atividadeRealizada().atividade().horasPorAtividade().descricao();
            int validadas = val.horasValidadas();
            String desc = val.atividadeRealizada().atividade().descricao();
            String obs = val.atividadeRealizada().observacao();

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
        textoFinalParecer.append("  Total de horas validadas:  ").append(totalValidadas).append("h\n");

        return textoFinalParecer.toString();
    }
}
