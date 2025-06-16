package ifsc.jvgc;

import ifsc.jvgc.model.*;
import ifsc.jvgc.strategy.*;
import ifsc.jvgc.template.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(1, "Ana");
        DocumentacaoComprobatoria doc = new DocumentacaoComprobatoria(1, "Certificado");
        Modalidade modalidade = new Modalidade(1, "Ensino");
        HorasPorAtividade horas = new HorasPorAtividade(1, "Conforme documento");

        Requerimento requerimento = new Requerimento(1, aluno, LocalDate.of(2025, 4, 20),
                null);
        AtividadeComplementar atividadeComp = new AtividadeComplementar(1, "Curso de Extensão", doc, horas,
                40, modalidade);
        AtividadeRealizada atividadeRealizada = new AtividadeRealizada(1, requerimento, atividadeComp,
                30, "certificado.pdf");

        // Usando STRATEGY + TEMPLATE METHOD
        EstrategiaValidacaoHoras estrategia = new ValidacaoComLimiteMaximo();
        ProcessoValidacaoAtividade processo = new ProcessoValidacaoPadrao();
        processo.validar(atividadeRealizada, estrategia);

        // Usando STATE
        requerimento.avaliar();
        requerimento.avaliar();
        requerimento.avaliar();
    }
}
