package ifsc.jvgc.model.template;

import ifsc.jvgc.model.entities.AtividadeRealizada;

public class ProcessoValidacaoPadrao extends ProcessoValidacaoAtividade {
    protected void verificarDocumento(AtividadeRealizada atividade) {
        System.out.println("Verificando documento: " + atividade.documento());
    }

}
