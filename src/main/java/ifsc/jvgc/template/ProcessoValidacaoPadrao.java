package ifsc.jvgc.template;

import ifsc.jvgc.model.AtividadeRealizada;

public class ProcessoValidacaoPadrao {
    protected void verificarDocumento(AtividadeRealizada atividade) {
        System.out.println("Verificando documento: " + atividade.documento());
    }

    protected void emitirParecer(AtividadeRealizada atividade, int horasValidadas) {
        System.out.println("Emitindo parecer de validação para atividade: " + atividade.id());
    }
}
