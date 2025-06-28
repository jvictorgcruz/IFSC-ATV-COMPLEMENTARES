package ifsc.jvgc.controller;

import ifsc.jvgc.model.entities.*;
import ifsc.jvgc.model.entities.modalidades.*;
import ifsc.jvgc.model.enums.ModalidadeTipo;
import ifsc.jvgc.model.template.*;

import java.time.LocalDate;
import java.util.*;

public class MenuController {

    private Matricula matricula;
    private final Requerimento requerimento = new Requerimento(matricula, LocalDate.now(), null);
    private final List<ValidacaoAtividade> validacoes = new ArrayList<>();
    private final Map<Modalidade, Integer> horasValidadasPorModalidade = new HashMap<>();

    public MenuController(Matricula matricula) {
        this.matricula = matricula;
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

        int acumulado = horasValidadasPorModalidade.getOrDefault(modalidade, 0);
        int restante = limiteModalidade - acumulado;

        if (restante <= 0) {
            return "Limite de horas para essa modalidade já foi atingido.";
        }

        int horasAValidar = Math.min(horas, restante);

        AtividadeRealizada realizada = new AtividadeRealizada(requerimento, atividade, horasAValidar, "certificado.pdf");
        ProcessoValidacaoAtividade processo = new ProcessoValidacaoPadrao();

        ValidacaoAtividade validacao = processo.validar(realizada);
        validacoes.add(validacao);
        horasValidadasPorModalidade.put(modalidade, acumulado + validacao.horasValidadas());

        return "Atividade validada com " + validacao.horasValidadas() + "h (limite restante da modalidade: "
                + (limiteModalidade - acumulado - validacao.horasValidadas()) + "h)";
    }

    public boolean temValidacoes(){
        return !validacoes.isEmpty();
    }

    public String gerarParecer(String textoParecer) {
        requerimento.avaliar();
        Parecer parecer = new Parecer(requerimento, textoParecer, LocalDate.now());
        requerimento.avaliar();

        int totalDeclaradas = 0;
        int totalValidadas = 0;

        int count = 1;
        StringBuilder sb = new StringBuilder("\n=== PARECER DE VALIDAÇÃO ===\n");
        sb.append("Matrícula: ").append(matricula.id()).append("\n");
        sb.append("Data emissão: ").append(parecer.dataParecer()).append("\n");

        for (ValidacaoAtividade val : validacoes) {
            val.definirParecer(parecer);
            int declaradas = val.atividadeRealizada().horasApresentadas();
            String porAtividade = val.atividadeRealizada().atividade().horasPorAtividade().descricao();
            int validadas = val.horasValidadas();
            String desc = val.atividadeRealizada().atividade().descricao();
            int limite = val.atividadeRealizada().atividade().limiteMaximo();
            String obs = val.atividadeRealizada().observacao();

            sb.append("\nAtividade ").append(count++).append(":\n");
            sb.append("  Descrição:       ").append(desc).append("\n");
            sb.append("  Horas declaradas: ").append(declaradas).append("h\n");
            sb.append("  Horas por atividade: ").append(porAtividade).append("\n");
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
